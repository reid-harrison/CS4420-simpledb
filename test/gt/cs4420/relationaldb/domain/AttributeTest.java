package gt.cs4420.relationaldb.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class AttributeTest {

    @Test
    public void testEquals_expectsEqual() {
        Attribute firstAttribute = new Attribute(DataType.INT, "myAttribute");
        Attribute secondAttribute = new Attribute(DataType.INT, "myAttribute");

        assertThat(firstAttribute, is(secondAttribute));
    }

    @Test
    public void testEquals_expectsNotEqual() {
        Attribute firstAttribute = new Attribute(DataType.INT, "myAttribute");
        Attribute secondAttribute = new Attribute(DataType.INT, "notMyAttribute");

        assertThat(firstAttribute, is(not(secondAttribute)));
    }
}
