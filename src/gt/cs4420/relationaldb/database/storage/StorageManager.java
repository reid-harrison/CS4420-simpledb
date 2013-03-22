package gt.cs4420.relationaldb.database.storage;

import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import gt.cs4420.relationaldb.domain.validator.AttributeValidator;
import gt.cs4420.relationaldb.domain.validator.TableValidator;

import java.util.Map;

/**
 * The point of interaction for the Storage Engine. Use the provided methods to perform database operations.
 *
 * TODO:
 * -Implement more database operations and management functionality
 * * * SELECT
 * * * UPDATE
 * * * DELETE
 * * * JOIN
 * * * ORDER BY
 */
public class StorageManager {

    private StorageData storageData;

    private TableValidator tableValidator;
    private AttributeValidator attributeValidator;

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

    /**
     * Retrieves the in-memory Table object corresponding to the given table name. The returned Table will not be
     * populated with row data, it is just a container for metadata.
     *
     * @param tableName String name of the desired Table
     * @return Table holding metadata but not populated with row data
     */
    public Table getTable(final String tableName) {
        return storageData.getTable(tableName);
    }

    /**
     * Creates the given Table in the database with no rows. The table's ID is generated automatically and so doesn't
     * need to be set and will be populated in the passed Table.
     *
     * @param table Table with valid name and Description
     * @throws ValidationException if the given Table doesn't have a unique name or doesn't have sufficient meta-data to be created
     */
    public void createTable(final Table table) throws ValidationException {
        if (storageData.tableExists(table.getName())) {
            throw new ValidationException("A table with the name " + table.getName() + " already exists");
        }
        Integer id = storageData.getNextTableId();
        table.setId(id);

        tableValidator.validate(table);
        storageData.addTable(table);
    }

    /**
     * Removes the table with the given ID from existence.
     *
     * @param tableId the ID of the table to drop
     * @throws ValidationException if the table doesn't exist
     */
    public void dropTable(final Integer tableId) throws ValidationException {
        validateTableExists(tableId);

        storageData.removeTable(tableId);
    }

    /**
     * Inserts the given attribute data mapping into the given table.
     *
     * @param tableId the ID of the table
     * @param attributes the mapping of the data to insert
     * @throws ValidationException if a row already exists with the private key or the data is not valid for the table's description
     */
    public void insert(final Integer tableId, Map<Attribute, Object> attributes) throws ValidationException {
        validateTableExists(tableId);
        attributeValidator.validate(attributes, storageData.getTable(tableId).getDescription());
        //TODO Implement insert validation

        storageData.insert(tableId, attributes);
    }

    /**
     * Throws a ValidationException if the given tableId does not correspond to an existing table.
     *
     * @param tableId
     * @throws ValidationException
     */
    private void validateTableExists(final Integer tableId) throws ValidationException {
        if (!storageData.tableExists(tableId)) {
            throw new ValidationException("Table does not exist with ID: " + tableId);
        }
    }

}
