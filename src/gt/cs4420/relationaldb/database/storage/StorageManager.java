package gt.cs4420.relationaldb.database.storage;

import gt.cs4420.relationaldb.domain.*;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import gt.cs4420.relationaldb.domain.query.Constraint;
import gt.cs4420.relationaldb.domain.query.JoinConstraint;
import gt.cs4420.relationaldb.domain.query.OrderConstraint;
import gt.cs4420.relationaldb.domain.validator.AttributeValidator;
import gt.cs4420.relationaldb.domain.validator.RowValidator;
import gt.cs4420.relationaldb.domain.validator.TableValidator;

import java.util.List;
import java.util.Map;

/**
 * The point of interaction for the Storage Engine. Use the provided methods to perform database operations.
 */
public class StorageManager {

    private static final String DEFAULT_DB_ROOT_DIRECTORY = "database/";

    private StorageData storageData;

    private TableValidator tableValidator;
    private RowValidator rowValidator;
    private AttributeValidator attrValidator;

    public StorageManager() {
        this(DEFAULT_DB_ROOT_DIRECTORY);
    }

    public StorageManager(final String dbRootDirectory) {
        storageData = StorageData.getInstance(dbRootDirectory);
        tableValidator = new TableValidator();
        rowValidator = new RowValidator();
        attrValidator = new AttributeValidator();
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

    public String getTableName(final Integer tableId) {
        Table table = getTable(tableId);

        if (table == null) {
            return null;
        }

        return table.getName();
    }

    /**
     * Returns the Integer ID of the table with the given table name. Returns null if no table exists with the given name.
     *
     * @param tableName
     * @return Integer ID of the table or null if no table exists with the given name
     */
    public Integer getTableId(final String tableName) {
        return storageData.getTableId(tableName);
    }

    /**
     * Creates the given Table in the database with no rows. The table's ID is generated automatically if it isn't alread
     * set. The ID does not need to be set and will be populated in the passed Table.
     *
     * @param table Table with valid name and Description
     * @throws ValidationException if the given Table doesn't have a unique name or doesn't have sufficient meta-data to be created
     */
    public void createTable(final Table table) throws ValidationException {
        if (storageData.getTable(table.getId()) != null) {
            throw new ValidationException("A table with the ID: " + table.getId() + " alread exists");
        }

        if (storageData.tableExists(table.getName())) {
            throw new ValidationException("A table with the name " + table.getName() + " already exists");
        }

        if (table.getId() == null || table.getId() < 0) {
            Integer id = storageData.generateNextTableId();
            table.setId(id);
        }

        tableValidator.validate(table);
        storageData.addTable(table);
    }

    /**
     * Removes the table with the given name from existence.
     *
     * @param tableName the name of the table to drop
     * @throws ValidationException if the table doesn't exist
     */
    public void dropTable(final String tableName) throws ValidationException {
        Integer tableId = storageData.getTableId(tableName);
        validateTableExists(tableId);

        storageData.removeTable(tableId);
    }

    /**
     * Selects and returns the rows from the table with the given name.
     *
     * @param tableName
     * @param whereConstraint Constraint to limit results of the select
     * @return List<Row> All of the Rows that exist in tableName
     */
    public List<Row> select(final String tableName, final Constraint whereConstraint) {
        return select(tableName, whereConstraint, null);
    }

    public List<Row> select(final String tableName, final Constraint whereConstraint, final OrderConstraint orderConstraint) {
        return storageData.select(getTableId(tableName), whereConstraint, orderConstraint);
    }

    public List<JoinedRow> selectJoin(final String leftTableName, final String rightTableName, final JoinConstraint joinConstraint, final Constraint whereConstraint) throws ValidationException {
        return selectJoin(leftTableName, rightTableName, joinConstraint, whereConstraint, null);
    }

    public List<JoinedRow> selectJoin(final String leftTableName, final String rightTableName, final JoinConstraint joinConstraint, final Constraint whereConstraint, final OrderConstraint orderConstraint) throws ValidationException {
        Integer leftTableId = getTableId(leftTableName);
        Integer rightTableId = getTableId(rightTableName);

        return storageData.selectJoin(leftTableId, rightTableId, joinConstraint, whereConstraint, orderConstraint);
    }
    /**
     * Inserts the given attribute data mapping into the given table.
     *
     * @param tableName the name of the table
     * @param row the row to insert (with the primary key at least populated in the row's data)
     * @throws ValidationException if a row already exists with the private key or the data is not valid for the table's description
     */
    public void insert(final String tableName, Row row) throws ValidationException {
        Integer tableId = storageData.getTableId(tableName);
        validateTableExists(tableId);

        Description description = storageData.getTable(tableId).getDescription();
        Map<Attribute, Object> rowData = row.getRowData();

        for (Attribute attr : rowData.keySet()) {
            String attrString = rowData.get(attr).toString();
            if (attrString.startsWith("'") && attrString.endsWith("'")) {
                rowData.put(attr, attrString.substring(1, attrString.length() - 1));
            }
        }

        //Validate the the row data is populated with valid data
        rowValidator.validate(row, storageData.getTable(tableId));

        //Resolve primary key
        Attribute primaryKeyAttr = description.getPrimaryKeyAttribute();
        Integer primaryKey = (Integer) row.getRowData().get(primaryKeyAttr);
        row.setPrimaryKey(primaryKey);

        storageData.insert(tableId, row);
    }

    /**
     * Updates a table's Row based on the given Row's primary key by modifying the attributes specified in the given
     * Row's row data.
     * @param tableName
     * @param updateDataRow
     * @param whereConstraint Constraint to limit rows that are updated
     * @throws ValidationException
     */
    public void update(final String tableName, final Row updateDataRow, final Constraint whereConstraint) throws ValidationException {
        Integer tableId = storageData.getTableId(tableName);
        validateTableExists(tableId);

        //Validate the the row data is populated with valid data
        rowValidator.validate(updateDataRow, storageData.getTable(tableId));

        storageData.update(tableId, updateDataRow, whereConstraint);
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

    /**
     * Throws a ValidationException if the given tableName does not correspond to an existing table.
     *
     * @param tableName
     * @throws ValidationException
     */
    public void validateTableExists(final String tableName) throws ValidationException {
        if (!storageData.tableExists(tableName)) {
            throw new ValidationException("Table does not exist with name: " + tableName);
        }
    }

    /**
     * Deletes absolutely everything from the database
     */
    public void clearDatabase() {
        storageData.clearDatabase();
    }

    public void flushDirtyRows() {
        storageData.flushDirtyRows();
    }

}