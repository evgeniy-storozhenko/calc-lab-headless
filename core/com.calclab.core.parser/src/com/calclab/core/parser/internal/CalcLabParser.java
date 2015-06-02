// $ANTLR 3.5.2 CalcLab.g 2015-06-02 11:26:32

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

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CalcLabParser extends Parser {
	public static final String[] tokenNames = new String[] {
			"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARGUMENTS_SEPARATOR", "CHAR",
			"CLOSING_PARENTHESIS", "DECIMAL_SEPARATOR", "DIGIT", "DIVISION", "EXPRESSIONS_SEPARATOR",
			"FACTORIAL", "ID", "INVOLUTION", "MINUS", "MULTIPLY", "NAME", "NEWLINE",
			"OPENING_PARENTHESIS", "PLUS", "WS"
	};
	public static final int EOF = -1;
	public static final int ARGUMENTS_SEPARATOR = 4;
	public static final int CHAR = 5;
	public static final int CLOSING_PARENTHESIS = 6;
	public static final int DECIMAL_SEPARATOR = 7;
	public static final int DIGIT = 8;
	public static final int DIVISION = 9;
	public static final int EXPRESSIONS_SEPARATOR = 10;
	public static final int FACTORIAL = 11;
	public static final int ID = 12;
	public static final int INVOLUTION = 13;
	public static final int MINUS = 14;
	public static final int MULTIPLY = 15;
	public static final int NAME = 16;
	public static final int NEWLINE = 17;
	public static final int OPENING_PARENTHESIS = 18;
	public static final int PLUS = 19;
	public static final int WS = 20;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators

	public CalcLabParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public CalcLabParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override
	public String[] getTokenNames() {
		return CalcLabParser.tokenNames;
	}

	@Override
	public String getGrammarFileName() {
		return "CalcLab.g";
	}

	private CommonOperandFactory operandFactory = CommonOperandFactory.getInstance();
	private CommonOperationFactory operationFactory = new CommonOperationFactory();
	private CalculationFactory calcFactory = new CalculationFactory();
	private List<Calculable> calculations = new ArrayList<Calculable>();

	public List<Calculable> getCalculations() {
		return calculations;
	}

	@Override
	public void displayRecognitionError(String[] tokenNames,
			RecognitionException e) {
		if (e.token.getType() == Token.EOF) {
			Token prev = getTokenStream().get(e.index - 1);
			throw new SyntaxErrorException(prev.getLine(),
					prev.getCharPositionInLine());
		}
		throw new SyntaxErrorException(e.line, e.charPositionInLine);
	}

	// $ANTLR start "calculation"
	// CalcLab.g:50:1: calculation : (e= expression EXPRESSIONS_SEPARATOR )+ ;
	public final void calculation() throws RecognitionException {
		ParserRuleReturnScope e = null;

		try {
			// CalcLab.g:51:2: ( (e= expression EXPRESSIONS_SEPARATOR )+ )
			// CalcLab.g:51:4: (e= expression EXPRESSIONS_SEPARATOR )+
			{
				// CalcLab.g:51:4: (e= expression EXPRESSIONS_SEPARATOR )+
				int cnt1 = 0;
				loop1: while (true) {
					int alt1 = 2;
					int LA1_0 = input.LA(1);
					if ((LA1_0 == DIGIT || LA1_0 == MINUS || LA1_0 == NAME || LA1_0 == OPENING_PARENTHESIS)) {
						alt1 = 1;
					}

					switch (alt1) {
					case 1:
					// CalcLab.g:51:5: e= expression EXPRESSIONS_SEPARATOR
					{
						pushFollow(FOLLOW_expression_in_calculation51);
						e = expression();
						state._fsp--;

						calculations.add(calcFactory.createCalculation(
								(e != null ? ((CalcLabParser.expression_return) e).value : null),
								(e != null ? input.toString(e.start, e.stop) : null)));
						match(input, EXPRESSIONS_SEPARATOR, FOLLOW_EXPRESSIONS_SEPARATOR_in_calculation57);
					}
						break;

					default:
						if (cnt1 >= 1)
							break loop1;
						EarlyExitException eee = new EarlyExitException(1, input);
						throw eee;
					}
					cnt1++;
				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
	}

	// $ANTLR end "calculation"

	public static class expression_return extends ParserRuleReturnScope {
		public Operand value;
	};

	// $ANTLR start "expression"
	// CalcLab.g:55:1: expression returns [Operand value] : (c1= complexCompositeUnit ) (o= binaryOperationLow c2=
	// complexCompositeUnit )* ;
	public final CalcLabParser.expression_return expression() throws RecognitionException {
		CalcLabParser.expression_return retval = new CalcLabParser.expression_return();
		retval.start = input.LT(1);

		Operand c1 = null;
		Operation o = null;
		Operand c2 = null;

		try {
			// CalcLab.g:56:2: ( (c1= complexCompositeUnit ) (o= binaryOperationLow c2= complexCompositeUnit )* )
			// CalcLab.g:56:4: (c1= complexCompositeUnit ) (o= binaryOperationLow c2= complexCompositeUnit )*
			{
				// CalcLab.g:56:4: (c1= complexCompositeUnit )
				// CalcLab.g:56:5: c1= complexCompositeUnit
				{
					pushFollow(FOLLOW_complexCompositeUnit_in_expression75);
					c1 = complexCompositeUnit();
					state._fsp--;

					retval.value = c1;
				}

				// CalcLab.g:57:3: (o= binaryOperationLow c2= complexCompositeUnit )*
				loop2: while (true) {
					int alt2 = 2;
					int LA2_0 = input.LA(1);
					if ((LA2_0 == MINUS || LA2_0 == PLUS)) {
						alt2 = 1;
					}

					switch (alt2) {
					case 1:
					// CalcLab.g:57:4: o= binaryOperationLow c2= complexCompositeUnit
					{
						pushFollow(FOLLOW_binaryOperationLow_in_expression86);
						o = binaryOperationLow();
						state._fsp--;

						pushFollow(FOLLOW_complexCompositeUnit_in_expression90);
						c2 = complexCompositeUnit();
						state._fsp--;

						retval.value = operandFactory.createCompositeOperand(retval.value, o, c2);
					}
						break;

					default:
						break loop2;
					}
				}

			}

			retval.stop = input.LT(-1);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "expression"

	// $ANTLR start "complexCompositeUnit"
	// CalcLab.g:62:1: complexCompositeUnit returns [Operand value] : c1= compositeUnit (o= binaryOperationMiddle c2=
	// compositeUnit )* ;
	public final Operand complexCompositeUnit() throws RecognitionException {
		Operand value = null;

		Operand c1 = null;
		Operation o = null;
		Operand c2 = null;

		try {
			// CalcLab.g:63:2: (c1= compositeUnit (o= binaryOperationMiddle c2= compositeUnit )* )
			// CalcLab.g:63:4: c1= compositeUnit (o= binaryOperationMiddle c2= compositeUnit )*
			{
				pushFollow(FOLLOW_compositeUnit_in_complexCompositeUnit115);
				c1 = compositeUnit();
				state._fsp--;

				value = c1;
				// CalcLab.g:64:3: (o= binaryOperationMiddle c2= compositeUnit )*
				loop3: while (true) {
					int alt3 = 2;
					int LA3_0 = input.LA(1);
					if ((LA3_0 == INVOLUTION)) {
						alt3 = 1;
					}

					switch (alt3) {
					case 1:
					// CalcLab.g:64:4: o= binaryOperationMiddle c2= compositeUnit
					{
						pushFollow(FOLLOW_binaryOperationMiddle_in_complexCompositeUnit125);
						o = binaryOperationMiddle();
						state._fsp--;

						pushFollow(FOLLOW_compositeUnit_in_complexCompositeUnit129);
						c2 = compositeUnit();
						state._fsp--;

						value = operandFactory.createCompositeOperand(value, o, c2);
					}
						break;

					default:
						break loop3;
					}
				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "complexCompositeUnit"

	// $ANTLR start "compositeUnit"
	// CalcLab.g:69:1: compositeUnit returns [Operand value] : unit1= unit ( binaryOperationHigh unit2= unit )* ;
	public final Operand compositeUnit() throws RecognitionException {
		Operand value = null;

		Operand unit1 = null;
		Operand unit2 = null;
		Operation binaryOperationHigh1 = null;

		try {
			// CalcLab.g:70:2: (unit1= unit ( binaryOperationHigh unit2= unit )* )
			// CalcLab.g:70:4: unit1= unit ( binaryOperationHigh unit2= unit )*
			{
				pushFollow(FOLLOW_unit_in_compositeUnit154);
				unit1 = unit();
				state._fsp--;

				value = unit1;
				// CalcLab.g:71:3: ( binaryOperationHigh unit2= unit )*
				loop4: while (true) {
					int alt4 = 2;
					int LA4_0 = input.LA(1);
					if ((LA4_0 == DIVISION || LA4_0 == MULTIPLY)) {
						alt4 = 1;
					}

					switch (alt4) {
					case 1:
					// CalcLab.g:71:4: binaryOperationHigh unit2= unit
					{
						pushFollow(FOLLOW_binaryOperationHigh_in_compositeUnit162);
						binaryOperationHigh1 = binaryOperationHigh();
						state._fsp--;

						pushFollow(FOLLOW_unit_in_compositeUnit166);
						unit2 = unit();
						state._fsp--;

						value = operandFactory.createCompositeOperand(value,
								binaryOperationHigh1, unit2);

					}
						break;

					default:
						break loop4;
					}
				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "compositeUnit"

	// $ANTLR start "unit"
	// CalcLab.g:78:1: unit returns [Operand value] : ( number | compositeExpression | function ) (u= unaryOperation )?
	// ;
	public final Operand unit() throws RecognitionException {
		Operand value = null;

		Operation u = null;
		ParserRuleReturnScope number2 = null;
		Operand compositeExpression3 = null;
		Operand function4 = null;

		try {
			// CalcLab.g:79:2: ( ( number | compositeExpression | function ) (u= unaryOperation )? )
			// CalcLab.g:79:4: ( number | compositeExpression | function ) (u= unaryOperation )?
			{
				// CalcLab.g:79:4: ( number | compositeExpression | function )
				int alt5 = 3;
				switch (input.LA(1)) {
				case MINUS: {
					switch (input.LA(2)) {
					case DIGIT: {
						alt5 = 1;
					}
						break;
					case OPENING_PARENTHESIS: {
						alt5 = 2;
					}
						break;
					case NAME: {
						alt5 = 3;
					}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							input.consume();
							NoViableAltException nvae =
									new NoViableAltException("", 5, 1, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}
					break;
				case DIGIT: {
					alt5 = 1;
				}
					break;
				case OPENING_PARENTHESIS: {
					alt5 = 2;
				}
					break;
				case NAME: {
					alt5 = 3;
				}
					break;
				default:
					NoViableAltException nvae =
							new NoViableAltException("", 5, 0, input);
					throw nvae;
				}
				switch (alt5) {
				case 1:
				// CalcLab.g:79:5: number
				{
					pushFollow(FOLLOW_number_in_unit192);
					number2 = number();
					state._fsp--;

					value = operandFactory.createNumber((number2 != null ? input.toString(number2.start, number2.stop)
							: null));
				}
					break;
				case 2:
				// CalcLab.g:80:5: compositeExpression
				{
					pushFollow(FOLLOW_compositeExpression_in_unit201);
					compositeExpression3 = compositeExpression();
					state._fsp--;

					value = compositeExpression3;
				}
					break;
				case 3:
				// CalcLab.g:81:5: function
				{
					pushFollow(FOLLOW_function_in_unit210);
					function4 = function();
					state._fsp--;

					value = function4;
				}
					break;

				}

				// CalcLab.g:82:4: (u= unaryOperation )?
				int alt6 = 2;
				int LA6_0 = input.LA(1);
				if ((LA6_0 == FACTORIAL)) {
					alt6 = 1;
				}
				switch (alt6) {
				case 1:
				// CalcLab.g:82:5: u= unaryOperation
				{
					pushFollow(FOLLOW_unaryOperation_in_unit220);
					u = unaryOperation();
					state._fsp--;

					value = operandFactory.createUnaryOperand(value, u);
				}
					break;

				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "unit"

	public static class number_return extends ParserRuleReturnScope {
	};

	// $ANTLR start "number"
	// CalcLab.g:85:1: number : ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )* ;
	public final CalcLabParser.number_return number() throws RecognitionException {
		CalcLabParser.number_return retval = new CalcLabParser.number_return();
		retval.start = input.LT(1);

		try {
			// CalcLab.g:86:2: ( ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )* )
			// CalcLab.g:86:4: ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )*
			{
				// CalcLab.g:86:4: ( MINUS )?
				int alt7 = 2;
				int LA7_0 = input.LA(1);
				if ((LA7_0 == MINUS)) {
					alt7 = 1;
				}
				switch (alt7) {
				case 1:
				// CalcLab.g:86:4: MINUS
				{
					match(input, MINUS, FOLLOW_MINUS_in_number236);
				}
					break;

				}

				match(input, DIGIT, FOLLOW_DIGIT_in_number239);
				// CalcLab.g:86:17: ( DECIMAL_SEPARATOR DIGIT )*
				loop8: while (true) {
					int alt8 = 2;
					int LA8_0 = input.LA(1);
					if ((LA8_0 == DECIMAL_SEPARATOR)) {
						alt8 = 1;
					}

					switch (alt8) {
					case 1:
					// CalcLab.g:86:18: DECIMAL_SEPARATOR DIGIT
					{
						match(input, DECIMAL_SEPARATOR, FOLLOW_DECIMAL_SEPARATOR_in_number242);
						match(input, DIGIT, FOLLOW_DIGIT_in_number244);
					}
						break;

					default:
						break loop8;
					}
				}

			}

			retval.stop = input.LT(-1);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}

	// $ANTLR end "number"

	// $ANTLR start "compositeExpression"
	// CalcLab.g:89:1: compositeExpression returns [Operand value] : ( MINUS )? OPENING_PARENTHESIS expression
	// CLOSING_PARENTHESIS ;
	public final Operand compositeExpression() throws RecognitionException {
		Operand value = null;

		Token MINUS5 = null;
		ParserRuleReturnScope expression6 = null;

		try {
			// CalcLab.g:90:2: ( ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS )
			// CalcLab.g:90:4: ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS
			{
				Operation operation = null;
				// CalcLab.g:91:3: ( MINUS )?
				int alt9 = 2;
				int LA9_0 = input.LA(1);
				if ((LA9_0 == MINUS)) {
					alt9 = 1;
				}
				switch (alt9) {
				case 1:
				// CalcLab.g:91:4: MINUS
				{
					MINUS5 = (Token) match(input, MINUS, FOLLOW_MINUS_in_compositeExpression266);
					operation = operationFactory.createCommonOperation((MINUS5 != null ? MINUS5.getText() : null));
				}
					break;

				}

				match(input, OPENING_PARENTHESIS, FOLLOW_OPENING_PARENTHESIS_in_compositeExpression276);
				pushFollow(FOLLOW_expression_in_compositeExpression278);
				expression6 = expression();
				state._fsp--;

				match(input, CLOSING_PARENTHESIS, FOLLOW_CLOSING_PARENTHESIS_in_compositeExpression280);
				if (operation == null)
					value = (expression6 != null ? ((CalcLabParser.expression_return) expression6).value : null);
				else
					value = operandFactory.createUnaryOperand(operation,
							(expression6 != null ? ((CalcLabParser.expression_return) expression6).value : null));
			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "compositeExpression"

	// $ANTLR start "function"
	// CalcLab.g:97:1: function returns [Operand value] : ( MINUS )? NAME OPENING_PARENTHESIS arguments
	// CLOSING_PARENTHESIS ;
	public final Operand function() throws RecognitionException {
		Operand value = null;

		Token MINUS7 = null;
		Token NAME8 = null;
		ArrayList<Operand> arguments9 = null;

		try {
			// CalcLab.g:98:2: ( ( MINUS )? NAME OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS )
			// CalcLab.g:98:4: ( MINUS )? NAME OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS
			{
				Operation operation = null;
				// CalcLab.g:99:3: ( MINUS )?
				int alt10 = 2;
				int LA10_0 = input.LA(1);
				if ((LA10_0 == MINUS)) {
					alt10 = 1;
				}
				switch (alt10) {
				case 1:
				// CalcLab.g:99:4: MINUS
				{
					MINUS7 = (Token) match(input, MINUS, FOLLOW_MINUS_in_function306);
					operation = operationFactory.createCommonOperation((MINUS7 != null ? MINUS7.getText() : null));
				}
					break;

				}

				NAME8 = (Token) match(input, NAME, FOLLOW_NAME_in_function314);
				match(input, OPENING_PARENTHESIS, FOLLOW_OPENING_PARENTHESIS_in_function316);
				pushFollow(FOLLOW_arguments_in_function318);
				arguments9 = arguments();
				state._fsp--;

				match(input, CLOSING_PARENTHESIS, FOLLOW_CLOSING_PARENTHESIS_in_function320);
				value = operandFactory.createFunctionOperand((NAME8 != null ? NAME8.getText() : null), arguments9);
				if (operation != null)
					value = operandFactory.createUnaryOperand(operation, value);
			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "function"

	// $ANTLR start "arguments"
	// CalcLab.g:106:1: arguments returns [ArrayList<Operand> value] :e1= expression ( ARGUMENTS_SEPARATOR e2=
	// expression )* ;
	public final ArrayList<Operand> arguments() throws RecognitionException {
		ArrayList<Operand> value = null;

		ParserRuleReturnScope e1 = null;
		ParserRuleReturnScope e2 = null;

		try {
			// CalcLab.g:107:2: (e1= expression ( ARGUMENTS_SEPARATOR e2= expression )* )
			// CalcLab.g:107:4: e1= expression ( ARGUMENTS_SEPARATOR e2= expression )*
			{
				value = new ArrayList<Operand>();
				pushFollow(FOLLOW_expression_in_arguments344);
				e1 = expression();
				state._fsp--;

				value.add((e1 != null ? ((CalcLabParser.expression_return) e1).value : null));
				// CalcLab.g:109:4: ( ARGUMENTS_SEPARATOR e2= expression )*
				loop11: while (true) {
					int alt11 = 2;
					int LA11_0 = input.LA(1);
					if ((LA11_0 == ARGUMENTS_SEPARATOR)) {
						alt11 = 1;
					}

					switch (alt11) {
					case 1:
					// CalcLab.g:109:5: ARGUMENTS_SEPARATOR e2= expression
					{
						match(input, ARGUMENTS_SEPARATOR, FOLLOW_ARGUMENTS_SEPARATOR_in_arguments353);
						pushFollow(FOLLOW_expression_in_arguments357);
						e2 = expression();
						state._fsp--;

						value.add((e2 != null ? ((CalcLabParser.expression_return) e2).value : null));
					}
						break;

					default:
						break loop11;
					}
				}

			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "arguments"

	// $ANTLR start "unaryOperation"
	// CalcLab.g:113:1: unaryOperation returns [Operation value] : FACTORIAL ;
	public final Operation unaryOperation() throws RecognitionException {
		Operation value = null;

		Token FACTORIAL10 = null;

		try {
			// CalcLab.g:113:40: ( FACTORIAL )
			// CalcLab.g:113:42: FACTORIAL
			{
				FACTORIAL10 = (Token) match(input, FACTORIAL, FOLLOW_FACTORIAL_in_unaryOperation373);
				value = operationFactory.createCommonOperation((FACTORIAL10 != null ? FACTORIAL10.getText() : null));
			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "unaryOperation"

	// $ANTLR start "binaryOperationHigh"
	// CalcLab.g:115:1: binaryOperationHigh returns [Operation value] : ( MULTIPLY | DIVISION );
	public final Operation binaryOperationHigh() throws RecognitionException {
		Operation value = null;

		Token MULTIPLY11 = null;
		Token DIVISION12 = null;

		try {
			// CalcLab.g:115:45: ( MULTIPLY | DIVISION )
			int alt12 = 2;
			int LA12_0 = input.LA(1);
			if ((LA12_0 == MULTIPLY)) {
				alt12 = 1;
			}
			else if ((LA12_0 == DIVISION)) {
				alt12 = 2;
			}

			else {
				NoViableAltException nvae =
						new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
			case 1:
			// CalcLab.g:115:47: MULTIPLY
			{
				MULTIPLY11 = (Token) match(input, MULTIPLY, FOLLOW_MULTIPLY_in_binaryOperationHigh386);
				value = operationFactory.createCommonOperation((MULTIPLY11 != null ? MULTIPLY11.getText() : null));
			}
				break;
			case 2:
			// CalcLab.g:117:4: DIVISION
			{
				DIVISION12 = (Token) match(input, DIVISION, FOLLOW_DIVISION_in_binaryOperationHigh397);
				value = operationFactory.createCommonOperation((DIVISION12 != null ? DIVISION12.getText() : null));
			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "binaryOperationHigh"

	// $ANTLR start "binaryOperationMiddle"
	// CalcLab.g:120:1: binaryOperationMiddle returns [Operation value] : INVOLUTION ;
	public final Operation binaryOperationMiddle() throws RecognitionException {
		Operation value = null;

		Token INVOLUTION13 = null;

		try {
			// CalcLab.g:120:47: ( INVOLUTION )
			// CalcLab.g:120:49: INVOLUTION
			{
				INVOLUTION13 = (Token) match(input, INVOLUTION, FOLLOW_INVOLUTION_in_binaryOperationMiddle412);
				value = operationFactory.createCommonOperation((INVOLUTION13 != null ? INVOLUTION13.getText() : null));
			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "binaryOperationMiddle"

	// $ANTLR start "binaryOperationLow"
	// CalcLab.g:122:1: binaryOperationLow returns [Operation value] : ( PLUS | MINUS );
	public final Operation binaryOperationLow() throws RecognitionException {
		Operation value = null;

		Token PLUS14 = null;
		Token MINUS15 = null;

		try {
			// CalcLab.g:122:44: ( PLUS | MINUS )
			int alt13 = 2;
			int LA13_0 = input.LA(1);
			if ((LA13_0 == PLUS)) {
				alt13 = 1;
			}
			else if ((LA13_0 == MINUS)) {
				alt13 = 2;
			}

			else {
				NoViableAltException nvae =
						new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
			case 1:
			// CalcLab.g:122:46: PLUS
			{
				PLUS14 = (Token) match(input, PLUS, FOLLOW_PLUS_in_binaryOperationLow425);
				value = operationFactory.createCommonOperation((PLUS14 != null ? PLUS14.getText() : null));
			}
				break;
			case 2:
			// CalcLab.g:124:4: MINUS
			{
				MINUS15 = (Token) match(input, MINUS, FOLLOW_MINUS_in_binaryOperationLow435);
				value = operationFactory.createCommonOperation((MINUS15 != null ? MINUS15.getText() : null));
			}
				break;

			}
		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
		return value;
	}

	// $ANTLR end "binaryOperationLow"

	// Delegated rules

	public static final BitSet FOLLOW_expression_in_calculation51 = new BitSet(new long[] { 0x0000000000000400L });
	public static final BitSet FOLLOW_EXPRESSIONS_SEPARATOR_in_calculation57 = new BitSet(
			new long[] { 0x0000000000054102L });
	public static final BitSet FOLLOW_complexCompositeUnit_in_expression75 = new BitSet(
			new long[] { 0x0000000000084002L });
	public static final BitSet FOLLOW_binaryOperationLow_in_expression86 = new BitSet(
			new long[] { 0x0000000000054100L });
	public static final BitSet FOLLOW_complexCompositeUnit_in_expression90 = new BitSet(
			new long[] { 0x0000000000084002L });
	public static final BitSet FOLLOW_compositeUnit_in_complexCompositeUnit115 = new BitSet(
			new long[] { 0x0000000000002002L });
	public static final BitSet FOLLOW_binaryOperationMiddle_in_complexCompositeUnit125 = new BitSet(
			new long[] { 0x0000000000054100L });
	public static final BitSet FOLLOW_compositeUnit_in_complexCompositeUnit129 = new BitSet(
			new long[] { 0x0000000000002002L });
	public static final BitSet FOLLOW_unit_in_compositeUnit154 = new BitSet(new long[] { 0x0000000000008202L });
	public static final BitSet FOLLOW_binaryOperationHigh_in_compositeUnit162 = new BitSet(
			new long[] { 0x0000000000054100L });
	public static final BitSet FOLLOW_unit_in_compositeUnit166 = new BitSet(new long[] { 0x0000000000008202L });
	public static final BitSet FOLLOW_number_in_unit192 = new BitSet(new long[] { 0x0000000000000802L });
	public static final BitSet FOLLOW_compositeExpression_in_unit201 = new BitSet(new long[] { 0x0000000000000802L });
	public static final BitSet FOLLOW_function_in_unit210 = new BitSet(new long[] { 0x0000000000000802L });
	public static final BitSet FOLLOW_unaryOperation_in_unit220 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_number236 = new BitSet(new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_DIGIT_in_number239 = new BitSet(new long[] { 0x0000000000000082L });
	public static final BitSet FOLLOW_DECIMAL_SEPARATOR_in_number242 = new BitSet(new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_DIGIT_in_number244 = new BitSet(new long[] { 0x0000000000000082L });
	public static final BitSet FOLLOW_MINUS_in_compositeExpression266 = new BitSet(new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_compositeExpression276 = new BitSet(
			new long[] { 0x0000000000054100L });
	public static final BitSet FOLLOW_expression_in_compositeExpression278 = new BitSet(
			new long[] { 0x0000000000000040L });
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_compositeExpression280 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_function306 = new BitSet(new long[] { 0x0000000000010000L });
	public static final BitSet FOLLOW_NAME_in_function314 = new BitSet(new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_function316 = new BitSet(
			new long[] { 0x0000000000054100L });
	public static final BitSet FOLLOW_arguments_in_function318 = new BitSet(new long[] { 0x0000000000000040L });
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_function320 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expression_in_arguments344 = new BitSet(new long[] { 0x0000000000000012L });
	public static final BitSet FOLLOW_ARGUMENTS_SEPARATOR_in_arguments353 = new BitSet(
			new long[] { 0x0000000000054100L });
	public static final BitSet FOLLOW_expression_in_arguments357 = new BitSet(new long[] { 0x0000000000000012L });
	public static final BitSet FOLLOW_FACTORIAL_in_unaryOperation373 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MULTIPLY_in_binaryOperationHigh386 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DIVISION_in_binaryOperationHigh397 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVOLUTION_in_binaryOperationMiddle412 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_PLUS_in_binaryOperationLow425 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_binaryOperationLow435 = new BitSet(new long[] { 0x0000000000000002L });
}
