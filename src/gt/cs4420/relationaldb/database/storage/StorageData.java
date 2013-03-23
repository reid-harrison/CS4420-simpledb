package gt.cs4420.relationaldb.database.storage;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import gt.cs4420.relationaldb.database.storage.block.Block;
import gt.cs4420.relationaldb.database.storage.block.BlockManager;
import gt.cs4420.relationaldb.database.storage.file.FileManager;
import gt.cs4420.relationaldb.database.storage.index.IndexManager;
import gt.cs4420.relationaldb.domain.Row;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.exception.ValidationException;

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
    protected static StorageData getInstance() {
        if (instance == null) {
            instance = new StorageData();
        }

        return instance;
    }

    //The root directory relative to run-time directory where the database files are kept (this will be moved elsewhere later)
    private final String DB_ROOT_DIRECTORY = "database";

    //The amount of dirty operations to allow before dirtied data is flushed
    private final int DIRTY_COUNT_LIMIT = 10;
    //The current number of dirty operations before last flush
    private int dirtyCount = 0;

    //Control flags for exporting data to file that are useful for testing
    protected static boolean ignoreDirty = false;
    protected static boolean exportDisabled = false;

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

    private StorageData() {
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

        //Import the block sizes for already allocated blocks referenced by the current IndexManager
        for (Integer tableId : indexManager.getTableIdSet()) {
            List<Block> blockSizes = fileManager.importBlockSizes(tableId);

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

    protected Table getTable(final Integer tableId) {
        return tables.get(tableId);
    }

    protected Table getTable(final String tableName) {
        return getTable(tableNames.get(tableName));
    }

    protected void addTable(final Table table) {
        tables.put(table.getId(), table);
        tableNames.put(table.getName(), table.getId());
        dirtyCheck();
    }

    protected void removeTable(final Integer tableId) {
        tables.remove(tableId);
        dirtyCheck();
    }

    protected void insert(final Integer tableId, final Row row) throws ValidationException {
        addRow(tableId, row);

        //TODO Figure out what to do about long ass Strings
        Integer blockIndex = blockManager.allocateBlockSpace(tableId, row.getRowData().size());

        indexManager.addIndexEntry(tableId, row.getPrimaryKey(), blockIndex);

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

        //TODO This needs to check the IndexManager, not table data!
        if (tableData.get(tableId).containsKey(row.getPrimaryKey())) {
            throw new ValidationException("A row already exists with the provided primary key attribute; primary keys must be unique");
        }

        tableData.get(tableId).put(row.getPrimaryKey(), row);
    }

    /**
     * TODO
     * -Something special will have to be done to cast deserialized Objects into their appropriate types based off
     *  of an Attribute's DataType
     */
    private Row getRow(final Integer tableId, final Integer primaryKey) {
        Integer blockId = indexManager.getIndex(tableId).getBlockId(primaryKey);

        if (blockId == null) {
            throw new NullPointerException("Primary key: " + primaryKey + " does not exist for table ID: " + tableId);
        }

        Row row = tableData.get(tableId).get(primaryKey);

        //Try to find the data on disk if it isn't in memory already
        if (row == null || row.getRowData() == null || row.getRowData().isEmpty()) {
            Block block = fileManager.importTableBlock(tableId, blockId);
            List<Row> rowData = block.getBlockData();

            //TODO Add a better representation of row data so access by primary key can be more efficient
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

    private void addBlock(final Integer tableId, final Block block) {
        for (Row row : block.getBlockData()) {
            tableData.get(tableId).put(row.getPrimaryKey(), row);
        }
    }

    private void dirtyCheck() {
        if (ignoreDirty) { return; }

        dirtyCount++;

        if (dirtyCount < DIRTY_COUNT_LIMIT) {
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
        for (Integer tableId : indexManager.getTableIdSet()) {
            Map<Integer, List<Integer>> blockIndex = indexManager.getIndex(tableId).getBlockIndex();

            for (Integer blockId : blockIndex.keySet()) {
                List<Integer> primaryKeys = blockIndex.get(blockId);

                List<Row> rows = Lists.newArrayList();

                for (Integer primaryKey : primaryKeys) {
                    rows.add(tableData.get(tableId).get(primaryKey));
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
