package gt.cs4420.relationaldb.domain;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class RowTest {

    @Test
    public void testEquals_expectsNotEquals() {
        Row firstRow = new Row();
        firstRow.setPrimaryKey(0);
        firstRow.setRowData(new HashMap<Attribute, Object>());

        Row secondRow = new Row();
        secondRow.setPrimaryKey(0);
        Map<Attribute, Object> rowData = new HashMap<>();
        rowData.put(new Attribute(DataType.INT, "secondRowAttribute"), 0);
        secondRow.setRowData(rowData);

        assertThat(firstRow, is(not(secondRow)));
    }

    @Test
    public void testEquals_expectsEqual() {
        Row firstRow = new Row();
        Map<Attribute, Object> firstRowData = new HashMap<>();
        firstRowData.put(new Attribute(DataType.INT, "firstRowAttribute"), 0);
        firstRow.setPrimaryKey(0);
        firstRow.setRowData(firstRowData);

        Row secondRow = new Row();
        Map<Attribute, Object> secondRowData = new HashMap<>();
        secondRowData.put(new Attribute(DataType.INT, "firstRowAttribute"), 0);
        secondRow.setPrimaryKey(0);
        secondRow.setRowData(secondRowData);

        assertThat(firstRow, is(secondRow));
    }
}
