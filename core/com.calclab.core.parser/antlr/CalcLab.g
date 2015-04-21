grammar CalcLab;

options {
	k=2;
	language=Java;
}

@header{
	package com.calclab.core.parser.internal;
	
	import java.util.List;
	import java.util.ArrayList;
	
	import com.calclab.operations.common.CommonOperationFactory;
	import com.calclab.operands.common.CommonOperandFactory;
	import com.calclab.core.calculations.CalculationFactory;
	import com.calclab.core.calculations.Calculable;
	import com.calclab.core.operations.Operation;
	import com.calclab.core.operands.Operand;
	
}

@lexer::header {
	package com.calclab.core.parser.internal;
}

@members{
	private CommonOperationFactory operationFactory = new CommonOperationFactory();
	private CommonOperandFactory operandFactory = new CommonOperandFactory();
	private CalculationFactory calcFactory = new CalculationFactory();
	private List<Calculable> calculations = new ArrayList<Calculable>();
}


calculation
	: (expression EXPRESSIONS_SEPARATOR { calculations.add(calcFactory.createCalculation()); } )+
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

unit returns[Operand value]
	: (number1=number { $value=operandFactory.createNumber($number1.text); } 
		| compositeExpression { $value=null; } 
		| function { $value=null; }
	) unaryOperation? 
;

number
	: MINUS? DIGIT (DECIMAL_SEPARATOR DIGIT)*
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
binaryOperationHigh returns[Operation value]: MULTIPLY 
		{value = operationFactory.createCommonOperation($MULTIPLY.text);} 
	| DIVISION 
		{value = operationFactory.createCommonOperation($DIVISION.text);}
;
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
NAME : ID (ID |DIGIT)*; 
fragment ID : ('a'..'z' | 'A'..'Z' | '_');
fragment CHAR : 'A'..'z';
OPENING_PARENTHESIS : '(';
CLOSING_PARENTHESIS : ')';
NEWLINE : '\r'? '\n' {$channel=HIDDEN;};
DECIMAL_SEPARATOR : '.';
ARGUMENTS_SEPARATOR : ',';
EXPRESSIONS_SEPARATOR : NEWLINE* ';' NEWLINE* ;
WS: (' ' |'\n' |'\r' )+ {$channel=HIDDEN;};

