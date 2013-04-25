package gt.cs4420.relationaldb.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class TableTest {

    private static final String MY_ATTRIBUTE = "myAttribute";

    @Test
    public void testNotEquals(){
        Attribute attribute = new Attribute(DataType.INT, MY_ATTRIBUTE);
        Attribute[] attributes = {attribute};

        Description description = new Description();
        description.setAttributes(attributes);
        description.setPrimaryKeyAttribute(attribute);

        Table table = new Table();
        table.setDescription(description);
        table.setName("myTable");

        Attribute otherAttribute = new Attribute(DataType.INT, "10");
        Attribute[] otherAttributes = {otherAttribute};

        Description otherDescription = new Description();
        otherDescription.setAttributes(otherAttributes);
        otherDescription.setPrimaryKeyAttribute(otherAttribute);

        Table otherTable = new Table();
        otherTable.setDescription(otherDescription);
        otherTable.setName("myTable");

        assertThat(table, is(not(otherTable)));

    }

    @Test
    public void testEquals() {
        Attribute attribute = new Attribute(DataType.INT, MY_ATTRIBUTE);
        Attribute[] attributes = {attribute};

        Description description = new Description();
        description.setAttributes(attributes);
        description.setPrimaryKeyAttribute(attribute);

        Table table = new Table();
        table.setDescription(description);
        table.setName("myTable");

        Attribute otherAttribute = new Attribute(DataType.INT, MY_ATTRIBUTE);
        Attribute[] otherAttributes = {otherAttribute};

        Description otherDescription = new Description();
        otherDescription.setAttributes(otherAttributes);
        otherDescription.setPrimaryKeyAttribute(otherAttribute);

        Table otherTable = new Table();
        otherTable.setDescription(otherDescription);
        otherTable.setName("myTable");

        assertThat(table, is(otherTable));
    }

    @Test
    public void testEquals_withTableId() {
        Attribute attribute = new Attribute(DataType.INT, MY_ATTRIBUTE);
        Attribute[] attributes = {attribute};

        Description description = new Description();
        description.setAttributes(attributes);
        description.setPrimaryKeyAttribute(attribute);

        Table table = new Table();
        table.setDescription(description);
        table.setName("myTable");
        table.setId(2);

        Attribute otherAttribute = new Attribute(DataType.INT, MY_ATTRIBUTE);
        Attribute[] otherAttributes = {otherAttribute};

        Description otherDescription = new Description();
        otherDescription.setAttributes(otherAttributes);
        otherDescription.setPrimaryKeyAttribute(otherAttribute);

        Table otherTable = new Table();
        otherTable.setDescription(otherDescription);
        otherTable.setName("myTable");
        otherTable.setId(2);

        assertThat(table, is(otherTable));
    }
}
