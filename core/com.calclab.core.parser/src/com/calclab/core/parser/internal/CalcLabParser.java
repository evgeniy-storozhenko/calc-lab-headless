// $ANTLR 3.5.2 CalcLab.g 2015-08-16 17:14:41

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
			"CLOSING_PARENTHESIS", "CLOSING_SQ_PARENTHESIS", "DECIMAL_SEPARATOR",
			"DIGIT", "DIVISION", "EQUALS", "EXPRESSIONS_SEPARATOR", "FACTORIAL", "ID",
			"INVOLUTION", "MINUS", "MULTIPLY", "NAME", "NEWLINE", "OPENING_PARENTHESIS",
			"OPENING_SQ_PARENTHESIS", "PLUS", "WS"
	};
	public static final int EOF = -1;
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
	public static final int NEWLINE = 19;
	public static final int OPENING_PARENTHESIS = 20;
	public static final int OPENING_SQ_PARENTHESIS = 21;
	public static final int PLUS = 22;
	public static final int WS = 23;

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
					if ((LA2_0 == DIGIT || LA2_0 == MINUS || LA2_0 == NAME
							|| (LA2_0 >= OPENING_PARENTHESIS && LA2_0 <= OPENING_SQ_PARENTHESIS))) {
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
				case 4:
				// CalcLab.g:104:5: matrix
				{
					pushFollow(FOLLOW_matrix_in_unit236);
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
				int alt11 = 2;
				int LA11_0 = input.LA(1);
				if ((LA11_0 == MINUS)) {
					alt11 = 1;
				}
				switch (alt11) {
				case 1:
				// CalcLab.g:122:4: MINUS
				{
					MINUS10 = (Token) match(input, MINUS, FOLLOW_MINUS_in_functionOrVariable329);
					operation = operationFactory.createCommonOperation((MINUS10 != null ? MINUS10.getText() : null));
				}
					break;

				}

				name = (Token) match(input, NAME, FOLLOW_NAME_in_functionOrVariable339);
				// CalcLab.g:123:13: ( OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS )?
				int alt12 = 2;
				int LA12_0 = input.LA(1);
				if ((LA12_0 == OPENING_PARENTHESIS)) {
					alt12 = 1;
				}
				switch (alt12) {
				case 1:
				// CalcLab.g:123:14: OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS
				{
					match(input, OPENING_PARENTHESIS, FOLLOW_OPENING_PARENTHESIS_in_functionOrVariable342);
					pushFollow(FOLLOW_arguments_in_functionOrVariable344);
					arguments11 = arguments();
					state._fsp--;

					match(input, CLOSING_PARENTHESIS, FOLLOW_CLOSING_PARENTHESIS_in_functionOrVariable346);
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
					value = operandFactory.createFunctionOperand((name != null ? name.getText() : null), arguments11);
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
				pushFollow(FOLLOW_expression_in_arguments373);
				e1 = expression();
				state._fsp--;

				value.add((e1 != null ? ((CalcLabParser.expression_return) e1).value : null));
				// CalcLab.g:148:4: ( ARGUMENTS_SEPARATOR e2= expression )*
				loop13: while (true) {
					int alt13 = 2;
					int LA13_0 = input.LA(1);
					if ((LA13_0 == ARGUMENTS_SEPARATOR)) {
						alt13 = 1;
					}

					switch (alt13) {
					case 1:
					// CalcLab.g:148:5: ARGUMENTS_SEPARATOR e2= expression
					{
						match(input, ARGUMENTS_SEPARATOR, FOLLOW_ARGUMENTS_SEPARATOR_in_arguments382);
						pushFollow(FOLLOW_expression_in_arguments386);
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

	// $ANTLR start "matrix"
	// CalcLab.g:152:1: matrix returns [Operand value] : ( MINUS )? OPENING_SQ_PARENTHESIS matrixArguments
	// CLOSING_SQ_PARENTHESIS ;
	public final Operand matrix() throws RecognitionException {
		Operand value = null;

		Token MINUS12 = null;
		Operand matrixArguments13 = null;

		try {
			// CalcLab.g:153:2: ( ( MINUS )? OPENING_SQ_PARENTHESIS matrixArguments CLOSING_SQ_PARENTHESIS )
			// CalcLab.g:153:4: ( MINUS )? OPENING_SQ_PARENTHESIS matrixArguments CLOSING_SQ_PARENTHESIS
			{
				Operation operation = null;
				// CalcLab.g:154:3: ( MINUS )?
				int alt14 = 2;
				int LA14_0 = input.LA(1);
				if ((LA14_0 == MINUS)) {
					alt14 = 1;
				}
				switch (alt14) {
				case 1:
				// CalcLab.g:154:4: MINUS
				{
					MINUS12 = (Token) match(input, MINUS, FOLLOW_MINUS_in_matrix410);
					operation = operationFactory.createCommonOperation((MINUS12 != null ? MINUS12.getText() : null));
				}
					break;

				}

				match(input, OPENING_SQ_PARENTHESIS, FOLLOW_OPENING_SQ_PARENTHESIS_in_matrix420);
				pushFollow(FOLLOW_matrixArguments_in_matrix422);
				matrixArguments13 = matrixArguments();
				state._fsp--;

				match(input, CLOSING_SQ_PARENTHESIS, FOLLOW_CLOSING_SQ_PARENTHESIS_in_matrix424);
				if (operation == null)
					value = matrixArguments13;
				else
					value = operandFactory.createUnaryOperand(operation, matrixArguments13);
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

	// $ANTLR start "matrixArguments"
	// CalcLab.g:160:1: matrixArguments returns [Operand value] :a1= arguments ( EXPRESSIONS_SEPARATOR a2= arguments )*
	// ;
	public final Operand matrixArguments() throws RecognitionException {
		Operand value = null;

		ArrayList<Operand> a1 = null;
		ArrayList<Operand> a2 = null;

		try {
			// CalcLab.g:161:2: (a1= arguments ( EXPRESSIONS_SEPARATOR a2= arguments )* )
			// CalcLab.g:161:4: a1= arguments ( EXPRESSIONS_SEPARATOR a2= arguments )*
			{
				ArrayList<Operand[]> argsList = new ArrayList<Operand[]>();
				pushFollow(FOLLOW_arguments_in_matrixArguments447);
				a1 = arguments();
				state._fsp--;

				argsList.add(a1.toArray(new Operand[1]));
				// CalcLab.g:163:4: ( EXPRESSIONS_SEPARATOR a2= arguments )*
				loop15: while (true) {
					int alt15 = 2;
					int LA15_0 = input.LA(1);
					if ((LA15_0 == EXPRESSIONS_SEPARATOR)) {
						alt15 = 1;
					}

					switch (alt15) {
					case 1:
					// CalcLab.g:163:5: EXPRESSIONS_SEPARATOR a2= arguments
					{
						match(input, EXPRESSIONS_SEPARATOR, FOLLOW_EXPRESSIONS_SEPARATOR_in_matrixArguments456);
						pushFollow(FOLLOW_arguments_in_matrixArguments460);
						a2 = arguments();
						state._fsp--;

						argsList.add(a2.toArray(new Operand[1]));
					}
						break;

					default:
						break loop15;
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
	// $ANTLR end "matrixArguments"

	// $ANTLR start "unaryOperation"
	// CalcLab.g:168:1: unaryOperation returns [Operation value] : FACTORIAL ;
	public final Operation unaryOperation() throws RecognitionException {
		Operation value = null;

		Token FACTORIAL14 = null;

		try {
			// CalcLab.g:168:40: ( FACTORIAL )
			// CalcLab.g:168:42: FACTORIAL
			{
				FACTORIAL14 = (Token) match(input, FACTORIAL, FOLLOW_FACTORIAL_in_unaryOperation479);
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
	// CalcLab.g:170:1: binaryOperationHigh returns [Operation value] : ( MULTIPLY | DIVISION );
	public final Operation binaryOperationHigh() throws RecognitionException {
		Operation value = null;

		Token MULTIPLY15 = null;
		Token DIVISION16 = null;

		try {
			// CalcLab.g:170:45: ( MULTIPLY | DIVISION )
			int alt16 = 2;
			int LA16_0 = input.LA(1);
			if ((LA16_0 == MULTIPLY)) {
				alt16 = 1;
			} else if ((LA16_0 == DIVISION)) {
				alt16 = 2;
			}

			else {
				NoViableAltException nvae = new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
			case 1:
			// CalcLab.g:170:47: MULTIPLY
			{
				MULTIPLY15 = (Token) match(input, MULTIPLY, FOLLOW_MULTIPLY_in_binaryOperationHigh492);
				value = operationFactory.createCommonOperation((MULTIPLY15 != null ? MULTIPLY15.getText() : null));
			}
				break;
			case 2:
			// CalcLab.g:172:4: DIVISION
			{
				DIVISION16 = (Token) match(input, DIVISION, FOLLOW_DIVISION_in_binaryOperationHigh503);
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
	// CalcLab.g:175:1: binaryOperationMiddle returns [Operation value] : INVOLUTION ;
	public final Operation binaryOperationMiddle() throws RecognitionException {
		Operation value = null;

		Token INVOLUTION17 = null;

		try {
			// CalcLab.g:175:47: ( INVOLUTION )
			// CalcLab.g:175:49: INVOLUTION
			{
				INVOLUTION17 = (Token) match(input, INVOLUTION, FOLLOW_INVOLUTION_in_binaryOperationMiddle518);
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
	// CalcLab.g:177:1: binaryOperationLow returns [Operation value] : ( PLUS | MINUS );
	public final Operation binaryOperationLow() throws RecognitionException {
		Operation value = null;

		Token PLUS18 = null;
		Token MINUS19 = null;

		try {
			// CalcLab.g:177:44: ( PLUS | MINUS )
			int alt17 = 2;
			int LA17_0 = input.LA(1);
			if ((LA17_0 == PLUS)) {
				alt17 = 1;
			} else if ((LA17_0 == MINUS)) {
				alt17 = 2;
			}

			else {
				NoViableAltException nvae = new NoViableAltException("", 17, 0, input);
				throw nvae;
			}

			switch (alt17) {
			case 1:
			// CalcLab.g:177:46: PLUS
			{
				PLUS18 = (Token) match(input, PLUS, FOLLOW_PLUS_in_binaryOperationLow531);
				value = operationFactory.createCommonOperation((PLUS18 != null ? PLUS18.getText() : null));
			}
				break;
			case 2:
			// CalcLab.g:179:4: MINUS
			{
				MINUS19 = (Token) match(input, MINUS, FOLLOW_MINUS_in_binaryOperationLow541);
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

	public static final BitSet FOLLOW_NAME_in_calculation55 = new BitSet(new long[] { 0x0000000000000800L });
	public static final BitSet FOLLOW_EQUALS_in_calculation57 = new BitSet(new long[] { 0x0000000000350200L });
	public static final BitSet FOLLOW_expression_in_calculation66 = new BitSet(new long[] { 0x0000000000001000L });
	public static final BitSet FOLLOW_EXPRESSIONS_SEPARATOR_in_calculation72 = new BitSet(
			new long[] { 0x0000000000350202L });
	public static final BitSet FOLLOW_complexCompositeUnit_in_expression93 = new BitSet(
			new long[] { 0x0000000000410002L });
	public static final BitSet FOLLOW_binaryOperationLow_in_expression104 = new BitSet(
			new long[] { 0x0000000000350200L });
	public static final BitSet FOLLOW_complexCompositeUnit_in_expression108 = new BitSet(
			new long[] { 0x0000000000410002L });
	public static final BitSet FOLLOW_compositeUnit_in_complexCompositeUnit133 = new BitSet(
			new long[] { 0x0000000000008002L });
	public static final BitSet FOLLOW_binaryOperationMiddle_in_complexCompositeUnit143 = new BitSet(
			new long[] { 0x0000000000350200L });
	public static final BitSet FOLLOW_compositeUnit_in_complexCompositeUnit147 = new BitSet(
			new long[] { 0x0000000000008002L });
	public static final BitSet FOLLOW_unit_in_compositeUnit172 = new BitSet(new long[] { 0x0000000000020402L });
	public static final BitSet FOLLOW_binaryOperationHigh_in_compositeUnit180 = new BitSet(
			new long[] { 0x0000000000350200L });
	public static final BitSet FOLLOW_unit_in_compositeUnit184 = new BitSet(new long[] { 0x0000000000020402L });
	public static final BitSet FOLLOW_number_in_unit210 = new BitSet(new long[] { 0x0000000000002002L });
	public static final BitSet FOLLOW_compositeExpression_in_unit219 = new BitSet(new long[] { 0x0000000000002002L });
	public static final BitSet FOLLOW_functionOrVariable_in_unit228 = new BitSet(new long[] { 0x0000000000002002L });
	public static final BitSet FOLLOW_matrix_in_unit236 = new BitSet(new long[] { 0x0000000000002002L });
	public static final BitSet FOLLOW_unaryOperation_in_unit246 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_number262 = new BitSet(new long[] { 0x0000000000000200L });
	public static final BitSet FOLLOW_DIGIT_in_number265 = new BitSet(new long[] { 0x0000000000000102L });
	public static final BitSet FOLLOW_DECIMAL_SEPARATOR_in_number268 = new BitSet(new long[] { 0x0000000000000200L });
	public static final BitSet FOLLOW_DIGIT_in_number270 = new BitSet(new long[] { 0x0000000000000102L });
	public static final BitSet FOLLOW_MINUS_in_compositeExpression292 = new BitSet(new long[] { 0x0000000000100000L });
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_compositeExpression302 = new BitSet(
			new long[] { 0x0000000000350200L });
	public static final BitSet FOLLOW_expression_in_compositeExpression304 = new BitSet(
			new long[] { 0x0000000000000040L });
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_compositeExpression306 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_functionOrVariable329 = new BitSet(new long[] { 0x0000000000040000L });
	public static final BitSet FOLLOW_NAME_in_functionOrVariable339 = new BitSet(new long[] { 0x0000000000100002L });
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_functionOrVariable342 = new BitSet(
			new long[] { 0x0000000000350200L });
	public static final BitSet FOLLOW_arguments_in_functionOrVariable344 = new BitSet(
			new long[] { 0x0000000000000040L });
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_functionOrVariable346 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_expression_in_arguments373 = new BitSet(new long[] { 0x0000000000000012L });
	public static final BitSet FOLLOW_ARGUMENTS_SEPARATOR_in_arguments382 = new BitSet(
			new long[] { 0x0000000000350200L });
	public static final BitSet FOLLOW_expression_in_arguments386 = new BitSet(new long[] { 0x0000000000000012L });
	public static final BitSet FOLLOW_MINUS_in_matrix410 = new BitSet(new long[] { 0x0000000000200000L });
	public static final BitSet FOLLOW_OPENING_SQ_PARENTHESIS_in_matrix420 = new BitSet(
			new long[] { 0x0000000000350200L });
	public static final BitSet FOLLOW_matrixArguments_in_matrix422 = new BitSet(new long[] { 0x0000000000000080L });
	public static final BitSet FOLLOW_CLOSING_SQ_PARENTHESIS_in_matrix424 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_arguments_in_matrixArguments447 = new BitSet(new long[] { 0x0000000000001002L });
	public static final BitSet FOLLOW_EXPRESSIONS_SEPARATOR_in_matrixArguments456 = new BitSet(
			new long[] { 0x0000000000350200L });
	public static final BitSet FOLLOW_arguments_in_matrixArguments460 = new BitSet(new long[] { 0x0000000000001002L });
	public static final BitSet FOLLOW_FACTORIAL_in_unaryOperation479 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MULTIPLY_in_binaryOperationHigh492 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_DIVISION_in_binaryOperationHigh503 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_INVOLUTION_in_binaryOperationMiddle518 = new BitSet(
			new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_PLUS_in_binaryOperationLow531 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_MINUS_in_binaryOperationLow541 = new BitSet(new long[] { 0x0000000000000002L });
}
