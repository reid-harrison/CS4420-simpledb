package gt.cs4420.relationaldb.database.storage;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import gt.cs4420.relationaldb.domain.*;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import gt.cs4420.relationaldb.domain.query.Constraint;
import gt.cs4420.relationaldb.domain.query.ValueConstraint;
import gt.cs4420.relationaldb.domain.query.ValueOperator;
import gt.cs4420.relationaldb.test.TestFailedException;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class StorageManagerLargeTest {

    private final String DB_ROOT_DIRECTORY = "database/test_large/";

    private final int TABLE_COUNT = 10;
    private final int ATTRIBUTE_SIZE = 10;
    private final int ROW_COUNT = 1000;

    private final int DIFFERENT_STRING_COUNT = 300;
    private final int MAX_STRING_SIZE = 100;
    private final int MAX_INT = 300;

    private final int NUMBER_OF_SELECTION_TESTS = 100;

    public static void main(String[] args) {
        StorageManagerLargeTest test = new StorageManagerLargeTest();

        try {
            test.generateData();
            test.run();
        } catch (final ValidationException ve) {
            for (String msg : ve.getMessages()) {
                System.err.println(msg);
            }

            ve.printStackTrace();
        }

    }

    private StorageManager manager;

    private List<Table> tables;
    private Map<Integer, List<Row>> tableData;

    private Map<Integer, Map<Attribute, int[]>> intUsage;
    private Map<Integer, Map<Attribute, int[]>> stringUsage;

    private Random random;

    public void generateData() throws ValidationException {
        manager = new StorageManager(DB_ROOT_DIRECTORY);
        manager.clearDatabase();

        random = new Random();

        intUsage = Maps.newHashMap();
        stringUsage = Maps.newHashMap();

        generateRandomStrings();

        createTestTables();
        createTestRows();
    }

    private void createTestTables() throws ValidationException {
        System.out.println("Generating " + TABLE_COUNT + " random large tables.");

        tables = Lists.newArrayList();
        tableData = Maps.newHashMap();

        for (int i = 1; i <= TABLE_COUNT; i++) {
            Table table = new Table(i);
            table.setName("table" + i);

            Map<Attribute, int[]> tableIntUsage = Maps.newHashMap();
            Map<Attribute, int[]> tableStringUsage = Maps.newHashMap();
            intUsage.put(table.getId(), tableIntUsage);
            stringUsage.put(table.getId(), tableStringUsage);

            Description description = new Description();
            table.setDescription(description);

            Attribute[] attributes = new Attribute[ATTRIBUTE_SIZE];

            Attribute primaryKeyAttribute = new Attribute(DataType.INT, "id");
            attributes[0] = primaryKeyAttribute;

            for (int j = 1; j < attributes.length; j++) {
                Attribute attr = null;

                if (j < 5) {
                    attr = new Attribute(DataType.INT, "table" + table.getId() + "attribute" + j);
                    tableIntUsage.put(attr, new int[MAX_INT]);
                } else {
                    attr = new Attribute(DataType.STRING, "table" + table.getId() + "attribute" + j);
                    tableStringUsage.put(attr, new int[DIFFERENT_STRING_COUNT]);
                }

                attributes[j] = attr;
            }

            description.setAttributes(attributes);
            description.setPrimaryKeyAttribute(primaryKeyAttribute);

            tables.add(table);

        }
    }

    private void createTestRows() {
        System.out.println("Generating " + ROW_COUNT + " random rows for each table.");

        for (Table table : tables) {
            Description description = table.getDescription();

            List<Row> rows = Lists.newArrayList();
            tableData.put(table.getId(), rows);

            Map<Attribute, int[]> tableIntUsage = intUsage.get(table.getId());
            Map<Attribute, int[]> tableStringUsage = stringUsage.get(table.getId());

            for (int i = 0; i < ROW_COUNT; i++) {
                Row row = new Row();
                rows.add(row);
                row.setPrimaryKey(i);

                Map<Attribute, Object> rowData = Maps.newHashMap();
                row.setRowData(rowData);

                for (Attribute attr : description.getAttributes()) {
                    Object data = null;

                    if (attr.equals(description.getPrimaryKeyAttribute())) {
                        data = i;
                    } else {
                        int nextInt;

                        switch (attr.getType()) {
                            case INT:
                                nextInt = random.nextInt(MAX_INT);
                                data = nextInt;

                                int[] intCounts = tableIntUsage.get(attr);
                                intCounts[nextInt]++;

                                break;
                            case STRING:
                                nextInt = random.nextInt(strings.length);
                                data = strings[nextInt];

                                int[] stringCounts = tableStringUsage.get(attr);
                                stringCounts[nextInt]++;

                                break;
                        }
                    }

                    rowData.put(attr, data);
                }
            }
        }
    }

    private void run() throws ValidationException {
        testCreateTables();

        for (Table table : tables) {
            Integer tableId = table.getId();
            String tableName = table.getName();
            Attribute[] attributes = table.getDescription().getAttributes();

            System.out.println("Inserting test data into table with ID: " + tableId);
            testInsert(tableId, tableData.get(tableId));

            Map<Attribute, int[]> tableIntUsage = intUsage.get(table.getId());
            Map<Attribute, int[]> tableStringUsage = stringUsage.get(table.getId());

            int expectedRowCount = 0;
            Constraint whereConstraint = null;

            System.out.println("Testing " + NUMBER_OF_SELECTION_TESTS + " random selection tests on table with ID: " + tableId);

            //TODO Test more complex where constraints
            for (int i = 0; i < NUMBER_OF_SELECTION_TESTS; i++) {
                int nextInt = random.nextInt(attributes.length);

                Attribute attribute = attributes[nextInt];

                switch (attribute.getType()) {
                    case STRING:
                        nextInt = random.nextInt(strings.length);
                        whereConstraint = new ValueConstraint(attribute, "'" + strings[nextInt] + "'", ValueOperator.EQUALS);
                        expectedRowCount = tableStringUsage.get(attribute)[nextInt];
                        break;
                    case INT:
                        nextInt = random.nextInt(MAX_INT);
                        whereConstraint = new ValueConstraint(attribute, nextInt, ValueOperator.EQUALS);

                        if (table.getDescription().getPrimaryKeyAttribute().equals(attribute)) {
                            expectedRowCount = 1;
                            break;
                        }

                        expectedRowCount = tableIntUsage.get(attribute)[nextInt];
                        break;
                }

                testSelect(tableName, whereConstraint, expectedRowCount);
            }

        }

        /**
         * TODO
         * Join, update tests
         */
    }

    private void testCreateTables() throws ValidationException {
        System.out.println("Creating test tables.");

        for (Table table : tables) {
            manager.createTable(table);
        }
    }

    private void testInsert(final Integer tableId, final List<Row> rows) throws ValidationException {
        System.out.println("Inserting test rows.");

        for (Row row : rows) {
            manager.insert(manager.getTableName(tableId), row);
        }
    }

    private void testSelect(final String tableName, Constraint whereConstraint, final int expectedRowCount) {
        List<Row> selectedRows = manager.select(tableName, whereConstraint);

        if (selectedRows.size() != expectedRowCount) {
            throw new TestFailedException("Select", "Selected " + selectedRows.size() + " rows when " + expectedRowCount + " rows were expected");
        }
    }

    private final String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private String[] strings;

    private void generateRandomStrings() {
        strings = new String[DIFFERENT_STRING_COUNT];

        for (int i = 0; i < strings.length; i++) {
            int stringSize = random.nextInt(MAX_STRING_SIZE);

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < stringSize; j++) {
                int letterIndex = random.nextInt(letters.length);

                sb.append(letters[letterIndex]);
            }

            strings[i] = sb.toString();
        }
    }

}
