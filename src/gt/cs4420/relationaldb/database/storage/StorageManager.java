package gt.cs4420.relationaldb.database.storage;

import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import gt.cs4420.relationaldb.domain.validator.TableValidator;

public class StorageManager {

    private StorageData storageData;

    private TableValidator tableValidator;

    public StorageManager() {
        storageData = new StorageData();

        tableValidator = new TableValidator();
    }

    public void createTable(final Table table) throws ValidationException {
        tableValidator.validate(table);

        storageData.addTable(table);
    }

    public void dropTable(final Integer tableId) throws ValidationException {
        if (!storageData.tableExists(tableId)) {
            throw new ValidationException("Table does not exist with ID: " + tableId);
        }

        storageData.removeTable(tableId);
    }

    public void insert(final Integer tableId, final Integer attributeId, final Object record) throws ValidationException {
        //TODO Implement insert
    }



}
