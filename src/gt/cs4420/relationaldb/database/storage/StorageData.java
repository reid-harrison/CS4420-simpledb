package gt.cs4420.relationaldb.database.storage;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import gt.cs4420.relationaldb.database.storage.block.Block;
import gt.cs4420.relationaldb.database.storage.block.BlockFilter;
import gt.cs4420.relationaldb.database.storage.block.BlockManager;
import gt.cs4420.relationaldb.database.storage.file.FileManager;
import gt.cs4420.relationaldb.database.storage.index.Index;
import gt.cs4420.relationaldb.database.storage.index.IndexManager;
import gt.cs4420.relationaldb.domain.*;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import gt.cs4420.relationaldb.domain.query.*;

import java.util.*;

/**
 * StorageData
 *
 * Maintains state information about data in the database including a cache of recently accessed data. StorageData is best
 * kept as a singleton so that data remains consistent.
 */
class StorageData {

    //The singleton instance of this class
    private static StorageData instance;

    /**
     * Returns the static instance to the StorageData singleton.
     *
     * @return StorageData singleton instance
     */
    protected static StorageData getInstance(final String dbRootDirectory) {
        if (instance == null) {
            instance = new StorageData(dbRootDirectory);
        }

        return instance;
    }

    //The root directory relative to run-time directory where the database files are kept (this will be moved elsewhere later)
    private final String DB_ROOT_DIRECTORY;

    //The amount of dirty operations to allow before dirtied data is flushed
    private final int DIRTY_COUNT_LIMIT = 10;
    //The current number of dirty operations before last flush
    private int dirtyCount = 0;

    //Control flags for exporting data to file that are useful for testing
    protected static boolean ignoreDirty = false;
    protected static boolean exportDisabled = false;
    protected static boolean forceFlush = false;

    //Table name -> Table ID
    private Map<String, Integer> tableNames;

    //Table ID -> Table
    private Map<Integer, Table> tables;

    //Table ID -> (Primary Key -> Row data)
    private Map<Integer, Map<Integer, Row>> tableData;

    //Various assisting Managers
    private IndexManager indexManager;
    private FileManager fileManager;
    private BlockManager blockManager;

    //Random necessary data
    private Integer nextId;

    private StorageData(final String dbRootDirectory) {
        DB_ROOT_DIRECTORY = dbRootDirectory;

        tableNames = Maps.newHashMap();
        tables = Maps.newHashMap();
        tableData = Maps.newHashMap();

        indexManager = new IndexManager();
        fileManager = new FileManager(DB_ROOT_DIRECTORY);
        blockManager = new BlockManager();

        loadTableDescriptions();
        initIndexManager();
        initBlockManager();
    }

    private void loadTableDescriptions() {
        Set<Table> tableSet = fileManager.importDescriptions();

        Integer highestId = 0;

        for (Table table : tableSet) {
            tableNames.put(table.getName(), table.getId());
            tables.put(table.getId(), table);

            if (table.getId() > highestId) {
                highestId = table.getId();
            }
        }

        nextId = highestId + 1;
    }

    private void initIndexManager() {
        for (Integer tableId : tables.keySet()) {
            indexManager.createIndex(tableId);
        }

        fileManager.importIndexes(indexManager);
    }

    private void initBlockManager() {

        //Import the block meta-data for already allocated blocks referenced by the current IndexManager
        for (Integer tableId : indexManager.getTableIdSet()) {
            List<Block> blockSizes = fileManager.importBlockMetaData(tableId);

            if (blockSizes == null) {
                return;
            }

            for (Block block : blockSizes) {
                blockManager.setBlockSize(tableId, block.getBlockId(), block.getBlockSize());
            }
        }

    }

    protected boolean tableExists(final Integer tableId) {
        return tables.containsKey(tableId);
    }

    protected boolean tableExists(final String tableName) {
        return tableNames.containsKey(tableName);
    }

    protected Integer getTableId(final String tableName) {
        return tableNames.get(tableName);
    }

    protected Table getTable(final Integer tableId) {
        return tables.get(tableId);
    }

    protected Table getTable(final String tableName) {
        Integer tableId = getTableId(tableName);

        if (tableId == null) {
            return null;
        }

        return getTable(tableId);
    }
    
    protected Description getTableDescription(final String tableName) {
    	return getTable(tableNames.get(tableName)).getDescription();
    }

    protected void addTable(final Table table) {
        tables.put(table.getId(), table);
        tableNames.put(table.getName(), table.getId());
        tableData.put(table.getId(), new HashMap<Integer, Row>());
        indexManager.createIndex(table.getId());
        dirtyCheck();
    }

    /**
     * Removes all references to and data for the given table from memory and disk.
     * @param tableId
     */
    protected void removeTable(final Integer tableId) {

        //Remove all table data in memory
        tables.remove(tableId);
        tableData.remove(tableId);
        indexManager.removeIndex(tableId);
        blockManager.removeAllBlocks(tableId);

        //Remove all table data on disk
        fileManager.removeTableRowData(tableId);
        dirtyCount = DIRTY_COUNT_LIMIT;
        dirtyCheck();
    }

    /**
     * Inserts the given attribute data mapping into the given table.
     *
     * @param tableId
     * @param row the row to insert (with the primary key at least populated in the row's data)
     * @throws ValidationException if a row already exists with the private key or the data is not valid for the table's description
     */
    protected void insert(final Integer tableId, final Row row) throws ValidationException {
        addRow(tableId, row);

        Integer blockId = blockManager.allocateBlockSpace(tableId, row.getRowData().size());
        Integer blockIndex = indexManager.getIndex(tableId).getNextBlockIndex(blockId);

        indexManager.addIndexEntry(tableId, row.getPrimaryKey(), blockId, blockIndex);
        indexManager.getIndex(tableId).addDirtyPrimaryKey(blockId, row.getPrimaryKey());

        dirtyCheck();
    }

    /**
     * Updates a table's Row based on the given Row's primary key by modifying the attributes specified in the given
     * Row's row data.
     *
     * @param tableId
     * @param updateDataRow Row populated with the data that will replace the old row's corresponding data
     * @param whereConstraint Constraint to limit rows that are updated
     * @throws ValidationException
     */
    protected void update(final Integer tableId, final Row updateDataRow, final Constraint whereConstraint) throws ValidationException {
        List<Row> affectedRows = select(tableId, whereConstraint, null);

        Index tableIndex = indexManager.getIndex(tableId);

        Map<Attribute, Object> updateData = updateDataRow.getRowData();

        for (Row affectedRow : affectedRows) {
            Integer affectedPrimaryKey = affectedRow.getPrimaryKey();
            Integer affectedBlockId = tableIndex.getBlockId(affectedPrimaryKey);

            tableData.get(tableId).get(affectedPrimaryKey).getRowData().putAll(updateData);
            tableIndex.addDirtyPrimaryKey(affectedPrimaryKey, affectedBlockId);
        }

        dirtyCheck();
    }

    protected Integer getNextTableId() {
        return nextId;
    }

    /**
     * Adds a row to this in-memory representation of a Table. This will not guarantee that the row is actually written
     * to disk.
     *
     * @
     * @param row Attribute values for the new row
     * @return
     */
    private void addRow(final Integer tableId, final Row row) throws ValidationException {

        if (row.getPrimaryKey() == null) {
            throw new ValidationException("Primary key must be set for any new row");
        }

        if (indexManager.getIndex(tableId).getPrimaryKeySet().contains(row.getPrimaryKey())) {
            throw new ValidationException("A row already exists with the provided primary key attribute; primary keys must be unique");
        }

        tableData.get(tableId).put(row.getPrimaryKey(), row);
    }

    private Row getRow(final Integer tableId, final Integer primaryKey) {
        Index index = indexManager.getIndex(tableId);

        if (!index.primaryKeyExists(primaryKey)) {
            return null;
        }

        Row row = tableData.get(tableId).get(primaryKey);

        //Try to find the data on disk if it isn't in memory already
        if (row == null || row.getRowData() == null || row.getRowData().isEmpty()) {
            Integer blockId = indexManager.getIndex(tableId).getBlockId(primaryKey);

            if (blockId == null) {
                return null;
            }


            Block block = fileManager.importTableBlock(tableId, blockId, tables.get(tableId).getDescription());
            List<Row> rowData = block.getBlockData();

            for (Row currRow : rowData) {
                if (primaryKey.equals(currRow.getPrimaryKey())) {
                    row = currRow;
                }
            }

            if (row == null || row.getRowData() == null || row.getRowData().isEmpty()) {
                return null;
            }

            addBlock(tableId, block);
        }

        return row;
    }

    protected List<Row> getAllRows(final Integer tableId) {
        List<Row> rows = Lists.newArrayList();

        for (Integer primaryKey : indexManager.getIndex(tableId).getPrimaryKeySet()) {
            rows.add(getRow(tableId, primaryKey));
        }

        return rows;
    }

    protected List<Row> select(final Integer tableId, final Constraint whereConstraint, final OrderConstraint orderConstraint) {
        List<Row> rows = Lists.newArrayList();
        BlockFilter filter = new BlockFilter(whereConstraint);

        Index index = indexManager.getIndex(tableId);

        if (tables.get(tableId) == null) {
            return null;
        }

        Description description = tables.get(tableId).getDescription();
        Map<Integer, Row> tableDataMap = tableData.get(tableId);

        for (Integer blockId : index.getBlockIdSet()) {
            List<Row> blockRows = Lists.newArrayList();
            Set<Integer> cachedPrimaryKeys = Sets.newHashSet();

            //Select the row from memory if it already exists there
            for (Integer primaryKey : index.getReverseIndex().get(blockId)) {
                Row cachedRow = tableDataMap.get(primaryKey);

                if (cachedRow != null) {
                    //If this row is cached and meets the where constraints, select it
                    if (filter.rowMeetsConstraints(cachedRow)) {
                        blockRows.add(cachedRow);
                        cachedPrimaryKeys.add(primaryKey);
                    }
                }
            }

            //Import the remaining (not cached) row data from disk
            List<Row> importedRows = fileManager.importTableBlockWithConstraint(tableId, blockId, description, whereConstraint, cachedPrimaryKeys);

            for (Row row : importedRows) {
                try {
                    addRow(tableId, row);
                } catch (ValidationException e) {
                    e.printStackTrace();
                }
            }

            blockRows.addAll(importedRows);

            rows.addAll(blockRows);

        }

        // Sort the rows depending on the order by clause
        if (orderConstraint == null) {
            OrderConstraint primaryKeyOrder = new OrderConstraint(description.getPrimaryKeyAttribute(), OrderConstraint.Direction.ASCENDING);
            sortRows(rows, primaryKeyOrder);
        } else {
            sortRows(rows, orderConstraint);
        }

        return rows;
    }

    protected List<JoinedRow> selectJoin(final Integer leftTableId, final Integer rightTableId, final JoinConstraint joinConstraint, final Constraint whereConstraint, final OrderConstraint orderConstraint) throws ValidationException {
        List<JoinedRow> rows = Lists.newArrayList();

        ValueOperator joinOperator = joinConstraint.getOperator();
        Attribute leftAttribute = joinConstraint.getLeftAttribute();
        Attribute rightAttribute = joinConstraint.getRightAttribute();

        DataType leftDataType = tables.get(leftTableId).getDescription().getAttribute(leftAttribute.getName()).getType();
        DataType rightDataType = tables.get(rightTableId).getDescription().getAttribute(rightAttribute.getName()).getType();

        if (leftDataType != rightDataType) {
            throw new ValidationException("Data types for join constraints must be the same");
        }

        //TODO support more than just inner join
        JoinConstraint.JoinType joinType = joinConstraint.getJoinType();

        Constraint leftWhereConstraint = removeIrrelevantConstraints(whereConstraint, leftTableId);
        Constraint rightWhereConstraint = removeIrrelevantConstraints(whereConstraint, leftTableId);

        List<Row> leftRows = select(leftTableId, leftWhereConstraint, orderConstraint);
        List<Row> rightRows = select(rightTableId, rightWhereConstraint, orderConstraint);

        for (Row leftRow : leftRows) {
            Object leftValue = leftRow.getRowData().get(leftAttribute);

            for (Row rightRow : rightRows) {
                Object rightValue = rightRow.getRowData().get(rightAttribute);

                if (valuesMeetJoinConstraint(leftDataType, leftValue, rightValue, joinOperator)) {
                    JoinedRow joinedRow = new JoinedRow();

                    joinedRow.setLeftPrimaryKey(leftRow.getPrimaryKey());
                    joinedRow.setLeftRow(leftRow);

                    joinedRow.setRightPrimaryKey(rightRow.getPrimaryKey());
                    joinedRow.setRightRow(rightRow);

                    rows.add(joinedRow);
                }
            }
        }

        return rows;
    }

    protected void clearDatabase() {
        for (Integer tableId : tables.keySet()) {
            removeTable(tableId);
        }
    }

    private Constraint removeIrrelevantConstraints(final Constraint constraint, final Integer tableId) {

        if (constraint instanceof LogicalConstraint) {
            LogicalConstraint logicalConstraint = (LogicalConstraint) constraint;

            Constraint leftConstraint = removeIrrelevantConstraints(logicalConstraint.getLeftConstraint(), tableId);
            Constraint rightConstraint = removeIrrelevantConstraints(logicalConstraint.getRightConstraint(), tableId);

            if (leftConstraint == null) {
                if (rightConstraint == null) {
                    return null;
                }

                return rightConstraint;
            }

            if (rightConstraint == null) {
                return leftConstraint;
            }

            logicalConstraint.setLeftConstraint(leftConstraint);
            logicalConstraint.setRightConstraint(rightConstraint);

            return logicalConstraint;
        }

        if (constraint instanceof ValueConstraint) {
            ValueConstraint valueConstraint = (ValueConstraint) constraint;
            Attribute attribute = valueConstraint.getAttribute();

            List<Attribute> attrs = Arrays.asList(tables.get(tableId).getDescription().getAttributes());

            if (attrs.contains(attribute)) {
                return constraint;
            }

            return null;
        }

        return null;
    }

    /**
     * Adds a table data block to in-memory storage.
     *
     * @param tableId
     * @param block
     */
    private void addBlock(final Integer tableId, final Block block) {
        for (Row row : block.getBlockData()) {
            tableData.get(tableId).put(row.getPrimaryKey(), row);
        }
    }

    private void dirtyCheck() {
        if (ignoreDirty) { return; }

        dirtyCount++;

        if (dirtyCount < DIRTY_COUNT_LIMIT || forceFlush) {
            return;
        }

        export();

        dirtyCount = 0;
    }

    private void export() {
        if (!exportDisabled) {
            exportBlocks();
            exportIndexes();
        }
    }

    private void exportBlocks() {
        exportBlockMetaData();
        exportBlockRowData();
    }

    private void exportBlockMetaData() {
        for (Integer tableId : indexManager.getTableIdSet()) {
            List<Block> metaBlocks = Lists.newArrayList();

            for (Integer blockId  : blockManager.getBlockIdSet(tableId)) {
                Block block = blockManager.getBlock(tableId, blockId);
                metaBlocks.add(block);
            }

            fileManager.exportBlockMetaData(tableId, metaBlocks);
        }
    }

    private void exportBlockRowData() {
        for (Integer tableId : indexManager.getTableIdSet()) {
            Map<Integer, List<Integer>> dirtyBlockIndex = indexManager.getIndex(tableId).getDirtyPrimaryKeys();

            for (Integer blockId : dirtyBlockIndex.keySet()) {
                List<Integer> primaryKeys = dirtyBlockIndex.get(blockId);

                List<Row> rows = Lists.newArrayList();

                for (Integer primaryKey : primaryKeys) {
                    if (tableData.get(tableId) != null) {
                        Row row = tableData.get(tableId).get(primaryKey);

                        if (row != null) {
                            rows.add(tableData.get(tableId).get(primaryKey));
                        }
                    }
                }

                int blockSize = blockManager.getBlockSize(tableId, blockId);
                fileManager.exportTableBlockMerge(tableId, blockId, blockSize, rows);
            }

            indexManager.getIndex(tableId).clearAllDirtyPrimaryKeys();
        }
    }

    private void exportIndexes() {
        fileManager.exportIndexes(indexManager);
    }

    private boolean valuesMeetJoinConstraint(final DataType dataType, final Object leftValue, final Object rightValue, final ValueOperator joinOperator) {

        if (leftValue == null) {
            if (joinOperator == ValueOperator.EQUALS) {
                return rightValue == null;
            }

            if (joinOperator == ValueOperator.NOT_EQUALS) {
                return rightValue != null;
            }

            return false;
        }

        if (rightValue == null) {
            if (joinOperator == ValueOperator.EQUALS) {
                return leftValue == null;
            }

            if (joinOperator == ValueOperator.NOT_EQUALS) {
                return leftValue != null;
            }

            return false;
        }

        switch (dataType) {
            case INT:

                //Probably an integer, let's make sure
                int leftValueInt;
                int rightValueInt;

                try {
                    leftValueInt = Integer.parseInt(leftValue.toString());
                    rightValueInt = Integer.parseInt (rightValue.toString());
                } catch (final NumberFormatException nfe) {
                    //Hmm, wasn't an integer
                    throw nfe;
                } catch (final ClassCastException cce) {
                    //Well damn, this doesn't work;
                    throw cce;
                }

                switch (joinOperator) {
                    case EQUALS:
                        return leftValueInt == rightValueInt;
                    case NOT_EQUALS:
                        return leftValueInt != rightValueInt;
                    case GREATER_THAN:
                        return leftValueInt > rightValueInt;
                    case GREATER_THAN_EQUAL_TO:
                        return leftValueInt >= rightValueInt;
                    case LESS_THAN:
                        return leftValueInt < rightValueInt;
                    case LESS_THAN_EQUAL_TO:
                        return leftValueInt <= rightValueInt;
                }

                return false;

            case STRING:

                String leftValueString = leftValue.toString();
                String rightValueString = rightValue.toString();

                switch (joinOperator) {
                    case EQUALS:
                        return leftValueString.equals(rightValueString);
                    case NOT_EQUALS:
                        return !leftValueString.equals(rightValueString);
                    case GREATER_THAN:
                        return leftValueString.compareTo(rightValueString) > 0;
                    case GREATER_THAN_EQUAL_TO:
                        return leftValueString.compareTo(rightValueString) >= 0;
                    case LESS_THAN:
                        return leftValueString.compareTo(rightValueString) < 0;
                    case LESS_THAN_EQUAL_TO:
                        return leftValueString.compareTo(rightValueString) <= 0;
                }

                return false;
        }

        return false;
    }

    private void sortRows(final List<Row> unsortedRows, final OrderConstraint orderConstraint) {
        Collections.sort(unsortedRows, new Comparator<Row>() {
            @Override
            public int compare(Row row1, Row row2) {
                Attribute attribute = orderConstraint.getAttribute();
                OrderConstraint.Direction direction = orderConstraint.getDirection();

                Object row1Data = row1.getRowData().get(attribute);
                Object row2Data = row2.getRowData().get(attribute);

                if (row1Data == null) {
                    if (row2Data == null) {
                        return 0;
                    }

                    return -1;
                }

                if (row2Data == null) {
                    return 1;
                }

                switch (attribute.getType()) {
                    case INT:

                        Integer int1 =  (Integer) row1Data;
                        Integer int2 =  (Integer) row2Data;

                        switch (direction) {
                            case ASCENDING:
                                return int1.compareTo(int2);
                            case DESCENDING:
                                return int2.compareTo(int1);
                        }

                        break;

                    case STRING:

                        String str1 =  (String) row1Data;
                        String str2 =  (String) row2Data;

                        switch (direction) {
                            case ASCENDING:
                                return str1.compareTo(str2);
                            case DESCENDING:
                                return str2.compareTo(str1);
                        }

                        break;

                }

                return 0;
            }
        });
    }

}
