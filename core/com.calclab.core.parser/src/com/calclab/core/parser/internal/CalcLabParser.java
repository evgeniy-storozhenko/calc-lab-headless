// $ANTLR 3.5.2 CalcLab.g 2015-09-06 16:55:29

package com.calclab.core.parser.internal;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.MismatchedSetException;
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
			"CLOSING_PARENTHESIS", "CLOSING_SQ_PARENTHESIS", "DECIMAL_SEPARATOR",
			"DIGIT", "DIVISION", "EQUALS", "EXPRESSIONS_SEPARATOR", "FACTORIAL", "HELP",
			"ID", "INVOLUTION", "MINUS", "MULTIPLY", "NAME", "OPENING_PARENTHESIS",
			"OPENING_SQ_PARENTHESIS", "PLUS", "REMAINDER", "S", "' '"
	};
	public static final int EOF = -1;
	public static final int T__25 = 25;
	public static final int ARGUMENTS_SEPARATOR = 4;
	public static final int CHAR = 5;
	public static final int CLOSING_PARENTHESIS = 6;
	public static final int CLOSING_SQ_PARENTHESIS = 7;
	public static final int DECIMAL_SEPARATOR = 8;
	public static final int DIGIT = 9;
	public static final int DIVISION = 10;
	public static final int EQUALS = 11;
	public static final int EXPRESSIONS_SEPARATOR = 12;
	public static final int FACTORIAL = 13;
	public static final int HELP = 14;
	public static final int ID = 15;
	public static final int INVOLUTION = 16;
	public static final int MINUS = 17;
	public static final int MULTIPLY = 18;
	public static final int NAME = 19;
	public static final int OPENING_PARENTHESIS = 20;
	public static final int OPENING_SQ_PARENTHESIS = 21;
	public static final int PLUS = 22;
	public static final int REMAINDER = 23;
	public static final int S = 24;

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
					if ((LA2_0 == DIGIT || LA2_0 == HELP || LA2_0 == MINUS
							|| (LA2_0 >= NAME && LA2_0 <= OPENING_SQ_PARENTHESIS) || LA2_0 == S)) {
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

							variable = (NAME1 != null ? NAME1.getText() : null).trim();
							in.append((NAME1 != null ? NAME1.getText() : null));
							in.append((EQUALS2 != null ? EQUALS2.getText() : null));

						}
							break;

						}

						pushFollow(FOLLOW_expression_in_calculation67);
						e = expression();
						state._fsp--;

						in.append((e != null ? input.toString(e.start, e.stop) : null));
						Calculable calculable = calcFactory.createCalculation(
								(e != null ? ((CalcLabParser.expression_return) e).value : null), in.toString());
						calculations.add(calculable);
						if (variable != null) {
							variables.put(variable, calculable);
						}

						match(input, EXPRESSIONS_SEPARATOR, FOLLOW_EXPRESSIONS_SEPARATOR_in_calculation73);
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
					pushFollow(FOLLOW_complexCompositeUnit_in_expression94);
					c1 = complexCompositeUnit();
					state._fsp--;

					retval.value = c1;
				}

				// CalcLab.g:79:3: (o= binaryOperationLow c2= complexCompositeUnit )*
				loop3: while (true) {
					int alt3 = 2;
					int LA3_0 = input.LA(1);
					if ((LA3_0 == MINUS || (LA3_0 >= PLUS && LA3_0 <= REMAINDER))) {
						alt3 = 1;
					}

					switch (alt3) {
					case 1:
					// CalcLab.g:79:4: o= binaryOperationLow c2= complexCompositeUnit
					{
						pushFollow(FOLLOW_binaryOperationLow_in_expression105);
						o = binaryOperationLow();
						state._fsp--;

						pushFollow(FOLLOW_complexCompositeUnit_in_expression109);
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
				pushFollow(FOLLOW_compositeUnit_in_complexCompositeUnit134);
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
						pushFollow(FOLLOW_binaryOperationMiddle_in_complexCompositeUnit144);
						o = binaryOperationMiddle();
						state._fsp--;

						pushFollow(FOLLOW_compositeUnit_in_complexCompositeUnit148);
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
				pushFollow(FOLLOW_unit_in_compositeUnit173);
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
						pushFollow(FOLLOW_binaryOperationHigh_in_compositeUnit181);
						binaryOperationHigh3 = binaryOperationHigh();
						state._fsp--;

						pushFollow(FOLLOW_unit_in_compositeUnit185);
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
	// CalcLab.g:100:1: unit returns [Operand value] : ( number | compositeExpression | help | functionOrVariable |
	// matrix ) (u= unaryOperation )? ;
	public final Operand unit() throws RecognitionException {
		Operand value = null;

		Operation u = null;
		ParserRuleReturnScope number4 = null;
		Operand compositeExpression5 = null;
		Operand help6 = null;
		Operand functionOrVariable7 = null;
		Operand matrix8 = null;

		try {
			// CalcLab.g:101:2: ( ( number | compositeExpression | help | functionOrVariable | matrix ) (u=
			// unaryOperation )? )
			// CalcLab.g:101:4: ( number | compositeExpression | help | functionOrVariable | matrix ) (u= unaryOperation
			// )?
			{
				// CalcLab.g:101:4: ( number | compositeExpression | help | functionOrVariable | matrix )
				int alt6 = 5;
				switch (input.LA(1)) {
				case MINUS: {
					switch (input.LA(2)) {
					case DIGIT:
					case S: {
						alt6 = 1;
					}
						break;
					case OPENING_PARENTHESIS: {
						alt6 = 2;
					}
						break;
					case NAME: {
						alt6 = 4;
					}
						break;
					case OPENING_SQ_PARENTHESIS: {
						alt6 = 5;
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
				case DIGIT:
				case S: {
					alt6 = 1;
				}
					break;
				case OPENING_PARENTHESIS: {
					alt6 = 2;
				}
					break;
				case HELP: {
					alt6 = 3;
				}
					break;
				case NAME: {
					alt6 = 4;
				}
					break;
				case OPENING_SQ_PARENTHESIS: {
					alt6 = 5;
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
					pushFollow(FOLLOW_number_in_unit211);
					number4 = number();
					state._fsp--;

					value = operandFactory.createNumber(
							(number4 != null ? input.toString(number4.start, number4.stop) : null).trim());
				}
					break;
				case 2:
				// CalcLab.g:102:5: compositeExpression
				{
					pushFollow(FOLLOW_compositeExpression_in_unit220);
					compositeExpression5 = compositeExpression();
					state._fsp--;

					value = compositeExpression5;
				}
					break;
				case 3:
				// CalcLab.g:103:5: help
				{
					pushFollow(FOLLOW_help_in_unit228);
					help6 = help();
					state._fsp--;

					value = help6;
				}
					break;
				case 4:
				// CalcLab.g:104:5: functionOrVariable
				{
					pushFollow(FOLLOW_functionOrVariable_in_unit237);
					functionOrVariable7 = functionOrVariable();
					state._fsp--;

					value = functionOrVariable7;
				}
					break;
				case 5:
				// CalcLab.g:105:5: matrix
				{
					pushFollow(FOLLOW_matrix_in_unit245);
					matrix8 = matrix();
					state._fsp--;

					value = matrix8;
				}
					break;

				}

				// CalcLab.g:106:4: (u= unaryOperation )?
				int alt7 = 2;
				int LA7_0 = input.LA(1);
				if ((LA7_0 == FACTORIAL)) {
					alt7 = 1;
				}
				switch (alt7) {
				case 1:
				// CalcLab.g:106:5: u= unaryOperation
				{
					pushFollow(FOLLOW_unaryOperation_in_unit255);
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
	// CalcLab.g:109:1: number : ( MINUS )? ( S )* DIGIT ( DECIMAL_SEPARATOR DIGIT )* ( S )* ;
	public final CalcLabParser.number_return number() throws RecognitionException {
		CalcLabParser.number_return retval = new CalcLabParser.number_return();
		retval.start = input.LT(1);

		try {
			// CalcLab.g:110:2: ( ( MINUS )? ( S )* DIGIT ( DECIMAL_SEPARATOR DIGIT )* ( S )* )
			// CalcLab.g:110:4: ( MINUS )? ( S )* DIGIT ( DECIMAL_SEPARATOR DIGIT )* ( S )*
			{
				// CalcLab.g:110:4: ( MINUS )?
				int alt8 = 2;
				int LA8_0 = input.LA(1);
				if ((LA8_0 == MINUS)) {
					alt8 = 1;
				}
				switch (alt8) {
				case 1:
				// CalcLab.g:110:4: MINUS
				{
					match(input, MINUS, FOLLOW_MINUS_in_number270);
				}
					break;

				}

				// CalcLab.g:110:11: ( S )*
				loop9: while (true) {
					int alt9 = 2;
					int LA9_0 = input.LA(1);
					if ((LA9_0 == S)) {
						alt9 = 1;
					}

					switch (alt9) {
					case 1:
					// CalcLab.g:110:11: S
					{
						match(input, S, FOLLOW_S_in_number273);
					}
						break;

					default:
						break loop9;
					}
				}

				match(input, DIGIT, FOLLOW_DIGIT_in_number276);
				// CalcLab.g:110:20: ( DECIMAL_SEPARATOR DIGIT )*
				loop10: while (true) {
					int alt10 = 2;
					int LA10_0 = input.LA(1);
					if ((LA10_0 == DECIMAL_SEPARATOR)) {
						alt10 = 1;
					}

					switch (alt10) {
					case 1:
					// CalcLab.g:110:21: DECIMAL_SEPARATOR DIGIT
					{
						match(input, DECIMAL_SEPARATOR, FOLLOW_DECIMAL_SEPARATOR_in_number279);
						match(input, DIGIT, FOLLOW_DIGIT_in_number281);
					}
						break;

					default:
						break loop10;
					}
				}

				// CalcLab.g:110:47: ( S )*
				loop11: while (true) {
					int alt11 = 2;
					int LA11_0 = input.LA(1);
					if ((LA11_0 == S)) {
						alt11 = 1;
					}

					switch (alt11) {
					case 1:
					// CalcLab.g:110:47: S
					{
						match(input, S, FOLLOW_S_in_number285);
					}
						break;

					default:
						break loop11;
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
	// CalcLab.g:113:1: compositeExpression returns [Operand value] : ( MINUS )? OPENING_PARENTHESIS expression
	// CLOSING_PARENTHESIS ;
	public final Operand compositeExpression() throws RecognitionException {
		Operand value = null;

		Token MINUS9 = null;
		ParserRuleReturnScope expression10 = null;

		try {
			// CalcLab.g:114:2: ( ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS )
			// CalcLab.g:114:4: ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS
			{
				Operation operation = null;
				// CalcLab.g:115:3: ( MINUS )?
				int alt12 = 2;
				int LA12_0 = input.LA(1);
				if ((LA12_0 == MINUS)) {
					alt12 = 1;
				}
				switch (alt12) {
				case 1:
				// CalcLab.g:115:4: MINUS
				{
					MINUS9 = (Token) match(input, MINUS, FOLLOW_MINUS_in_compositeExpression306);
					operation = operationFactory.createCommonOperation((MINUS9 != null ? MINUS9.getText() : null));
				}
					break;

				}

				match(input, OPENING_PARENTHESIS, FOLLOW_OPENING_PARENTHESIS_in_compositeExpression316);
				pushFollow(FOLLOW_expression_in_compositeExpression318);
				expression10 = expression();
				state._fsp--;

				match(input, CLOSING_PARENTHESIS, FOLLOW_CLOSING_PARENTHESIS_in_compositeExpression320);
				if (operation == null)
					value = (expression10 != null ? ((CalcLabParser.expression_return) expression10).value : null);
				else
					value = operandFactory.createUnaryOperand(operation,
							(expression10 != null ? ((CalcLabParser.expression_return) expression10).value : null));
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
	// CalcLab.g:121:1: functionOrVariable returns [Operand value] : ( MINUS )? name= NAME ( OPENING_PARENTHESIS
	// arguments CLOSING_PARENTHESIS )? ;
	public final Operand functionOrVariable() throws RecognitionException {
		Operand value = null;

		Token name = null;
		Token MINUS11 = null;
		ArrayList<Operand> arguments12 = null;

		try {
			// CalcLab.g:122:2: ( ( MINUS )? name= NAME ( OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS )? )
			// CalcLab.g:122:4: ( MINUS )? name= NAME ( OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS )?
			{
				Operation operation = null;
				boolean isVariable = true;
				// CalcLab.g:123:3: ( MINUS )?
				int alt13 = 2;
				int LA13_0 = input.LA(1);
				if ((LA13_0 == MINUS)) {
					alt13 = 1;
				}
				switch (alt13) {
				case 1:
				// CalcLab.g:123:4: MINUS
				{
					MINUS11 = (Token) match(input, MINUS, FOLLOW_MINUS_in_functionOrVariable343);
					operation = operationFactory.createCommonOperation((MINUS11 != null ? MINUS11.getText() : null));
				}
					break;

				}

				name = (Token) match(input, NAME, FOLLOW_NAME_in_functionOrVariable353);
				// CalcLab.g:124:13: ( OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS )?
				int alt14 = 2;
				int LA14_0 = input.LA(1);
				if ((LA14_0 == OPENING_PARENTHESIS)) {
					alt14 = 1;
				}
				switch (alt14) {
				case 1:
				// CalcLab.g:124:14: OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS
				{
					match(input, OPENING_PARENTHESIS, FOLLOW_OPENING_PARENTHESIS_in_functionOrVariable356);
					pushFollow(FOLLOW_arguments_in_functionOrVariable358);
					arguments12 = arguments();
					state._fsp--;

					match(input, CLOSING_PARENTHESIS, FOLLOW_CLOSING_PARENTHESIS_in_functionOrVariable360);
					isVariable = false;
				}
					break;

				}

				if (isVariable) {
					Calculable variable = variables.get((name != null ? name.getText() : null).trim());
					if (variable != null) {
						value = operandFactory.createVariableOperand((name != null ? name.getText() : null).trim(),
								variable);
					} else {
						String msg = "The variable '" + (name != null ? name.getText() : null).trim()
								+ "' is not defined.";
						throw new SyntaxErrorException((name != null ? name.getLine() : 0),
								name.getCharPositionInLine(), msg);
					}
					if (operation != null) {
						value = operandFactory.createUnaryOperand(operation, value);
					}
				} else {
					value = operandFactory.createFunctionOperand((name != null ? name.getText() : null).trim(),
							arguments12);
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
	// CalcLab.g:146:1: arguments returns [ArrayList<Operand> value] :e1= expression ( ARGUMENTS_SEPARATOR e2=
	// expression )* ;
	public final ArrayList<Operand> arguments() throws RecognitionException {
		ArrayList<Operand> value = null;

		ParserRuleReturnScope e1 = null;
		ParserRuleReturnScope e2 = null;

		try {
			// CalcLab.g:147:2: (e1= expression ( ARGUMENTS_SEPARATOR e2= expression )* )
			// CalcLab.g:147:4: e1= expression ( ARGUMENTS_SEPARATOR e2= expression )*
			{
				value = new ArrayList<Operand>();
				pushFollow(FOLLOW_expression_in_arguments387);
				e1 = expression();
				state._fsp--;

				value.add((e1 != null ? ((CalcLabParser.expression_return) e1).value : null));
				// CalcLab.g:149:4: ( ARGUMENTS_SEPARATOR e2= expression )*
				loop15: while (true) {
					int alt15 = 2;
					int LA15_0 = input.LA(1);
					if ((LA15_0 == ARGUMENTS_SEPARATOR)) {
						alt15 = 1;
					}

					switch (alt15) {
					case 1:
					// CalcLab.g:149:5: ARGUMENTS_SEPARATOR e2= expression
					{
						match(input, ARGUMENTS_SEPARATOR, FOLLOW_ARGUMENTS_SEPARATOR_in_arguments396);
						pushFollow(FOLLOW_expression_in_arguments400);
						e2 = expression();
						state._fsp--;

						value.add((e2 != null ? ((CalcLabParser.expression_return) e2).value : null));
					}
						break;

					default:
						break loop15;
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

	// $ANTLR start "matrix"
	// CalcLab.g:153:1: matrix returns [Operand value] : ( MINUS )? OPENING_SQ_PARENTHESIS matrixRows
	// CLOSING_SQ_PARENTHESIS ;
	public final Operand matrix() throws RecognitionException {
		Operand value = null;

		Token MINUS13 = null;
		Operand matrixRows14 = null;

		try {
			// CalcLab.g:154:2: ( ( MINUS )? OPENING_SQ_PARENTHESIS matrixRows CLOSING_SQ_PARENTHESIS )
			// CalcLab.g:154:4: ( MINUS )? OPENING_SQ_PARENTHESIS matrixRows CLOSING_SQ_PARENTHESIS
			{
				Operation operation = null;
				// CalcLab.g:155:3: ( MINUS )?
				int alt16 = 2;
				int LA16_0 = input.LA(1);
				if ((LA16_0 == MINUS)) {
					alt16 = 1;
				}
				switch (alt16) {
				case 1:
				// CalcLab.g:155:4: MINUS
				{
					MINUS13 = (Token) match(input, MINUS, FOLLOW_MINUS_in_matrix424);
					operation = operationFactory.createCommonOperation((MINUS13 != null ? MINUS13.getText() : null));
				}
					break;

				}

				match(input, OPENING_SQ_PARENTHESIS, FOLLOW_OPENING_SQ_PARENTHESIS_in_matrix434);
				pushFollow(FOLLOW_matrixRows_in_matrix436);
				matrixRows14 = matrixRows();
				state._fsp--;

				match(input, CLOSING_SQ_PARENTHESIS, FOLLOW_CLOSING_SQ_PARENTHESIS_in_matrix438);
				if (operation == null)
					value = matrixRows14;
				else
					value = operandFactory.createUnaryOperand(operation, matrixRows14);
			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "matrix"

	// $ANTLR start "matrixRows"
	// CalcLab.g:161:1: matrixRows returns [Operand value] :a1= matrixColumns ( EXPRESSIONS_SEPARATOR a2= matrixColumns
	// )* ;
	public final Operand matrixRows() throws RecognitionException {
		Operand value = null;

		ArrayList<Operand> a1 = null;
		ArrayList<Operand> a2 = null;

		try {
			// CalcLab.g:162:2: (a1= matrixColumns ( EXPRESSIONS_SEPARATOR a2= matrixColumns )* )
			// CalcLab.g:162:4: a1= matrixColumns ( EXPRESSIONS_SEPARATOR a2= matrixColumns )*
			{
				ArrayList<Operand[]> argsList = new ArrayList<Operand[]>();
				pushFollow(FOLLOW_matrixColumns_in_matrixRows461);
				a1 = matrixColumns();
				state._fsp--;

				argsList.add(a1.toArray(new Operand[1]));
				// CalcLab.g:164:4: ( EXPRESSIONS_SEPARATOR a2= matrixColumns )*
				loop17: while (true) {
					int alt17 = 2;
					int LA17_0 = input.LA(1);
					if ((LA17_0 == EXPRESSIONS_SEPARATOR)) {
						alt17 = 1;
					}

					switch (alt17) {
					case 1:
					// CalcLab.g:164:5: EXPRESSIONS_SEPARATOR a2= matrixColumns
					{
						match(input, EXPRESSIONS_SEPARATOR, FOLLOW_EXPRESSIONS_SEPARATOR_in_matrixRows470);
						pushFollow(FOLLOW_matrixColumns_in_matrixRows474);
						a2 = matrixColumns();
						state._fsp--;

						argsList.add(a2.toArray(new Operand[1]));
					}
						break;

					default:
						break loop17;
					}
				}

				value = operandFactory.createMatrix(argsList.toArray(new Operand[1][]));
			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "matrixRows"

	// $ANTLR start "matrixColumns"
	// CalcLab.g:168:1: matrixColumns returns [ArrayList<Operand> value] :e1= expression ( ( ' ' | ARGUMENTS_SEPARATOR )
	// e2= expression )* ;
	public final ArrayList<Operand> matrixColumns() throws RecognitionException {
		ArrayList<Operand> value = null;

		ParserRuleReturnScope e1 = null;
		ParserRuleReturnScope e2 = null;

		try {
			// CalcLab.g:169:2: (e1= expression ( ( ' ' | ARGUMENTS_SEPARATOR ) e2= expression )* )
			// CalcLab.g:169:4: e1= expression ( ( ' ' | ARGUMENTS_SEPARATOR ) e2= expression )*
			{
				value = new ArrayList<Operand>();
				pushFollow(FOLLOW_expression_in_matrixColumns500);
				e1 = expression();
				state._fsp--;

				value.add((e1 != null ? ((CalcLabParser.expression_return) e1).value : null));
				// CalcLab.g:171:4: ( ( ' ' | ARGUMENTS_SEPARATOR ) e2= expression )*
				loop18: while (true) {
					int alt18 = 2;
					int LA18_0 = input.LA(1);
					if ((LA18_0 == ARGUMENTS_SEPARATOR || LA18_0 == 25)) {
						alt18 = 1;
					}

					switch (alt18) {
					case 1:
					// CalcLab.g:171:5: ( ' ' | ARGUMENTS_SEPARATOR ) e2= expression
					{
						if (input.LA(1) == ARGUMENTS_SEPARATOR || input.LA(1) == 25) {
							input.consume();
							state.errorRecovery = false;
						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							throw mse;
						}
						pushFollow(FOLLOW_expression_in_matrixColumns519);
						e2 = expression();
						state._fsp--;

						value.add((e2 != null ? ((CalcLabParser.expression_return) e2).value : null));
					}
						break;

					default:
						break loop18;
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
	// $ANTLR end "matrixColumns"

	// $ANTLR start "help"
	// CalcLab.g:174:1: help returns [Operand value] : HELP ( NAME )? ;
	public final Operand help() throws RecognitionException {
		Operand value = null;

		Token NAME15 = null;
		Token HELP16 = null;

		try {
			// CalcLab.g:175:2: ( HELP ( NAME )? )
			// CalcLab.g:175:4: HELP ( NAME )?
			{
				List<Operand> arguments = new ArrayList<Operand>();
				HELP16 = (Token) match(input, HELP, FOLLOW_HELP_in_help541);
				// CalcLab.g:176:8: ( NAME )?
				int alt19 = 2;
				int LA19_0 = input.LA(1);
				if ((LA19_0 == NAME)) {
					alt19 = 1;
				}
				switch (alt19) {
				case 1:
				// CalcLab.g:176:9: NAME
				{
					NAME15 = (Token) match(input, NAME, FOLLOW_NAME_in_help544);

					Operand arg = operandFactory.createStringOperand((NAME15 != null ? NAME15.getText() : null).trim());
					arguments.add(arg);

				}
					break;

				}

				value = operandFactory.createFunctionOperand((HELP16 != null ? HELP16.getText() : null).trim(),
						arguments);
			}

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
		} finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "help"

	// $ANTLR start "unaryOperation"
	// CalcLab.g:184:1: unaryOperation returns [Operation value] : FACTORIAL ;
	public final Operation unaryOperation() throws RecognitionException {
		Operation value = null;

		Token FACTORIAL17 = null;

		try {
			// CalcLab.g:184:40: ( FACTORIAL )
			// CalcLab.g:184:42: FACTORIAL
			{
				FACTORIAL17 = (Token) match(input, FACTORIAL, FOLLOW_FACTORIAL_in_unaryOperation565);
				value = operationFactory.createCommonOperation((FACTORIAL17 != null ? FACTORIAL17.getText() : null));
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
	// CalcLab.g:186:1: binaryOperationHigh returns [Operation value] : ( MULTIPLY | DIVISION );
	public final Operation binaryOperationHigh() throws RecognitionException {
		Operation value = null;

		Token MULTIPLY18 = null;
		Token DIVISION19 = null;

		try {
			// CalcLab.g:186:45: ( MULTIPLY | DIVISION )
			int alt20 = 2;
			int LA20_0 = input.LA(1);
			if ((LA20_0 == MULTIPLY)) {
				alt20 = 1;
			} else if ((LA20_0 == DIVISION)) {
				alt20 = 2;
			}

			else {
				NoViableAltException nvae = new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
			case 1:
			// CalcLab.g:186:47: MULTIPLY
			{
				MULTIPLY18 = (Token) match(input, MULTIPLY, FOLLOW_MULTIPLY_in_binaryOperationHigh578);
				value = operationFactory.createCommonOperation((MULTIPLY18 != null ? MULTIPLY18.getText() : null));
			}
				break;
			case 2:
			// CalcLab.g:188:4: DIVISION
			{
				DIVISION19 = (Token) match(input, DIVISION, FOLLOW_DIVISION_in_binaryOperationHigh589);
				value = operationFactory.createCommonOperation((DIVISION19 != null ? DIVISION19.getText() : null));
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
	// CalcLab.g:191:1: binaryOperationMiddle returns [Operation value] : INVOLUTION ;
	public final Operation binaryOperationMiddle() throws RecognitionException {
		Operation value = null;

		Token INVOLUTION20 = null;

		try {
			// CalcLab.g:191:47: ( INVOLUTION )
			// CalcLab.g:191:49: INVOLUTION
			{
				INVOLUTION20 = (Token) match(input, INVOLUTION, FOLLOW_INVOLUTION_in_binaryOperationMiddle604);
				value = operationFactory.createCommonOperation((INVOLUTION20 != null ? INVOLUTION20.getText() : null));
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
	// CalcLab.g:193:1: binaryOperationLow returns [Operation value] : ( PLUS | MINUS | REMAINDER );
	public final Operation binaryOperationLow() throws RecognitionException {
		Operation value = null;

		Token PLUS21 = null;
		Token MINUS22 = null;
		Token REMAINDER23 = null;

		try {
			// CalcLab.g:193:44: ( PLUS | MINUS | REMAINDER )
			int alt21 = 3;
			switch (input.LA(1)) {
			case PLUS: {
				alt21 = 1;
			}
				break;
			case MINUS: {
				alt21 = 2;
			}
				break;
			case REMAINDER: {
				alt21 = 3;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 21, 0, input);
				throw nvae;
			}
			switch (alt21) {
			case 1:
			// CalcLab.g:193:46: PLUS
			{
				PLUS21 = (Token) match(input, PLUS, FOLLOW_PLUS_in_binaryOperationLow617);
				value = operationFactory.createCommonOperation((PLUS21 != null ? PLUS21.getText() : null));
			}
				break;
			case 2:
			// CalcLab.g:195:4: MINUS
			{
				MINUS22 = (Token) match(input, MINUS, FOLLOW_MINUS_in_binaryOperationLow627);
				value = operationFactory.createCommonOperation((MINUS22 != null ? MINUS22.getText() : null));
			}
				break;
			case 3:
			// CalcLab.g:197:4: REMAINDER
			{
				REMAINDER23 = (Token) match(input, REMAINDER, FOLLOW_REMAINDER_in_binaryOperationLow636);
				value = operationFactory.createCommonOperation((REMAINDER23 != null ? REMAINDER23.getText() : null));
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

	public static final BitSet FOLLOW_NAME_in_calculation55 = new BitSet(new long[] { 0x0000000000000800L });
	public static final BitSet FOLLOW_EQUALS_in_calculation57 = new BitSet(new long[] { 0x00000000013A4200L });
	public static final BitSet FOLLOW_expression_in_calculation67 = new BitSet(new long[] { 0x0000000000001000L });
	public static final BitSet FOLLOW_EXPRESSIONS_SEPARATOR_in_calculation73 = new BitSet(
			new long[] { 0x00000000013A4202L });
	public static final BitSet FOLLOW_complexCompositeUnit_in_expression94 = new BitSet(
			new long[] { 0x0000000000C20002L });
	public static final BitSet FOLLOW_binaryOperationLow_in_expression105 = new BitSet(
			new long[] { 0x00000000013A4200L });
	public static final BitSet FOLLOW_complexCompositeUnit_in_expression109 = new BitSet(
			new long[] { 0x0000000000C20002L });
	public static final BitSet FOLLOW_compositeUnit_in_complexCompositeUnit134 = new BitSet(
			new long[] { 0x0000000000010002L });
	public static final BitSet FOLLOW_binaryOperationMiddle_in_complexCompositeUnit144 = new BitSet(
			new long[] { 0x00000000013A4200L });
	public static final BitSet FOLLOW_compositeUnit_in_complexCompositeUnit148 = new BitSet(
			new long[] { 0x0000000000010002L });
	public static final BitSet FOLLOW_unit_in_compositeUnit173 = new BitSet(new long[] { 0x0000000000040402L });
	public static final BitSet FOLLOW_binaryOperationHigh_in_compositeUnit181 = new BitSet(
			new long[] { 0x00000000013A4200L });
	public static final BitSet FOLLOW_unit_in_compositeUnit185 = new BitSet(new long[] { 0x0000000000040402L });
	public static final BitSet FOLLOW_number_in_unit211 = new BitSet(new long[] { 0x0000000000002002L });
	public static final BitSet FOLLOW_compositeExpression_in_unit220 = new BitSet(new long[] { 0x0000000000002002L });
	public static final BitSet FOLLOW_help_in_unit228 = new BitSet(new long[] { 0x0000000000002002L });
	public static final BitSet FOLLOW_functionOrVariable_in_unit237 = new BitSet(new long[] { 0x0000000000002002L });
	public static final BitSet FOLLOW_matrix_in_unit245 = new BitSet(new long[] { 0x0000000000002002L });
	public static final BitSet FOLLOW_unaryOperation_in_unit255 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_number270 = new BitSet(new long[] { 0x0000000001000200L });
	public static final BitSet FOLLOW_S_in_number273 = new BitSet(new long[] { 0x0000000001000200L });
	public static final BitSet FOLLOW_DIGIT_in_number276 = new BitSet(new long[] { 0x0000000001000102L });
	public static final BitSet FOLLOW_DECIMAL_SEPARATOR_in_number279 = new BitSet(new long[] { 0x0000000000000200L });
	public static final BitSet FOLLOW_DIGIT_in_number281 = new BitSet(new long[] { 0x0000000001000102L });
	public static final BitSet FOLLOW_S_in_number285 = new BitSet(new long[] { 0x0000000001000002L });
	public static final BitSet FOLLOW_MINUS_in_compositeExpression306 = new BitSet(new long[] { 0x0000000000100000L });
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_compositeExpression316 = new BitSet(
			new long[] { 0x00000000013A4200L });
	public static final BitSet FOLLOW_expression_in_compositeExpression318 = new BitSet(
			new long[] { 0x0000000000000040L });
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_compositeExpression320 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_functionOrVariable343 = new BitSet(new long[] { 0x0000000000080000L });
	public static final BitSet FOLLOW_NAME_in_functionOrVariable353 = new BitSet(new long[] { 0x0000000000100002L });
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_functionOrVariable356 = new BitSet(
			new long[] { 0x00000000013A4200L });
	public static final BitSet FOLLOW_arguments_in_functionOrVariable358 = new BitSet(
			new long[] { 0x0000000000000040L });
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_functionOrVariable360 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expression_in_arguments387 = new BitSet(new long[] { 0x0000000000000012L });
	public static final BitSet FOLLOW_ARGUMENTS_SEPARATOR_in_arguments396 = new BitSet(
			new long[] { 0x00000000013A4200L });
	public static final BitSet FOLLOW_expression_in_arguments400 = new BitSet(new long[] { 0x0000000000000012L });
	public static final BitSet FOLLOW_MINUS_in_matrix424 = new BitSet(new long[] { 0x0000000000200000L });
	public static final BitSet FOLLOW_OPENING_SQ_PARENTHESIS_in_matrix434 = new BitSet(
			new long[] { 0x00000000013A4200L });
	public static final BitSet FOLLOW_matrixRows_in_matrix436 = new BitSet(new long[] { 0x0000000000000080L });
	public static final BitSet FOLLOW_CLOSING_SQ_PARENTHESIS_in_matrix438 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_matrixColumns_in_matrixRows461 = new BitSet(new long[] { 0x0000000000001002L });
	public static final BitSet FOLLOW_EXPRESSIONS_SEPARATOR_in_matrixRows470 = new BitSet(
			new long[] { 0x00000000013A4200L });
	public static final BitSet FOLLOW_matrixColumns_in_matrixRows474 = new BitSet(new long[] { 0x0000000000001002L });
	public static final BitSet FOLLOW_expression_in_matrixColumns500 = new BitSet(new long[] { 0x0000000002000012L });
	public static final BitSet FOLLOW_set_in_matrixColumns509 = new BitSet(new long[] { 0x00000000013A4200L });
	public static final BitSet FOLLOW_expression_in_matrixColumns519 = new BitSet(new long[] { 0x0000000002000012L });
	public static final BitSet FOLLOW_HELP_in_help541 = new BitSet(new long[] { 0x0000000000080002L });
	public static final BitSet FOLLOW_NAME_in_help544 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_FACTORIAL_in_unaryOperation565 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MULTIPLY_in_binaryOperationHigh578 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DIVISION_in_binaryOperationHigh589 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVOLUTION_in_binaryOperationMiddle604 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_PLUS_in_binaryOperationLow617 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_binaryOperationLow627 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_REMAINDER_in_binaryOperationLow636 = new BitSet(
			new long[] { 0x0000000000000002L });
}
