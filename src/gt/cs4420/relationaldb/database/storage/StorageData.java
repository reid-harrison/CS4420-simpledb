package gt.cs4420.relationaldb.database.storage;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import gt.cs4420.relationaldb.database.storage.block.Block;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
     * TODO Actually drop table from disk and remove description
     * @param tableId
     */
    protected void removeTable(final Integer tableId) {
        tables.remove(tableId);
        dirtyCheck();
    }

    protected void insert(final Integer tableId, final Row row) throws ValidationException {
        addRow(tableId, row);

        Integer blockId = blockManager.allocateBlockSpace(tableId, row.getRowData().size());
        Integer blockIndex = indexManager.getIndex(tableId).getNextBlockIndex(blockId);

        indexManager.addIndexEntry(tableId, row.getPrimaryKey(), blockId, blockIndex);

        dirtyCheck();
    }

    protected void update(final Integer tableId, final Row row) throws ValidationException {
        Row currentRow = getRow(tableId, row.getPrimaryKey());

        if (currentRow == null) {
            insert(tableId, row);
            return;
        }

        Map<Attribute, Object> rowData = row.getRowData();

        currentRow.getRowData().putAll(rowData);

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
            Integer blockIndex = indexManager.getIndex(tableId).getBlockIndex(primaryKey);

            if (blockId == null) {
                return null;
            }

            row = fileManager.importRow(tableId, blockId, blockIndex);

            try {
                addRow(tableId, row);
            } catch (final ValidationException ve) {
                //Row must have already been added
            }
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

    public List<Row> getRows(final Integer tableId, final Constraint whereConstraint) {
        //TODO add special handling if constraint involves primary key
        //TODO implement getRows
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

        if (dirtyCount < DIRTY_COUNT_LIMIT && !forceFlush) {
            return;
        }

        export();

        dirtyCount = 0;
    }

    private void export() {
        //TODO Make a smart export (only export modified data)
        //TODO Currently, block data will get overwritten if it hasn't been imported yet
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
            Map<Integer, List<Integer>> blockIndex = indexManager.getIndex(tableId).getReverseIndex();

            for (Integer blockId : blockIndex.keySet()) {
                List<Integer> primaryKeys = blockIndex.get(blockId);

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
                fileManager.exportTableBlock(tableId, blockId, blockSize, rows);
            }
        }
    }

    private void exportIndexes() {
        fileManager.exportIndexes(indexManager);
    }

}
