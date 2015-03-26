grammar CalcLab;

calculation: statement+ ;

statement
	: number EXPRESSIONS_SEPARATOR
;

number 
	: DIGIT (DECIMAL_SEPARATOR DIGIT)*
;


// Simple operations
PLUS 	:	'+';
MINUS	:	'-';
MULTIPLY :	'*';
DIVISION :	'/';

// System
DIGIT : '0'..'9'+;
VAR : 'A'..'z';
NEWLINE : '\r'? '\n';
DECIMAL_SEPARATOR : '.';
EXPRESSIONS_SEPARATOR : NEWLINE* ';' NEWLINE*;
WS: (' ' |'\n' |'\r' )+ {$channel=HIDDEN;} ; 











