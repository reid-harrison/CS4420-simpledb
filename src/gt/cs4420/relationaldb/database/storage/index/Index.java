package gt.cs4420.relationaldb.database.storage.index;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Index {

    //For now, just a Map from primary keys to block ids
    private Map<Integer, Integer> index;

    //The index of blocks to the primary keys they contain
    private Map<Integer, List<Integer>> blockIndex;
    

    public Index() {
        index = Maps.newHashMap();
        blockIndex = Maps.newHashMap();
    }

    public Set<Integer> getPrimaryKeySet() {
        return index.keySet();
    }

    public Integer getBlockId(final Integer primaryKey) {
        return index.get(primaryKey);
    }

    public void addIndexEntry(final Integer primaryKey, final Integer blockId) {
        index.put(primaryKey, blockId);

        if (blockIndex.get(blockId) == null) {
            blockIndex.put(blockId, new ArrayList<Integer>());
        }

        blockIndex.get(blockId).add(primaryKey);
    }

    public void removeIndexEntry(final Integer primaryKey, final Integer blockId) {
        index.remove(primaryKey);

        blockIndex.get(blockId).remove(primaryKey);
    }

    public Map<Integer, List<Integer>> getBlockIndex() {
        return blockIndex;
    }

    /**
     * Returns true if both Indexes have the same index mapping primaryKeys -> block ID.
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(final Object object) {
        if (object == null || !(object instanceof Index)) {
            return false;
        }

        Index other = (Index) object;
        Set<Integer> otherSet = other.getPrimaryKeySet();
        Set<Integer> thisSet = getPrimaryKeySet();

        if (!otherSet.equals(thisSet)) {
            return false;
        }

        for (Integer primaryKey : thisSet) {
            if (!index.get(primaryKey).equals(other.getBlockId(primaryKey))) {
                return false;
            }
        }

        return true;
    }

}
