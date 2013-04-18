package gt.cs4420.relationaldb.database.storage.index;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Index {

    //A Map from primary keys to block ids
    private Map<Integer, Integer> index;

    //Map from primary keys to their index within the block
    private Map<Integer, Integer> blockIndex;

    //The index of blocks to the primary keys they contain
    private Map<Integer, List<Integer>> reverseIndex;

    //The lists that keep track of which rows have been modified in each block;
    private Map<Integer, List<Integer>> dirtyPrimaryKeys;

    public Index() {
        index = Maps.newHashMap();
        blockIndex = Maps.newHashMap();
        reverseIndex = Maps.newHashMap();
        dirtyPrimaryKeys = Maps.newHashMap();
    }

    public Set<Integer> getPrimaryKeySet() {
        return index.keySet();
    }

    public Set<Integer> getBlockIdSet() {
        return reverseIndex.keySet();
    }

    public Integer getBlockId(final Integer primaryKey) {
        return index.get(primaryKey);
    }

    public void addIndexEntry(final Integer primaryKey, final Integer blockId, final Integer blockIndex) {
        index.put(primaryKey, blockId);
        this.blockIndex.put(primaryKey, blockIndex);

        if (reverseIndex.get(blockId) == null) {
            reverseIndex.put(blockId, new ArrayList<Integer>());
        }

        reverseIndex.get(blockId).add(primaryKey);
    }

    public void removeIndexEntry(final Integer primaryKey, final Integer blockId, final Integer blockIndex) {
        index.remove(primaryKey);
        this.blockIndex.remove(blockIndex);
        reverseIndex.get(blockId).remove(primaryKey);
    }

    public Map<Integer, List<Integer>> getDirtyPrimaryKeys() {
        return dirtyPrimaryKeys;
    }

    public void addDirtyPrimaryKey(final Integer blockId, final Integer primaryKey) {
        List<Integer> dirtyKeys = dirtyPrimaryKeys.get(blockId);

        if (dirtyKeys == null) {
            dirtyKeys = Lists.newArrayList();
            dirtyPrimaryKeys.put(blockId, dirtyKeys);
        }

        if (dirtyKeys.contains(primaryKey)) {
            return;
        }

        dirtyKeys.add(primaryKey);
    }

    public void removeDirtyPrimaryKey(final Integer blockId, final Integer primaryKey) {
        List<Integer> dirtyKeys = dirtyPrimaryKeys.get(blockId);

        if (dirtyKeys == null || !dirtyKeys.contains(primaryKey)) {
            return;
        }

        dirtyKeys.remove(blockId);
    }

    public void clearAllDirtyPrimaryKeys() {
        dirtyPrimaryKeys.clear();
    }

    /**
     * Returns the index of block IDs to the List of primary keys they contain.
     *
     * @return Map<Integer, List<Integer>>
     */
    public Map<Integer, List<Integer>> getReverseIndex() {
        return reverseIndex;
    }

    public int getBlockIndex(final Integer primaryKey) {
        return blockIndex.get(primaryKey);
    }

    public int getNextBlockIndex(final Integer blockId) {
        if (reverseIndex.get(blockId) == null) {
            return 0;
        }

        return reverseIndex.get(blockId).size();
    }

    public boolean primaryKeyExists(final Integer primaryKey) {
        return index.containsKey(primaryKey);
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
