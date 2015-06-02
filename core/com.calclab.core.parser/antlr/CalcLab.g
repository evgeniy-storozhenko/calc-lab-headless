grammar CalcLab;

options {
	k=2;
	language=Java;
}

@header{
	package com.calclab.core.parser.internal;
	
	import java.util.List;
	import java.util.ArrayList;
	
	import com.calclab.core.parser.extensions.SyntaxErrorException;
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
	private CommonOperandFactory operandFactory = CommonOperandFactory.getInstance();
	private CommonOperationFactory operationFactory = new CommonOperationFactory();
	private CalculationFactory calcFactory = new CalculationFactory();
	private List<Calculable> calculations = new ArrayList<Calculable>();
	
	public List<Calculable> getCalculations() {
		return calculations;
	}
	
	public void displayRecognitionError(String[] tokenNames,
        RecognitionException e) {
              if (e.token.getType() == Token.EOF) {
                Token prev = getTokenStream().get(e.index - 1);
                throw new SyntaxErrorException(prev.getLine(),
                    prev.getCharPositionInLine());
              }
        throw new SyntaxErrorException(e.line, e.charPositionInLine);
    }
}


calculation
	: (e=expression { calculations.add(calcFactory.createCalculation($e.value, $e.text)); }
		EXPRESSIONS_SEPARATOR)+
;

expression returns[Operand value]
	: (c1=complexCompositeUnit { $value = $c1.value; }) 
		(o=binaryOperationLow c2=complexCompositeUnit
			{ $value = operandFactory.createCompositeOperand($value, $o.value, $c2.value); }
		)*
;

complexCompositeUnit returns[Operand value]
	: c1=compositeUnit { $value = $c1.value; } 
		(o=binaryOperationMiddle c2=compositeUnit
			{ $value = operandFactory.createCompositeOperand($value, $o.value, $c2.value); }
		)*
;

compositeUnit returns[Operand value]
	: unit1=unit { $value=$unit1.value; } 
		(binaryOperationHigh unit2=unit 
			{ $value = operandFactory.createCompositeOperand($value, 
				$binaryOperationHigh.value, $unit2.value);
			} 
		)*
;

unit returns[Operand value]
	: (number { $value = operandFactory.createNumber($number.text); } 
		| compositeExpression { $value = $compositeExpression.value; } 
		| function { $value = $function.value; }
	) (u=unaryOperation { $value = operandFactory.createUnaryOperand($value, $u.value); } )? 
;

number
	: MINUS? DIGIT (DECIMAL_SEPARATOR DIGIT)*
;

compositeExpression returns[Operand value] 
	: { Operation operation = null; } 
		(MINUS { operation = operationFactory.createCommonOperation($MINUS.text); })?  
		OPENING_PARENTHESIS expression CLOSING_PARENTHESIS 
		{ if (operation == null) $value = $expression.value;
		  else $value = operandFactory.createUnaryOperand(operation, $expression.value); }
;

function returns[Operand value] 
	: { Operation operation = null; }  
		(MINUS { operation = operationFactory.createCommonOperation($MINUS.text); })?
		NAME OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS 
		{ $value = operandFactory.createFunctionOperand($NAME.text, $arguments.value);
			if (operation != null) 
				$value = operandFactory.createUnaryOperand(operation, $value); }
;

arguments returns[ArrayList<Operand> value]
	: { $value = new ArrayList<Operand>(); }
		e1=expression { $value.add($e1.value); } 
			(ARGUMENTS_SEPARATOR e2=expression { $value.add($e2.value); })*
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

