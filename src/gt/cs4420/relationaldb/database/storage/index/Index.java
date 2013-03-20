package gt.cs4420.relationaldb.database.storage.index;

import com.google.common.collect.Maps;

import java.util.Map;

public class Index {

    //For now, just a Map from primary keys to block ids
    private Map<Integer, Integer> index;

    public Index() {
        index = Maps.newHashMap();
    }

    public Integer getBlockId(final Integer primaryKey) {
        return index.get(primaryKey);
    }

    public void addIndexEntry(final Integer primaryKey, final Integer blockId) {
        index.put(primaryKey, blockId);
    }

}
