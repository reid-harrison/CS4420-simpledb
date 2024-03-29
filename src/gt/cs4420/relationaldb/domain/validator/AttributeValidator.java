package gt.cs4420.relationaldb.domain.validator;

import com.google.common.base.Strings;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.exception.ValidationException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AttributeValidator implements Validator<Attribute> {

    /**
     * Validates that the given Attribute is valid to be added to the database.
     * @param attribute (must have name and DataType)
     * @throws ValidationException
     */
    @Override
    public void validate(final Attribute attribute) throws ValidationException {
        ValidationException ve = new ValidationException();

        if (Strings.isNullOrEmpty(attribute.getName())) {
            ve.addMessage("Name required for attribute");
        }

        if (attribute.getType() == null) {
            ve.addMessage("Type required for attribute");
        }

        if (ve.hasMessages()) {
            throw ve;
        }
    }

    /**
     * Validates that all of the given Attributes are included in the given Table's Description.
     *
     * @param attributes
     * @param table
     * @throws ValidationException
     */
    public void validate(final Attribute[] attributes, final Table table) throws ValidationException {
        ValidationException ve = new ValidationException();
        List<Attribute> descAttributes = Arrays.asList(table.getDescription().getAttributes());

        for (Attribute attr : attributes) {
            int index = descAttributes.indexOf(attr);

            if (index < 0) {
                ve.addMessage("The attribute " + attr.getName() + " of type " + attr.getType()
                        + " is not in the description of table \'" + table.getName() + "\'");
                throw ve;
            }

            Attribute descAttr = descAttributes.get(index);

            if (attr.getType() != descAttr.getType()) {
                ve.addMessage("The attribute " + attr.getName() + " of type " + attr.getType()
                        + " does not match the table " + table.getName()  + "\'s description (" + descAttr.getName() + ": " + descAttr.getType().getTypeString() + ")");
            }
        }

        if (ve.hasMessages()) {
            throw ve;
        }
    }

    /**
     * Validates that all of the given Attributes and their corresponding values are valid for the given Table's Description.
     * This will check that the types of values match with the Attribute's correct DataType.
     *
     * @param attributes The Attribute->Value mapping to be validated
     * @param table The Table against whose Description to validate
     */
    public void validate(final Map<Attribute, Object> attributes, final Table table) throws ValidationException {
        ValidationException ve = new ValidationException();

        try {
            Set<Attribute> attrSet = attributes.keySet();
            Attribute[] attrArr = new Attribute[attrSet.size()];
            int i = 0;

            for (Attribute attr : attrSet) {
                attrArr[i] = attr;
                i++;
            }

            validate(attrArr, table);
        } catch (final ValidationException v) {
            ve.addException(v);
        }

        for (Attribute attr : attributes.keySet()) {
            if (attr.getType() == null) {
                attr.setType(table.getDescription().getAttribute(attr.getName()).getType());
            }

            Object obj = attributes.get(attr);

            if (obj == null) {
                if (attr.equals(table.getDescription().getPrimaryKeyAttribute())) {
                    ve.addMessage("Primary key attribute cannot be null, must be set");
                    continue;
                }

                //Null value not for primary key (allowed) no need to validate further
                continue;
            }

            try {
                attributeTypeCheck(attr, obj);
            } catch (final ClassCastException cce) {
                ve.addMessage(cce.getMessage());
            }
        }

        if (ve.hasMessages()) {
            throw ve;
        }
    }

    public void attributeTypeCheck(final Attribute attribute, final Object object) throws ClassCastException {
        boolean error = false;

        switch (attribute.getType()) {
            case INT:
                if (!(object instanceof Integer)) {
                    error = true;
                }

                break;

            case STRING:
                if (!(object instanceof String)) {
                    error = true;
                }

                if (object.toString().length() > 10000) {
                    throw new ClassCastException("Congratulations, you hit our arbitrary String length cap of 10,000 characters!");
                }

                break;
        }
        
        if (error) {
            throw new ClassCastException("The value given for attribute " + attribute.getName() + " is not the correct " +
                    "type (" + attribute.getType().getTypeString() + ")");
        }
    }

}
