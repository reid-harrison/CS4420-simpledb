package gt.cs4420.relationaldb.database.storage;

import com.google.common.collect.Maps;
import gt.cs4420.relationaldb.database.storage.file.FileManager;
import gt.cs4420.relationaldb.domain.Table;

import java.util.Map;
import java.util.Set;

public class StorageData {

    private Map<Integer, Table> tables;

    private FileManager fileManager;

    public StorageData() {
        tables = Maps.newHashMap();
        loadTableDescriptions();
    }

    private void loadTableDescriptions() {
        Set<Table> tableSet = fileManager.importDescriptions();

        for (final Table table : tableSet) {
            tables.put(table.getId(), table);
        }
    }

    public boolean tableExists(final Integer tableId) {
        return tables.containsKey(tableId);
    }

    public Table getTable(final Integer tableId) {
        return tables.get(tableId);
    }

    public void addTable(final Table table) {
        tables.put(table.getId(), table);
    }

    public void removeTable(final Integer tableId) {
        tables.remove(tableId);
    }

}
