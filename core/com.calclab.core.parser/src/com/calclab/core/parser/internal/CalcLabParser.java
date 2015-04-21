// $ANTLR 3.5.2 CalcLab.g 2015-04-21 18:48:55

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
	// CalcLab.g:47:1: compositeUnit : unit ( binaryOperationHigh unit )* ;
	public final void compositeUnit() throws RecognitionException {
		try {
			// CalcLab.g:48:2: ( unit ( binaryOperationHigh unit )* )
			// CalcLab.g:48:4: unit ( binaryOperationHigh unit )*
			{
			pushFollow(FOLLOW_unit_in_compositeUnit102);
			unit();
			state._fsp--;

			// CalcLab.g:48:9: ( binaryOperationHigh unit )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==DIVISION||LA4_0==MULTIPLY) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// CalcLab.g:48:10: binaryOperationHigh unit
					{
					pushFollow(FOLLOW_binaryOperationHigh_in_compositeUnit105);
					binaryOperationHigh();
					state._fsp--;

					pushFollow(FOLLOW_unit_in_compositeUnit107);
					unit();
					state._fsp--;

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
	}
	// $ANTLR end "compositeUnit"



	// $ANTLR start "unit"
	// CalcLab.g:51:1: unit returns [Operand value] : (number1= number | compositeExpression | function ) ( unaryOperation )? ;
	public final Operand unit() throws RecognitionException {
		Operand value = null;


		ParserRuleReturnScope number1 =null;

		try {
			// CalcLab.g:52:2: ( (number1= number | compositeExpression | function ) ( unaryOperation )? )
			// CalcLab.g:52:4: (number1= number | compositeExpression | function ) ( unaryOperation )?
			{
			// CalcLab.g:52:4: (number1= number | compositeExpression | function )
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
					// CalcLab.g:52:5: number1= number
					{
					pushFollow(FOLLOW_number_in_unit125);
					number1=number();
					state._fsp--;

					 value =operandFactory.createNumber((number1!=null?input.toString(number1.start,number1.stop):null)); 
					}
					break;
				case 2 :
					// CalcLab.g:53:5: compositeExpression
					{
					pushFollow(FOLLOW_compositeExpression_in_unit134);
					compositeExpression();
					state._fsp--;

					 value =null; 
					}
					break;
				case 3 :
					// CalcLab.g:54:5: function
					{
					pushFollow(FOLLOW_function_in_unit143);
					function();
					state._fsp--;

					 value =null; 
					}
					break;

			}

			// CalcLab.g:55:4: ( unaryOperation )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==FACTORIAL) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// CalcLab.g:55:4: unaryOperation
					{
					pushFollow(FOLLOW_unaryOperation_in_unit150);
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
	// CalcLab.g:58:1: number : ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )* ;
	public final CalcLabParser.number_return number() throws RecognitionException {
		CalcLabParser.number_return retval = new CalcLabParser.number_return();
		retval.start = input.LT(1);

		try {
			// CalcLab.g:59:2: ( ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )* )
			// CalcLab.g:59:4: ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )*
			{
			// CalcLab.g:59:4: ( MINUS )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==MINUS) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// CalcLab.g:59:4: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_number162); 
					}
					break;

			}

			match(input,DIGIT,FOLLOW_DIGIT_in_number165); 
			// CalcLab.g:59:17: ( DECIMAL_SEPARATOR DIGIT )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==DECIMAL_SEPARATOR) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// CalcLab.g:59:18: DECIMAL_SEPARATOR DIGIT
					{
					match(input,DECIMAL_SEPARATOR,FOLLOW_DECIMAL_SEPARATOR_in_number168); 
					match(input,DIGIT,FOLLOW_DIGIT_in_number170); 
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
	// CalcLab.g:62:1: compositeExpression : ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS ;
	public final void compositeExpression() throws RecognitionException {
		try {
			// CalcLab.g:63:2: ( ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS )
			// CalcLab.g:63:4: ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS
			{
			// CalcLab.g:63:4: ( MINUS )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==MINUS) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// CalcLab.g:63:4: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_compositeExpression182); 
					}
					break;

			}

			match(input,OPENING_PARENTHESIS,FOLLOW_OPENING_PARENTHESIS_in_compositeExpression185); 
			pushFollow(FOLLOW_expression_in_compositeExpression187);
			expression();
			state._fsp--;

			match(input,CLOSING_PARENTHESIS,FOLLOW_CLOSING_PARENTHESIS_in_compositeExpression189); 
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
	// CalcLab.g:66:1: function : ( MINUS )? NAME OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS ;
	public final void function() throws RecognitionException {
		try {
			// CalcLab.g:67:2: ( ( MINUS )? NAME OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS )
			// CalcLab.g:67:4: ( MINUS )? NAME OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS
			{
			// CalcLab.g:67:4: ( MINUS )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==MINUS) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// CalcLab.g:67:4: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_function199); 
					}
					break;

			}

			match(input,NAME,FOLLOW_NAME_in_function202); 
			match(input,OPENING_PARENTHESIS,FOLLOW_OPENING_PARENTHESIS_in_function204); 
			pushFollow(FOLLOW_arguments_in_function206);
			arguments();
			state._fsp--;

			match(input,CLOSING_PARENTHESIS,FOLLOW_CLOSING_PARENTHESIS_in_function208); 
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
	// CalcLab.g:70:1: arguments : expression ( ARGUMENTS_SEPARATOR expression )* ;
	public final void arguments() throws RecognitionException {
		try {
			// CalcLab.g:71:2: ( expression ( ARGUMENTS_SEPARATOR expression )* )
			// CalcLab.g:71:4: expression ( ARGUMENTS_SEPARATOR expression )*
			{
			pushFollow(FOLLOW_expression_in_arguments218);
			expression();
			state._fsp--;

			// CalcLab.g:71:15: ( ARGUMENTS_SEPARATOR expression )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==ARGUMENTS_SEPARATOR) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// CalcLab.g:71:16: ARGUMENTS_SEPARATOR expression
					{
					match(input,ARGUMENTS_SEPARATOR,FOLLOW_ARGUMENTS_SEPARATOR_in_arguments221); 
					pushFollow(FOLLOW_expression_in_arguments223);
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
	// CalcLab.g:75:1: unaryOperation : FACTORIAL ;
	public final void unaryOperation() throws RecognitionException {
		try {
			// CalcLab.g:75:15: ( FACTORIAL )
			// CalcLab.g:75:17: FACTORIAL
			{
			match(input,FACTORIAL,FOLLOW_FACTORIAL_in_unaryOperation234); 
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
	// $ANTLR end "unaryOperation"



	// $ANTLR start "binaryOperationHigh"
	// CalcLab.g:76:1: binaryOperationHigh returns [Operation value] : ( MULTIPLY | DIVISION );
	public final Operation binaryOperationHigh() throws RecognitionException {
		Operation value = null;


		Token MULTIPLY1=null;
		Token DIVISION2=null;

		try {
			// CalcLab.g:76:45: ( MULTIPLY | DIVISION )
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
					// CalcLab.g:76:47: MULTIPLY
					{
					MULTIPLY1=(Token)match(input,MULTIPLY,FOLLOW_MULTIPLY_in_binaryOperationHigh243); 
					value = operationFactory.createCommonOperation((MULTIPLY1!=null?MULTIPLY1.getText():null));
					}
					break;
				case 2 :
					// CalcLab.g:77:3: DIVISION
					{
					DIVISION2=(Token)match(input,DIVISION,FOLLOW_DIVISION_in_binaryOperationHigh250); 
					value = operationFactory.createCommonOperation((DIVISION2!=null?DIVISION2.getText():null));
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
	// CalcLab.g:78:1: binaryOperationMiddle : INVOLUTION ;
	public final void binaryOperationMiddle() throws RecognitionException {
		try {
			// CalcLab.g:78:23: ( INVOLUTION )
			// CalcLab.g:78:25: INVOLUTION
			{
			match(input,INVOLUTION,FOLLOW_INVOLUTION_in_binaryOperationMiddle259); 
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
	// $ANTLR end "binaryOperationMiddle"



	// $ANTLR start "binaryOperationLow"
	// CalcLab.g:79:1: binaryOperationLow : ( PLUS | MINUS );
	public final void binaryOperationLow() throws RecognitionException {
		try {
			// CalcLab.g:79:20: ( PLUS | MINUS )
			// CalcLab.g:
			{
			if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
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
	public static final BitSet FOLLOW_unit_in_compositeUnit102 = new BitSet(new long[]{0x0000000000008202L});
	public static final BitSet FOLLOW_binaryOperationHigh_in_compositeUnit105 = new BitSet(new long[]{0x0000000000054100L});
	public static final BitSet FOLLOW_unit_in_compositeUnit107 = new BitSet(new long[]{0x0000000000008202L});
	public static final BitSet FOLLOW_number_in_unit125 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_compositeExpression_in_unit134 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_function_in_unit143 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_unaryOperation_in_unit150 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_number162 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_DIGIT_in_number165 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_DECIMAL_SEPARATOR_in_number168 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_DIGIT_in_number170 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_MINUS_in_compositeExpression182 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_compositeExpression185 = new BitSet(new long[]{0x0000000000054100L});
	public static final BitSet FOLLOW_expression_in_compositeExpression187 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_compositeExpression189 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_function199 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_NAME_in_function202 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_function204 = new BitSet(new long[]{0x0000000000054100L});
	public static final BitSet FOLLOW_arguments_in_function206 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_function208 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_arguments218 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_ARGUMENTS_SEPARATOR_in_arguments221 = new BitSet(new long[]{0x0000000000054100L});
	public static final BitSet FOLLOW_expression_in_arguments223 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_FACTORIAL_in_unaryOperation234 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULTIPLY_in_binaryOperationHigh243 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIVISION_in_binaryOperationHigh250 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INVOLUTION_in_binaryOperationMiddle259 = new BitSet(new long[]{0x0000000000000002L});
}
