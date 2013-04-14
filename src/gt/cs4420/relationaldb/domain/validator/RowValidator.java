package gt.cs4420.relationaldb.domain.validator;

import gt.cs4420.relationaldb.domain.Description;
import gt.cs4420.relationaldb.domain.Row;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.exception.ValidationException;

public class RowValidator implements Validator<Row> {

    private AttributeValidator attributeValidator;

    public RowValidator() {
        attributeValidator = new AttributeValidator();
    }

    @Override
    public void validate(final Row row) throws ValidationException {
        if (row == null) {
            throw new ValidationException("Row cannot be null");
        }

        if (row.getRowData() == null || row.getRowData().isEmpty()) {
            throw new ValidationException("Row data cannot be null, or empty");
        }
    }

    public void validate(final Row row, final Table table) throws ValidationException {
        validate(row);

        //Validate the the row data is populated with valid data
        attributeValidator.validate(row.getRowData(), table);
    }

    /**
     * Currently just here to check that the primary key is not null or -1
     *
     * @param row
     * @param row
     * @throws ValidationException
     */
    public void validatePrimaryKey(final Row row) throws ValidationException {
        if (row == null) {
            throw new ValidationException("Null Row");
        }

        Integer primaryKey = row.getPrimaryKey();

        if (primaryKey == null || primaryKey == -1) {
            throw new ValidationException("Invalid primary key for given Row");
        }
    }
}
