package gt.cs4420.relationaldb.database.storage.index;

import com.google.common.collect.Maps;
import gt.cs4420.relationaldb.domain.Table;

import java.util.Map;

public class IndexManager {

    private Map<Table, Index> indexes;

    public IndexManager() {
        indexes = Maps.newHashMap();
    }

    public void addIndex(final Table table, final Index index) {
        indexes.put(table, index);
    }

    public Index getIndex(final Table table) {
        if (indexes.get(table) == null) {
            indexes.put(table, new Index());
        }

        return indexes.get(table);
    }
}
