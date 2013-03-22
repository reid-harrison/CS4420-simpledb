package gt.cs4420.relationaldb.database.storage.index;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Set;

public class IndexManager {

    private Map<Integer, Index> indexes;

    public IndexManager() {
        indexes = Maps.newHashMap();
    }

    public void createIndex(final Integer tableId) {
        indexes.put(tableId, new Index());
    }

    public Index getIndex(final Integer tableId) {
        if (indexes.get(tableId) == null) {
            indexes.put(tableId, new Index());
        }

        return indexes.get(tableId);
    }

    public void addIndex(final Integer tableId, final Index index) {
        indexes.put(tableId, index);
    }

    public void addIndexEntry(final Integer tableId, final Integer primaryKey, final Integer blockId) {
        if (indexes.get(tableId) == null) {
            createIndex(tableId);
        }

        indexes.get(tableId).addIndexEntry(primaryKey, blockId);
    }

    public Set<Integer> getTableIdSet() {
        return indexes.keySet();
    }
}
