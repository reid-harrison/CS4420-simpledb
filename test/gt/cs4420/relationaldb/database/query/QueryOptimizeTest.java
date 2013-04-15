package gt.cs4420.relationaldb.database.query;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class QueryOptimizeTest {

    @Test
    public void optimizationTest(){
        QueryOptimizer optimizer = new QueryOptimizer();

        assertThat(optimizer, is(notNullValue()));
    }
}
