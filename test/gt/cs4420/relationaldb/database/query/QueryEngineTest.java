package gt.cs4420.relationaldb.database.query;

import gt.cs4420.relationaldb.database.storage.StorageManager;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class QueryEngineTest {

    @Test
    public void queryEngineTest_runCreateTable() throws ValidationException {
        //setup
        Tree primaryKeyNode = mock(Tree.class);

        Tree attributeTypeNode = mock(Tree.class);
        when(attributeTypeNode.getText()).thenReturn("int");

        Tree attributeNameNode = mock(Tree.class);
        when(attributeNameNode.getText()).thenReturn("myAttribute");
        when(attributeNameNode.getChild(0)).thenReturn(attributeTypeNode);
        when(attributeNameNode.getChild(1)).thenReturn(primaryKeyNode);

        Tree tableNameNode = mock(Tree.class);
        when(tableNameNode.getText()).thenReturn("myTable");

        CommonTree queryTree = mock(CommonTree.class);
        when(queryTree.getText()).thenReturn("CREATE TABLE");
        when(queryTree.getChild(0)).thenReturn(tableNameNode);
        when(queryTree.getChild(1)).thenReturn(attributeNameNode);

        StorageManager storageManager = mock(StorageManager.class);
        QueryEngine engine = new QueryEngine(storageManager);

        //execute
        engine.executeQuery(queryTree);

        //verify
        verify(storageManager).createTable(any(Table.class));
    }


}
