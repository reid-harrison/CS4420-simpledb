package gt.cs4420.relationaldb.database.storage;

import gt.cs4420.relationaldb.database.storage.file.FileManager;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import gt.cs4420.relationaldb.domain.validator.TableValidator;

public class StorageManager {

    private StorageData storageData;

    private TableValidator tableValidator;

    public StorageManager() {
        initStorageData();

        tableValidator = new TableValidator();
    }

    private void initStorageData() {
        storageData = new StorageData();
        
        //TODO initStorageData
    }

    public void createTable(final Table table) throws ValidationException {
        tableValidator.validate(table);

        //TODO createTable
    }

    public void dropTable(final Integer tableId) throws ValidationException {
        //TODO Implement dropTable
    }

    public void insert(final Integer tableId, final Integer attributeId, final Object record) throws ValidationException {
        //TODO Implement insert
    }



}
