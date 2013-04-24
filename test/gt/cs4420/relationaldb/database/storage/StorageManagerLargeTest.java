package gt.cs4420.relationaldb.database.storage;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import gt.cs4420.relationaldb.domain.*;
import gt.cs4420.relationaldb.domain.exception.ValidationException;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class StorageManagerLargeTest {

    private final String DB_ROOT_DIRECTORY = "database/test_large/";

    private final int ATTRIBUTE_SIZE = 10;
    private final int ROW_COUNT = 1000;

    private final int DIFFERENT_STRING_COUNT = 300;
    private final int MAX_STRING_SIZE = 100;

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

    private Random random;

    public void generateData() throws ValidationException {
        manager = new StorageManager(DB_ROOT_DIRECTORY);
        manager.clearDatabase();

        random = new Random();

        generateRandomStrings();

        createTestTables();
        createTestRows();
    }

    private void createTestTables() throws ValidationException {
        tables = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            Table table = new Table();
            table.setId(i);
            table.setName("table" + i);

            Description description = new Description();
            table.setDescription(description);

            Attribute[] attributes = new Attribute[ATTRIBUTE_SIZE];

            Attribute primaryKeyAttribute = new Attribute(DataType.INT, "id");
            description.setPrimaryKeyAttribute(primaryKeyAttribute);
            attributes[0] = primaryKeyAttribute;

            for (int j = 1; j < attributes.length; j++) {
                Attribute attr = null;

                if (j < 5) {
                    attr = new Attribute(DataType.INT, "table" + table.getId() + "attribute" + j);
                } else {
                    attr = new Attribute(DataType.STRING, "table" + table.getId() + "attribute" + j);
                }

                attributes[j] = attr;
            }

            description.setAttributes(attributes);

            tables.add(table);
        }
    }

    private void createTestRows() {
        for (Table table : tables) {
            Description description = table.getDescription();

            List<Row> rows = Lists.newArrayList();
            tableData.put(table.getId(), rows);

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
                        switch (attr.getType()) {
                            case INT:
                                data = random.nextInt(300);
                            case STRING:
                                data = strings[random.nextInt(strings.length)];
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
            testInsert(tableId, tableData.get(tableId));
        }
    }

    private void testCreateTables() throws ValidationException {
        for (Table table : tables) {
            manager.createTable(table);
        }
    }

    private void testInsert(final Integer tableId, final List<Row> rows) throws ValidationException {
        for (Row row : rows) {
            manager.insert(manager.getTableName(tableId), row);
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
