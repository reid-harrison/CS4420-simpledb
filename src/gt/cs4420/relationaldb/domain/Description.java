package gt.cs4420.relationaldb.domain;

import com.google.common.base.Strings;

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
        if (Strings.isNullOrEmpty(primaryKeyAttribute.getName())) {
            throw new IllegalArgumentException("Primary key attributes must at least be populated with a name");
        }

        for (Attribute attr : attributes) {
            if (attr.getName().equals(primaryKeyAttribute.getName())) {
            	
                //Resolve type if need-be
                if (primaryKeyAttribute.getType() == null) {
                    primaryKeyAttribute.setType(attr.getType());
                }

                if (!primaryKeyAttribute.getType().equals(DataType.INT)) {
                    throw new IllegalArgumentException("Primary Key attributes must be of data type INT");
                }

                //All validation passes
                this.primaryKeyAttribute = primaryKeyAttribute;
                return;
            }
        }

        //If it gets here, there hasn't been a match between the primaryKey's name and any attribute in the description
        throw new IllegalArgumentException("Primary Key attribute does not exist in the table's description");

    }

    /*
     * Implemented for ease of testing.
     */
    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Description))
            return false;

        boolean equals = true; //must assume true to use && later
        if(primaryKeyAttribute != null){
            equals = this.getPrimaryKeyAttribute().equals(((Description) other).getPrimaryKeyAttribute());
        }

        Attribute[] otherAttributes = ((Description) other).getAttributes();
        if(equals && (attributes.length == (otherAttributes.length))) {
            for(int i = 0; i < attributes.length; i++){
                equals = equals && attributes[i].equals(otherAttributes[i]);
            }
        } else {
            return false;
        }
        return equals;
    }

}
