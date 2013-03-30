package gt.cs4200.relationaldb.database.validator;


import java.util.ArrayList;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import gt.cs4420.relationaldb.domain.validator.Validator;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.Table;

/**
 * 
 * Validates the existence of an attribute in a table
 */
public class TableAttributeValidator implements Validator<ArrayList<Object>> {

	@Override
	public void validate(ArrayList<Object> list) throws ValidationException {
		Table table = (Table) list.get(0);
		Attribute attr = (Attribute) list.get(1);
		
		// TODO Validate presence of attribute in given table
		
	}

	

}
