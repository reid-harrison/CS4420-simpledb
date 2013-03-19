package gt.cs4420.relationaldb.database.storage;

import com.google.common.collect.Maps;
import gt.cs4420.relationaldb.database.storage.file.FileManager;
import gt.cs4420.relationaldb.database.storage.index.IndexManager;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.DataType;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.exception.ValidationException;

import java.util.Map;
import java.util.Set;

/**
 * TODO:
 * -Implement in-memory storage
 * -Mechanism for writing to disk
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

    private Map<String, Integer> tableNames;
    private Map<Integer, Table> tables;
    private Map<Integer, Map<Integer, Map<Attribute, Object>>> tableData;

    private IndexManager indexManager;

    private FileManager fileManager;

    //Random necessary data
    private Integer nextId;

    private StorageData() {
        tableNames = Maps.newHashMap();
        tables = Maps.newHashMap();
        tableData = Maps.newHashMap();

        indexManager = new IndexManager();
        fileManager = new FileManager();

        loadTableDescriptions();
    }

    private void loadTableDescriptions() {
        Set<Table> tableSet = fileManager.importDescriptions();

        Integer highestId = 0;

        for (final Table table : tableSet) {
            tableNames.put(table.getName(), table.getId());
            tables.put(table.getId(), table);

            if (table.getId() > highestId) {
                highestId = table.getId();
            }
        }

        nextId = highestId + 1;
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
    }

    protected void removeTable(final Integer tableId) {
        tables.remove(tableId);
    }

    protected void insert(final Integer tableId, final Map<Attribute, Object> attributes) throws ValidationException {
        Integer primaryKey = addRow(getTable(tableId), attributes);

        //TODO Use a real block index
        int blockIndex = 0;

        indexManager.getIndex(tables.get(tableId)).setIndex(primaryKey, blockIndex);

        //TODO Insert data into the in-memory tableData map
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
        Object primaryKey = attributes.get(table.getPrimaryKeyAttribute());

        if (tableData.get(table.getId()).containsKey(primaryKey)) {
            throw new ValidationException("A row already exists with the provided primary key attribute; primary keys must be unique");
        }

        if (table.getPrimaryKeyAttribute().getType() == DataType.INT) {
            tableData.get(table.getId()).put((Integer) primaryKey, attributes);
        }

        return (Integer) primaryKey;
    }

}
