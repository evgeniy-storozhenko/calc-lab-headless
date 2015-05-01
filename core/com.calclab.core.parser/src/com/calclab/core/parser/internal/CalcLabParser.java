// $ANTLR 3.5.2 CalcLab.g 2015-05-01 13:23:37

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
		
		public List<Calculable> getCalculations() {
			return calculations;
		}



	// $ANTLR start "calculation"
	// CalcLab.g:39:1: calculation : (e= expression EXPRESSIONS_SEPARATOR )+ ;
	public final void calculation() throws RecognitionException {
		Operand e =null;

		try {
			// CalcLab.g:40:2: ( (e= expression EXPRESSIONS_SEPARATOR )+ )
			// CalcLab.g:40:4: (e= expression EXPRESSIONS_SEPARATOR )+
			{
			// CalcLab.g:40:4: (e= expression EXPRESSIONS_SEPARATOR )+
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
					// CalcLab.g:40:5: e= expression EXPRESSIONS_SEPARATOR
					{
					pushFollow(FOLLOW_expression_in_calculation51);
					e=expression();
					state._fsp--;

					 calculations.add(calcFactory.createCalculation(e)); 
					match(input,EXPRESSIONS_SEPARATOR,FOLLOW_EXPRESSIONS_SEPARATOR_in_calculation57); 
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
	// CalcLab.g:44:1: expression returns [Operand value] : (c1= complexCompositeUnit ) (o= binaryOperationLow c2= complexCompositeUnit )* ;
	public final Operand expression() throws RecognitionException {
		Operand value = null;


		Operand c1 =null;
		Operation o =null;
		Operand c2 =null;

		try {
			// CalcLab.g:45:2: ( (c1= complexCompositeUnit ) (o= binaryOperationLow c2= complexCompositeUnit )* )
			// CalcLab.g:45:4: (c1= complexCompositeUnit ) (o= binaryOperationLow c2= complexCompositeUnit )*
			{
			// CalcLab.g:45:4: (c1= complexCompositeUnit )
			// CalcLab.g:45:5: c1= complexCompositeUnit
			{
			pushFollow(FOLLOW_complexCompositeUnit_in_expression75);
			c1=complexCompositeUnit();
			state._fsp--;

			 value = c1; 
			}

			// CalcLab.g:46:3: (o= binaryOperationLow c2= complexCompositeUnit )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==MINUS||LA2_0==PLUS) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// CalcLab.g:46:4: o= binaryOperationLow c2= complexCompositeUnit
					{
					pushFollow(FOLLOW_binaryOperationLow_in_expression86);
					o=binaryOperationLow();
					state._fsp--;

					pushFollow(FOLLOW_complexCompositeUnit_in_expression90);
					c2=complexCompositeUnit();
					state._fsp--;

					 value = operandFactory.createCompositeOperand(value, o, c2); 
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
		return value;
	}
	// $ANTLR end "expression"



	// $ANTLR start "complexCompositeUnit"
	// CalcLab.g:51:1: complexCompositeUnit returns [Operand value] : c1= compositeUnit (o= binaryOperationMiddle c2= compositeUnit )* ;
	public final Operand complexCompositeUnit() throws RecognitionException {
		Operand value = null;


		Operand c1 =null;
		Operation o =null;
		Operand c2 =null;

		try {
			// CalcLab.g:52:2: (c1= compositeUnit (o= binaryOperationMiddle c2= compositeUnit )* )
			// CalcLab.g:52:4: c1= compositeUnit (o= binaryOperationMiddle c2= compositeUnit )*
			{
			pushFollow(FOLLOW_compositeUnit_in_complexCompositeUnit115);
			c1=compositeUnit();
			state._fsp--;

			 value = c1; 
			// CalcLab.g:53:3: (o= binaryOperationMiddle c2= compositeUnit )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==INVOLUTION) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// CalcLab.g:53:4: o= binaryOperationMiddle c2= compositeUnit
					{
					pushFollow(FOLLOW_binaryOperationMiddle_in_complexCompositeUnit125);
					o=binaryOperationMiddle();
					state._fsp--;

					pushFollow(FOLLOW_compositeUnit_in_complexCompositeUnit129);
					c2=compositeUnit();
					state._fsp--;

					 value = operandFactory.createCompositeOperand(value, o, c2); 
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
		return value;
	}
	// $ANTLR end "complexCompositeUnit"



	// $ANTLR start "compositeUnit"
	// CalcLab.g:58:1: compositeUnit returns [Operand value] : unit1= unit ( binaryOperationHigh unit2= unit )* ;
	public final Operand compositeUnit() throws RecognitionException {
		Operand value = null;


		Operand unit1 =null;
		Operand unit2 =null;
		Operation binaryOperationHigh1 =null;

		try {
			// CalcLab.g:59:2: (unit1= unit ( binaryOperationHigh unit2= unit )* )
			// CalcLab.g:59:4: unit1= unit ( binaryOperationHigh unit2= unit )*
			{
			pushFollow(FOLLOW_unit_in_compositeUnit154);
			unit1=unit();
			state._fsp--;

			 value =unit1; 
			// CalcLab.g:60:3: ( binaryOperationHigh unit2= unit )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==DIVISION||LA4_0==MULTIPLY) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// CalcLab.g:60:4: binaryOperationHigh unit2= unit
					{
					pushFollow(FOLLOW_binaryOperationHigh_in_compositeUnit162);
					binaryOperationHigh1=binaryOperationHigh();
					state._fsp--;

					pushFollow(FOLLOW_unit_in_compositeUnit166);
					unit2=unit();
					state._fsp--;

					 value = operandFactory.createCompositeOperand(value, 
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
	// CalcLab.g:67:1: unit returns [Operand value] : ( number | compositeExpression | function ) (u= unaryOperation )? ;
	public final Operand unit() throws RecognitionException {
		Operand value = null;


		Operation u =null;
		ParserRuleReturnScope number2 =null;
		Operand compositeExpression3 =null;

		try {
			// CalcLab.g:68:2: ( ( number | compositeExpression | function ) (u= unaryOperation )? )
			// CalcLab.g:68:4: ( number | compositeExpression | function ) (u= unaryOperation )?
			{
			// CalcLab.g:68:4: ( number | compositeExpression | function )
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
					// CalcLab.g:68:5: number
					{
					pushFollow(FOLLOW_number_in_unit192);
					number2=number();
					state._fsp--;

					 value = operandFactory.createNumber((number2!=null?input.toString(number2.start,number2.stop):null)); 
					}
					break;
				case 2 :
					// CalcLab.g:69:5: compositeExpression
					{
					pushFollow(FOLLOW_compositeExpression_in_unit201);
					compositeExpression3=compositeExpression();
					state._fsp--;

					 value = compositeExpression3; 
					}
					break;
				case 3 :
					// CalcLab.g:70:5: function
					{
					pushFollow(FOLLOW_function_in_unit210);
					function();
					state._fsp--;

					 value =null; 
					}
					break;

			}

			// CalcLab.g:71:4: (u= unaryOperation )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==FACTORIAL) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// CalcLab.g:71:5: u= unaryOperation
					{
					pushFollow(FOLLOW_unaryOperation_in_unit220);
					u=unaryOperation();
					state._fsp--;

					 value = operandFactory.createUnaryOperand(value, u); 
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
	// CalcLab.g:74:1: number : ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )* ;
	public final CalcLabParser.number_return number() throws RecognitionException {
		CalcLabParser.number_return retval = new CalcLabParser.number_return();
		retval.start = input.LT(1);

		try {
			// CalcLab.g:75:2: ( ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )* )
			// CalcLab.g:75:4: ( MINUS )? DIGIT ( DECIMAL_SEPARATOR DIGIT )*
			{
			// CalcLab.g:75:4: ( MINUS )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==MINUS) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// CalcLab.g:75:4: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_number236); 
					}
					break;

			}

			match(input,DIGIT,FOLLOW_DIGIT_in_number239); 
			// CalcLab.g:75:17: ( DECIMAL_SEPARATOR DIGIT )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==DECIMAL_SEPARATOR) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// CalcLab.g:75:18: DECIMAL_SEPARATOR DIGIT
					{
					match(input,DECIMAL_SEPARATOR,FOLLOW_DECIMAL_SEPARATOR_in_number242); 
					match(input,DIGIT,FOLLOW_DIGIT_in_number244); 
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
	// CalcLab.g:78:1: compositeExpression returns [Operand value] : ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS ;
	public final Operand compositeExpression() throws RecognitionException {
		Operand value = null;


		Token MINUS4=null;
		Operand expression5 =null;

		try {
			// CalcLab.g:79:2: ( ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS )
			// CalcLab.g:79:4: ( MINUS )? OPENING_PARENTHESIS expression CLOSING_PARENTHESIS
			{
			 Operation operation = null; 
			// CalcLab.g:80:3: ( MINUS )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==MINUS) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// CalcLab.g:80:4: MINUS
					{
					MINUS4=(Token)match(input,MINUS,FOLLOW_MINUS_in_compositeExpression265); 
					 operation = operationFactory.createCommonOperation((MINUS4!=null?MINUS4.getText():null)); 
					}
					break;

			}

			match(input,OPENING_PARENTHESIS,FOLLOW_OPENING_PARENTHESIS_in_compositeExpression275); 
			pushFollow(FOLLOW_expression_in_compositeExpression277);
			expression5=expression();
			state._fsp--;

			match(input,CLOSING_PARENTHESIS,FOLLOW_CLOSING_PARENTHESIS_in_compositeExpression279); 
			 if (operation == null) value = expression5;
					  else value = operandFactory.createUnaryOperand(operation, expression5); 
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
	// $ANTLR end "compositeExpression"



	// $ANTLR start "function"
	// CalcLab.g:86:1: function : ( MINUS )? NAME OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS ;
	public final void function() throws RecognitionException {
		try {
			// CalcLab.g:87:2: ( ( MINUS )? NAME OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS )
			// CalcLab.g:87:4: ( MINUS )? NAME OPENING_PARENTHESIS arguments CLOSING_PARENTHESIS
			{
			// CalcLab.g:87:4: ( MINUS )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==MINUS) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// CalcLab.g:87:4: MINUS
					{
					match(input,MINUS,FOLLOW_MINUS_in_function295); 
					}
					break;

			}

			match(input,NAME,FOLLOW_NAME_in_function298); 
			match(input,OPENING_PARENTHESIS,FOLLOW_OPENING_PARENTHESIS_in_function300); 
			pushFollow(FOLLOW_arguments_in_function302);
			arguments();
			state._fsp--;

			match(input,CLOSING_PARENTHESIS,FOLLOW_CLOSING_PARENTHESIS_in_function304); 
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
	// CalcLab.g:90:1: arguments : e1= expression ( ARGUMENTS_SEPARATOR e2= expression )* ;
	public final void arguments() throws RecognitionException {
		Operand e1 =null;
		Operand e2 =null;

		try {
			// CalcLab.g:91:2: (e1= expression ( ARGUMENTS_SEPARATOR e2= expression )* )
			// CalcLab.g:91:4: e1= expression ( ARGUMENTS_SEPARATOR e2= expression )*
			{
			pushFollow(FOLLOW_expression_in_arguments316);
			e1=expression();
			state._fsp--;

			// CalcLab.g:91:18: ( ARGUMENTS_SEPARATOR e2= expression )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==ARGUMENTS_SEPARATOR) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// CalcLab.g:91:19: ARGUMENTS_SEPARATOR e2= expression
					{
					match(input,ARGUMENTS_SEPARATOR,FOLLOW_ARGUMENTS_SEPARATOR_in_arguments319); 
					pushFollow(FOLLOW_expression_in_arguments323);
					e2=expression();
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
	// CalcLab.g:95:1: unaryOperation returns [Operation value] : FACTORIAL ;
	public final Operation unaryOperation() throws RecognitionException {
		Operation value = null;


		Token FACTORIAL6=null;

		try {
			// CalcLab.g:95:40: ( FACTORIAL )
			// CalcLab.g:95:42: FACTORIAL
			{
			FACTORIAL6=(Token)match(input,FACTORIAL,FOLLOW_FACTORIAL_in_unaryOperation337); 
			value = operationFactory.createCommonOperation((FACTORIAL6!=null?FACTORIAL6.getText():null));
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
	// CalcLab.g:97:1: binaryOperationHigh returns [Operation value] : ( MULTIPLY | DIVISION );
	public final Operation binaryOperationHigh() throws RecognitionException {
		Operation value = null;


		Token MULTIPLY7=null;
		Token DIVISION8=null;

		try {
			// CalcLab.g:97:45: ( MULTIPLY | DIVISION )
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
					// CalcLab.g:97:47: MULTIPLY
					{
					MULTIPLY7=(Token)match(input,MULTIPLY,FOLLOW_MULTIPLY_in_binaryOperationHigh350); 
					value = operationFactory.createCommonOperation((MULTIPLY7!=null?MULTIPLY7.getText():null));
					}
					break;
				case 2 :
					// CalcLab.g:99:4: DIVISION
					{
					DIVISION8=(Token)match(input,DIVISION,FOLLOW_DIVISION_in_binaryOperationHigh361); 
					value = operationFactory.createCommonOperation((DIVISION8!=null?DIVISION8.getText():null));
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
	// CalcLab.g:102:1: binaryOperationMiddle returns [Operation value] : INVOLUTION ;
	public final Operation binaryOperationMiddle() throws RecognitionException {
		Operation value = null;


		Token INVOLUTION9=null;

		try {
			// CalcLab.g:102:47: ( INVOLUTION )
			// CalcLab.g:102:49: INVOLUTION
			{
			INVOLUTION9=(Token)match(input,INVOLUTION,FOLLOW_INVOLUTION_in_binaryOperationMiddle376); 
			value = operationFactory.createCommonOperation((INVOLUTION9!=null?INVOLUTION9.getText():null));
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
	// CalcLab.g:104:1: binaryOperationLow returns [Operation value] : ( PLUS | MINUS );
	public final Operation binaryOperationLow() throws RecognitionException {
		Operation value = null;


		Token PLUS10=null;
		Token MINUS11=null;

		try {
			// CalcLab.g:104:44: ( PLUS | MINUS )
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
					// CalcLab.g:104:46: PLUS
					{
					PLUS10=(Token)match(input,PLUS,FOLLOW_PLUS_in_binaryOperationLow389); 
					value = operationFactory.createCommonOperation((PLUS10!=null?PLUS10.getText():null));
					}
					break;
				case 2 :
					// CalcLab.g:106:4: MINUS
					{
					MINUS11=(Token)match(input,MINUS,FOLLOW_MINUS_in_binaryOperationLow399); 
					value = operationFactory.createCommonOperation((MINUS11!=null?MINUS11.getText():null));
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



	public static final BitSet FOLLOW_expression_in_calculation51 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_EXPRESSIONS_SEPARATOR_in_calculation57 = new BitSet(new long[]{0x0000000000054102L});
	public static final BitSet FOLLOW_complexCompositeUnit_in_expression75 = new BitSet(new long[]{0x0000000000084002L});
	public static final BitSet FOLLOW_binaryOperationLow_in_expression86 = new BitSet(new long[]{0x0000000000054100L});
	public static final BitSet FOLLOW_complexCompositeUnit_in_expression90 = new BitSet(new long[]{0x0000000000084002L});
	public static final BitSet FOLLOW_compositeUnit_in_complexCompositeUnit115 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_binaryOperationMiddle_in_complexCompositeUnit125 = new BitSet(new long[]{0x0000000000054100L});
	public static final BitSet FOLLOW_compositeUnit_in_complexCompositeUnit129 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_unit_in_compositeUnit154 = new BitSet(new long[]{0x0000000000008202L});
	public static final BitSet FOLLOW_binaryOperationHigh_in_compositeUnit162 = new BitSet(new long[]{0x0000000000054100L});
	public static final BitSet FOLLOW_unit_in_compositeUnit166 = new BitSet(new long[]{0x0000000000008202L});
	public static final BitSet FOLLOW_number_in_unit192 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_compositeExpression_in_unit201 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_function_in_unit210 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_unaryOperation_in_unit220 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_number236 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_DIGIT_in_number239 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_DECIMAL_SEPARATOR_in_number242 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_DIGIT_in_number244 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_MINUS_in_compositeExpression265 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_compositeExpression275 = new BitSet(new long[]{0x0000000000054100L});
	public static final BitSet FOLLOW_expression_in_compositeExpression277 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_compositeExpression279 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_function295 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_NAME_in_function298 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_OPENING_PARENTHESIS_in_function300 = new BitSet(new long[]{0x0000000000054100L});
	public static final BitSet FOLLOW_arguments_in_function302 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_CLOSING_PARENTHESIS_in_function304 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_arguments316 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_ARGUMENTS_SEPARATOR_in_arguments319 = new BitSet(new long[]{0x0000000000054100L});
	public static final BitSet FOLLOW_expression_in_arguments323 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_FACTORIAL_in_unaryOperation337 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULTIPLY_in_binaryOperationHigh350 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIVISION_in_binaryOperationHigh361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INVOLUTION_in_binaryOperationMiddle376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_binaryOperationLow389 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_binaryOperationLow399 = new BitSet(new long[]{0x0000000000000002L});
}
