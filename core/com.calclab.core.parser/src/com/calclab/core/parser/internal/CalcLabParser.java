// $ANTLR 3.5.2 CalcLab.g 2015-08-31 11:57:25

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
			"DIGIT", "DIVISION", "EQUALS", "EXPRESSIONS_SEPARATOR", "FACTORIAL", "ID",
			"INVOLUTION", "MINUS", "MULTIPLY", "NAME", "OPENING_PARENTHESIS", "OPENING_SQ_PARENTHESIS",
			"PLUS", "REMAINDER", "S", "' '"
	};
	public static final int EOF = -1;
	public static final int T__24 = 24;
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
	public static final int ID = 14;
	public static final int INVOLUTION = 15;
	public static final int MINUS = 16;
	public static final int MULTIPLY = 17;
	public static final int NAME = 18;
	public static final int OPENING_PARENTHESIS = 19;
	public static final int OPENING_SQ_PARENTHESIS = 20;
	public static final int PLUS = 21;
	public static final int REMAINDER = 22;
	public static final int S = 23;

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
					if ((LA2_0 == DIGIT || LA2_0 == MINUS || (LA2_0 >= NAME && LA2_0 <= OPENING_SQ_PARENTHESIS)
							|| LA2_0 == S)) {
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
	// CalcLab.g:100:1: unit returns [Operand value] : ( number | compositeExpression | functionOrVariable | matrix )
	// (u= unaryOperation )? ;
	public final Operand unit() throws RecognitionException {
		Operand value = null;

		Operation u = null;
		ParserRuleReturnScope number4 = null;
		Operand compositeExpression5 = null;
		Operand functionOrVariable6 = null;
		Operand matrix7 = null;

		try {
			// CalcLab.g:101:2: ( ( number | compositeExpression | functionOrVariable | matrix ) (u= unaryOperation )? )
			// CalcLab.g:101:4: ( number | compositeExpression | functionOrVariable | matrix ) (u= unaryOperation )?
			{
				// CalcLab.g:101:4: ( number | compositeExpression | functionOrVariable | matrix )
				int alt6 = 4;
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
						alt6 = 3;
					}
						break;
					case OPENING_SQ_PARENTHESIS: {
						alt6 = 4;
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
				case NAME: {
					alt6 = 3;
				}
					break;
				case OPENING_SQ_PARENTHESIS: {
					alt6 = 4;
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
				// CalcLab.g:103:5: functionOrVariable
				{
					pushFollow(FOLLOW_functionOrVariable_in_unit229);
					functionOrVariable6 = functionOrVariable();
					state._fsp--;

					value = functionOrVariable6;
				}
					break;
				case 4:
				// CalcLab.g:104:5: matrix
				{
					pushFollow(FOLLOW_matrix_in_unit237);
					matrix7 = matrix();
					state._fsp--;

					value = matrix7;
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
					pushFollow(FOLLOW_unaryOperation_in_unit247);
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
	// CalcLab.g:108:1: number : ( MINUS )? ( S )* DIGIT ( DECIMAL_SEPARATOR DIGIT )* ( S )* ;
	public final CalcLabParser.number_return number() throws RecognitionException {
		CalcLabParser.number_return retval = new CalcLabParser.number_return();
		retval.start = input.LT(1);

		try {
			// CalcLab.g:109:2: ( ( MINUS )? ( S )* DIGIT ( DECIMAL_SEPARATOR DIGIT )* ( S )* )
			// CalcLab.g:109:4: ( MINUS )? ( S )* DIGIT ( DECIMAL_SEPARATOR DIGIT )* ( S )*
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

				// CalcLab.g:109:11: ( S )*
				loop9: while (true) {
					int alt9 = 2;
					int LA9_0 = input.LA(1);
					if ((LA9_0 == S)) {
						alt9 = 1;
					}

					switch (alt9) {
					case 1:
					// CalcLab.g:109:11: S
					{
						match(input, S, FOLLOW_S_in_number265);
					}
						break;

					default:
						break loop9;
					}
				}

				match(input, DIGIT, FOLLOW_DIGIT_in_number268);
				// CalcLab.g:109:20: ( DECIMAL_SEPARATOR DIGIT )*
				loop10: while (true) {
					int alt10 = 2;
					int LA10_0 = input.LA(1);
					if ((LA10_0 == DECIMAL_SEPARATOR)) {
						alt10 = 1;
					}

					switch (alt10) {
					case 1:
					// CalcLab.g:109:21: DECIMAL_SEPARATOR DIGIT
					{
						match(input, DECIMAL_SEPARATOR, FOLLOW_DECIMAL_SEPARATOR_in_number271);
						match(input, DIGIT, FOLLOW_DIGIT_in_number273);
					}
						break;

					default:
						break loop10;
					}
				}

				// CalcLab.g:109:47: ( S )*
				loop11: while (true) {
					int alt11 = 2;
					int LA11_0 = input.LA(1);
					if ((LA11_0 == S)) {
						alt11 = 1;
					}

					switch (alt11) {
					case 1:
					// CalcLab.g:109:47: S
					{
						match(input, S, FOLLOW_S_in_number277);
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
				int alt12 = 2;
				int LA12_0 = input.LA(1);
				if ((LA12_0 == MINUS)) {
					alt12 = 1;
				}
				switch (alt12) {
				case 1:
				// CalcLab.g:114:4: MINUS
				{
					MINUS8 = (Token) match(input, MINUS, FOLLOW_MINUS_in_compositeExpression298);
					operation = operationFactory.createCommonOperation((MINUS8 != null ? MINUS8.getText() : null));
				}
					break;

				}

				match(input, OPENING_PARENTHESIS, FOLLOW_OPENING_PARENTHESIS_in_compositeExpression308);
				pushFollow(FOLLOW_expression_in_compositeExpression310);
				expression9 = expression();
				state._fsp--;

				match(input, CLOSING_PARENTHESIS, FOLLOW_CLOSING_PARENTHESIS_in_compositeExpression312);
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

	// $ANTLR start "functionOrVariable"
	// CalcLab.g:120:1: functionOrVariable returns [Operand value] : ( MINUS )? name= NAME ( OPENING_PARENTHESIS
	// arguments CLOSING_PARENTHESIS )? ;
	public final Operand functionOrVariable() throws RecognitionException {
		Operand value = null;

		Token name = null;
		Token MINUS10 = null;
		ArrayList<Operand> arguments11 = null;

		try {
			// CalcLab.g:121:2: ( ( MINUS )? name= NAME ( OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS )? )
			// CalcLab.g:121:4: ( MINUS )? name= NAME ( OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS )?
			{
				Operation operation = null;
				boolean isVariable = true;
				// CalcLab.g:122:3: ( MINUS )?
				int alt13 = 2;
				int LA13_0 = input.LA(1);
				if ((LA13_0 == MINUS)) {
					alt13 = 1;
				}
				switch (alt13) {
				case 1:
				// CalcLab.g:122:4: MINUS
				{
					MINUS10 = (Token) match(input, MINUS, FOLLOW_MINUS_in_functionOrVariable335);
					operation = operationFactory.createCommonOperation((MINUS10 != null ? MINUS10.getText() : null));
				}
					break;

				}

				name = (Token) match(input, NAME, FOLLOW_NAME_in_functionOrVariable345);
				// CalcLab.g:123:13: ( OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS )?
				int alt14 = 2;
				int LA14_0 = input.LA(1);
				if ((LA14_0 == OPENING_PARENTHESIS)) {
					alt14 = 1;
				}
				switch (alt14) {
				case 1:
				// CalcLab.g:123:14: OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS
				{
					match(input, OPENING_PARENTHESIS, FOLLOW_OPENING_PARENTHESIS_in_functionOrVariable348);
					pushFollow(FOLLOW_arguments_in_functionOrVariable350);
					arguments11 = arguments();
					state._fsp--;

					match(input, CLOSING_PARENTHESIS, FOLLOW_CLOSING_PARENTHESIS_in_functionOrVariable352);
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
							arguments11);
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
	// CalcLab.g:145:1: arguments returns [ArrayList<Operand> value] :e1= expression ( ARGUMENTS_SEPARATOR e2=
	// expression )* ;
	public final ArrayList<Operand> arguments() throws RecognitionException {
		ArrayList<Operand> value = null;

		ParserRuleReturnScope e1 = null;
		ParserRuleReturnScope e2 = null;

		try {
			// CalcLab.g:146:2: (e1= expression ( ARGUMENTS_SEPARATOR e2= expression )* )
			// CalcLab.g:146:4: e1= expression ( ARGUMENTS_SEPARATOR e2= expression )*
			{
				value = new ArrayList<Operand>();
				pushFollow(FOLLOW_expression_in_arguments379);
				e1 = expression();
				state._fsp--;

				value.add((e1 != null ? ((CalcLabParser.expression_return) e1).value : null));
				// CalcLab.g:148:4: ( ARGUMENTS_SEPARATOR e2= expression )*
				loop15: while (true) {
					int alt15 = 2;
					int LA15_0 = input.LA(1);
					if ((LA15_0 == ARGUMENTS_SEPARATOR)) {
						alt15 = 1;
					}

					switch (alt15) {
					case 1:
					// CalcLab.g:148:5: ARGUMENTS_SEPARATOR e2= expression
					{
						match(input, ARGUMENTS_SEPARATOR, FOLLOW_ARGUMENTS_SEPARATOR_in_arguments388);
						pushFollow(FOLLOW_expression_in_arguments392);
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
	// CalcLab.g:152:1: matrix returns [Operand value] : ( MINUS )? OPENING_SQ_PARENTHESIS matrixRows
	// CLOSING_SQ_PARENTHESIS ;
	public final Operand matrix() throws RecognitionException {
		Operand value = null;

		Token MINUS12 = null;
		Operand matrixRows13 = null;

		try {
			// CalcLab.g:153:2: ( ( MINUS )? OPENING_SQ_PARENTHESIS matrixRows CLOSING_SQ_PARENTHESIS )
			// CalcLab.g:153:4: ( MINUS )? OPENING_SQ_PARENTHESIS matrixRows CLOSING_SQ_PARENTHESIS
			{
				Operation operation = null;
				// CalcLab.g:154:3: ( MINUS )?
				int alt16 = 2;
				int LA16_0 = input.LA(1);
				if ((LA16_0 == MINUS)) {
					alt16 = 1;
				}
				switch (alt16) {
				case 1:
				// CalcLab.g:154:4: MINUS
				{
					MINUS12 = (Token) match(input, MINUS, FOLLOW_MINUS_in_matrix416);
					operation = operationFactory.createCommonOperation((MINUS12 != null ? MINUS12.getText() : null));
				}
					break;

				}

				match(input, OPENING_SQ_PARENTHESIS, FOLLOW_OPENING_SQ_PARENTHESIS_in_matrix426);
				pushFollow(FOLLOW_matrixRows_in_matrix428);
				matrixRows13 = matrixRows();
				state._fsp--;

				match(input, CLOSING_SQ_PARENTHESIS, FOLLOW_CLOSING_SQ_PARENTHESIS_in_matrix430);
				if (operation == null)
					value = matrixRows13;
				else
					value = operandFactory.createUnaryOperand(operation, matrixRows13);
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
	// CalcLab.g:160:1: matrixRows returns [Operand value] :a1= matrixColumns ( EXPRESSIONS_SEPARATOR a2= matrixColumns
	// )* ;
	public final Operand matrixRows() throws RecognitionException {
		Operand value = null;

		ArrayList<Operand> a1 = null;
		ArrayList<Operand> a2 = null;

		try {
			// CalcLab.g:161:2: (a1= matrixColumns ( EXPRESSIONS_SEPARATOR a2= matrixColumns )* )
			// CalcLab.g:161:4: a1= matrixColumns ( EXPRESSIONS_SEPARATOR a2= matrixColumns )*
			{
				ArrayList<Operand[]> argsList = new ArrayList<Operand[]>();
				pushFollow(FOLLOW_matrixColumns_in_matrixRows453);
				a1 = matrixColumns();
				state._fsp--;

				argsList.add(a1.toArray(new Operand[1]));
				// CalcLab.g:163:4: ( EXPRESSIONS_SEPARATOR a2= matrixColumns )*
				loop17: while (true) {
					int alt17 = 2;
					int LA17_0 = input.LA(1);
					if ((LA17_0 == EXPRESSIONS_SEPARATOR)) {
						alt17 = 1;
					}

					switch (alt17) {
					case 1:
					// CalcLab.g:163:5: EXPRESSIONS_SEPARATOR a2= matrixColumns
					{
						match(input, EXPRESSIONS_SEPARATOR, FOLLOW_EXPRESSIONS_SEPARATOR_in_matrixRows462);
						pushFollow(FOLLOW_matrixColumns_in_matrixRows466);
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
	// CalcLab.g:167:1: matrixColumns returns [ArrayList<Operand> value] :e1= expression ( ( ' ' | ARGUMENTS_SEPARATOR )
	// e2= expression )* ;
	public final ArrayList<Operand> matrixColumns() throws RecognitionException {
		ArrayList<Operand> value = null;

		ParserRuleReturnScope e1 = null;
		ParserRuleReturnScope e2 = null;

		try {
			// CalcLab.g:168:2: (e1= expression ( ( ' ' | ARGUMENTS_SEPARATOR ) e2= expression )* )
			// CalcLab.g:168:4: e1= expression ( ( ' ' | ARGUMENTS_SEPARATOR ) e2= expression )*
			{
				value = new ArrayList<Operand>();
				pushFollow(FOLLOW_expression_in_matrixColumns492);
				e1 = expression();
				state._fsp--;

				value.add((e1 != null ? ((CalcLabParser.expression_return) e1).value : null));
				// CalcLab.g:170:4: ( ( ' ' | ARGUMENTS_SEPARATOR ) e2= expression )*
				loop18: while (true) {
					int alt18 = 2;
					int LA18_0 = input.LA(1);
					if ((LA18_0 == ARGUMENTS_SEPARATOR || LA18_0 == 24)) {
						alt18 = 1;
					}

					switch (alt18) {
					case 1:
					// CalcLab.g:170:5: ( ' ' | ARGUMENTS_SEPARATOR ) e2= expression
					{
						if (input.LA(1) == ARGUMENTS_SEPARATOR || input.LA(1) == 24) {
							input.consume();
							state.errorRecovery = false;
						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							throw mse;
						}
						pushFollow(FOLLOW_expression_in_matrixColumns511);
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

	// $ANTLR start "unaryOperation"
	// CalcLab.g:174:1: unaryOperation returns [Operation value] : FACTORIAL ;
	public final Operation unaryOperation() throws RecognitionException {
		Operation value = null;

		Token FACTORIAL14 = null;

		try {
			// CalcLab.g:174:40: ( FACTORIAL )
			// CalcLab.g:174:42: FACTORIAL
			{
				FACTORIAL14 = (Token) match(input, FACTORIAL, FOLLOW_FACTORIAL_in_unaryOperation527);
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
	// CalcLab.g:176:1: binaryOperationHigh returns [Operation value] : ( MULTIPLY | DIVISION );
	public final Operation binaryOperationHigh() throws RecognitionException {
		Operation value = null;

		Token MULTIPLY15 = null;
		Token DIVISION16 = null;

		try {
			// CalcLab.g:176:45: ( MULTIPLY | DIVISION )
			int alt19 = 2;
			int LA19_0 = input.LA(1);
			if ((LA19_0 == MULTIPLY)) {
				alt19 = 1;
			} else if ((LA19_0 == DIVISION)) {
				alt19 = 2;
			}

			else {
				NoViableAltException nvae = new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
			case 1:
			// CalcLab.g:176:47: MULTIPLY
			{
				MULTIPLY15 = (Token) match(input, MULTIPLY, FOLLOW_MULTIPLY_in_binaryOperationHigh540);
				value = operationFactory.createCommonOperation((MULTIPLY15 != null ? MULTIPLY15.getText() : null));
			}
				break;
			case 2:
			// CalcLab.g:178:4: DIVISION
			{
				DIVISION16 = (Token) match(input, DIVISION, FOLLOW_DIVISION_in_binaryOperationHigh551);
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
	// CalcLab.g:181:1: binaryOperationMiddle returns [Operation value] : INVOLUTION ;
	public final Operation binaryOperationMiddle() throws RecognitionException {
		Operation value = null;

		Token INVOLUTION17 = null;

		try {
			// CalcLab.g:181:47: ( INVOLUTION )
			// CalcLab.g:181:49: INVOLUTION
			{
				INVOLUTION17 = (Token) match(input, INVOLUTION, FOLLOW_INVOLUTION_in_binaryOperationMiddle566);
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
	// CalcLab.g:183:1: binaryOperationLow returns [Operation value] : ( PLUS | MINUS | REMAINDER );
	public final Operation binaryOperationLow() throws RecognitionException {
		Operation value = null;

		Token PLUS18 = null;
		Token MINUS19 = null;
		Token REMAINDER20 = null;

		try {
			// CalcLab.g:183:44: ( PLUS | MINUS | REMAINDER )
			int alt20 = 3;
			switch (input.LA(1)) {
			case PLUS: {
				alt20 = 1;
			}
				break;
			case MINUS: {
				alt20 = 2;
			}
				break;
			case REMAINDER: {
				alt20 = 3;
			}
				break;
			default:
				NoViableAltException nvae = new NoViableAltException("", 20, 0, input);
				throw nvae;
			}
			switch (alt20) {
			case 1:
			// CalcLab.g:183:46: PLUS
			{
				PLUS18 = (Token) match(input, PLUS, FOLLOW_PLUS_in_binaryOperationLow579);
				value = operationFactory.createCommonOperation((PLUS18 != null ? PLUS18.getText() : null));
			}
				break;
			case 2:
			// CalcLab.g:185:4: MINUS
			{
				MINUS19 = (Token) match(input, MINUS, FOLLOW_MINUS_in_binaryOperationLow589);
				value = operationFactory.createCommonOperation((MINUS19 != null ? MINUS19.getText() : null));
			}
				break;
			case 3:
			// CalcLab.g:187:4: REMAINDER
			{
				REMAINDER20 = (Token) match(input, REMAINDER, FOLLOW_REMAINDER_in_binaryOperationLow598);
				value = operationFactory.createCommonOperation((REMAINDER20 != null ? REMAINDER20.getText() : null));
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
	public static final BitSet FOLLOW_EQUALS_in_calculation57 = new BitSet(new long[] { 0x00000000009D0200L });
	public static final BitSet FOLLOW_expression_in_calculation67 = new BitSet(new long[] { 0x0000000000001000L });
	public static final BitSet FOLLOW_EXPRESSIONS_SEPARATOR_in_calculation73 = new BitSet(
			new long[] { 0x00000000009D0202L });
	public static final BitSet FOLLOW_complexCompositeUnit_in_expression94 = new BitSet(
			new long[] { 0x0000000000610002L });
	public static final BitSet FOLLOW_binaryOperationLow_in_expression105 = new BitSet(
			new long[] { 0x00000000009D0200L });
	public static final BitSet FOLLOW_complexCompositeUnit_in_expression109 = new BitSet(
			new long[] { 0x0000000000610002L });
	public static final BitSet FOLLOW_compositeUnit_in_complexCompositeUnit134 = new BitSet(
			new long[] { 0x0000000000008002L });
	public static final BitSet FOLLOW_binaryOperationMiddle_in_complexCompositeUnit144 = new BitSet(
			new long[] { 0x00000000009D0200L });
	public static final BitSet FOLLOW_compositeUnit_in_complexCompositeUnit148 = new BitSet(
			new long[] { 0x0000000000008002L });
	public static final BitSet FOLLOW_unit_in_compositeUnit173 = new BitSet(new long[] { 0x0000000000020402L });
	public static final BitSet FOLLOW_binaryOperationHigh_in_compositeUnit181 = new BitSet(
			new long[] { 0x00000000009D0200L });
	public static final BitSet FOLLOW_unit_in_compositeUnit185 = new BitSet(new long[] { 0x0000000000020402L });
	public static final BitSet FOLLOW_number_in_unit211 = new BitSet(new long[] { 0x0000000000002002L });
	public static final BitSet FOLLOW_compositeExpression_in_unit220 = new BitSet(new long[] { 0x0000000000002002L });
	public static final BitSet FOLLOW_functionOrVariable_in_unit229 = new BitSet(new long[] { 0x0000000000002002L });
	public static final BitSet FOLLOW_matrix_in_unit237 = new BitSet(new long[] { 0x0000000000002002L });
	public static final BitSet FOLLOW_unaryOperation_in_unit247 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_number262 = new BitSet(new long[] { 0x0000000000800200L });
	public static final BitSet FOLLOW_S_in_number265 = new BitSet(new long[] { 0x0000000000800200L });
	public static final BitSet FOLLOW_DIGIT_in_number268 = new BitSet(new long[] { 0x0000000000800102L });
	public static final BitSet FOLLOW_DECIMAL_SEPARATOR_in_number271 = new BitSet(new long[] { 0x0000000000000200L });
	public static final BitSet FOLLOW_DIGIT_in_number273 = new BitSet(new long[] { 0x0000000000800102L });
	public static final BitSet FOLLOW_S_in_number277 = new BitSet(new long[] { 0x0000000000800002L });
	public static final BitSet FOLLOW_MINUS_in_compositeExpression298 = new BitSet(new long[] { 0x0000000000080000L });
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_compositeExpression308 = new BitSet(
			new long[] { 0x00000000009D0200L });
	public static final BitSet FOLLOW_expression_in_compositeExpression310 = new BitSet(
			new long[] { 0x0000000000000040L });
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_compositeExpression312 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_functionOrVariable335 = new BitSet(new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_NAME_in_functionOrVariable345 = new BitSet(new long[] { 0x0000000000080002L });
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_functionOrVariable348 = new BitSet(
			new long[] { 0x00000000009D0200L });
	public static final BitSet FOLLOW_arguments_in_functionOrVariable350 = new BitSet(
			new long[] { 0x0000000000000040L });
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_functionOrVariable352 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expression_in_arguments379 = new BitSet(new long[] { 0x0000000000000012L });
	public static final BitSet FOLLOW_ARGUMENTS_SEPARATOR_in_arguments388 = new BitSet(
			new long[] { 0x00000000009D0200L });
	public static final BitSet FOLLOW_expression_in_arguments392 = new BitSet(new long[] { 0x0000000000000012L });
	public static final BitSet FOLLOW_MINUS_in_matrix416 = new BitSet(new long[] { 0x0000000000100000L });
	public static final BitSet FOLLOW_OPENING_SQ_PARENTHESIS_in_matrix426 = new BitSet(
			new long[] { 0x00000000009D0200L });
	public static final BitSet FOLLOW_matrixRows_in_matrix428 = new BitSet(new long[] { 0x0000000000000080L });
	public static final BitSet FOLLOW_CLOSING_SQ_PARENTHESIS_in_matrix430 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_matrixColumns_in_matrixRows453 = new BitSet(new long[] { 0x0000000000001002L });
	public static final BitSet FOLLOW_EXPRESSIONS_SEPARATOR_in_matrixRows462 = new BitSet(
			new long[] { 0x00000000009D0200L });
	public static final BitSet FOLLOW_matrixColumns_in_matrixRows466 = new BitSet(new long[] { 0x0000000000001002L });
	public static final BitSet FOLLOW_expression_in_matrixColumns492 = new BitSet(new long[] { 0x0000000001000012L });
	public static final BitSet FOLLOW_set_in_matrixColumns501 = new BitSet(new long[] { 0x00000000009D0200L });
	public static final BitSet FOLLOW_expression_in_matrixColumns511 = new BitSet(new long[] { 0x0000000001000012L });
	public static final BitSet FOLLOW_FACTORIAL_in_unaryOperation527 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MULTIPLY_in_binaryOperationHigh540 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DIVISION_in_binaryOperationHigh551 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVOLUTION_in_binaryOperationMiddle566 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_PLUS_in_binaryOperationLow579 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_binaryOperationLow589 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_REMAINDER_in_binaryOperationLow598 = new BitSet(
			new long[] { 0x0000000000000002L });
}
