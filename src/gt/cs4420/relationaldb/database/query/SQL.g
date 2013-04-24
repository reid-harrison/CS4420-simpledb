grammar SQL;

options {
  language = Java;
  output = AST;
  ASTLabelType = CommonTree;
}

@parser::members
{
	int numCols = 0;
	int numVals = 0;
	int numTables = 0;
	Table table1 = new Table();
	Table table2 = new Table();
	boolean isJoin = false;
	List<Table> tables = Lists.newArrayList();
	List<Attribute> table1Attributes = Lists.newArrayList();
	List<Object> insertVals = Lists.newArrayList();
	Map<Attribute, Object> attrVals = Maps.newHashMap();
	AttributeValidator attrValidator = new AttributeValidator();
	StorageManager storageManager = new StorageManager();
	
	@Override    
    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
        String hdr = getErrorHeader(e);
        String msg = getErrorMessage(e, tokenNames);
        throw new RuntimeException(hdr + ":" + msg);
    }
}

@rulecatch {
    catch (RecognitionException e) {
        throw e;
    }
}

@lexer::members {
	@Override
    public void reportError(RecognitionException e) {
        throw new RuntimeException(e);
    }
}

@header {
///////////////////////////////////////////////////////////////////
//                                                               //
//   THIS IS A DERIVED FILE! MAKE ANY DESIRED CHANGES IN SQL.g   //
//                                                               //
///////////////////////////////////////////////////////////////////

package gt.cs4420.relationaldb.database.query;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import gt.cs4420.relationaldb.domain.validator.AttributeValidator;
import gt.cs4420.relationaldb.database.storage.StorageManager;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Map;
}

@lexer::header {
///////////////////////////////////////////////////////////////////
//                                                               //
//   THIS IS A DERIVED FILE! MAKE ANY DESIRED CHANGES IN SQL.g   //
//                                                               //
///////////////////////////////////////////////////////////////////

package gt.cs4420.relationaldb.database.query;
}



statement
	:	select
	|	insert
	|	update
	|	EOF
	;


/* query statements */
select
	:	selectClause fromClause (onClause)? (whereClause)? (orderByClause)? SEMI!
	;
	
insert
	:	insertClause valuesClause SEMI!
	;
	
update
	:	updateClause setClause whereClause SEMI!
	;
	
	
	
	
	
/* Query clauses */
selectClause
	:	SELECT^ columns
	;
	
insertClause
	:	INSERT_INTO^ insertParams
	;
	
updateClause
	:	UPDATE^ table
	;
	
fromClause
	:	FROM^ tableClause 
	;
	
tableClause
	:	table
	|	joinClause
	;
	
joinClause
	:	table (joinOperator^ table)+
		{
			isJoin = true;
		}
	;
	
// Should only occur when preceded by a JOIN
onClause
	:	{
			if(!isJoin)
			{
				throw new IllegalArgumentException("Expecting previous join clause.");
			}
		}
		ON^ onSearchConditions	
	;

whereClause
	:	WHERE^ searchConditions
	;
	
orderByClause
	:	ORDER_BY^ column (order)?
	;
	
valuesClause
	: VALUES^ LPAREN! values RPAREN!
	;

setClause
	:	SET^ assignments
	;






/* Query parameters	*/
	
insertParams
	:	table^ LPAREN! columns RPAREN!
	;
	
table
	:	IDENT
		{
			//build a Table for use with validation
			table1 = storageManager.getTable($IDENT.text);
			tables.add(table1);
			//storageManager.validateTableExists(table1.getName());
			//table1.setDescription(storageManager.getTable($IDENT.text).getDescription());
		}
	;
	
// Requires different logic than table
onTable
	:	IDENT
		{
			if (!tables.contains($IDENT.text))
			{
				throw new IllegalArgumentException("'" + $IDENT.text + "' is not a table from which items are being queried.");
			}
		}
	;

columns
	:	(column (COMMA! column)*)
	;

// Matches an attribute in a query
column
	:	IDENT
		{
			numCols++;
			table1Attributes.add(new Attribute($IDENT.text));
		}
	;

// This is where more data type support can be added
// numVals is incremented to ensure the number of values matches the number of attributes in the INSERT
value
	:	STRING_LITERAL
		{
			insertVals.add($STRING_LITERAL);
			numVals++;
		}
	| 	INTEGER
		{
			insertVals.add($INTEGER);
			numVals++;
		}
	;
	
values
	:	(value (COMMA! value)*)
		{
			// Number of values must match number of attribues in INSERT
			if (!(numVals == numCols))
			{
				throw new IllegalArgumentException(numCols + " columns specified and " + numVals + " values entered.");
			}	
			
			// Once attributes and values are parsed, put them in a map for validation
			for(int i = 0; i < table1Attributes.size(); i++) {
				attrVals.put(table1Attributes.get(i), insertVals.get(i));			
			}
			
			
			
			attrValidator.validate(attrVals, table1);
		}
	;catch[ValidationException e]{}
	
order
	:	ASC
	|	DESC
	;
	
assignments
	:	assignment (COMMA! assignment)*
	;
	
assignment
	:	column EQUAL^ value
	;
	
// WHERE clause conditions
searchConditions
	:	searchCondition (logicalOperator^ searchCondition)*
	;
	
searchCondition
	:	column comparisonOperator^ value
		{
			//TODO Possibly validate type of value against column type?
		}
	;
	
// ON clause conditions when performing a JOIN
onSearchConditions
	:	onSearchCondition (logicalOperator^ onSearchCondition)*
	;

onSearchCondition
	:	onTable DOT!column comparisonOperator^ value
		{
			//TODO Possibly validate type of value against column type?
		}
	;
	


	

	
/* Operators */
comparisonOperator
	:	EQUAL
	|	NOT_EQUAL
	|	LESS_THAN_EQUAL
	|	LESS_THAN
	|	GREATER_THAN_EQUAL
	|	GREATER_THAN
	;
	
logicalOperator
	:	AND
	|	OR
	;
	
joinOperator
	:	INNER_JOIN
	|	OUTER_JOIN
	|	LEFT_JOIN
	|	RIGHT_JOIN
	|	JOIN
	;



/* Tokens */

// Reserved words are accepted in any lowercase, uppercase, or any combination of the two
SELECT : ('s' | 'S')('e' | 'E' )('l' | 'L')('e' | 'E')('c' | 'C')('t' | 'T') ;
FROM : ('f' |'F')('r' | 'R')('o' | 'O')('m' | 'M') ;
WHERE : ('w' | 'W')('h' | 'H')('e' | 'E')('r' | 'R')('e' | 'E') ;
ORDER_BY : ('o' | 'O')('r' | 'R')('d' | 'D')('e' | 'E')('r' | 'R')' '('b' |'B')('y' | 'Y');
INSERT_INTO : ('i' | 'I')('n' |'N')('s' | 'S')('e' | 'E')('r' | 'R')('t' | 'T')' '('i' | 'I')('n' | 'N')('t' | 'T')('o' | 'O') ;
VALUES : ('v' | 'V')('a' | 'A')('l' | 'L')('u' | 'U')('e' | 'E')('s' | 'S') ;
AND : ('a' |'A')('n' | 'N')('d' | 'D') ;
OR : ('o' | 'O')('r' | 'R') ;
UPDATE : ('u' | 'U')('p' | 'P')('d' | 'D')('a' | 'A')('t' | 'T')('e' | 'E') ;
SET : ('s' | 'S')('e' | 'E')('t' | 'T') ;
ASC : ('a' | 'A')('s' | 'S')('c' | 'C') ;
DESC: ('d' | 'D')('e' | 'E')('s' | 'S')('c' | 'S') ;
fragment JOIN : ('j' | 'J')('o' | 'O')('i' | 'I')('n' | 'N') ;
INNER_JOIN: ('i' | 'I')('n' | 'N')('n' | 'N')('e' | 'E')('r' | 'R')(' ')JOIN ;
OUTER_JOIN: ('o' | 'O')('u' | 'U')('t' | 'T')('e' | 'E')('r' | 'R')(' ')JOIN ;
LEFT_JOIN: ('l' | 'L')('e' | 'E')('f' | 'F')('t' | 'T')(' ')JOIN ;
RIGHT_JOIN: ('r' | 'R')('i' | 'I')('g' | 'G')('h' | 'H')('t' | 'T')(' ')JOIN ;
ON : ('o' | 'O')('n' | 'N') ;
DOT : '.' ;

LPAREN : '(' ;
RPAREN : ')';
COMMA : ',' ;
SEMI : ';' ;

EQUAL : '=' ;
NOT_EQUAL : ('!=' | '<>') ;
LESS_THAN_EQUAL : '<=' ;
LESS_THAN : '<' ;
GREATER_THAN_EQUAL : '>=' ;
GREATER_THAN : '>' ;

fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : ('0'..'9') ;
IDENT : LETTER (LETTER | DIGIT)* ;
INTEGER : DIGIT+;
STRING_LITERAL : '\'' .* '\'' ;

// Ignore comments and whitespace when parsing
COMMENT : '--' .* ('\r' | '\n') {$channel = HIDDEN;} ;
WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;} ;