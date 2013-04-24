package gt.cs4420.relationaldb.database.query;

import gt.cs4420.relationaldb.database.storage.StorageStatistics;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

public class QueryOptimizer {

    private StorageStatistics statistics;

    private CommonTree queryTree;

    public  QueryOptimizer(StorageStatistics statistics) {
        this.statistics = statistics;
    }

    public CommonTree optimize(CommonTree queryTree){

        if(isOptimizable(queryTree)) {
            restructureLogicalPlan(queryTree);
            generatePhysicalPlan(queryTree);
        }

        return queryTree;

    }

    public boolean isOptimizable(CommonTree queryTree) {
        int type = queryTree.getChild(0).getType();

        //Add these to this expression to exclude different top level operations
        boolean notOptimzable = (type == SQLParser.CREATE_TABLE ||
                              type == SQLParser.DROP_TABLE ||
                              type == SQLParser.INSERT_INTO);

        return !notOptimzable;

    }

    /*
     * Phase 1, push "selection" operations lower in the execution tree
     */
    private void restructureLogicalPlan(CommonTree queryTree) {

    }

    /*
     * Phase 2, estimated intermediate relation sizes, pick plan with smallest
     */
    private void generatePhysicalPlan(CommonTree queryTree) {
        Tree currentNode = queryTree.getChild(0);
        while(currentNode != null) {
            currentNode.getType();
        }
    }

}
