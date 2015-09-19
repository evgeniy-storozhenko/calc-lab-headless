grammar CalcLab;

options {
	k=2;
	language=Java;
}

@header{
	package com.calclab.core.parser.internal;
	
	import java.lang.StringBuilder;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	
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
	private Map<String, Calculable> variables = new HashMap<String, Calculable>();
	
	public List<Calculable> getCalculations() {
		return calculations;
	}
	
	public Map<String, Calculable> getVariables() {
		return variables;
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
	: ({ String variable = null; StringBuilder in = new StringBuilder();} 
		(NAME EQUALS { 
				variable = $NAME.text.trim();
				in.append($NAME.text);
				in.append($EQUALS.text);
			})?
		e=expression {
		 	in.append($e.text);
		 	Calculable calculable = calcFactory.createCalculation($e.value, in.toString());
		 	calculations.add(calculable);
		 	if (variable != null) {
		 		variables.put(variable, calculable);
		 	}
		 }
		EXPRESSIONS_SEPARATOR
		)+
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
	: (number { $value = operandFactory.createNumber($number.text.trim()); } 
		| compositeExpression { $value = $compositeExpression.value; }
		| help { $value = $help.value; } 
		| functionOrVariable { $value = $functionOrVariable.value; }
		| matrix { $value = $matrix.value; }
	) (u=unaryOperation { $value = operandFactory.createUnaryOperand($value, $u.value); } )?
;

number
	: MINUS? S* DIGIT (DECIMAL_SEPARATOR DIGIT)? (('e' | 'E') (MINUS | PLUS) DIGIT)? S*
;

compositeExpression returns[Operand value] 
	: { Operation operation = null; } 
		(MINUS { operation = operationFactory.createCommonOperation($MINUS.text); })?  
		OPENING_PARENTHESIS expression CLOSING_PARENTHESIS 
		{ if (operation == null) $value = $expression.value;
		  else $value = operandFactory.createUnaryOperand(operation, $expression.value); }
;

functionOrVariable returns[Operand value]
	: { Operation operation = null; boolean isVariable = true; }
		(MINUS { operation = operationFactory.createCommonOperation($MINUS.text); })?
		name=NAME (OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS {isVariable = false;})?
		{
			if (isVariable) {
				Calculable variable = variables.get($name.text.trim());
				if (variable != null) {
					$value = operandFactory.createVariableOperand($name.text.trim(), variable);
				} else {
					String msg = "The variable '"+ $name.text.trim() +"' is not defined.";
					throw new SyntaxErrorException($name.line, $name.getCharPositionInLine(), msg);
				}
				if (operation != null) {
					$value = operandFactory.createUnaryOperand(operation, $value);
				}
			} else {
				$value = operandFactory.createFunctionOperand($NAME.text.trim(), $arguments.value);
			 	if (operation != null) {
			 		$value = operandFactory.createUnaryOperand(operation, $value);
			 	}
			}
		}
;

arguments returns[ArrayList<Operand> value]
	: { $value = new ArrayList<Operand>(); }
		e1=expression { $value.add($e1.value); } (' ' | '\n' |'\r' | '\t')* // conflict with S
			(ARGUMENTS_SEPARATOR (' ' | '\n' |'\r' | '\t')* e2=expression (' ' | '\n' |'\r' | '\t')* { $value.add($e2.value); })*
;


matrix returns[Operand value]
	: { Operation operation = null; } 
		(MINUS { operation = operationFactory.createCommonOperation($MINUS.text); })?  
		OPENING_SQ_PARENTHESIS matrixRows CLOSING_SQ_PARENTHESIS
		{ if (operation == null) $value = $matrixRows.value;
		  else $value = operandFactory.createUnaryOperand(operation, $matrixRows.value); }
;

matrixRows returns[Operand value]
	: { ArrayList<Operand[]> argsList = new ArrayList<Operand[]>(); }
		a1=matrixColumns {argsList.add(a1.toArray(new Operand[1]));} 
			(EXPRESSIONS_SEPARATOR a2=matrixColumns { argsList.add(a2.toArray(new Operand[1])); })*
	{ $value = operandFactory.createMatrix(argsList.toArray(new Operand[1][])); }
;

matrixColumns returns[ArrayList<Operand> value]
	: { $value = new ArrayList<Operand>(); }
		e1=expression { $value.add($e1.value); } 
			((' ' | ARGUMENTS_SEPARATOR) e2=expression { $value.add($e2.value); })*
;

help returns[Operand value] 
	: { List<Operand> arguments = new ArrayList<Operand>(); }
		HELP (NAME { 
			Operand arg = operandFactory.createStringOperand($NAME.text.trim());
			arguments.add(arg);
		})? 
		{ $value = operandFactory.createFunctionOperand($HELP.text.trim(), arguments); }
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
		{value = operationFactory.createCommonOperation($MINUS.text);}
	| REMAINDER
		{value = operationFactory.createCommonOperation($REMAINDER.text);};

// Simple operations
PLUS 	:	S* '+' S*;
MINUS	:	S* '-' S*;
MULTIPLY :	S* '*' S*;
DIVISION :	S* '/' S*;
EQUALS	:	S* '=' S*;
REMAINDER	:	S* '%' S*;

// Difficult operations
INVOLUTION : S* '^' S*;
FACTORIAL : S* '!' S*;

// Operators
HELP: 'help' S* ;

// System
DIGIT : '0'..'9'+;
NAME : S* ID (ID |DIGIT)* S*;
fragment ID : ('a'..'z' | 'A'..'Z' | '_');
fragment CHAR : 'A'..'z';
OPENING_PARENTHESIS : S* '(' S*;
CLOSING_PARENTHESIS : S* ')' S*;
OPENING_SQ_PARENTHESIS : S* '[' S*;
CLOSING_SQ_PARENTHESIS : S* ']' S*;
DECIMAL_SEPARATOR : '.';
ARGUMENTS_SEPARATOR : ',';
EXPRESSIONS_SEPARATOR : S* ';' S* ;
S: (' ' | '\n' |'\r' | '\t')+ {$channel=HIDDEN;};