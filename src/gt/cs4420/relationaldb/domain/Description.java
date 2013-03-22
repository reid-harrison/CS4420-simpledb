package gt.cs4420.relationaldb.domain;

import java.util.Arrays;

public class Description {

    private Attribute[] attributes;

    private Attribute primaryKeyAttribute;

    public Description() {
        attributes = new Attribute[0];
        primaryKeyAttribute = null;
    }

    public Attribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(final Attribute[] attributes) {
        this.attributes = attributes;
    }

    public Attribute getAttribute(final String attributeName) {
        for (Attribute attr : attributes) {
            if (attr.getName().equals(attributeName)) {
                return attr;
            }
        }

        return null;
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

        if (!Arrays.asList(getAttributes()).contains(primaryKeyAttribute)) {
            throw new IllegalArgumentException("Primary Key attribute does not exist in the table's description");
        }

        this.primaryKeyAttribute = primaryKeyAttribute;
    }
}
