package gt.cs4420.relationaldb.domain.validator;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.exception.ValidationException;

import java.util.List;

public class TableValidator implements Validator<Table> {

    @Override
    public void validate(Table table) throws ValidationException {
        ValidationException ve = new ValidationException();

        if (table == null) {
            throw new IllegalArgumentException("Table cannot be null");
        }

        ve.addMessages(validateId(table));
        ve.addMessages(validateName(table));
        ve.addMessages(validateAttributes(table));

        if (ve.hasMessages()) {
            throw ve;
        }
    }

    private List<String> validateId(final Table table) {
        List<String> errors = Lists.newArrayList();
        Integer id = table.getId();

        if (id == null || id < 0) {
            errors.add("ID required for table");
        }

        return errors;
    }

    private List<String> validateName(final Table table) {
        List<String> errors = Lists.newArrayList();
        String name = table.getName();

        if (Strings.isNullOrEmpty(name)) {
            errors.add("Name required for table");
        }

        return errors;
    }

    private List<String> validateAttributes(final Table table) {
        List<String> errors = Lists.newArrayList();
        Attribute[] attributes = table.getAttributes();

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
