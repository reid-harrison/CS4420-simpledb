package gt.cs4420.relationaldb.database.storage.index;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractIndex implements Index {

    //The index of blocks to the primary keys they contain
    private Map<Integer, List<Integer>> reverseIndex;

    //The lists that keep track of which rows have been modified in each block;
    private Map<Integer, List<Integer>> dirtyPrimaryKeys;

    public AbstractIndex() {
        reverseIndex = Maps.newHashMap();
        dirtyPrimaryKeys = Maps.newHashMap();
    }

    @Override
    public Set<Integer> getBlockIdSet() {
        return reverseIndex.keySet();
    }

    @Override
    public Map<Integer, List<Integer>> getReverseIndex() {
        return reverseIndex;
    }

    @Override
    public int getNextBlockIndex(final Integer blockId) {
        if (reverseIndex.get(blockId) == null) {
            return 0;
        }

        return reverseIndex.get(blockId).size();
    }

    @Override
    public void addIndexEntry(final Integer primaryKey, final Integer blockId, final Integer blockIndex) {
        if (getReverseIndex().get(blockId) == null) {
            getReverseIndex().put(blockId, new ArrayList<Integer>());
        }

        getReverseIndex().get(blockId).add(primaryKey);
    }

    @Override
    public void removeIndexEntry(final Integer primaryKey) {
        Integer blockId = getBlockId(primaryKey);

        //Make sure that the reverse index reference is gone
        if (blockId == null) {
            for (Integer block: reverseIndex.keySet()) {
                if (reverseIndex.get(block).contains(primaryKey)) {
                    blockId = block;
                    break;
                }
            }

            //Could not find primary key in block index
            return;
        }

        getReverseIndex().get(blockId).remove(primaryKey);
    }

    @Override
    public Map<Integer, List<Integer>> getDirtyPrimaryKeys() {
        return dirtyPrimaryKeys;
    }

    @Override
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

    @Override
    public void removeDirtyPrimaryKey(final Integer blockId, final Integer primaryKey) {
        List<Integer> dirtyKeys = dirtyPrimaryKeys.get(blockId);

        if (dirtyKeys == null || !dirtyKeys.contains(primaryKey)) {
            return;
        }

        dirtyKeys.remove(blockId);
    }

    @Override
    public void clearAllDirtyPrimaryKeys() {
        dirtyPrimaryKeys.clear();
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
            if (!getBlockId(primaryKey).equals(other.getBlockId(primaryKey))) {
                return false;
            }
        }

        return true;
    }

}
