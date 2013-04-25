package gt.cs4420.relationaldb.database.query;

import com.google.common.collect.Lists;
import gt.cs4420.relationaldb.database.storage.StorageManager;
import gt.cs4420.relationaldb.domain.*;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import gt.cs4420.relationaldb.domain.query.Constraint;
import gt.cs4420.relationaldb.domain.query.JoinConstraint;
import gt.cs4420.relationaldb.domain.query.JoinConstraint.JoinType;
import gt.cs4420.relationaldb.domain.query.OrderConstraint;
import gt.cs4420.relationaldb.domain.query.OrderConstraint.Direction;
import gt.cs4420.relationaldb.domain.query.ValueOperator;
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
        if(queryTree.getChild(0).getText().equals("CREATE TABLE")){
            createTable(queryTree);
        } else if(queryTree.getChild(0).getText().equals("DROP TABLE")) {
            dropTable(queryTree);
        } else if(queryTree.getChild(0).getText().equals("INSERT INTO")) {
            insertIntoTable(queryTree);
        } else {
            return false;
        }
        return true;
    }

    public List<JoinedRow> selectFromJoinedTables(QueryParser parser)
    {
        Tree selectFromTableNode = parser.getQueryTree();
        Tree selectNode = null;
        Tree fromNode = null;
        Tree onNode = null;
        Tree whereNode = null;
        Tree orderByNode = null;
        Tree joinNode = null;
        List<String> selectColumns = Lists.newArrayList();
        List<String> joinTables = Lists.newArrayList();
        JoinConstraint joinConstraint = null;
        OrderConstraint orderConstraint = null;


        Constraint whereConstraint = null;
        boolean isJoin = false;

        for(int i = 0; i < selectFromTableNode.getChildCount(); i++)
        {
            if(selectFromTableNode.getChild(i).getText().equalsIgnoreCase("SELECT"))
                selectNode = selectFromTableNode.getChild(i);
            if(selectFromTableNode.getChild(i).getText().equalsIgnoreCase("FROM"))
                fromNode = selectFromTableNode.getChild(i);
            if(selectFromTableNode.getChild(i).getText().equalsIgnoreCase("ON"))
                onNode = selectFromTableNode.getChild(i);
            if(selectFromTableNode.getChild(i).getText().equalsIgnoreCase("WHERE"))
                whereNode = selectFromTableNode.getChild(i);
            if(selectFromTableNode.getChild(i).getText().equalsIgnoreCase("ORDER BY"))
                orderByNode = selectFromTableNode.getChild(i);
        }


        if(selectNode != null)
        {
            for(int i = 0; i < selectNode.getChildCount()-1; i++)
            {
                selectColumns.add(selectNode.getChild(i).getText());
            }
        }

        if(fromNode != null)
        {
            if(fromNode.getChild(0).getText().toUpperCase().contains("JOIN") && onNode != null)
            {
                joinNode = fromNode.getChild(0);

                for(int i = 0; i < joinNode.getChildCount(); i++)
                {
                    joinTables.add(joinNode.getChild(i).getText());
                }

                joinConstraint = new JoinConstraint(JoinType.INNER, ValueOperator.getByStringRepresentation(onNode.getChild(0).getText()), new Attribute(onNode.getChild(0).getChild(0).getChild(0).getText()), new Attribute(onNode.getChild(0).getChild(1).getChild(0).getText()));
                isJoin = true;
            }
            else
                joinTables.add(fromNode.getChild(0).getText());
        }

        if(whereNode != null)
        {
            parser.parseConstraint(selectFromTableNode);

        }

        if(orderByNode != null)
        {
            orderConstraint = new OrderConstraint(new Attribute(orderByNode.getChild(0).getText()),Direction.getByStringRepresenations(orderByNode.getChild(1).getText()));
        }


        if(isJoin)
        {
            try {
                return storageManager.selectJoin(joinTables.get(0), joinTables.get(1), joinConstraint, whereConstraint, orderConstraint);
            } catch (ValidationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Row> selectFromTable(QueryParser parser)
    {
        Tree selectFromTableNode = parser.getQueryTree();
        Tree selectNode = null;
        Tree fromNode = null;
        Tree whereNode = null;
        Tree orderByNode = null;
        List<String> selectColumns = Lists.newArrayList();
        String table = "";
        OrderConstraint orderConstraint = null;
        Constraint whereConstraint = null;

        for(int i = 0; i < selectFromTableNode.getChildCount(); i++)
        {
            if(selectFromTableNode.getChild(i).getText().equalsIgnoreCase("SELECT"))
                selectNode = selectFromTableNode.getChild(i);
            if(selectFromTableNode.getChild(i).getText().equalsIgnoreCase("FROM"))
                fromNode = selectFromTableNode.getChild(i);
            if(selectFromTableNode.getChild(i).getText().equalsIgnoreCase("ON")) {
            }
            if(selectFromTableNode.getChild(i).getText().equalsIgnoreCase("WHERE"))
                whereNode = selectFromTableNode.getChild(i);
            if(selectFromTableNode.getChild(i).getText().equalsIgnoreCase("ORDER BY"))
                orderByNode = selectFromTableNode.getChild(i);
        }

        if(selectNode != null)
        {
            for(int i = 0; i < selectNode.getChildCount()-1; i++)
            {
                selectColumns.add(selectNode.getChild(i).getText());
            }
        }

        if(fromNode != null)
        {
            table = fromNode.getChild(0).getText();
        }

        if(whereNode != null)
        {
            parser.parseConstraint(selectFromTableNode);
        }

        if(orderByNode != null)
        {
            orderConstraint = new OrderConstraint(new Attribute(orderByNode.getChild(0).getText()),Direction.getByStringRepresenations(orderByNode.getChild(1).getText()));
        }

        return storageManager.select(table, whereConstraint, orderConstraint);
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

            currentNode = createTableTree.getChild(++child);
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
        Tree valuesNode = insertIntoTableNode.getChild(1);
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
            DataType type = tabelMetaData.getDescription().getAttribute(attributeName).getType();
            attribute.setType(type);
            Object newValue = parseValue(value, type);
            rowData.put(attribute, newValue);

            childIndex++;
            currentAttributeNode = attributesRootNode.getChild(childIndex);
            currentValueNode = valuesNode.getChild(childIndex);
        }

        rowToInsert.setRowData(rowData);
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
                return Integer.parseInt(value);
            default :
                return value;
        }
    }
}