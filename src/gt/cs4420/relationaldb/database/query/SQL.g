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
//	|	update
	;
	
select
	:	'select'^ columns 'from'^ table (whereClause)? (orderByClause)? ';'!
	;
	
columns
	:	column (','! column)*
	;
	
column
	:	IDENT
	;
	
	
table
	/*@init 
		{
			ArrayList<String> tables = new ArrayList<String>();
			tables.add("rock");
			tables.add("paper");
			tables.add("scissors");
		}*/
	:	IDENT //{validateTableExists($IDENT.text.toString())}?
	;
	
whereClause
	:	'where' searchCondition
	;
	
orderByClause
	:	IDENT (',' IDENT)*
	;
	
searchCondition
	:
	;
	
comparisonOperator
	:	'='
	|	'!='
	|	'<='
	|	'<'
	|	'>='
	|	'>'
	;
	
logicalOperator
	:	'and'
	|	'or'
	;
	
insert
	:	'insert'^ 'into' table 'values'^ '('! values ')'! ';'!
	;
	
value
	:	STRING_LITERAL
	| 	INTEGER
	;
	
values
	:	value (','! value)*
	;



fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : ('0'..'9') ;
IDENT : LETTER (LETTER | DIGIT)* ;
WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;} ;
INTEGER : DIGIT+;
COMMENT : '--' .* ('\n' | '\r') {$channel = HIDDEN;} ;
STRING_LITERAL : '\'' .* '\'' ;

