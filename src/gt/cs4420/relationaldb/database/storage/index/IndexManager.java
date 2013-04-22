package gt.cs4420.relationaldb.database.storage.index;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Set;

public class IndexManager {
	//Table ID -> Index
    private Map<Integer, HashIndex> indexes;

    public IndexManager() {
        indexes = Maps.newHashMap();
    }

    public void createIndex(final Integer tableId) {
        indexes.put(tableId, new HashIndex());
    }

    public HashIndex getIndex(final Integer tableId) {
        if (indexes.get(tableId) == null) {
            indexes.put(tableId, new HashIndex());
        }

        return indexes.get(tableId);
    }

    public void addIndex(final Integer tableId, final HashIndex index) {
        indexes.put(tableId, index);
    }

    public void removeIndex(final Integer tableId) {
        indexes.remove(tableId);
    }

    public void addIndexEntry(final Integer tableId, final Integer primaryKey, final Integer blockId, final Integer blockIndex) {
        if (indexes.get(tableId) == null) {
            createIndex(tableId);
        }

        indexes.get(tableId).addIndexEntry(primaryKey, blockId, blockIndex);
    }

    public Set<Integer> getTableIdSet() {
        return indexes.keySet();
    }

    /**
     * Returns true if the two IndexManagers both have the same table ID -> Index mapping.
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(final Object object) {
        if (object == null || !(object instanceof IndexManager)) {
            return false;
        }

        IndexManager other = (IndexManager) object;
        Set<Integer> otherSet = other.getTableIdSet();
        Set<Integer> thisSet = indexes.keySet();

        if (!otherSet.equals(thisSet)) {
            return false;
        }

        for (Integer tableId : thisSet) {
            if (!indexes.get(tableId).equals(other.getIndex(tableId))) {
                return false;
            }
        }

        return true;
    }
}
