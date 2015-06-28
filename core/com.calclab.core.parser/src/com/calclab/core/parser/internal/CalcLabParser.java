// $ANTLR 3.5.2 CalcLab.g 2015-06-28 18:38:06

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

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

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
	// CalcLab.g:100:1: unit returns [Operand value] : ( number | compositeExpression | variable | function ) (u=
	// unaryOperation )? ;
	public final Operand unit() throws RecognitionException {
		Operand value = null;

		Operation u = null;
		ParserRuleReturnScope number4 = null;
		Operand compositeExpression5 = null;
		Operand variable6 = null;
		Operand function7 = null;

		try {
			// CalcLab.g:101:2: ( ( number | compositeExpression | variable | function ) (u= unaryOperation )? )
			// CalcLab.g:101:4: ( number | compositeExpression | variable | function ) (u= unaryOperation )?
			{
				// CalcLab.g:101:4: ( number | compositeExpression | variable | function )
				int alt6 = 4;
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
							NoViableAltException nvae =
									new NoViableAltException("", 6, 1, input);
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
					int LA6_4 = input.LA(2);
					if ((LA6_4 == OPENING_PARENTHESIS)) {
						alt6 = 4;
					}
					else if ((LA6_4 == ARGUMENTS_SEPARATOR || LA6_4 == CLOSING_PARENTHESIS || LA6_4 == DIVISION
							|| (LA6_4 >= EXPRESSIONS_SEPARATOR && LA6_4 <= FACTORIAL)
							|| (LA6_4 >= INVOLUTION && LA6_4 <= MULTIPLY) || LA6_4 == PLUS)) {
						alt6 = 3;
					}

					else {
						int nvaeMark = input.mark();
						try {
							input.consume();
							NoViableAltException nvae =
									new NoViableAltException("", 6, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
					break;
				default:
					NoViableAltException nvae =
							new NoViableAltException("", 6, 0, input);
					throw nvae;
				}
				switch (alt6) {
				case 1:
				// CalcLab.g:101:5: number
				{
					pushFollow(FOLLOW_number_in_unit210);
					number4 = number();
					state._fsp--;

					value = operandFactory.createNumber((number4 != null ? input.toString(number4.start, number4.stop)
							: null));
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
				// CalcLab.g:103:5: variable
				{
					pushFollow(FOLLOW_variable_in_unit228);
					variable6 = variable();
					state._fsp--;

					value = variable6;
				}
					break;
				case 4:
				// CalcLab.g:104:5: function
				{
					pushFollow(FOLLOW_function_in_unit236);
					function7 = function();
					state._fsp--;

					value = function7;
				}
					break;

				}

				// CalcLab.g:105:4: (u= unaryOperation )?
				int alt7 = 2;
				int LA7_0 = input.LA(1);
				if ((LA7_0 == FACTORIAL)) {
					alt7 = 1;
				}
				switch (alt7) {
				case 1:
				// CalcLab.g:105:5: u= unaryOperation
				{
					pushFollow(FOLLOW_unaryOperation_in_unit246);
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
	// CalcLab.g:108:1: number : ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )* ;
	public final CalcLabParser.number_return number() throws RecognitionException {
		CalcLabParser.number_return retval = new CalcLabParser.number_return();
		retval.start = input.LT(1);

		try {
			// CalcLab.g:109:2: ( ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )* )
			// CalcLab.g:109:4: ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )*
			{
				// CalcLab.g:109:4: ( MINUS )?
				int alt8 = 2;
				int LA8_0 = input.LA(1);
				if ((LA8_0 == MINUS)) {
					alt8 = 1;
				}
				switch (alt8) {
				case 1:
				// CalcLab.g:109:4: MINUS
				{
					match(input, MINUS, FOLLOW_MINUS_in_number262);
				}
					break;

				}

				match(input, DIGIT, FOLLOW_DIGIT_in_number265);
				// CalcLab.g:109:17: ( DECIMAL_SEPARATOR DIGIT )*
				loop9: while (true) {
					int alt9 = 2;
					int LA9_0 = input.LA(1);
					if ((LA9_0 == DECIMAL_SEPARATOR)) {
						alt9 = 1;
					}

					switch (alt9) {
					case 1:
					// CalcLab.g:109:18: DECIMAL_SEPARATOR DIGIT
					{
						match(input, DECIMAL_SEPARATOR, FOLLOW_DECIMAL_SEPARATOR_in_number268);
						match(input, DIGIT, FOLLOW_DIGIT_in_number270);
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
	// CalcLab.g:112:1: compositeExpression returns [Operand value] : ( MINUS )? OPENING_PARENTHESIS expression
	// CLOSING_PARENTHESIS ;
	public final Operand compositeExpression() throws RecognitionException {
		Operand value = null;

		Token MINUS8 = null;
		ParserRuleReturnScope expression9 = null;

		try {
			// CalcLab.g:113:2: ( ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS )
			// CalcLab.g:113:4: ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS
			{
				Operation operation = null;
				// CalcLab.g:114:3: ( MINUS )?
				int alt10 = 2;
				int LA10_0 = input.LA(1);
				if ((LA10_0 == MINUS)) {
					alt10 = 1;
				}
				switch (alt10) {
				case 1:
				// CalcLab.g:114:4: MINUS
				{
					MINUS8 = (Token) match(input, MINUS, FOLLOW_MINUS_in_compositeExpression292);
					operation = operationFactory.createCommonOperation((MINUS8 != null ? MINUS8.getText() : null));
				}
					break;

				}

				match(input, OPENING_PARENTHESIS, FOLLOW_OPENING_PARENTHESIS_in_compositeExpression302);
				pushFollow(FOLLOW_expression_in_compositeExpression304);
				expression9 = expression();
				state._fsp--;

				match(input, CLOSING_PARENTHESIS, FOLLOW_CLOSING_PARENTHESIS_in_compositeExpression306);
				if (operation == null)
					value = (expression9 != null ? ((CalcLabParser.expression_return) expression9).value : null);
				else
					value = operandFactory.createUnaryOperand(operation,
							(expression9 != null ? ((CalcLabParser.expression_return) expression9).value : null));
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
	// CalcLab.g:120:1: function returns [Operand value] : ( MINUS )? NAME OPENING_PARENTHESIS arguments
	// CLOSING_PARENTHESIS ;
	public final Operand function() throws RecognitionException {
		Operand value = null;

		Token MINUS10 = null;
		Token NAME11 = null;
		ArrayList<Operand> arguments12 = null;

		try {
			// CalcLab.g:121:2: ( ( MINUS )? NAME OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS )
			// CalcLab.g:121:4: ( MINUS )? NAME OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS
			{
				Operation operation = null;
				// CalcLab.g:122:3: ( MINUS )?
				int alt11 = 2;
				int LA11_0 = input.LA(1);
				if ((LA11_0 == MINUS)) {
					alt11 = 1;
				}
				switch (alt11) {
				case 1:
				// CalcLab.g:122:4: MINUS
				{
					MINUS10 = (Token) match(input, MINUS, FOLLOW_MINUS_in_function330);
					operation = operationFactory.createCommonOperation((MINUS10 != null ? MINUS10.getText() : null));
				}
					break;

				}

				NAME11 = (Token) match(input, NAME, FOLLOW_NAME_in_function338);
				match(input, OPENING_PARENTHESIS, FOLLOW_OPENING_PARENTHESIS_in_function340);
				pushFollow(FOLLOW_arguments_in_function342);
				arguments12 = arguments();
				state._fsp--;

				match(input, CLOSING_PARENTHESIS, FOLLOW_CLOSING_PARENTHESIS_in_function344);

				value = operandFactory.createFunctionOperand((NAME11 != null ? NAME11.getText() : null), arguments12);
				if (operation != null) {
					value = operandFactory.createUnaryOperand(operation, value);
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

	// $ANTLR end "function"

	// $ANTLR start "variable"
	// CalcLab.g:132:1: variable returns [Operand value] : ( MINUS )? name= NAME ;
	public final Operand variable() throws RecognitionException {
		Operand value = null;

		Token name = null;
		Token MINUS13 = null;

		try {
			// CalcLab.g:133:2: ( ( MINUS )? name= NAME )
			// CalcLab.g:133:4: ( MINUS )? name= NAME
			{
				Operation operation = null;
				// CalcLab.g:134:3: ( MINUS )?
				int alt12 = 2;
				int LA12_0 = input.LA(1);
				if ((LA12_0 == MINUS)) {
					alt12 = 1;
				}
				switch (alt12) {
				case 1:
				// CalcLab.g:134:4: MINUS
				{
					MINUS13 = (Token) match(input, MINUS, FOLLOW_MINUS_in_variable367);
					operation = operationFactory.createCommonOperation((MINUS13 != null ? MINUS13.getText() : null));
				}
					break;

				}

				name = (Token) match(input, NAME, FOLLOW_NAME_in_variable377);

				Calculable variable = variables.get((name != null ? name.getText() : null));
				if (variable != null) {
					value = operandFactory.createVariableOperand((name != null ? name.getText() : null), variable);
				} else {
					String msg = "The variable '" + (name != null ? name.getText() : null) + "' is not defined.";
					throw new SyntaxErrorException((name != null ? name.getLine() : 0), name.getCharPositionInLine(),
							msg);
				}
				if (operation != null) {
					value = operandFactory.createUnaryOperand(operation, value);
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

	// $ANTLR end "variable"

	// $ANTLR start "arguments"
	// CalcLab.g:150:1: arguments returns [ArrayList<Operand> value] :e1= expression ( ARGUMENTS_SEPARATOR e2=
	// expression )* ;
	public final ArrayList<Operand> arguments() throws RecognitionException {
		ArrayList<Operand> value = null;

		ParserRuleReturnScope e1 = null;
		ParserRuleReturnScope e2 = null;

		try {
			// CalcLab.g:151:2: (e1= expression ( ARGUMENTS_SEPARATOR e2= expression )* )
			// CalcLab.g:151:4: e1= expression ( ARGUMENTS_SEPARATOR e2= expression )*
			{
				value = new ArrayList<Operand>();
				pushFollow(FOLLOW_expression_in_arguments401);
				e1 = expression();
				state._fsp--;

				value.add((e1 != null ? ((CalcLabParser.expression_return) e1).value : null));
				// CalcLab.g:153:4: ( ARGUMENTS_SEPARATOR e2= expression )*
				loop13: while (true) {
					int alt13 = 2;
					int LA13_0 = input.LA(1);
					if ((LA13_0 == ARGUMENTS_SEPARATOR)) {
						alt13 = 1;
					}

					switch (alt13) {
					case 1:
					// CalcLab.g:153:5: ARGUMENTS_SEPARATOR e2= expression
					{
						match(input, ARGUMENTS_SEPARATOR, FOLLOW_ARGUMENTS_SEPARATOR_in_arguments410);
						pushFollow(FOLLOW_expression_in_arguments414);
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
	// CalcLab.g:157:1: unaryOperation returns [Operation value] : FACTORIAL ;
	public final Operation unaryOperation() throws RecognitionException {
		Operation value = null;

		Token FACTORIAL14 = null;

		try {
			// CalcLab.g:157:40: ( FACTORIAL )
			// CalcLab.g:157:42: FACTORIAL
			{
				FACTORIAL14 = (Token) match(input, FACTORIAL, FOLLOW_FACTORIAL_in_unaryOperation430);
				value = operationFactory.createCommonOperation((FACTORIAL14 != null ? FACTORIAL14.getText() : null));
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
	// CalcLab.g:159:1: binaryOperationHigh returns [Operation value] : ( MULTIPLY | DIVISION );
	public final Operation binaryOperationHigh() throws RecognitionException {
		Operation value = null;

		Token MULTIPLY15 = null;
		Token DIVISION16 = null;

		try {
			// CalcLab.g:159:45: ( MULTIPLY | DIVISION )
			int alt14 = 2;
			int LA14_0 = input.LA(1);
			if ((LA14_0 == MULTIPLY)) {
				alt14 = 1;
			}
			else if ((LA14_0 == DIVISION)) {
				alt14 = 2;
			}

			else {
				NoViableAltException nvae =
						new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
			case 1:
			// CalcLab.g:159:47: MULTIPLY
			{
				MULTIPLY15 = (Token) match(input, MULTIPLY, FOLLOW_MULTIPLY_in_binaryOperationHigh443);
				value = operationFactory.createCommonOperation((MULTIPLY15 != null ? MULTIPLY15.getText() : null));
			}
				break;
			case 2:
			// CalcLab.g:161:4: DIVISION
			{
				DIVISION16 = (Token) match(input, DIVISION, FOLLOW_DIVISION_in_binaryOperationHigh454);
				value = operationFactory.createCommonOperation((DIVISION16 != null ? DIVISION16.getText() : null));
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
	// CalcLab.g:164:1: binaryOperationMiddle returns [Operation value] : INVOLUTION ;
	public final Operation binaryOperationMiddle() throws RecognitionException {
		Operation value = null;

		Token INVOLUTION17 = null;

		try {
			// CalcLab.g:164:47: ( INVOLUTION )
			// CalcLab.g:164:49: INVOLUTION
			{
				INVOLUTION17 = (Token) match(input, INVOLUTION, FOLLOW_INVOLUTION_in_binaryOperationMiddle469);
				value = operationFactory.createCommonOperation((INVOLUTION17 != null ? INVOLUTION17.getText() : null));
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
	// CalcLab.g:166:1: binaryOperationLow returns [Operation value] : ( PLUS | MINUS );
	public final Operation binaryOperationLow() throws RecognitionException {
		Operation value = null;

		Token PLUS18 = null;
		Token MINUS19 = null;

		try {
			// CalcLab.g:166:44: ( PLUS | MINUS )
			int alt15 = 2;
			int LA15_0 = input.LA(1);
			if ((LA15_0 == PLUS)) {
				alt15 = 1;
			}
			else if ((LA15_0 == MINUS)) {
				alt15 = 2;
			}

			else {
				NoViableAltException nvae =
						new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
			case 1:
			// CalcLab.g:166:46: PLUS
			{
				PLUS18 = (Token) match(input, PLUS, FOLLOW_PLUS_in_binaryOperationLow482);
				value = operationFactory.createCommonOperation((PLUS18 != null ? PLUS18.getText() : null));
			}
				break;
			case 2:
			// CalcLab.g:168:4: MINUS
			{
				MINUS19 = (Token) match(input, MINUS, FOLLOW_MINUS_in_binaryOperationLow492);
				value = operationFactory.createCommonOperation((MINUS19 != null ? MINUS19.getText() : null));
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
	public static final BitSet FOLLOW_variable_in_unit228 = new BitSet(new long[] { 0x0000000000001002L });
	public static final BitSet FOLLOW_function_in_unit236 = new BitSet(new long[] { 0x0000000000001002L });
	public static final BitSet FOLLOW_unaryOperation_in_unit246 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_number262 = new BitSet(new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_DIGIT_in_number265 = new BitSet(new long[] { 0x0000000000000082L });
	public static final BitSet FOLLOW_DECIMAL_SEPARATOR_in_number268 = new BitSet(new long[] { 0x0000000000000100L });
	public static final BitSet FOLLOW_DIGIT_in_number270 = new BitSet(new long[] { 0x0000000000000082L });
	public static final BitSet FOLLOW_MINUS_in_compositeExpression292 = new BitSet(new long[] { 0x0000000000080000L });
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_compositeExpression302 = new BitSet(
			new long[] { 0x00000000000A8100L });
	public static final BitSet FOLLOW_expression_in_compositeExpression304 = new BitSet(
			new long[] { 0x0000000000000040L });
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_compositeExpression306 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_function330 = new BitSet(new long[] { 0x0000000000020000L });
	public static final BitSet FOLLOW_NAME_in_function338 = new BitSet(new long[] { 0x0000000000080000L });
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_function340 = new BitSet(
			new long[] { 0x00000000000A8100L });
	public static final BitSet FOLLOW_arguments_in_function342 = new BitSet(new long[] { 0x0000000000000040L });
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_function344 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_variable367 = new BitSet(new long[] { 0x0000000000020000L });
	public static final BitSet FOLLOW_NAME_in_variable377 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expression_in_arguments401 = new BitSet(new long[] { 0x0000000000000012L });
	public static final BitSet FOLLOW_ARGUMENTS_SEPARATOR_in_arguments410 = new BitSet(
			new long[] { 0x00000000000A8100L });
	public static final BitSet FOLLOW_expression_in_arguments414 = new BitSet(new long[] { 0x0000000000000012L });
	public static final BitSet FOLLOW_FACTORIAL_in_unaryOperation430 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MULTIPLY_in_binaryOperationHigh443 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DIVISION_in_binaryOperationHigh454 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVOLUTION_in_binaryOperationMiddle469 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_PLUS_in_binaryOperationLow482 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_binaryOperationLow492 = new BitSet(new long[] { 0x0000000000000002L });
}
