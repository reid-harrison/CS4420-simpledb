package gt.cs4420.relationaldb.database.query;

import gt.cs4420.relationaldb.database.storage.StorageManager;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.DataType;
import gt.cs4420.relationaldb.domain.Description;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class QueryEngineTest {

    public static final String MY_ATTRIBUTE = "myAttribute";
    public static final String MY_TABLE = "myTable";
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



}
