package gt.cs4420.relationaldb.database.query;

import gt.cs4420.relationaldb.database.storage.StorageManager;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.DataType;
import gt.cs4420.relationaldb.domain.Description;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class QueryEngine {

    public static final String CREATE_TABLE = "CREATE TABLE";
    private StorageManager storageManager;

    public QueryEngine(StorageManager storageManager) {
        this.storageManager = storageManager;
    }

    public boolean executeQuery(CommonTree queryTree) throws ValidationException {
        if(queryTree.getChild(0).getType() == SQLParser.CREATE_TABLE){
            createTable(queryTree);
        } else if(queryTree.getChild(0).getType() == SQLParser.DROP_TABLE) {
            dropTable(queryTree);
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

    public void insertIntoTable(Tree insertIntoTableNode) {

    }

    public static DataType matchToDataType(String type) {
        if(type.equals(DataType.INT.getTypeString().toLowerCase())) {
            return DataType.INT;
        } else {
            return DataType.STRING;
        }
    }
}
