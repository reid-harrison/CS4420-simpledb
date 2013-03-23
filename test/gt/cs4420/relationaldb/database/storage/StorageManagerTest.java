package gt.cs4420.relationaldb.database.storage;

import com.google.common.collect.Maps;
import gt.cs4420.relationaldb.domain.*;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import gt.cs4420.relationaldb.test.TestFailedException;

import java.util.Map;

/**
 * A basic class to test the functionality of the StorageManager. For now, the tests will just be run through the main
 * method. Later, we can consider implementing unit tests for all aspects of our system.
 */
public class StorageManagerTest {

    public static void main(String[] args) {
        StorageManagerTest test = new StorageManagerTest();
        test.run();
    }

    private final StorageManager manager;

    private StorageManagerTest() {
        manager = new StorageManager();

        //Currently disable exporting as only in-memory db is currently being tested
        StorageData.exportDisabled = true;
        StorageData.ignoreDirty = true;
    }

    private void run() {

        //Test createTable
        Attribute[] userAttrs = new Attribute[4];
        userAttrs[0] = new Attribute(DataType.INT, "userId");
        userAttrs[1] = new Attribute(DataType.STRING, "username");
        userAttrs[2] = new Attribute(DataType.STRING, "email");
        userAttrs[3] = new Attribute(DataType.STRING, "password");

        Description usersDescription = new Description();
        usersDescription.setAttributes(userAttrs);
        usersDescription.setPrimaryKeyAttribute(userAttrs[0]);

        Table usersTable = new Table(0, "users", usersDescription);
        testCreateTable(usersTable);

        //Test getTable
        testGetTable("users", usersTable);

        //Test insert (This should currently fail since the table was just dropped
        Map<Attribute, Object> attributes = Maps.newHashMap();
        attributes.put(userAttrs[0], 0);
        attributes.put(userAttrs[1], "reid");
        attributes.put(userAttrs[2], "rharr90@gmail.com");
        attributes.put(userAttrs[3], "reidpass");
        testInsert(usersTable.getId(), attributes);

        //Test dropTable
        testDropTable(usersTable.getId());

    }

    private void testCreateTable(final Table table) {
        try {
            manager.createTable(table);
        } catch (ValidationException e) {
            e.printStackTrace();
            throw new TestFailedException("Create table");
        }
    }

    private void testGetTable(final String tableName, final Table expectedTable) {
        Table receivedTable = manager.getTable(tableName);

        if (receivedTable == null) {
            throw new TestFailedException("Get table", "table retrieved was null");
        }
        if (!expectedTable.equals(receivedTable)) {
            throw new TestFailedException("Get table", "table retrieved did not equal expected");
        }
    }

    private void testDropTable(final Integer tableId) {
        try {
            manager.dropTable(tableId);
        } catch (ValidationException e) {
            e.printStackTrace();
            throw new TestFailedException("Drop table");
        }

        boolean dropValidationSuccess = false;

        //Try again to make sure this fails because table was dropped
        try {
            manager.dropTable(tableId);
        } catch (ValidationException e) {
            dropValidationSuccess = true;
        } finally {
            if (!dropValidationSuccess) {
                throw new TestFailedException("Drop table", "Table was not successfully dropped and still believed to exist");
            }
        }

    }

    private void testInsert(final Integer tableId, Map<Attribute, Object> attributes) {
        try {
            Row row = new Row();
            row.setRowData(attributes);

            manager.insert(tableId, row);
        } catch (final ValidationException ve) {
            ve.printStackTrace();
            throw new TestFailedException("Insert");
        }

        //TODO Implement check that items were inserted
    }

}
