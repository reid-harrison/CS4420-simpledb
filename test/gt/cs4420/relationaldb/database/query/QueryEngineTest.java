package gt.cs4420.relationaldb.database.query;

import gt.cs4420.relationaldb.database.storage.StorageManager;
import gt.cs4420.relationaldb.domain.*;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class QueryEngineTest {

    public static final String MY_ATTRIBUTE = "myAttribute";
    public static final String MY_TABLE = "myTable";
    public static final String FIRST_ATTRIBUTE_NAME = "primaryKeyAttribute";
    public static final String SECOND_ATTRIBUTE_NAME = "secondAttribute";
    public static final int PRIMARY_KEY = 10;
    private QueryEngine queryEngine;
    private StorageManager storageManager;

    @Before
    public void setUp() {
        storageManager = mock(StorageManager.class);
        queryEngine = new QueryEngine(storageManager);
    }

    @Test
    public void testMathDataType_expectsInt() {
        DataType dataType = QueryEngine.matchToDataType("int");

        assertThat(dataType, is(DataType.INT));
    }

    @Test
    public void testMathDataType_expectsString() {
        DataType dataType = QueryEngine.matchToDataType("varchar(1000)");

        assertThat(dataType, is(DataType.STRING));
    }

    @Test
    public void testExecuteQuery_dropTable() throws ValidationException {
        Tree dropNode = mock(Tree.class);
        when(dropNode.getType()).thenReturn(SQLParser.DROP_TABLE);

        Tree tableNameNode = mock(Tree.class);
        when(tableNameNode.getText()).thenReturn("myTable");

        CommonTree queryTree = mock(CommonTree.class);
        when(queryTree.getChild(0)).thenReturn(dropNode);
        when(queryTree.getChild(1)).thenReturn(tableNameNode);

        queryEngine.executeQuery(queryTree);

        verify(storageManager).dropTable("myTable");
    }

    @Test
    public void testExecuteQuery_createTable() throws ValidationException {
        //setup
        Tree primaryKeyNode = mock(Tree.class);

        Tree attributeTypeNode = mock(Tree.class);
        when(attributeTypeNode.getText()).thenReturn("int");

        Tree attributeNameNode = mock(Tree.class);
        when(attributeNameNode.getText()).thenReturn(MY_ATTRIBUTE);
        when(attributeNameNode.getChild(0)).thenReturn(attributeTypeNode);
        when(attributeNameNode.getChild(1)).thenReturn(primaryKeyNode);

        Tree tableNameNode = mock(Tree.class);
        when(tableNameNode.getText()).thenReturn(MY_TABLE);

        Tree createNode = mock(Tree.class);
        when(createNode.getText()).thenReturn("CREATE TABLE");

        CommonTree queryTree = mock(CommonTree.class);
        when(queryTree.getChild(0)).thenReturn(createNode);
        when(queryTree.getChild(1)).thenReturn(tableNameNode);
        when(queryTree.getChild(2)).thenReturn(attributeNameNode);

        //expected values
        Attribute expectedAttribute = new Attribute(DataType.INT, MY_ATTRIBUTE);
        Attribute[] expectedAttributes = {expectedAttribute};
        Description expectedDescription = new Description();
        expectedDescription.setAttributes(expectedAttributes);
        expectedDescription.setPrimaryKeyAttribute(expectedAttribute);

        Table expectedTable = new Table(MY_TABLE, expectedDescription);

        //execute
        queryEngine.executeQuery(queryTree);

        //verify
        verify(storageManager).createTable(eq(expectedTable));
    }

    @Test
    public void testExecuteQuery_insertIntoTable() throws ValidationException {
        //setup
        Tree firstValueNode = mock(Tree.class);
        when(firstValueNode.getText()).thenReturn("10");

        Tree secondValueNode = mock(Tree.class);
        when(secondValueNode.getText()).thenReturn("secondValue");

        Tree valuesNode = mock(Tree.class);
        when(valuesNode.getText()).thenReturn("VALUES");
        when(valuesNode.getChild(0)).thenReturn(firstValueNode);
        when(valuesNode.getChild(1)).thenReturn(secondValueNode);

        Tree firstAttributeName = mock(Tree.class);
        when(firstAttributeName.getText()).thenReturn(FIRST_ATTRIBUTE_NAME);

        Tree secondAttributeName = mock(Tree.class);
        when(secondAttributeName.getText()).thenReturn(SECOND_ATTRIBUTE_NAME);

        Tree tableNameNode = mock(Tree.class);
        when(tableNameNode.getText()).thenReturn(MY_TABLE);
        when(tableNameNode.getChild(0)).thenReturn(firstAttributeName);
        when(tableNameNode.getChild(1)).thenReturn(secondAttributeName);

        Tree insertIntoNode = mock(Tree.class);
        when(insertIntoNode.getText()).thenReturn("INSERT INTO");
        when(insertIntoNode.getChild(0)).thenReturn(tableNameNode);

        CommonTree queryTree = mock(CommonTree.class);
        when(queryTree.getChild(0)).thenReturn(insertIntoNode);
        when(queryTree.getChild(2)).thenReturn(valuesNode);

        //setup expected value
        Map<Attribute, Object> rowData = new HashMap<>();
        rowData.put(new Attribute(FIRST_ATTRIBUTE_NAME), new Integer(PRIMARY_KEY));
        rowData.put(new Attribute(SECOND_ATTRIBUTE_NAME), "secondValue");
        String expectedTableName = MY_TABLE;
        Row expectedRow = new Row();
        expectedRow.setPrimaryKey(PRIMARY_KEY);
        expectedRow.setRowData(rowData);

        //execute
        queryEngine.executeQuery(queryTree);

        //verify
        verify(storageManager).insert(eq(expectedTableName), eq(expectedRow));
    }

}
