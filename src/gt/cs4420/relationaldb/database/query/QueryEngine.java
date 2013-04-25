package gt.cs4420.relationaldb.database.query;

import gt.cs4420.relationaldb.database.storage.StorageManager;
import gt.cs4420.relationaldb.domain.Description;
import gt.cs4420.relationaldb.domain.Table;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

public class QueryEngine {

    private StorageManager storageManager;

    public QueryEngine(StorageManager storageManager) {
        this.storageManager = storageManager;
    }

    public boolean executeQuery(CommonTree queryTree) {

        //recurse down tree
            //match keywords to operations
            //should be off form "KEYWORD" -> parameters (as children)


        return false;
    }

    public void createTable(Tree createTableNode) {

        //extra this node's relevant data
        String name = createTableNode.getChild(0).getText();
        //move down CREATE TABLE tree


        Description description = new Description();


        Table table = new Table(name, description);
    }
}
