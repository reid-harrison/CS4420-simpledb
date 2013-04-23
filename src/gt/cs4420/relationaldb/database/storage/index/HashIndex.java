package gt.cs4420.relationaldb.database.storage.index;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Set;

public class HashIndex extends AbstractIndex {

    //A Map from primary keys to block ids
    private Map<Integer, Integer> index;

    //Map from primary keys to their index within the block
    private Map<Integer, Integer> blockIndex;

    public HashIndex() {
        index = Maps.newHashMap();
        blockIndex = Maps.newHashMap();
    }

    @Override
    public Set<Integer> getPrimaryKeySet() {
        return index.keySet();
    }

    @Override
    public Integer getBlockId(final Integer primaryKey) {
        return index.get(primaryKey);
    }

    @Override
    public void addIndexEntry(final Integer primaryKey, final Integer blockId, final Integer blockIndex) {
        index.put(primaryKey, blockId);
        this.blockIndex.put(primaryKey, blockIndex);

        super.addIndexEntry(primaryKey, blockId, blockIndex);
    }

    @Override
    public void removeIndexEntry(final Integer primaryKey) {
        super.removeIndexEntry(primaryKey);

        index.remove(primaryKey);
        this.blockIndex.remove(primaryKey);
    }

    @Override
    public int getBlockIndex(final Integer primaryKey) {
        return blockIndex.get(primaryKey);
    }

    @Override
    public boolean primaryKeyExists(final Integer primaryKey) {
        return index.containsKey(primaryKey);
    }

}
