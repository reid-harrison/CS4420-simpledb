package gt.cs4420.relationaldb.domain;


import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Map;

public class Table {

    private Integer id;
    private String name;
    private Description desc;

    private Attribute primaryKeyAttribute;

    private Map<Integer, Map<Attribute, Object>> data;

    public Table() {
        this(-1);
    }

    public Table(final Integer id) {
        this.id = id;

        name = "";
        desc = new Description();
        data = Maps.newHashMap();
    }

    public Table(final Integer id, final Description desc, final Attribute primaryKeyAttribute) {
        this(id);

        setDescription(desc);
        setPrimaryKeyAttribute(primaryKeyAttribute);
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Description getDescription() {
        return desc;
    }

    public void setDescription(final Description desc) {
        this.desc = desc;
    }

    public Attribute getPrimaryKeyAttribute() {
        return primaryKeyAttribute;
    }

    /**
     * Primary Key attributes may only be of DataType INT for now.
     * @param primaryKeyAttribute
     */
    public void setPrimaryKeyAttribute(final Attribute primaryKeyAttribute) {
        if (!primaryKeyAttribute.getType().equals(DataType.INT)) {
            throw new IllegalArgumentException("Primary Key attributes must be of the DataType INT");
        }

        if (!Arrays.asList(desc.getAttributes()).contains(primaryKeyAttribute)) {
            throw new IllegalArgumentException("Primary Key attributes must exist in a table's description");
        }

        this.primaryKeyAttribute = primaryKeyAttribute;
    }

    /**
     * Adds a row to this in-memory representation of a Table. This will not guarantee that the row is actually written
     * to disk.
     *
     * @param attributes Attribute values for the new row
     * @return
     */
    public Integer addRow(final Map<Attribute, Object> attributes) {
        Object primaryKey = attributes.get(primaryKeyAttribute);

        //TODO Support other types for primary keys?
        if (!(primaryKey instanceof Integer)) {
            throw new ClassCastException("Primary Keys may only be Integers at this time");
        }

        data.put((Integer) primaryKey, attributes);

        return (Integer) primaryKey;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Table)) {
            return false;
        }

        return this.id.equals(((Table) other).getId());
    }

}
