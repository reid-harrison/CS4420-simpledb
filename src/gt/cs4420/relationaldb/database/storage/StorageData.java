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
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.Description;
import gt.cs4420.relationaldb.domain.Row;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import gt.cs4420.relationaldb.domain.query.Constraint;

import java.util.*;

/**
 * StorageData
 *
 * Maintains state information about data in the database including a cache of recently accessed data. StorageData is best
 * kept as a singleton so that data remains consistent.
 *
 * TODO:
 * -More database functionality for StorageManager
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
        return getTable(tableNames.get(tableName));
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
        //TODO Don't select the entire row since only the primary key is needed
        List<Row> affectedRows = select(tableId, whereConstraint);

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

    public List<Row> getAllRows(final Integer tableId) {
        List<Row> rows = Lists.newArrayList();

        for (Integer primaryKey : indexManager.getIndex(tableId).getPrimaryKeySet()) {
            rows.add(getRow(tableId, primaryKey));
        }

        return rows;
    }

    public List<Row> select(final Integer tableId, final Constraint whereConstraint) {
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

            //TODO decide what to do about caching these blocks in memory
            //Import the remaining (not cached) row data from disk
            blockRows.addAll(fileManager.importTableBlockWithConstraint(tableId, blockId, description, whereConstraint, cachedPrimaryKeys));

            //Sort the rows selected from the current block by primary key
            Collections.sort(blockRows, new Comparator<Row>() {
                @Override
                public int compare(Row o1, Row o2) {
                    Integer pk1 = o1.getPrimaryKey();
                    Integer pk2 = o2.getPrimaryKey();

                    if (pk1 == null) {
                        if (pk2 == null) {
                            return 0;
                        }

                        return pk2;
                    }

                    return pk1.compareTo(pk2);
                }
            });

            rows.addAll(blockRows);

        }

        return rows;
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

}
