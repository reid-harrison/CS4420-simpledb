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
	List<Attribute> table1Attributes = Lists.newArrayList();
	List<Object> insertVals = Lists.newArrayList();
	Map<Attribute, Object> attrVals = Maps.newHashMap();
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
package gt.cs4420.relationaldb.database.query;
import gt.cs4200.relationaldb.database.validator.TableAttributeValidator;
import gt.cs4200.relationaldb.database.validator.TableValidator;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import gt.cs4420.relationaldb.database.storage.StorageManager;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Map;
}

@lexer::header {
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
	:	selectClause fromClause (whereClause)? (orderByClause)? SEMI!
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
	:	FROM^ table
	;
	
whereClause
	:	WHERE^ searchConditions
	;
	
orderByClause
	:	ORDER_BY^ column (COMMA! column)* (order)?
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
	/*@init 
		{
		}*/
	:	IDENT
		{
			table1.setName($IDENT.text);
			table1.setDescription(storageManager.getTableDescription($IDENT.text));
			storageManager.validateTableExists(table1.getName());
		} // need validation of table existence
	;
	catch [ValidationException e]{}

columns
	@init
	{
		
	}
	:	(column (COMMA! column)*)
	;
	
column
	/*@init
		{
		}*/
	:	IDENT
		{
			numCols++;
			table1Attributes.add(new Attribute($IDENT.text));
			
		} // need validation of column existence within table
	;

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
	@init
	{
		
	}
	:	(value (COMMA! value)*)
		{
			if (!(numVals == numCols))
			{
				throw new IllegalArgumentException(numCols + " columns specified and " + numVals + " values entered.");
			}	
			
			for(int i = 0; i < table1Attributes.size(); i++) {
				attrVals.put(table1Attributes.get(i), insertVals.get(i));			
			}
			
			storageManager.validateValueTypes(attrVals, table1);
		}
	; catch [ValidationException e]{}
	
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
	
searchConditions
	:	searchCondition (logicalOperator^ searchCondition)*
	;
	
searchCondition
	:	column comparisonOperator^ value
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
	:	AND^
	|	OR^
	;
	




/* Tokens */
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
WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;} ;
INTEGER : DIGIT+;
COMMENT : '--' .* ('\r' | '\n') {$channel = HIDDEN;} ;
STRING_LITERAL : '\'' .* '\'' ;