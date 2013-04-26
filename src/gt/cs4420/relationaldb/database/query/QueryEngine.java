package gt.cs4420.relationaldb.database.query;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
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

    public List<JoinedRow> selectFromJoinedTables(QueryParser parser) throws ValidationException
    {
        Tree selectFromTableNode = parser.getQueryTree();
        Tree selectNode = null;
        Tree fromNode = null;
        Tree onNode = null;
        Tree whereNode = null;
        Tree orderByNode = null;
        Tree joinNode = null;
        List<String> selectColumns = Lists.newArrayList();
        List<Attribute> selectAttributes = Lists.newArrayList();
        List<String> joinTables = Lists.newArrayList();
        JoinConstraint joinConstraint = null;
        OrderConstraint orderConstraint = null;


        Constraint whereConstraint = parser.parseConstraint(selectFromTableNode);
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
                String attrName = selectNode.getChild(i).getText();
                selectColumns.add(attrName);
                selectAttributes.add(new Attribute(attrName));
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

        if(orderByNode != null) {
            Tree attributeRoot = orderByNode.getChild(0);
            String attributeText = attributeRoot.getText();
            Attribute attribute = new Attribute(attributeText);

            Tree orderByDirectionRoot = orderByNode.getChild(1);

            Direction orderDirection;

            if (orderByDirectionRoot != null)  {
                String directionText = orderByDirectionRoot.getText();
                orderDirection = Direction.getByStringRepresenations(directionText);
            } else {
                orderDirection = Direction.ASCENDING;
            }

            orderConstraint = new OrderConstraint(attribute, orderDirection);
        }


        if(isJoin)
        {
            List<JoinedRow> joinedRows = storageManager.selectJoin(joinTables.get(0), joinTables.get(1), joinConstraint, whereConstraint, orderConstraint);
            List<JoinedRow> relevantJoinedRows = Lists.newArrayList();

            for (JoinedRow joinedRow : joinedRows) {
                Row leftRow = joinedRow.getLeftRow();
                Row rightRow = joinedRow.getRightRow();

                Row relevantLeftRow = getRelevantRowData(leftRow, selectAttributes);
                Row relevantRightRow = getRelevantRowData(rightRow, selectAttributes);

                JoinedRow relevantJoinedRow = new JoinedRow();
                relevantJoinedRow.setLeftRow(relevantLeftRow);
                relevantJoinedRow.setRightRow(relevantRightRow);

                relevantJoinedRows.add(relevantJoinedRow);
            }

            return relevantJoinedRows;
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
        List<Attribute> selectAttributes = Lists.newArrayList();

        String table = "";
        OrderConstraint orderConstraint = null;
        Constraint whereConstraint = parser.parseConstraint(selectFromTableNode);

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
            for(int i = 0; i < selectNode.getChildCount(); i++)
            {
                String attrName = selectNode.getChild(i).getText();
                selectColumns.add(attrName);
                selectAttributes.add(new Attribute(attrName));
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
            Tree orderTree = orderByNode.getChild(0);
            String orderByText = orderTree.getText();
            Direction dir = Direction.getByStringRepresenations(orderByText);

            Attribute attr = new Attribute(orderByText);

            orderConstraint = new OrderConstraint(attr, dir);
        }

        List<Row> selectedRows = storageManager.select(table, whereConstraint, orderConstraint);
        List<Row> relevantSelectedRows = Lists.newArrayList();

        if (selectedRows == null) {
            return Lists.newArrayList();
        }

        for (Row row : selectedRows) {
            relevantSelectedRows.add(getRelevantRowData(row, selectAttributes));
        }

        return relevantSelectedRows;
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
    private Row getRelevantRowData(final Row row, final List<Attribute> relevantAttributes) {
        Map<Attribute, Object> rowData = row.getRowData();
        Map<Attribute, Object> relevantData = Maps.newHashMap();

        for (Attribute attr : relevantAttributes) {
            relevantData.put(attr, rowData.get(attr));
        }

        Row relevantRow = new Row();
        relevantRow.setPrimaryKey(row.getPrimaryKey());
        relevantRow.setRowData(relevantData);

        return relevantRow;
    }
}