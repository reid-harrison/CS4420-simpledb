package gt.cs4420.relationaldb.database.query;

import gt.cs4420.relationaldb.database.storage.StorageStatistics;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class QueryOptimizeTest {

    private QueryOptimizer optimizer;

    @Before
    public void setUp() throws Exception {
        optimizer = new QueryOptimizer(mock(StorageStatistics.class));
    }

    @Test
    public void optimizationTest(){
        CommonTree queryTree = mock(CommonTree.class);
        CommonTree optimizedtree = optimizer.optimize(queryTree); //may need real value over mock object here

        assertThat(optimizer, is(notNullValue()));
        assertThat(queryTree, is(sameInstance(queryTree)));
    }

    @Test
    public void testIsOptimizable_expectsFalse() {

    }
}
