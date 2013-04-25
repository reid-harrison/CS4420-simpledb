package gt.cs4420.relationaldb.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DescriptionTest {

    @Test
    public void testEquals_expectsEqual() {
        Attribute attribute = new Attribute(DataType.INT, "myAttribute");
        Attribute[] attributes = {attribute};
        Description firstDescription = new Description();
        firstDescription.setAttributes(attributes);
        firstDescription.setPrimaryKeyAttribute(attribute);

        Attribute otherAttribute = new Attribute(DataType.INT, "myAttribute");
        Attribute[] otherAttributes = {attribute};
        Description secondDescription = new Description();
        secondDescription.setAttributes(otherAttributes);
        secondDescription.setPrimaryKeyAttribute(otherAttribute);

        assertThat(firstDescription, is(secondDescription));
    }

    @Test
    public void testEquals_expectsNotEqual() {
        Attribute attribute = new Attribute(DataType.INT, "myAttribute");
        Attribute[] attributes = {attribute};
        Description firstDescription = new Description();
        firstDescription.setAttributes(attributes);
        firstDescription.setPrimaryKeyAttribute(attribute);

        Attribute otherAttribute = new Attribute(DataType.INT, "myNotAttribute");
        Attribute[] otherAttributes = {otherAttribute};
        Description secondDescription = new Description();
        secondDescription.setAttributes(otherAttributes);
        secondDescription.setPrimaryKeyAttribute(otherAttribute);

        assertThat(firstDescription, is(not(secondDescription)));
    }
}
