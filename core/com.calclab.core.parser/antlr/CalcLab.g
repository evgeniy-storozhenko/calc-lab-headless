grammar CalcLab;

calculation
	: (expression EXPRESSIONS_SEPARATOR)+
;

expression
	: (complexCompositeUnit) (binaryOperationLow complexCompositeUnit)*
;

complexCompositeUnit
	: compositeUnit (binaryOperationMiddle compositeUnit)*
;

compositeUnit
	: unit (binaryOperationHigh unit)*
;

unit
	: (number | compositeExpression | function) unaryOperation?
;

number 
	: MINUS? DIGIT+ (DECIMAL_SEPARATOR DIGIT+)*
;

compositeExpression
	: MINUS? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS
;

function
	: MINUS? NAME OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS
;

arguments
	: expression (ARGUMENTS_SEPARATOR expression)*
;

// Composite operations
unaryOperation: FACTORIAL;
binaryOperationHigh : MULTIPLY | DIVISION;
binaryOperationMiddle : INVOLUTION;
binaryOperationLow : PLUS | MINUS;

// Simple operations
PLUS 	:	'+';
MINUS	:	'-';
MULTIPLY :	'*';
DIVISION :	'/';

// Difficult operations
INVOLUTION : '^';
FACTORIAL : '!';

// System
DIGIT : '0'..'9'+;
NAME : ('A'..'z') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')* ;
OPENING_PARENTHESIS : '(';
CLOSING_PARENTHESIS : ')';
NEWLINE : '\r'? '\n' {$channel=HIDDEN;};
DECIMAL_SEPARATOR : '.';
ARGUMENTS_SEPARATOR : ',';
EXPRESSIONS_SEPARATOR : NEWLINE* ';' NEWLINE* ;
WS: (' ' |'\n' |'\r' )+ {$channel=HIDDEN;};

