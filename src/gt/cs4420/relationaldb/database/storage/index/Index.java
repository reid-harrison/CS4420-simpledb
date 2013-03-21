package gt.cs4420.relationaldb.database.storage.index;

import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class Index {

    //For now, just a Map from primary keys to block ids
    private Map<Integer, Integer> index;

    //The index of blocks to the primary keys they contain
    private Map<Integer, List<Integer>> blockIndex;

    public Index() {
        index = Maps.newHashMap();
    }

    public Integer getBlockId(final Integer primaryKey) {
        return index.get(primaryKey);
    }

    public void addIndexEntry(final Integer primaryKey, final Integer blockId) {
        index.put(primaryKey, blockId);

        blockIndex.get(blockId).add(primaryKey);
    }

    public void removeIndexEntry(final Integer primaryKey, final Integer blockId) {
        index.remove(primaryKey);

        blockIndex.get(blockId).remove(primaryKey);
    }

    public Map<Integer, List<Integer>> getBlockIndex() {
        return blockIndex;
    }

}
