package gt.cs4420.relationaldb.domain.validator;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.exception.ValidationException;

import java.util.List;

public class TableValidator implements Validator<Table> {

    private DescriptionValidator descValidator;

    public TableValidator() {
        descValidator = new DescriptionValidator();
    }

    @Override
    public void validate(Table table) throws ValidationException {
        ValidationException ve = new ValidationException();

        if (table == null) {
            throw new IllegalArgumentException("Table cannot be null");
        }

        ve.addMessages(validateId(table));
        ve.addMessages(validateName(table));

        try {
            descValidator.validate(table.getDescription());
        } catch (final ValidationException ve2) {
            ve.addException(ve2);
        }

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

}
