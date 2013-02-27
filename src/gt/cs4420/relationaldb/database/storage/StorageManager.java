package gt.cs4420.relationaldb.database.storage;

import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import gt.cs4420.relationaldb.domain.validator.TableValidator;

import java.util.Map;

/**
 * The point of interaction for the Storage Engine. Use the provided methods to perform database operations.
 *
 * TODO:
 * -Implement more database operations and management functionality
 */
public class StorageManager {

    private StorageData storageData;

    private TableValidator tableValidator;

    public StorageManager() {
        storageData = StorageData.getInstance();

        tableValidator = new TableValidator();
    }

    /**
     * Retrieves the in-memory Table object corresponding to the given table ID. The returned Table will not be
     * populated with row data, it is just a container for metadata.
     *
     * @param tableId Integer id for the desired Table
     * @return Table holding metadata but not populated with row data
     */
    public Table getTable(final Integer tableId) {
        return storageData.getTable(tableId);
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

    public void insert(final Integer tableId, Map<Attribute, Object> attributes) throws ValidationException {
        //TODO Implement insert validation

        storageData.insert(tableId, attributes);
    }

}
