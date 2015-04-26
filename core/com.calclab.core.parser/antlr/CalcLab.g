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
	
	public List<Calculable> getCalculations() {
		return calculations;
	}
}


calculation
	: (e=expression { calculations.add(calcFactory.createCalculation($e.value)); }
		EXPRESSIONS_SEPARATOR)+
;

expression returns[Operand value]
	: (c1=complexCompositeUnit { $value = $c1.value; }) 
		(o=binaryOperationLow c2=complexCompositeUnit
			{ $value = operandFactory.createCompositOperand($value, $o.value, $c2.value); }
		)*
;

complexCompositeUnit returns[Operand value]
	: c1=compositeUnit { $value = $c1.value; } 
		(o=binaryOperationMiddle c2=compositeUnit
			{ $value = operandFactory.createCompositOperand($value, $o.value, $c2.value); }
		)*
;

compositeUnit returns[Operand value]
	: unit1=unit { $value=$unit1.value; } 
		(binaryOperationHigh unit2=unit 
			{ $value = operandFactory.createCompositOperand($value, 
				$binaryOperationHigh.value, $unit2.value);
			} 
		)*
;

unit returns[Operand value]
	: (number { $value=operandFactory.createNumber($number.text); } 
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
unaryOperation returns[Operation value]: FACTORIAL
		{value = operationFactory.createCommonOperation($FACTORIAL.text);};
binaryOperationHigh returns[Operation value]: MULTIPLY 
		{value = operationFactory.createCommonOperation($MULTIPLY.text);} 
	| DIVISION 
		{value = operationFactory.createCommonOperation($DIVISION.text);}
;
binaryOperationMiddle returns[Operation value]: INVOLUTION
		{value = operationFactory.createCommonOperation($INVOLUTION.text);};
binaryOperationLow returns[Operation value]: PLUS 
		{value = operationFactory.createCommonOperation($PLUS.text);}
	| MINUS
		{value = operationFactory.createCommonOperation($MINUS.text);};

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

