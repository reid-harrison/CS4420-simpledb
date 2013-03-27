grammar SQL;

options {
  language = Java;
  output = AST;
  ASTLabelType = CommonTree;
}

@header {
package gt.cs4420.relationaldb.database.query;
}

@lexer::header {
package gt.cs4420.relationaldb.database.query;
}



statement
	:	select
	|	insert
	|	update
	;
	
select
	:	SELECT columns FROM table (whereClause)? (orderByClause)? SEMI
	;
	
insert
	:	INSERT INTO table LPAREN columns RPAREN VALUES LPAREN values RPAREN SEMI
	;
	
update
	:	UPDATE table SET assignments whereClause SEMI
	;
	
assignments
	:	assignment (COMMA assignment)*
	;
	
assignment
	:	column EQUAL value
	;
	
columns
	:	column (COMMA column)*
	;
	
column
	/*@init
		{
		}*/
	:	IDENT // need validation of column existence within table
	;
	
table
	/*@init 
		{
		}*/
	:	IDENT // need validation of table existence
	;
	
whereClause
	:	WHERE searchConditions
	;
	
orderByClause
	:	ORDER_BY column (COMMA column)* (order)?
	;
	
order
	:	ASC
	|	DESC
	;
	
searchConditions
	:	searchCondition (logicalOperator searchCondition)?
	;
	
searchCondition
	:	column comparisonOperator value
	;
	
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
	
value
	:	STRING_LITERAL
	| 	INTEGER
	;
	
values
	:	value (COMMA value)*
	;



// case insensitive reserved words
SELECT : ('s' | 'S')('e' | 'E' )('l' | 'L')('e' | 'E')('c' | 'C')('t' | 'T') ;
FROM : ('f' |'F')('r' | 'R')('o' | 'O')('m' | 'M') ;
WHERE : ('w' | 'W')('h' | 'H')('e' | 'E')('r' | 'R')('e' | 'E') ;
ORDER_BY : ('o' | 'O')('r' | 'R')('d' | 'D')('e' | 'E')('r' | 'R')' '('b' |'B')('y' | 'Y');
INSERT : ('i' | 'I')('n' |'N')('s' | 'S')('e' | 'E')('r' | 'R')('t' | 'T') ;
INTO : ('i' | 'I')('n' | 'N')('t' | 'T')('o' | 'O') ;
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
//COMMENT : '--' ~('\r' | '\n')* ('\r'? '\n')+ {$channel = HIDDEN;} ;
STRING_LITERAL : '\'' .* '\'' ;