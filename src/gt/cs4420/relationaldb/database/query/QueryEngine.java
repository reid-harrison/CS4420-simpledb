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
        if(queryTree.getType() == SQLParser.CREATE_TABLE);
            createTable(queryTree);
        return false;
    }

    public void createTable(CommonTree createTableNode) throws ValidationException {

        //extract this node's relevant data
        String name = createTableNode.getChild(0).getText();

        List<Attribute> tableAttributes = new ArrayList<>();
        Tree currentNode = createTableNode.getChild(1);
        Description description = new Description();

        int child = 0;
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

            currentNode = createTableNode.getChild(child++);
        }

        description.setAttributes(tableAttributes.toArray(new Attribute[tableAttributes.size()]));
        description.setPrimaryKeyAttribute(primaryKeyAttribute);

        Table table = new Table(name, description);
        storageManager.createTable(table);
    }

    public void dropTable(Tree dropTableNode) {

    }

    public void insertIntoTable(Tree insertIntoTableNode) {

    }

    public static DataType matchToDataType(String type) {
        if(type.equals(DataType.INT.getTypeString())) {
            return DataType.INT;
        } else {
            return DataType.STRING;
        }
    }
}
