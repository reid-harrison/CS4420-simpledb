package gt.cs4420.relationaldb.database.query;

import gt.cs4420.relationaldb.database.storage.StorageStatistics;
import org.antlr.runtime.tree.CommonTree;

public class QueryOptimizer {

    private final StorageStatistics statistics;

    public  QueryOptimizer(StorageStatistics statistics) {
        this.statistics = statistics;
    }

    public CommonTree optimize(CommonTree queryTree){
        restructureLogicalPlan(queryTree);
        generatePhysicalPlan(queryTree);
        return queryTree;
    }

    private void restructureLogicalPlan(CommonTree queryTree) {

    }

    private void generatePhysicalPlan(CommonTree queryTree) {

    }

}
