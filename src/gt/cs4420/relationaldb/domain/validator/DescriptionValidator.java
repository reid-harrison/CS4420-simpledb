package gt.cs4420.relationaldb.domain.validator;

import com.google.common.collect.Lists;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.DataType;
import gt.cs4420.relationaldb.domain.Description;
import gt.cs4420.relationaldb.domain.exception.ValidationException;

import java.util.Arrays;
import java.util.List;

public class DescriptionValidator implements Validator<Description> {

    private AttributeValidator attributeValidator;

    public DescriptionValidator() {
        attributeValidator = new AttributeValidator();
    }

    @Override
    public void validate(Description desc) throws ValidationException {
        Attribute[] attributes = desc.getAttributes();

        validateAttributes(attributes);
        validatePrimaryKeyAttribute(attributes, desc.getPrimaryKeyAttribute());
    }

    private void validateAttributes(final Attribute[] attributes) throws ValidationException {
        ValidationException ve = new ValidationException();

        if (attributes == null || attributes.length == 0) {
            ve.addMessage("At least one attribute required for a table's description");
        }

        for (Attribute attr : attributes) {
            try {
                attributeValidator.validate(attr);
            } catch (final ValidationException v) {
                ve.addException(v);
            }
        }

        if (ve.hasMessages()) {
            throw ve;
        }
    }

    private List<String> validatePrimaryKeyAttribute(final Attribute[] attributes, final Attribute primaryKeyAttribute) {
        List<String> errors = Lists.newArrayList();

        if (primaryKeyAttribute == null) {
            errors.add("A primary key attribute is required");
        }

        if (!primaryKeyAttribute.getType().equals(DataType.INT)) {
            throw new IllegalArgumentException("Primary Key attributes must be of data type INT");
        }

        if (!Arrays.asList(attributes).contains(primaryKeyAttribute)) {
            throw new IllegalArgumentException("Primary Key attribute does not exist in the table's description");
        }

        return errors;
    }

}
