package gt.cs4420.relationaldb.domain.validator;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.Description;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.exception.ValidationException;

import java.util.List;

public class DescriptionValidator implements Validator<Description> {

    @Override
    public void validate(Description desc) throws ValidationException {
        validateAttributes(desc);
    }

    private List<String> validateAttributes(final Description desc) {
        List<String> errors = Lists.newArrayList();
        Attribute[] attributes = desc.getAttributes();

        if (attributes == null || attributes.length == 0) {
            errors.add("At least one attribute required for table");
        }

        for (Attribute attr : attributes) {
            errors.addAll(validateAttribute(attr));
        }

        return errors;
    }

    private List<String> validateAttribute(final Attribute attribute) {
        List<String> errors = Lists.newArrayList();

        if (Strings.isNullOrEmpty(attribute.getName())) {
            errors.add("Name required for attribute");
        }

        if (attribute.getType() == null) {
            errors.add("Type required for attribute");
        }

        return errors;
    }

}
