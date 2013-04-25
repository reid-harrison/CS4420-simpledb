package gt.cs4420.relationaldb.database.storage;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import gt.cs4420.relationaldb.domain.Attribute;

import java.util.Map;
import java.util.Set;

/**
 * StorageStatistics
 *
 * Singleton class used to maintain and access statistics about the data stored in the database.
 */
public class StorageStatistics {

    private static StorageStatistics instance;

    /**
     * Returns the static instance of StorageStatistics
     *
     * @return StorageStatistics
     */
    public static StorageStatistics getInstance() {
        if (instance == null) {
            instance = new StorageStatistics();
        }

        return instance;
    }

    private StorageData storageData;

    //Keeps track of all of the distinct values for each attribute for each table
    private Map<Integer, Map<Attribute, Set<Object>>> distinctValues;

    private StorageStatistics() {
        distinctValues = Maps.newHashMap();
    }

    /**
     * Checks if the given value is distinct for the given attribute in the given table. If it is distinct, it will be
     * added as a distinct value.
     *
     * @param tableId
     * @param attribute
     * @param value
     */
    protected void checkAndAddDistinctValue(final Integer tableId, final Attribute attribute, final Object value) {
        Map<Attribute, Set<Object>> tableDistinctValues = distinctValues.get(tableId);

        if (tableDistinctValues == null) {
            tableDistinctValues = Maps.newHashMap();
            distinctValues.put(tableId, tableDistinctValues);
        }

        Set<Object> values = tableDistinctValues.get(attribute);

        if (values == null) {
            values = Sets.newHashSet();
            tableDistinctValues.put(attribute, values);
        }

        values.add(value);
    }

    /**
     * Returns the total number of tuples/rows in the table referred to by the given table name.
     *
     * @param tableName
     * @return int
     */
    public int tuplesInRelation(final String tableName) {
        Integer tableId = storageData.getTableId(tableName);
        return storageData.getRowCount(tableId);
    }

    /**
     * Returns the number of distinct values for the given attribute over all the rows in the table referred to by the
     * given table name.
     *
     * @param tableName
     * @param attribute
     * @return int
     */
    public int numberOfDistinctValuesForAttribute(final String tableName, final Attribute attribute) {
        storageData = StorageData.getInstance();

        Integer tableId = storageData.getTableId(tableName);
        Map<Attribute, Set<Object>> tableDistinctValues = distinctValues.get(tableId);

        if (tableDistinctValues == null) {
            return 0;
        }

        Set<Object> values = tableDistinctValues.get(attribute);

        if (values == null) {
            return 0;
        }

        return values.size();
    }
}
