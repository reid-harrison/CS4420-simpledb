package gt.cs4420.relationaldb.database.storage;

import com.google.common.collect.Maps;
import gt.cs4420.relationaldb.database.storage.file.FileManager;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.Table;

import java.util.Map;
import java.util.Set;

/**
 * TODO:
 * -Mechanism for writing to disk
 * -Indexing
 */
public class StorageData {

    private static StorageData instance;

    protected static StorageData getInstance() {
        if (instance == null) {
            instance = new StorageData();
        }

        return instance;
    }



    private Map<Integer, Table> tables;
    private Map<Integer, Map<Integer, Map<Attribute, Object>>> tableData;

    private FileManager fileManager;

    private StorageData() {
        tables = Maps.newHashMap();
        loadTableDescriptions();
    }

    private void loadTableDescriptions() {
        Set<Table> tableSet = fileManager.importDescriptions();

        for (final Table table : tableSet) {
            tables.put(table.getId(), table);
        }
    }

    protected boolean tableExists(final Integer tableId) {
        return tables.containsKey(tableId);
    }

    protected Table getTable(final Integer tableId) {
        return tables.get(tableId);
    }

    protected void addTable(final Table table) {
        tables.put(table.getId(), table);
    }

    protected void removeTable(final Integer tableId) {
        tables.remove(tableId);
    }

    protected void insert(final Integer tableId, final Map<Attribute, Object> attributes) {
        tables.get(tableId).addRow(attributes);
    }

}
