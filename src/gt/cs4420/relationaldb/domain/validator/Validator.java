package gt.cs4420.relationaldb.domain.validator;

import gt.cs4420.relationaldb.domain.exception.ValidationException;

public interface Validator<O> {

    /**
     * @throws ValidationException containing validation messages that came up during validation.
     */
    void validate(O object) throws ValidationException;

}
