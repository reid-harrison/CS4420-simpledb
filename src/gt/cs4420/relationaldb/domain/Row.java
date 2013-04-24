package gt.cs4420.relationaldb.domain;

import java.util.Map;

public class Row {
/*
 * Need a little more clarification of the private fields here
 */
    private Integer primaryKey;
    private Map<Attribute, Object> rowData;

    public Row() {
        primaryKey = null;
        rowData = null;
    }

    public Row(final Map<Attribute, Object> rowData) {
        this();
        this.rowData = rowData;
    }

    public Integer getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(final Integer primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Map<Attribute, Object> getRowData() {
        return rowData;
    }

    public void setRowData(final Map<Attribute, Object> rowData) {
        this.rowData = rowData;
    }

}
