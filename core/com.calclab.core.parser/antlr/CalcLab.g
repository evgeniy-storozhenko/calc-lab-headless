grammar CalcLab;

calculation: (expression EXPRESSIONS_SEPARATOR)+ ;


expression
	: (complexCompositeUnit) (binaryOperationLow complexCompositeUnit)*
;

compositeExpression
	: MINUS? '(' expression ')'
;

complexCompositeUnit
	: compositeUnit (binaryOperationMiddle compositeUnit)*
;

compositeUnit
	: unit (binaryOperationHigh unit)*
;

unit
	: (number | compositeExpression) unaryOperation?
;

number 
	: MINUS? DIGIT (DECIMAL_SEPARATOR DIGIT)*
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
VAR : 'A'..'z';
NEWLINE : '\r'? '\n' {$channel=HIDDEN;};
DECIMAL_SEPARATOR : '.';
EXPRESSIONS_SEPARATOR : NEWLINE* ';' NEWLINE* ;
WS: (' ' |'\n' |'\r' )+ {$channel=HIDDEN;}; 

