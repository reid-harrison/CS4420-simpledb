package gt.cs4420.relationaldb.database.storage;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
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
 * TODO:
 * -Implement in-memory storage
 * -Mechanism for writing to disk
 * -Importing data from disk
 * -Indexing
 */
class StorageData {

    private static StorageData instance;

    protected static StorageData getInstance() {
        if (instance == null) {
            instance = new StorageData();
        }

        return instance;
    }

    private final int DIRTY_COUNT_LIMIT = 10;
    private int dirtyCount = 0;

    protected static boolean ignoreDirty = false;
    protected static boolean exportDisabled = false;

    private Map<String, Integer> tableNames;
    private Map<Integer, Table> tables;
    private Map<Integer, Map<Integer, Map<Attribute, Object>>> tableData;

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
        fileManager = new FileManager();
        blockManager = new BlockManager();

        loadTableDescriptions();
        createIndex();
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

    private void createIndex() {
        for (Integer tableId : tables.keySet()) {
            indexManager.createIndex(tableId);
        }

        fileManager.importIndexes(indexManager);

        //TODO Set up block manager
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

        //TODO Make use of spanning blocks and figure out what to do about long ass Strings
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
