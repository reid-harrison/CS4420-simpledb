package gt.cs4420.relationaldb.database.query;

import gt.cs4420.relationaldb.database.storage.StorageManager;
import gt.cs4420.relationaldb.domain.*;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryEngine {

    public static final String CREATE_TABLE = "CREATE TABLE";
    private StorageManager storageManager;

    public QueryEngine(StorageManager storageManager) {
        this.storageManager = storageManager;
    }

    public boolean executeQuery(CommonTree queryTree) throws ValidationException {
        if(queryTree.getChild(0).getText().equals("CREATE_TABLE")){
            createTable(queryTree);
        } else if(queryTree.getChild(0).getText().equals("DROP_TABLE")) {
            dropTable(queryTree);
        } else if(queryTree.getChild(0).getType() == SQLParser.INSERT_INTO) {
            insertIntoTable(queryTree);
        } else {
            return false;
        }
        return true;
    }

    public void createTable(CommonTree createTableTree) throws ValidationException {

        //extract this node's relevant data
        String name = createTableTree.getChild(1).getText();

        List<Attribute> tableAttributes = new ArrayList<>();
        Tree currentNode = createTableTree.getChild(2);
        Description description = new Description();

        int child = 2;
        Attribute attribute;
        Attribute primaryKeyAttribute = null;
        while(currentNode != null){
            attribute = new Attribute(currentNode.getText());
            tableAttributes.add(attribute);

            //We know this is a dataType node
            attribute.setType(matchToDataType(currentNode.getChild(0).getText()));

            //check to see if we have a key specification
            Tree keyChild = currentNode.getChild(1);
            if(keyChild != null) {
                 primaryKeyAttribute = attribute;
            }

            currentNode = createTableTree.getChild(child++);
        }

        description.setAttributes(tableAttributes.toArray(new Attribute[tableAttributes.size()]));
        description.setPrimaryKeyAttribute(primaryKeyAttribute);

        Table table = new Table(name, description);
        storageManager.createTable(table);
    }

    public void dropTable(Tree dropTableTree) throws ValidationException {
        String tableName = dropTableTree.getChild(1).getText();
        storageManager.dropTable(tableName);
    }

    public void insertIntoTable(Tree insertIntoTableNode) throws ValidationException {
        //set relevant nodes
        Tree insertIntoNode = insertIntoTableNode.getChild(0);
        Tree valuesNode = insertIntoTableNode.getChild(0);
        Tree attributesRootNode = insertIntoNode.getChild(0);
        Tree currentAttributeNode = attributesRootNode.getChild(0);
        Tree currentValueNode = valuesNode.getChild(0);

        String tableName = insertIntoNode.getChild(0).getText();
        Table tabelMetaData = storageManager.getTable(tableName);

        Row rowToInsert = new Row();
        rowToInsert.setPrimaryKey((Integer)parseValue(currentValueNode.getText(), DataType.INT) );

        Map<Attribute, Object> rowData = new HashMap<>();
        int childIndex = 0;
        while (currentAttributeNode != null) {
            String attributeName = currentAttributeNode.getText();
            Attribute attribute = new Attribute(attributeName);
            String value = currentValueNode.getText();
            Object newValue = parseValue(value, tabelMetaData.getDescription().getAttribute(attributeName).getType());
            rowData.put(attribute, newValue);

            childIndex++;
            currentAttributeNode = attributesRootNode.getChild(childIndex);
        }

        storageManager.insert(tableName, rowToInsert);
    }

    public static DataType matchToDataType(String type) {
        if(type.equals(DataType.INT.getTypeString().toLowerCase())) {
            return DataType.INT;
        } else {
            return DataType.STRING;
        }
    }

    public static Object parseValue(String value, DataType type){
        switch(type.getTypeString()) {
            case "INT" :
                return Integer.getInteger(value);
            case "STRING" :
                return value;
        }
        return null;
    }
}
