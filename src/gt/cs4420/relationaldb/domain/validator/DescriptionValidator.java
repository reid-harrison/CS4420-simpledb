package gt.cs4420.relationaldb.domain.validator;

import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.Description;
import gt.cs4420.relationaldb.domain.exception.ValidationException;

public class DescriptionValidator implements Validator<Description> {

    private AttributeValidator attributeValidator;

    public DescriptionValidator() {
        attributeValidator = new AttributeValidator();
    }

    @Override
    public void validate(Description desc) throws ValidationException {
        validateAttributes(desc.getAttributes());
    }

    private void validateAttributes(final Attribute[] attributes) throws ValidationException {
        ValidationException ve = new ValidationException();

        if (attributes == null || attributes.length == 0) {
            ve.addMessage("At least one attribute required for a table");
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



}
