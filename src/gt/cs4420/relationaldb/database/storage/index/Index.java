package gt.cs4420.relationaldb.database.storage.index;

import com.google.common.collect.Maps;

import java.util.Map;

public class Index {

    //For now, just a Map from primary keys to blocks
    private Map<Integer, Integer> index;

    public Index() {
        index = Maps.newHashMap();
    }

    public Integer getIndex(final Integer primaryKey) {
        return index.get(primaryKey);
    }

    public void setIndex(final Integer primaryKey, final Integer blockId) {
        index.put(primaryKey, blockId);
    }

}
