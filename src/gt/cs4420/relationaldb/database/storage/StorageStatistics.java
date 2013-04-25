package gt.cs4420.relationaldb.database.storage;

public class StorageStatistics {

    private static StorageStatistics instance;

    public StorageStatistics getInstance() {
        if (instance == null) {
            instance = new StorageStatistics();
        }

        return instance;
    }

    private StorageStatistics() {

    }

    public int tuplesInRelation(String table){
        return 0;
    }

    public int numberValuesInAttribute(String table, String attribute) {
        return 0;
    }
}
