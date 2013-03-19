package gt.cs4420.relationaldb.domain;


import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Map;

public class Table {

    private Integer id;
    private String name;
    private Description desc;

    private Attribute primaryKeyAttribute;

    public Table() {
        this(-1);
    }

    public Table(final Integer id) {
        this.id = id;

        name = "";
        desc = new Description();
        primaryKeyAttribute = null;
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
        //TODO Support primary key data types other than INTs?
        if (!primaryKeyAttribute.getType().equals(DataType.INT)) {
            throw new IllegalArgumentException("Primary Key attributes must be of data type INT");
        }

        if (!Arrays.asList(desc.getAttributes()).contains(primaryKeyAttribute)) {
            throw new IllegalArgumentException("Primary Key attribute does not exist in the table's description");
        }

        this.primaryKeyAttribute = primaryKeyAttribute;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Table)) {
            return false;
        }

        return this.id.equals(((Table) other).getId());
    }

}
