// $ANTLR 3.5.2 CalcLab.g 2015-04-22 12:39:26

	package com.calclab.core.parser.internal;
	
	import java.util.List;
	import java.util.ArrayList;
	
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
	public static final int EOF=-1;
	public static final int ARGUMENTS_SEPARATOR=4;
	public static final int CHAR=5;
	public static final int CLOSING_PARENTHESIS=6;
	public static final int DECIMAL_SEPARATOR=7;
	public static final int DIGIT=8;
	public static final int DIVISION=9;
	public static final int EXPRESSIONS_SEPARATOR=10;
	public static final int FACTORIAL=11;
	public static final int ID=12;
	public static final int INVOLUTION=13;
	public static final int MINUS=14;
	public static final int MULTIPLY=15;
	public static final int NAME=16;
	public static final int NEWLINE=17;
	public static final int OPENING_PARENTHESIS=18;
	public static final int PLUS=19;
	public static final int WS=20;

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

	@Override public String[] getTokenNames() { return CalcLabParser.tokenNames; }
	@Override public String getGrammarFileName() { return "CalcLab.g"; }


		private CommonOperationFactory operationFactory = new CommonOperationFactory();
		private CommonOperandFactory operandFactory = new CommonOperandFactory();
		private CalculationFactory calcFactory = new CalculationFactory();
		private List<Calculable> calculations = new ArrayList<Calculable>();



	// $ANTLR start "calculation"
	// CalcLab.g:35:1: calculation : ( expression EXPRESSIONS_SEPARATOR )+ ;
	public final void calculation() throws RecognitionException {
		try {
			// CalcLab.g:36:2: ( ( expression EXPRESSIONS_SEPARATOR )+ )
			// CalcLab.g:36:4: ( expression EXPRESSIONS_SEPARATOR )+
			{
			// CalcLab.g:36:4: ( expression EXPRESSIONS_SEPARATOR )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==DIGIT||LA1_0==MINUS||LA1_0==NAME||LA1_0==OPENING_PARENTHESIS) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// CalcLab.g:36:5: expression EXPRESSIONS_SEPARATOR
					{
					pushFollow(FOLLOW_expression_in_calculation49);
					expression();
					state._fsp--;

					match(input,EXPRESSIONS_SEPARATOR,FOLLOW_EXPRESSIONS_SEPARATOR_in_calculation51); 
					 calculations.add(calcFactory.createCalculation()); 
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "calculation"



	// $ANTLR start "expression"
	// CalcLab.g:39:1: expression : ( complexCompositeUnit ) ( binaryOperationLow complexCompositeUnit )* ;
	public final void expression() throws RecognitionException {
		try {
			// CalcLab.g:40:2: ( ( complexCompositeUnit ) ( binaryOperationLow complexCompositeUnit )* )
			// CalcLab.g:40:4: ( complexCompositeUnit ) ( binaryOperationLow complexCompositeUnit )*
			{
			// CalcLab.g:40:4: ( complexCompositeUnit )
			// CalcLab.g:40:5: complexCompositeUnit
			{
			pushFollow(FOLLOW_complexCompositeUnit_in_expression67);
			complexCompositeUnit();
			state._fsp--;

			}

			// CalcLab.g:40:27: ( binaryOperationLow complexCompositeUnit )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==MINUS||LA2_0==PLUS) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// CalcLab.g:40:28: binaryOperationLow complexCompositeUnit
					{
					pushFollow(FOLLOW_binaryOperationLow_in_expression71);
					binaryOperationLow();
					state._fsp--;

					pushFollow(FOLLOW_complexCompositeUnit_in_expression73);
					complexCompositeUnit();
					state._fsp--;

					}
					break;

				default :
					break loop2;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expression"



	// $ANTLR start "complexCompositeUnit"
	// CalcLab.g:43:1: complexCompositeUnit : compositeUnit ( binaryOperationMiddle compositeUnit )* ;
	public final void complexCompositeUnit() throws RecognitionException {
		try {
			// CalcLab.g:44:2: ( compositeUnit ( binaryOperationMiddle compositeUnit )* )
			// CalcLab.g:44:4: compositeUnit ( binaryOperationMiddle compositeUnit )*
			{
			pushFollow(FOLLOW_compositeUnit_in_complexCompositeUnit85);
			compositeUnit();
			state._fsp--;

			// CalcLab.g:44:18: ( binaryOperationMiddle compositeUnit )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==INVOLUTION) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// CalcLab.g:44:19: binaryOperationMiddle compositeUnit
					{
					pushFollow(FOLLOW_binaryOperationMiddle_in_complexCompositeUnit88);
					binaryOperationMiddle();
					state._fsp--;

					pushFollow(FOLLOW_compositeUnit_in_complexCompositeUnit90);
					compositeUnit();
					state._fsp--;

					}
					break;

				default :
					break loop3;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "complexCompositeUnit"



	// $ANTLR start "compositeUnit"
	// CalcLab.g:47:1: compositeUnit returns [Operand value] : unit1= unit ( binaryOperationHigh unit2= unit )* ;
	public final Operand compositeUnit() throws RecognitionException {
		Operand value = null;


		Operand unit1 =null;
		Operand unit2 =null;
		Operation binaryOperationHigh1 =null;

		try {
			// CalcLab.g:48:2: (unit1= unit ( binaryOperationHigh unit2= unit )* )
			// CalcLab.g:48:4: unit1= unit ( binaryOperationHigh unit2= unit )*
			{
			pushFollow(FOLLOW_unit_in_compositeUnit107);
			unit1=unit();
			state._fsp--;

			 value =unit1; 
			// CalcLab.g:49:3: ( binaryOperationHigh unit2= unit )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==DIVISION||LA4_0==MULTIPLY) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// CalcLab.g:49:4: binaryOperationHigh unit2= unit
					{
					pushFollow(FOLLOW_binaryOperationHigh_in_compositeUnit115);
					binaryOperationHigh1=binaryOperationHigh();
					state._fsp--;

					pushFollow(FOLLOW_unit_in_compositeUnit119);
					unit2=unit();
					state._fsp--;

					 value = operandFactory.createCompositOperand(value, 
									binaryOperationHigh1, unit2); 
								
					}
					break;

				default :
					break loop4;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "compositeUnit"



	// $ANTLR start "unit"
	// CalcLab.g:56:1: unit returns [Operand value] : ( number | compositeExpression | function ) ( unaryOperation )? ;
	public final Operand unit() throws RecognitionException {
		Operand value = null;


		ParserRuleReturnScope number2 =null;

		try {
			// CalcLab.g:57:2: ( ( number | compositeExpression | function ) ( unaryOperation )? )
			// CalcLab.g:57:4: ( number | compositeExpression | function ) ( unaryOperation )?
			{
			// CalcLab.g:57:4: ( number | compositeExpression | function )
			int alt5=3;
			switch ( input.LA(1) ) {
			case MINUS:
				{
				switch ( input.LA(2) ) {
				case DIGIT:
					{
					alt5=1;
					}
					break;
				case OPENING_PARENTHESIS:
					{
					alt5=2;
					}
					break;
				case NAME:
					{
					alt5=3;
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
			case DIGIT:
				{
				alt5=1;
				}
				break;
			case OPENING_PARENTHESIS:
				{
				alt5=2;
				}
				break;
			case NAME:
				{
				alt5=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// CalcLab.g:57:5: number
					{
					pushFollow(FOLLOW_number_in_unit145);
					number2=number();
					state._fsp--;

					 value =operandFactory.createNumber((number2!=null?input.toString(number2.start,number2.stop):null)); 
					}
					break;
				case 2 :
					// CalcLab.g:58:5: compositeExpression
					{
					pushFollow(FOLLOW_compositeExpression_in_unit154);
					compositeExpression();
					state._fsp--;

					 value =null; 
					}
					break;
				case 3 :
					// CalcLab.g:59:5: function
					{
					pushFollow(FOLLOW_function_in_unit163);
					function();
					state._fsp--;

					 value =null; 
					}
					break;

			}

			// CalcLab.g:60:4: ( unaryOperation )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==FACTORIAL) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// CalcLab.g:60:4: unaryOperation
					{
					pushFollow(FOLLOW_unaryOperation_in_unit170);
					unaryOperation();
					state._fsp--;

					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "unit"


	public static class number_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "number"
	// CalcLab.g:63:1: number : ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )* ;
	public final CalcLabParser.number_return number() throws RecognitionException {
		CalcLabParser.number_return retval = new CalcLabParser.number_return();
		retval.start = input.LT(1);

		try {
			// CalcLab.g:64:2: ( ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )* )
			// CalcLab.g:64:4: ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )*
			{
			// CalcLab.g:64:4: ( MINUS )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==MINUS) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// CalcLab.g:64:4: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_number182); 
					}
					break;

			}

			match(input,DIGIT,FOLLOW_DIGIT_in_number185); 
			// CalcLab.g:64:17: ( DECIMAL_SEPARATOR DIGIT )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==DECIMAL_SEPARATOR) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// CalcLab.g:64:18: DECIMAL_SEPARATOR DIGIT
					{
					match(input,DECIMAL_SEPARATOR,FOLLOW_DECIMAL_SEPARATOR_in_number188); 
					match(input,DIGIT,FOLLOW_DIGIT_in_number190); 
					}
					break;

				default :
					break loop8;
				}
			}

			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "number"



	// $ANTLR start "compositeExpression"
	// CalcLab.g:67:1: compositeExpression : ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS ;
	public final void compositeExpression() throws RecognitionException {
		try {
			// CalcLab.g:68:2: ( ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS )
			// CalcLab.g:68:4: ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS
			{
			// CalcLab.g:68:4: ( MINUS )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==MINUS) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// CalcLab.g:68:4: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_compositeExpression202); 
					}
					break;

			}

			match(input,OPENING_PARENTHESIS,FOLLOW_OPENING_PARENTHESIS_in_compositeExpression205); 
			pushFollow(FOLLOW_expression_in_compositeExpression207);
			expression();
			state._fsp--;

			match(input,CLOSING_PARENTHESIS,FOLLOW_CLOSING_PARENTHESIS_in_compositeExpression209); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "compositeExpression"



	// $ANTLR start "function"
	// CalcLab.g:71:1: function : ( MINUS )? NAME OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS ;
	public final void function() throws RecognitionException {
		try {
			// CalcLab.g:72:2: ( ( MINUS )? NAME OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS )
			// CalcLab.g:72:4: ( MINUS )? NAME OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS
			{
			// CalcLab.g:72:4: ( MINUS )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==MINUS) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// CalcLab.g:72:4: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_function219); 
					}
					break;

			}

			match(input,NAME,FOLLOW_NAME_in_function222); 
			match(input,OPENING_PARENTHESIS,FOLLOW_OPENING_PARENTHESIS_in_function224); 
			pushFollow(FOLLOW_arguments_in_function226);
			arguments();
			state._fsp--;

			match(input,CLOSING_PARENTHESIS,FOLLOW_CLOSING_PARENTHESIS_in_function228); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "function"



	// $ANTLR start "arguments"
	// CalcLab.g:75:1: arguments : expression ( ARGUMENTS_SEPARATOR expression )* ;
	public final void arguments() throws RecognitionException {
		try {
			// CalcLab.g:76:2: ( expression ( ARGUMENTS_SEPARATOR expression )* )
			// CalcLab.g:76:4: expression ( ARGUMENTS_SEPARATOR expression )*
			{
			pushFollow(FOLLOW_expression_in_arguments238);
			expression();
			state._fsp--;

			// CalcLab.g:76:15: ( ARGUMENTS_SEPARATOR expression )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==ARGUMENTS_SEPARATOR) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// CalcLab.g:76:16: ARGUMENTS_SEPARATOR expression
					{
					match(input,ARGUMENTS_SEPARATOR,FOLLOW_ARGUMENTS_SEPARATOR_in_arguments241); 
					pushFollow(FOLLOW_expression_in_arguments243);
					expression();
					state._fsp--;

					}
					break;

				default :
					break loop11;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "arguments"



	// $ANTLR start "unaryOperation"
	// CalcLab.g:80:1: unaryOperation returns [Operation value] : FACTORIAL ;
	public final Operation unaryOperation() throws RecognitionException {
		Operation value = null;


		Token FACTORIAL3=null;

		try {
			// CalcLab.g:80:40: ( FACTORIAL )
			// CalcLab.g:80:42: FACTORIAL
			{
			FACTORIAL3=(Token)match(input,FACTORIAL,FOLLOW_FACTORIAL_in_unaryOperation257); 
			value = operationFactory.createCommonOperation((FACTORIAL3!=null?FACTORIAL3.getText():null));
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "unaryOperation"



	// $ANTLR start "binaryOperationHigh"
	// CalcLab.g:82:1: binaryOperationHigh returns [Operation value] : ( MULTIPLY | DIVISION );
	public final Operation binaryOperationHigh() throws RecognitionException {
		Operation value = null;


		Token MULTIPLY4=null;
		Token DIVISION5=null;

		try {
			// CalcLab.g:82:45: ( MULTIPLY | DIVISION )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==MULTIPLY) ) {
				alt12=1;
			}
			else if ( (LA12_0==DIVISION) ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// CalcLab.g:82:47: MULTIPLY
					{
					MULTIPLY4=(Token)match(input,MULTIPLY,FOLLOW_MULTIPLY_in_binaryOperationHigh270); 
					value = operationFactory.createCommonOperation((MULTIPLY4!=null?MULTIPLY4.getText():null));
					}
					break;
				case 2 :
					// CalcLab.g:84:4: DIVISION
					{
					DIVISION5=(Token)match(input,DIVISION,FOLLOW_DIVISION_in_binaryOperationHigh281); 
					value = operationFactory.createCommonOperation((DIVISION5!=null?DIVISION5.getText():null));
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "binaryOperationHigh"



	// $ANTLR start "binaryOperationMiddle"
	// CalcLab.g:87:1: binaryOperationMiddle returns [Operation value] : INVOLUTION ;
	public final Operation binaryOperationMiddle() throws RecognitionException {
		Operation value = null;


		Token INVOLUTION6=null;

		try {
			// CalcLab.g:87:47: ( INVOLUTION )
			// CalcLab.g:87:49: INVOLUTION
			{
			INVOLUTION6=(Token)match(input,INVOLUTION,FOLLOW_INVOLUTION_in_binaryOperationMiddle296); 
			value = operationFactory.createCommonOperation((INVOLUTION6!=null?INVOLUTION6.getText():null));
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "binaryOperationMiddle"



	// $ANTLR start "binaryOperationLow"
	// CalcLab.g:89:1: binaryOperationLow returns [Operation value] : ( PLUS | MINUS );
	public final Operation binaryOperationLow() throws RecognitionException {
		Operation value = null;


		Token PLUS7=null;
		Token MINUS8=null;

		try {
			// CalcLab.g:89:44: ( PLUS | MINUS )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==PLUS) ) {
				alt13=1;
			}
			else if ( (LA13_0==MINUS) ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// CalcLab.g:89:46: PLUS
					{
					PLUS7=(Token)match(input,PLUS,FOLLOW_PLUS_in_binaryOperationLow309); 
					value = operationFactory.createCommonOperation((PLUS7!=null?PLUS7.getText():null));
					}
					break;
				case 2 :
					// CalcLab.g:91:4: MINUS
					{
					MINUS8=(Token)match(input,MINUS,FOLLOW_MINUS_in_binaryOperationLow319); 
					value = operationFactory.createCommonOperation((MINUS8!=null?MINUS8.getText():null));
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return value;
	}
	// $ANTLR end "binaryOperationLow"

	// Delegated rules



	public static final BitSet FOLLOW_expression_in_calculation49 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_EXPRESSIONS_SEPARATOR_in_calculation51 = new BitSet(new long[]{0x0000000000054102L});
	public static final BitSet FOLLOW_complexCompositeUnit_in_expression67 = new BitSet(new long[]{0x0000000000084002L});
	public static final BitSet FOLLOW_binaryOperationLow_in_expression71 = new BitSet(new long[]{0x0000000000054100L});
	public static final BitSet FOLLOW_complexCompositeUnit_in_expression73 = new BitSet(new long[]{0x0000000000084002L});
	public static final BitSet FOLLOW_compositeUnit_in_complexCompositeUnit85 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_binaryOperationMiddle_in_complexCompositeUnit88 = new BitSet(new long[]{0x0000000000054100L});
	public static final BitSet FOLLOW_compositeUnit_in_complexCompositeUnit90 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_unit_in_compositeUnit107 = new BitSet(new long[]{0x0000000000008202L});
	public static final BitSet FOLLOW_binaryOperationHigh_in_compositeUnit115 = new BitSet(new long[]{0x0000000000054100L});
	public static final BitSet FOLLOW_unit_in_compositeUnit119 = new BitSet(new long[]{0x0000000000008202L});
	public static final BitSet FOLLOW_number_in_unit145 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_compositeExpression_in_unit154 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_function_in_unit163 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_unaryOperation_in_unit170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_number182 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_DIGIT_in_number185 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_DECIMAL_SEPARATOR_in_number188 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_DIGIT_in_number190 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_MINUS_in_compositeExpression202 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_compositeExpression205 = new BitSet(new long[]{0x0000000000054100L});
	public static final BitSet FOLLOW_expression_in_compositeExpression207 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_compositeExpression209 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_function219 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_NAME_in_function222 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_function224 = new BitSet(new long[]{0x0000000000054100L});
	public static final BitSet FOLLOW_arguments_in_function226 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_function228 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_arguments238 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_ARGUMENTS_SEPARATOR_in_arguments241 = new BitSet(new long[]{0x0000000000054100L});
	public static final BitSet FOLLOW_expression_in_arguments243 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_FACTORIAL_in_unaryOperation257 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULTIPLY_in_binaryOperationHigh270 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIVISION_in_binaryOperationHigh281 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INVOLUTION_in_binaryOperationMiddle296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_binaryOperationLow309 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_binaryOperationLow319 = new BitSet(new long[]{0x0000000000000002L});
}
