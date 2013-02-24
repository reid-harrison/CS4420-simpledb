package gt.cs4420.relationaldb.domain.validator;

import gt.cs4420.relationaldb.domain.exception.ValidationException;

public interface Validator<O> {

    void validate(O object) throws ValidationException;

}
