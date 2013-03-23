package gt.cs4420.relationaldb.database.storage;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import gt.cs4420.relationaldb.database.storage.block.Block;
import gt.cs4420.relationaldb.database.storage.block.BlockManager;
import gt.cs4420.relationaldb.database.storage.file.FileManager;
import gt.cs4420.relationaldb.database.storage.index.IndexManager;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.DataType;
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

    //Table ID -> (Primary Key -> Attribute value mapping)
    private Map<Integer, Map<Integer, Map<Attribute, Object>>> tableData;

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

    protected void insert(final Integer tableId, final Map<Attribute, Object> attributes) throws ValidationException {
        Integer primaryKey = addRow(getTable(tableId), attributes);

        //TODO Figure out what to do about long ass Strings
        Integer blockIndex = blockManager.allocateBlockSpace(tableId, attributes.size());

        indexManager.addIndexEntry(tableId, primaryKey, blockIndex);

        dirtyCheck();
    }

    protected Integer getNextTableId() {
        return nextId;
    }

    /**
     * Adds a row to this in-memory representation of a Table. This will not guarantee that the row is actually written
     * to disk.
     *
     * @param attributes Attribute values for the new row
     * @return
     */
    private Integer addRow(final Table table, final Map<Attribute, Object> attributes) throws ValidationException {
        Attribute primaryKeyAttr = table.getDescription().getPrimaryKeyAttribute();
        Object primaryKey = attributes.get(primaryKeyAttr);

        if (tableData.get(table.getId()).containsKey(primaryKey)) {
            throw new ValidationException("A row already exists with the provided primary key attribute; primary keys must be unique");
        }

        if (primaryKeyAttr.getType() == DataType.INT) {
            tableData.get(table.getId()).put((Integer) primaryKey, attributes);
        }

        return (Integer) primaryKey;
    }

    /**
     * TODO
     * -Something special will have to be done to cast deserialized Objects into their appropriate types based off
     *  of an Attribute's DataType
     */
    private Map<Attribute, Object> getRow(final Integer tableId, final Integer primaryKey) {
        Integer blockId = indexManager.getIndex(tableId).getBlockId(primaryKey);

        if (blockId == null) {
            throw new NullPointerException("Primary key: " + primaryKey + " does not exist for table ID: " + tableId);
        }

        Map<Attribute, Object> rowData = tableData.get(tableId).get(primaryKey);

        if (rowData == null || rowData.isEmpty()) {
            Block block = fileManager.importTableBlock(tableId, blockId);
            List<Map<Attribute, Object>> blockData = block.getBlockData();

            //TODO Add a better representation of row data so access by primary key can be more efficient
            for (Map<Attribute, Object> row : blockData) {
                Integer currPrimaryKey = (Integer) row.get(tables.get(tableId).getDescription().getPrimaryKeyAttribute());

                if (primaryKey.equals(currPrimaryKey)) {
                    rowData = row;
                }
            }

            if (rowData == null) {
                throw new NullPointerException("Row data could not be retrieved and populated");
            }

            addBlock(tableId, block);
        }

        Block block = fileManager.importTableBlock(tableId, blockId);

        return rowData;
    }

    private void addBlock(final Integer tableId, final Block block) {
        for (Map<Attribute, Object> rowData : block.getBlockData()) {
            Integer primaryKey = (Integer) rowData.get(tables.get(tableId).getDescription().getPrimaryKeyAttribute());
            tableData.get(tableId).put(primaryKey, rowData);
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

                List<Map<Attribute, Object>> blockData = Lists.newArrayList();

                for (Integer primaryKey : primaryKeys) {
                    blockData.add(tableData.get(tableId).get(primaryKey));
                }

                int blockSize = blockManager.getBlockSize(tableId, blockId);
                fileManager.exportTableBlock(tableId, blockId, blockSize, blockData);
            }
        }
    }

    private void exportIndexes() {
        fileManager.exportIndexes(indexManager);
    }

}
