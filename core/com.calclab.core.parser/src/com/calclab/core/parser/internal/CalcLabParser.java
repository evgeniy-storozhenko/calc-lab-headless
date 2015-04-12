// $ANTLR 3.5.2 CalcLab.g 2015-04-12 14:05:44

	package com.calclab.core.parser.internal;
	
	import java.util.List;
	import java.util.ArrayList;
	
	import com.calclab.core.calculations.CalculationFactory;
	import com.calclab.core.calculations.Calculable;


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


		private CalculationFactory factory = new CalculationFactory();
		private List<Calculable> calculations = new ArrayList<Calculable>();



	// $ANTLR start "calculation"
	// CalcLab.g:28:1: calculation : ( expression EXPRESSIONS_SEPARATOR )+ ;
	public final void calculation() throws RecognitionException {
		try {
			// CalcLab.g:29:2: ( ( expression EXPRESSIONS_SEPARATOR )+ )
			// CalcLab.g:29:4: ( expression EXPRESSIONS_SEPARATOR )+
			{
			// CalcLab.g:29:4: ( expression EXPRESSIONS_SEPARATOR )+
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
					// CalcLab.g:29:5: expression EXPRESSIONS_SEPARATOR
					{
					pushFollow(FOLLOW_expression_in_calculation49);
					expression();
					state._fsp--;

					match(input,EXPRESSIONS_SEPARATOR,FOLLOW_EXPRESSIONS_SEPARATOR_in_calculation51); 
					 calculations.add(factory.createCalculation()); 
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
	// CalcLab.g:32:1: expression : ( complexCompositeUnit ) ( binaryOperationLow complexCompositeUnit )* ;
	public final void expression() throws RecognitionException {
		try {
			// CalcLab.g:33:2: ( ( complexCompositeUnit ) ( binaryOperationLow complexCompositeUnit )* )
			// CalcLab.g:33:4: ( complexCompositeUnit ) ( binaryOperationLow complexCompositeUnit )*
			{
			// CalcLab.g:33:4: ( complexCompositeUnit )
			// CalcLab.g:33:5: complexCompositeUnit
			{
			pushFollow(FOLLOW_complexCompositeUnit_in_expression67);
			complexCompositeUnit();
			state._fsp--;

			}

			// CalcLab.g:33:27: ( binaryOperationLow complexCompositeUnit )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==MINUS||LA2_0==PLUS) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// CalcLab.g:33:28: binaryOperationLow complexCompositeUnit
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
	// CalcLab.g:36:1: complexCompositeUnit : compositeUnit ( binaryOperationMiddle compositeUnit )* ;
	public final void complexCompositeUnit() throws RecognitionException {
		try {
			// CalcLab.g:37:2: ( compositeUnit ( binaryOperationMiddle compositeUnit )* )
			// CalcLab.g:37:4: compositeUnit ( binaryOperationMiddle compositeUnit )*
			{
			pushFollow(FOLLOW_compositeUnit_in_complexCompositeUnit85);
			compositeUnit();
			state._fsp--;

			// CalcLab.g:37:18: ( binaryOperationMiddle compositeUnit )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==INVOLUTION) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// CalcLab.g:37:19: binaryOperationMiddle compositeUnit
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
	// CalcLab.g:40:1: compositeUnit : unit ( binaryOperationHigh unit )* ;
	public final void compositeUnit() throws RecognitionException {
		try {
			// CalcLab.g:41:2: ( unit ( binaryOperationHigh unit )* )
			// CalcLab.g:41:4: unit ( binaryOperationHigh unit )*
			{
			pushFollow(FOLLOW_unit_in_compositeUnit102);
			unit();
			state._fsp--;

			// CalcLab.g:41:9: ( binaryOperationHigh unit )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==DIVISION||LA4_0==MULTIPLY) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// CalcLab.g:41:10: binaryOperationHigh unit
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
	// CalcLab.g:44:1: unit : ( number | compositeExpression | function ) ( unaryOperation )? ;
	public final void unit() throws RecognitionException {
		try {
			// CalcLab.g:45:2: ( ( number | compositeExpression | function ) ( unaryOperation )? )
			// CalcLab.g:45:4: ( number | compositeExpression | function ) ( unaryOperation )?
			{
			// CalcLab.g:45:4: ( number | compositeExpression | function )
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
					// CalcLab.g:45:5: number
					{
					pushFollow(FOLLOW_number_in_unit120);
					number();
					state._fsp--;

					}
					break;
				case 2 :
					// CalcLab.g:45:14: compositeExpression
					{
					pushFollow(FOLLOW_compositeExpression_in_unit124);
					compositeExpression();
					state._fsp--;

					}
					break;
				case 3 :
					// CalcLab.g:45:36: function
					{
					pushFollow(FOLLOW_function_in_unit128);
					function();
					state._fsp--;

					}
					break;

			}

			// CalcLab.g:45:46: ( unaryOperation )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==FACTORIAL) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// CalcLab.g:45:46: unaryOperation
					{
					pushFollow(FOLLOW_unaryOperation_in_unit131);
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
	}
	// $ANTLR end "unit"



	// $ANTLR start "number"
	// CalcLab.g:48:1: number : ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )* ;
	public final void number() throws RecognitionException {
		try {
			// CalcLab.g:49:2: ( ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )* )
			// CalcLab.g:49:4: ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )*
			{
			// CalcLab.g:49:4: ( MINUS )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==MINUS) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// CalcLab.g:49:4: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_number142); 
					}
					break;

			}

			match(input,DIGIT,FOLLOW_DIGIT_in_number145); 
			// CalcLab.g:49:17: ( DECIMAL_SEPARATOR DIGIT )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==DECIMAL_SEPARATOR) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// CalcLab.g:49:18: DECIMAL_SEPARATOR DIGIT
					{
					match(input,DECIMAL_SEPARATOR,FOLLOW_DECIMAL_SEPARATOR_in_number148); 
					match(input,DIGIT,FOLLOW_DIGIT_in_number150); 
					}
					break;

				default :
					break loop8;
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
	// $ANTLR end "number"



	// $ANTLR start "compositeExpression"
	// CalcLab.g:52:1: compositeExpression : ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS ;
	public final void compositeExpression() throws RecognitionException {
		try {
			// CalcLab.g:53:2: ( ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS )
			// CalcLab.g:53:4: ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS
			{
			// CalcLab.g:53:4: ( MINUS )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==MINUS) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// CalcLab.g:53:4: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_compositeExpression162); 
					}
					break;

			}

			match(input,OPENING_PARENTHESIS,FOLLOW_OPENING_PARENTHESIS_in_compositeExpression165); 
			pushFollow(FOLLOW_expression_in_compositeExpression167);
			expression();
			state._fsp--;

			match(input,CLOSING_PARENTHESIS,FOLLOW_CLOSING_PARENTHESIS_in_compositeExpression169); 
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
	// CalcLab.g:56:1: function : ( MINUS )? NAME OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS ;
	public final void function() throws RecognitionException {
		try {
			// CalcLab.g:57:2: ( ( MINUS )? NAME OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS )
			// CalcLab.g:57:4: ( MINUS )? NAME OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS
			{
			// CalcLab.g:57:4: ( MINUS )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==MINUS) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// CalcLab.g:57:4: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_function179); 
					}
					break;

			}

			match(input,NAME,FOLLOW_NAME_in_function182); 
			match(input,OPENING_PARENTHESIS,FOLLOW_OPENING_PARENTHESIS_in_function184); 
			pushFollow(FOLLOW_arguments_in_function186);
			arguments();
			state._fsp--;

			match(input,CLOSING_PARENTHESIS,FOLLOW_CLOSING_PARENTHESIS_in_function188); 
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
	// CalcLab.g:60:1: arguments : expression ( ARGUMENTS_SEPARATOR expression )* ;
	public final void arguments() throws RecognitionException {
		try {
			// CalcLab.g:61:2: ( expression ( ARGUMENTS_SEPARATOR expression )* )
			// CalcLab.g:61:4: expression ( ARGUMENTS_SEPARATOR expression )*
			{
			pushFollow(FOLLOW_expression_in_arguments198);
			expression();
			state._fsp--;

			// CalcLab.g:61:15: ( ARGUMENTS_SEPARATOR expression )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==ARGUMENTS_SEPARATOR) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// CalcLab.g:61:16: ARGUMENTS_SEPARATOR expression
					{
					match(input,ARGUMENTS_SEPARATOR,FOLLOW_ARGUMENTS_SEPARATOR_in_arguments201); 
					pushFollow(FOLLOW_expression_in_arguments203);
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
	// CalcLab.g:65:1: unaryOperation : FACTORIAL ;
	public final void unaryOperation() throws RecognitionException {
		try {
			// CalcLab.g:65:15: ( FACTORIAL )
			// CalcLab.g:65:17: FACTORIAL
			{
			match(input,FACTORIAL,FOLLOW_FACTORIAL_in_unaryOperation214); 
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
	// CalcLab.g:66:1: binaryOperationHigh : ( MULTIPLY | DIVISION );
	public final void binaryOperationHigh() throws RecognitionException {
		try {
			// CalcLab.g:66:21: ( MULTIPLY | DIVISION )
			// CalcLab.g:
			{
			if ( input.LA(1)==DIVISION||input.LA(1)==MULTIPLY ) {
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
	// $ANTLR end "binaryOperationHigh"



	// $ANTLR start "binaryOperationMiddle"
	// CalcLab.g:67:1: binaryOperationMiddle : INVOLUTION ;
	public final void binaryOperationMiddle() throws RecognitionException {
		try {
			// CalcLab.g:67:23: ( INVOLUTION )
			// CalcLab.g:67:25: INVOLUTION
			{
			match(input,INVOLUTION,FOLLOW_INVOLUTION_in_binaryOperationMiddle232); 
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
	// CalcLab.g:68:1: binaryOperationLow : ( PLUS | MINUS );
	public final void binaryOperationLow() throws RecognitionException {
		try {
			// CalcLab.g:68:20: ( PLUS | MINUS )
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
	public static final BitSet FOLLOW_number_in_unit120 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_compositeExpression_in_unit124 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_function_in_unit128 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_unaryOperation_in_unit131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_number142 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_DIGIT_in_number145 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_DECIMAL_SEPARATOR_in_number148 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_DIGIT_in_number150 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_MINUS_in_compositeExpression162 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_compositeExpression165 = new BitSet(new long[]{0x0000000000054100L});
	public static final BitSet FOLLOW_expression_in_compositeExpression167 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_compositeExpression169 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_function179 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_NAME_in_function182 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_function184 = new BitSet(new long[]{0x0000000000054100L});
	public static final BitSet FOLLOW_arguments_in_function186 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_function188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_arguments198 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_ARGUMENTS_SEPARATOR_in_arguments201 = new BitSet(new long[]{0x0000000000054100L});
	public static final BitSet FOLLOW_expression_in_arguments203 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_FACTORIAL_in_unaryOperation214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INVOLUTION_in_binaryOperationMiddle232 = new BitSet(new long[]{0x0000000000000002L});
}
