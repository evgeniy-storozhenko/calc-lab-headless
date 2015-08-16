// $ANTLR 3.5.2 CalcLab.g 2015-08-16 15:32:35

package com.calclab.core.parser.internal;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.calculations.CalculationFactory;
import com.calclab.core.operands.Operand;
import com.calclab.core.operations.Operation;
import com.calclab.core.parser.extensions.SyntaxErrorException;
import com.calclab.operands.common.CommonOperandFactory;
import com.calclab.operations.common.CommonOperationFactory;

@SuppressWarnings("all")
public class CalcLabParser extends Parser {
	public static final String[] tokenNames = new String[] {
			"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ARGUMENTS_SEPARATOR", "CHAR",
			"CLOSING_PARENTHESIS", "DECIMAL_SEPARATOR", "DIGIT", "DIVISION", "EQUALS",
			"EXPRESSIONS_SEPARATOR", "FACTORIAL", "ID", "INVOLUTION", "MINUS", "MULTIPLY",
			"NAME", "NEWLINE", "OPENING_PARENTHESIS", "PLUS", "WS"
	};
	public static final int EOF = -1;
	public static final int ARGUMENTS_SEPARATOR = 4;
	public static final int CHAR = 5;
	public static final int CLOSING_PARENTHESIS = 6;
	public static final int DECIMAL_SEPARATOR = 7;
	public static final int DIGIT = 8;
	public static final int DIVISION = 9;
	public static final int EQUALS = 10;
	public static final int EXPRESSIONS_SEPARATOR = 11;
	public static final int FACTORIAL = 12;
	public static final int ID = 13;
	public static final int INVOLUTION = 14;
	public static final int MINUS = 15;
	public static final int MULTIPLY = 16;
	public static final int NAME = 17;
	public static final int NEWLINE = 18;
	public static final int OPENING_PARENTHESIS = 19;
	public static final int PLUS = 20;
	public static final int WS = 21;

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
	private Map<String, Calculable> variables = new HashMap<String, Calculable>();

	public List<Calculable> getCalculations() {
		return calculations;
	}

	public Map<String, Calculable> getVariables() {
		return variables;
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
	// CalcLab.g:58:1: calculation : ( ( NAME EQUALS )? e= expression EXPRESSIONS_SEPARATOR )+ ;
	public final void calculation() throws RecognitionException {
		Token NAME1 = null;
		Token EQUALS2 = null;
		ParserRuleReturnScope e = null;

		try {
			// CalcLab.g:59:2: ( ( ( NAME EQUALS )? e= expression EXPRESSIONS_SEPARATOR )+ )
			// CalcLab.g:59:4: ( ( NAME EQUALS )? e= expression EXPRESSIONS_SEPARATOR )+
			{
				// CalcLab.g:59:4: ( ( NAME EQUALS )? e= expression EXPRESSIONS_SEPARATOR )+
				int cnt2 = 0;
				loop2: while (true) {
					int alt2 = 2;
					int LA2_0 = input.LA(1);
					if ((LA2_0 == DIGIT || LA2_0 == MINUS || LA2_0 == NAME || LA2_0 == OPENING_PARENTHESIS)) {
						alt2 = 1;
					}

					switch (alt2) {
					case 1:
					// CalcLab.g:59:5: ( NAME EQUALS )? e= expression EXPRESSIONS_SEPARATOR
					{
						String variable = null;
						StringBuilder in = new StringBuilder();
						// CalcLab.g:60:3: ( NAME EQUALS )?
						int alt1 = 2;
						int LA1_0 = input.LA(1);
						if ((LA1_0 == NAME)) {
							int LA1_1 = input.LA(2);
							if ((LA1_1 == EQUALS)) {
								alt1 = 1;
							}
						}
						switch (alt1) {
						case 1:
						// CalcLab.g:60:4: NAME EQUALS
						{
							NAME1 = (Token) match(input, NAME, FOLLOW_NAME_in_calculation55);
							EQUALS2 = (Token) match(input, EQUALS, FOLLOW_EQUALS_in_calculation57);

							variable = (NAME1 != null ? NAME1.getText() : null);
							in.append((NAME1 != null ? NAME1.getText() : null));
							in.append((EQUALS2 != null ? EQUALS2.getText() : null));

						}
							break;

						}

						pushFollow(FOLLOW_expression_in_calculation66);
						e = expression();
						state._fsp--;

						in.append((e != null ? input.toString(e.start, e.stop) : null));
						Calculable calculable = calcFactory.createCalculation(
								(e != null ? ((CalcLabParser.expression_return) e).value : null), in.toString());
						calculations.add(calculable);
						if (variable != null) {
							variables.put(variable, calculable);
						}

						match(input, EXPRESSIONS_SEPARATOR, FOLLOW_EXPRESSIONS_SEPARATOR_in_calculation72);
					}
						break;

					default:
						if (cnt2 >= 1)
							break loop2;
						EarlyExitException eee = new EarlyExitException(2, input);
						throw eee;
					}
					cnt2++;
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
	// CalcLab.g:77:1: expression returns [Operand value] : (c1= complexCompositeUnit ) (o= binaryOperationLow c2=
	// complexCompositeUnit )* ;
	public final CalcLabParser.expression_return expression() throws RecognitionException {
		CalcLabParser.expression_return retval = new CalcLabParser.expression_return();
		retval.start = input.LT(1);

		Operand c1 = null;
		Operation o = null;
		Operand c2 = null;

		try {
			// CalcLab.g:78:2: ( (c1= complexCompositeUnit ) (o= binaryOperationLow c2= complexCompositeUnit )* )
			// CalcLab.g:78:4: (c1= complexCompositeUnit ) (o= binaryOperationLow c2= complexCompositeUnit )*
			{
				// CalcLab.g:78:4: (c1= complexCompositeUnit )
				// CalcLab.g:78:5: c1= complexCompositeUnit
				{
					pushFollow(FOLLOW_complexCompositeUnit_in_expression93);
					c1 = complexCompositeUnit();
					state._fsp--;

					retval.value = c1;
				}

				// CalcLab.g:79:3: (o= binaryOperationLow c2= complexCompositeUnit )*
				loop3: while (true) {
					int alt3 = 2;
					int LA3_0 = input.LA(1);
					if ((LA3_0 == MINUS || LA3_0 == PLUS)) {
						alt3 = 1;
					}

					switch (alt3) {
					case 1:
					// CalcLab.g:79:4: o= binaryOperationLow c2= complexCompositeUnit
					{
						pushFollow(FOLLOW_binaryOperationLow_in_expression104);
						o = binaryOperationLow();
						state._fsp--;

						pushFollow(FOLLOW_complexCompositeUnit_in_expression108);
						c2 = complexCompositeUnit();
						state._fsp--;

						retval.value = operandFactory.createCompositeOperand(retval.value, o, c2);
					}
						break;

					default:
						break loop3;
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
	// CalcLab.g:84:1: complexCompositeUnit returns [Operand value] : c1= compositeUnit (o= binaryOperationMiddle c2=
	// compositeUnit )* ;
	public final Operand complexCompositeUnit() throws RecognitionException {
		Operand value = null;

		Operand c1 = null;
		Operation o = null;
		Operand c2 = null;

		try {
			// CalcLab.g:85:2: (c1= compositeUnit (o= binaryOperationMiddle c2= compositeUnit )* )
			// CalcLab.g:85:4: c1= compositeUnit (o= binaryOperationMiddle c2= compositeUnit )*
			{
				pushFollow(FOLLOW_compositeUnit_in_complexCompositeUnit133);
				c1 = compositeUnit();
				state._fsp--;

				value = c1;
				// CalcLab.g:86:3: (o= binaryOperationMiddle c2= compositeUnit )*
				loop4: while (true) {
					int alt4 = 2;
					int LA4_0 = input.LA(1);
					if ((LA4_0 == INVOLUTION)) {
						alt4 = 1;
					}

					switch (alt4) {
					case 1:
					// CalcLab.g:86:4: o= binaryOperationMiddle c2= compositeUnit
					{
						pushFollow(FOLLOW_binaryOperationMiddle_in_complexCompositeUnit143);
						o = binaryOperationMiddle();
						state._fsp--;

						pushFollow(FOLLOW_compositeUnit_in_complexCompositeUnit147);
						c2 = compositeUnit();
						state._fsp--;

						value = operandFactory.createCompositeOperand(value, o, c2);
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
	// $ANTLR end "complexCompositeUnit"

	// $ANTLR start "compositeUnit"
	// CalcLab.g:91:1: compositeUnit returns [Operand value] : unit1= unit ( binaryOperationHigh unit2= unit )* ;
	public final Operand compositeUnit() throws RecognitionException {
		Operand value = null;

		Operand unit1 = null;
		Operand unit2 = null;
		Operation binaryOperationHigh3 = null;

		try {
			// CalcLab.g:92:2: (unit1= unit ( binaryOperationHigh unit2= unit )* )
			// CalcLab.g:92:4: unit1= unit ( binaryOperationHigh unit2= unit )*
			{
				pushFollow(FOLLOW_unit_in_compositeUnit172);
				unit1 = unit();
				state._fsp--;

				value = unit1;
				// CalcLab.g:93:3: ( binaryOperationHigh unit2= unit )*
				loop5: while (true) {
					int alt5 = 2;
					int LA5_0 = input.LA(1);
					if ((LA5_0 == DIVISION || LA5_0 == MULTIPLY)) {
						alt5 = 1;
					}

					switch (alt5) {
					case 1:
					// CalcLab.g:93:4: binaryOperationHigh unit2= unit
					{
						pushFollow(FOLLOW_binaryOperationHigh_in_compositeUnit180);
						binaryOperationHigh3 = binaryOperationHigh();
						state._fsp--;

						pushFollow(FOLLOW_unit_in_compositeUnit184);
						unit2 = unit();
						state._fsp--;

						value = operandFactory.createCompositeOperand(value,
								binaryOperationHigh3, unit2);

					}
						break;

					default:
						break loop5;
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
	// CalcLab.g:100:1: unit returns [Operand value] : ( number | compositeExpression | functionOrVariable ) (u=
	// unaryOperation )? ;
	public final Operand unit() throws RecognitionException {
		Operand value = null;

		Operation u = null;
		ParserRuleReturnScope number4 = null;
		Operand compositeExpression5 = null;
		Operand functionOrVariable6 = null;

		try {
			// CalcLab.g:101:2: ( ( number | compositeExpression | functionOrVariable ) (u= unaryOperation )? )
			// CalcLab.g:101:4: ( number | compositeExpression | functionOrVariable ) (u= unaryOperation )?
			{
				// CalcLab.g:101:4: ( number | compositeExpression | functionOrVariable )
				int alt6 = 3;
				switch (input.LA(1)) {
				case MINUS: {
					switch (input.LA(2)) {
					case DIGIT: {
						alt6 = 1;
					}
						break;
					case OPENING_PARENTHESIS: {
						alt6 = 2;
					}
						break;
					case NAME: {
						alt6 = 3;
					}
						break;
					default:
						int nvaeMark = input.mark();
						try {
							input.consume();
							NoViableAltException nvae = new NoViableAltException("", 6, 1, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}
					break;
				case DIGIT: {
					alt6 = 1;
				}
					break;
				case OPENING_PARENTHESIS: {
					alt6 = 2;
				}
					break;
				case NAME: {
					alt6 = 3;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException("", 6, 0, input);
					throw nvae;
				}
				switch (alt6) {
				case 1:
				// CalcLab.g:101:5: number
				{
					pushFollow(FOLLOW_number_in_unit210);
					number4 = number();
					state._fsp--;

					value = operandFactory
							.createNumber((number4 != null ? input.toString(number4.start, number4.stop) : null));
				}
					break;
				case 2:
				// CalcLab.g:102:5: compositeExpression
				{
					pushFollow(FOLLOW_compositeExpression_in_unit219);
					compositeExpression5 = compositeExpression();
					state._fsp--;

					value = compositeExpression5;
				}
					break;
				case 3:
				// CalcLab.g:103:5: functionOrVariable
				{
					pushFollow(FOLLOW_functionOrVariable_in_unit228);
					functionOrVariable6 = functionOrVariable();
					state._fsp--;

					value = functionOrVariable6;
				}
					break;

				}

				// CalcLab.g:104:4: (u= unaryOperation )?
				int alt7 = 2;
				int LA7_0 = input.LA(1);
				if ((LA7_0 == FACTORIAL)) {
					alt7 = 1;
				}
				switch (alt7) {
				case 1:
				// CalcLab.g:104:5: u= unaryOperation
				{
					pushFollow(FOLLOW_unaryOperation_in_unit238);
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
	// CalcLab.g:107:1: number : ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )* ;
	public final CalcLabParser.number_return number() throws RecognitionException {
		CalcLabParser.number_return retval = new CalcLabParser.number_return();
		retval.start = input.LT(1);

		try {
			// CalcLab.g:108:2: ( ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )* )
			// CalcLab.g:108:4: ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )*
			{
				// CalcLab.g:108:4: ( MINUS )?
				int alt8 = 2;
				int LA8_0 = input.LA(1);
				if ((LA8_0 == MINUS)) {
					alt8 = 1;
				}
				switch (alt8) {
				case 1:
				// CalcLab.g:108:4: MINUS
				{
					match(input, MINUS, FOLLOW_MINUS_in_number254);
				}
					break;

				}

				match(input, DIGIT, FOLLOW_DIGIT_in_number257);
				// CalcLab.g:108:17: ( DECIMAL_SEPARATOR DIGIT )*
				loop9: while (true) {
					int alt9 = 2;
					int LA9_0 = input.LA(1);
					if ((LA9_0 == DECIMAL_SEPARATOR)) {
						alt9 = 1;
					}

					switch (alt9) {
					case 1:
					// CalcLab.g:108:18: DECIMAL_SEPARATOR DIGIT
					{
						match(input, DECIMAL_SEPARATOR, FOLLOW_DECIMAL_SEPARATOR_in_number260);
						match(input, DIGIT, FOLLOW_DIGIT_in_number262);
					}
						break;

					default:
						break loop9;
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
	// CalcLab.g:111:1: compositeExpression returns [Operand value] : ( MINUS )? OPENING_PARENTHESIS expression
	// CLOSING_PARENTHESIS ;
	public final Operand compositeExpression() throws RecognitionException {
		Operand value = null;

		Token MINUS7 = null;
		ParserRuleReturnScope expression8 = null;

		try {
			// CalcLab.g:112:2: ( ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS )
			// CalcLab.g:112:4: ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS
			{
				Operation operation = null;
				// CalcLab.g:113:3: ( MINUS )?
				int alt10 = 2;
				int LA10_0 = input.LA(1);
				if ((LA10_0 == MINUS)) {
					alt10 = 1;
				}
				switch (alt10) {
				case 1:
				// CalcLab.g:113:4: MINUS
				{
					MINUS7 = (Token) match(input, MINUS, FOLLOW_MINUS_in_compositeExpression284);
					operation = operationFactory.createCommonOperation((MINUS7 != null ? MINUS7.getText() : null));
				}
					break;

				}

				match(input, OPENING_PARENTHESIS, FOLLOW_OPENING_PARENTHESIS_in_compositeExpression294);
				pushFollow(FOLLOW_expression_in_compositeExpression296);
				expression8 = expression();
				state._fsp--;

				match(input, CLOSING_PARENTHESIS, FOLLOW_CLOSING_PARENTHESIS_in_compositeExpression298);
				if (operation == null)
					value = (expression8 != null ? ((CalcLabParser.expression_return) expression8).value : null);
				else
					value = operandFactory.createUnaryOperand(operation,
							(expression8 != null ? ((CalcLabParser.expression_return) expression8).value : null));
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

	// $ANTLR start "functionOrVariable"
	// CalcLab.g:119:1: functionOrVariable returns [Operand value] : ( MINUS )? name= NAME ( OPENING_PARENTHESIS
	// arguments CLOSING_PARENTHESIS )? ;
	public final Operand functionOrVariable() throws RecognitionException {
		Operand value = null;

		Token name = null;
		Token MINUS9 = null;
		ArrayList<Operand> arguments10 = null;

		try {
			// CalcLab.g:120:2: ( ( MINUS )? name= NAME ( OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS )? )
			// CalcLab.g:120:4: ( MINUS )? name= NAME ( OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS )?
			{
				Operation operation = null;
				boolean isVariable = true;
				// CalcLab.g:121:3: ( MINUS )?
				int alt11 = 2;
				int LA11_0 = input.LA(1);
				if ((LA11_0 == MINUS)) {
					alt11 = 1;
				}
				switch (alt11) {
				case 1:
				// CalcLab.g:121:4: MINUS
				{
					MINUS9 = (Token) match(input, MINUS, FOLLOW_MINUS_in_functionOrVariable321);
					operation = operationFactory.createCommonOperation((MINUS9 != null ? MINUS9.getText() : null));
				}
					break;

				}

				name = (Token) match(input, NAME, FOLLOW_NAME_in_functionOrVariable331);
				// CalcLab.g:122:13: ( OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS )?
				int alt12 = 2;
				int LA12_0 = input.LA(1);
				if ((LA12_0 == OPENING_PARENTHESIS)) {
					alt12 = 1;
				}
				switch (alt12) {
				case 1:
				// CalcLab.g:122:14: OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS
				{
					match(input, OPENING_PARENTHESIS, FOLLOW_OPENING_PARENTHESIS_in_functionOrVariable334);
					pushFollow(FOLLOW_arguments_in_functionOrVariable336);
					arguments10 = arguments();
					state._fsp--;

					match(input, CLOSING_PARENTHESIS, FOLLOW_CLOSING_PARENTHESIS_in_functionOrVariable338);
					isVariable = false;
				}
					break;

				}

				if (isVariable) {
					Calculable variable = variables.get((name != null ? name.getText() : null));
					if (variable != null) {
						value = operandFactory.createVariableOperand((name != null ? name.getText() : null), variable);
					} else {
						String msg = "The variable '" + (name != null ? name.getText() : null) + "' is not defined.";
						throw new SyntaxErrorException((name != null ? name.getLine() : 0),
								name.getCharPositionInLine(), msg);
					}
					if (operation != null) {
						value = operandFactory.createUnaryOperand(operation, value);
					}
				} else {
					value = operandFactory.createFunctionOperand((name != null ? name.getText() : null), arguments10);
					if (operation != null) {
						value = operandFactory.createUnaryOperand(operation, value);
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
	// $ANTLR end "functionOrVariable"

	// $ANTLR start "arguments"
	// CalcLab.g:144:1: arguments returns [ArrayList<Operand> value] :e1= expression ( ARGUMENTS_SEPARATOR e2=
	// expression )* ;
	public final ArrayList<Operand> arguments() throws RecognitionException {
		ArrayList<Operand> value = null;

		ParserRuleReturnScope e1 = null;
		ParserRuleReturnScope e2 = null;

		try {
			// CalcLab.g:145:2: (e1= expression ( ARGUMENTS_SEPARATOR e2= expression )* )
			// CalcLab.g:145:4: e1= expression ( ARGUMENTS_SEPARATOR e2= expression )*
			{
				value = new ArrayList<Operand>();
				pushFollow(FOLLOW_expression_in_arguments365);
				e1 = expression();
				state._fsp--;

				value.add((e1 != null ? ((CalcLabParser.expression_return) e1).value : null));
				// CalcLab.g:147:4: ( ARGUMENTS_SEPARATOR e2= expression )*
				loop13: while (true) {
					int alt13 = 2;
					int LA13_0 = input.LA(1);
					if ((LA13_0 == ARGUMENTS_SEPARATOR)) {
						alt13 = 1;
					}

					switch (alt13) {
					case 1:
					// CalcLab.g:147:5: ARGUMENTS_SEPARATOR e2= expression
					{
						match(input, ARGUMENTS_SEPARATOR, FOLLOW_ARGUMENTS_SEPARATOR_in_arguments374);
						pushFollow(FOLLOW_expression_in_arguments378);
						e2 = expression();
						state._fsp--;

						value.add((e2 != null ? ((CalcLabParser.expression_return) e2).value : null));
					}
						break;

					default:
						break loop13;
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
	// CalcLab.g:151:1: unaryOperation returns [Operation value] : FACTORIAL ;
	public final Operation unaryOperation() throws RecognitionException {
		Operation value = null;

		Token FACTORIAL11 = null;

		try {
			// CalcLab.g:151:40: ( FACTORIAL )
			// CalcLab.g:151:42: FACTORIAL
			{
				FACTORIAL11 = (Token) match(input, FACTORIAL, FOLLOW_FACTORIAL_in_unaryOperation394);
				value = operationFactory.createCommonOperation((FACTORIAL11 != null ? FACTORIAL11.getText() : null));
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
	// CalcLab.g:153:1: binaryOperationHigh returns [Operation value] : ( MULTIPLY | DIVISION );
	public final Operation binaryOperationHigh() throws RecognitionException {
		Operation value = null;

		Token MULTIPLY12 = null;
		Token DIVISION13 = null;

		try {
			// CalcLab.g:153:45: ( MULTIPLY | DIVISION )
			int alt14 = 2;
			int LA14_0 = input.LA(1);
			if ((LA14_0 == MULTIPLY)) {
				alt14 = 1;
			} else if ((LA14_0 == DIVISION)) {
				alt14 = 2;
			}

			else {
				NoViableAltException nvae = new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
			case 1:
			// CalcLab.g:153:47: MULTIPLY
			{
				MULTIPLY12 = (Token) match(input, MULTIPLY, FOLLOW_MULTIPLY_in_binaryOperationHigh407);
				value = operationFactory.createCommonOperation((MULTIPLY12 != null ? MULTIPLY12.getText() : null));
			}
				break;
			case 2:
			// CalcLab.g:155:4: DIVISION
			{
				DIVISION13 = (Token) match(input, DIVISION, FOLLOW_DIVISION_in_binaryOperationHigh418);
				value = operationFactory.createCommonOperation((DIVISION13 != null ? DIVISION13.getText() : null));
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
	// CalcLab.g:158:1: binaryOperationMiddle returns [Operation value] : INVOLUTION ;
	public final Operation binaryOperationMiddle() throws RecognitionException {
		Operation value = null;

		Token INVOLUTION14 = null;

		try {
			// CalcLab.g:158:47: ( INVOLUTION )
			// CalcLab.g:158:49: INVOLUTION
			{
				INVOLUTION14 = (Token) match(input, INVOLUTION, FOLLOW_INVOLUTION_in_binaryOperationMiddle433);
				value = operationFactory.createCommonOperation((INVOLUTION14 != null ? INVOLUTION14.getText() : null));
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
	// CalcLab.g:160:1: binaryOperationLow returns [Operation value] : ( PLUS | MINUS );
	public final Operation binaryOperationLow() throws RecognitionException {
		Operation value = null;

		Token PLUS15 = null;
		Token MINUS16 = null;

		try {
			// CalcLab.g:160:44: ( PLUS | MINUS )
			int alt15 = 2;
			int LA15_0 = input.LA(1);
			if ((LA15_0 == PLUS)) {
				alt15 = 1;
			} else if ((LA15_0 == MINUS)) {
				alt15 = 2;
			}

			else {
				NoViableAltException nvae = new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
			case 1:
			// CalcLab.g:160:46: PLUS
			{
				PLUS15 = (Token) match(input, PLUS, FOLLOW_PLUS_in_binaryOperationLow446);
				value = operationFactory.createCommonOperation((PLUS15 != null ? PLUS15.getText() : null));
			}
				break;
			case 2:
			// CalcLab.g:162:4: MINUS
			{
				MINUS16 = (Token) match(input, MINUS, FOLLOW_MINUS_in_binaryOperationLow456);
				value = operationFactory.createCommonOperation((MINUS16 != null ? MINUS16.getText() : null));
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

	public static final BitSet FOLLOW_NAME_in_calculation55 = new BitSet(new long[] { 0x0000000000000400L });
	public static final BitSet FOLLOW_EQUALS_in_calculation57 = new BitSet(new long[] { 0x00000000000A8100L });
	public static final BitSet FOLLOW_expression_in_calculation66 = new BitSet(new long[] { 0x0000000000000800L });
	public static final BitSet FOLLOW_EXPRESSIONS_SEPARATOR_in_calculation72 = new BitSet(
			new long[] { 0x00000000000A8102L });
	public static final BitSet FOLLOW_complexCompositeUnit_in_expression93 = new BitSet(
			new long[] { 0x0000000000108002L });
	public static final BitSet FOLLOW_binaryOperationLow_in_expression104 = new BitSet(
			new long[] { 0x00000000000A8100L });
	public static final BitSet FOLLOW_complexCompositeUnit_in_expression108 = new BitSet(
			new long[] { 0x0000000000108002L });
	public static final BitSet FOLLOW_compositeUnit_in_complexCompositeUnit133 = new BitSet(
			new long[] { 0x0000000000004002L });
	public static final BitSet FOLLOW_binaryOperationMiddle_in_complexCompositeUnit143 = new BitSet(
			new long[] { 0x00000000000A8100L });
	public static final BitSet FOLLOW_compositeUnit_in_complexCompositeUnit147 = new BitSet(
			new long[] { 0x0000000000004002L });
	public static final BitSet FOLLOW_unit_in_compositeUnit172 = new BitSet(new long[] { 0x0000000000010202L });
	public static final BitSet FOLLOW_binaryOperationHigh_in_compositeUnit180 = new BitSet(
			new long[] { 0x00000000000A8100L });
	public static final BitSet FOLLOW_unit_in_compositeUnit184 = new BitSet(new long[] { 0x0000000000010202L });
	public static final BitSet FOLLOW_number_in_unit210 = new BitSet(new long[] { 0x0000000000001002L });
	public static final BitSet FOLLOW_compositeExpression_in_unit219 = new BitSet(new long[] { 0x0000000000001002L });
	public static final BitSet FOLLOW_functionOrVariable_in_unit228 = new BitSet(new long[] { 0x0000000000001002L });
	public static final BitSet FOLLOW_unaryOperation_in_unit238 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_number254 = new BitSet(new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_DIGIT_in_number257 = new BitSet(new long[] { 0x0000000000000082L });
	public static final BitSet FOLLOW_DECIMAL_SEPARATOR_in_number260 = new BitSet(new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_DIGIT_in_number262 = new BitSet(new long[] { 0x0000000000000082L });
	public static final BitSet FOLLOW_MINUS_in_compositeExpression284 = new BitSet(new long[] { 0x0000000000080000L });
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_compositeExpression294 = new BitSet(
			new long[] { 0x00000000000A8100L });
	public static final BitSet FOLLOW_expression_in_compositeExpression296 = new BitSet(
			new long[] { 0x0000000000000040L });
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_compositeExpression298 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_functionOrVariable321 = new BitSet(new long[] { 0x0000000000020000L });
	public static final BitSet FOLLOW_NAME_in_functionOrVariable331 = new BitSet(new long[] { 0x0000000000080002L });
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_functionOrVariable334 = new BitSet(
			new long[] { 0x00000000000A8100L });
	public static final BitSet FOLLOW_arguments_in_functionOrVariable336 = new BitSet(
			new long[] { 0x0000000000000040L });
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_functionOrVariable338 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expression_in_arguments365 = new BitSet(new long[] { 0x0000000000000012L });
	public static final BitSet FOLLOW_ARGUMENTS_SEPARATOR_in_arguments374 = new BitSet(
			new long[] { 0x00000000000A8100L });
	public static final BitSet FOLLOW_expression_in_arguments378 = new BitSet(new long[] { 0x0000000000000012L });
	public static final BitSet FOLLOW_FACTORIAL_in_unaryOperation394 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MULTIPLY_in_binaryOperationHigh407 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DIVISION_in_binaryOperationHigh418 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVOLUTION_in_binaryOperationMiddle433 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_PLUS_in_binaryOperationLow446 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_binaryOperationLow456 = new BitSet(new long[] { 0x0000000000000002L });
}
