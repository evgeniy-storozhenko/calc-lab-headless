// $ANTLR 3.5.2 CalcLab.g 2015-04-28 17:40:01

	package com.calclab.core.parser.internal;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CalcLabLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public CalcLabLexer() {} 
	public CalcLabLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public CalcLabLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "CalcLab.g"; }

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:106:7: ( '+' )
			// CalcLab.g:106:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:107:7: ( '-' )
			// CalcLab.g:107:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "MULTIPLY"
	public final void mMULTIPLY() throws RecognitionException {
		try {
			int _type = MULTIPLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:108:10: ( '*' )
			// CalcLab.g:108:12: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULTIPLY"

	// $ANTLR start "DIVISION"
	public final void mDIVISION() throws RecognitionException {
		try {
			int _type = DIVISION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:109:10: ( '/' )
			// CalcLab.g:109:12: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIVISION"

	// $ANTLR start "INVOLUTION"
	public final void mINVOLUTION() throws RecognitionException {
		try {
			int _type = INVOLUTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:112:12: ( '^' )
			// CalcLab.g:112:14: '^'
			{
			match('^'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INVOLUTION"

	// $ANTLR start "FACTORIAL"
	public final void mFACTORIAL() throws RecognitionException {
		try {
			int _type = FACTORIAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:113:11: ( '!' )
			// CalcLab.g:113:13: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FACTORIAL"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			int _type = DIGIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:116:7: ( ( '0' .. '9' )+ )
			// CalcLab.g:116:9: ( '0' .. '9' )+
			{
			// CalcLab.g:116:9: ( '0' .. '9' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// CalcLab.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
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

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "NAME"
	public final void mNAME() throws RecognitionException {
		try {
			int _type = NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:117:6: ( ID ( ID | DIGIT )* )
			// CalcLab.g:117:8: ID ( ID | DIGIT )*
			{
			mID(); 

			// CalcLab.g:117:11: ( ID | DIGIT )*
			loop2:
			while (true) {
				int alt2=3;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}
				else if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
					alt2=2;
				}

				switch (alt2) {
				case 1 :
					// CalcLab.g:117:12: ID
					{
					mID(); 

					}
					break;
				case 2 :
					// CalcLab.g:117:16: DIGIT
					{
					mDIGIT(); 

					}
					break;

				default :
					break loop2;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NAME"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			// CalcLab.g:118:13: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) )
			// CalcLab.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "CHAR"
	public final void mCHAR() throws RecognitionException {
		try {
			// CalcLab.g:119:15: ( 'A' .. 'z' )
			// CalcLab.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR"

	// $ANTLR start "OPENING_PARENTHESIS"
	public final void mOPENING_PARENTHESIS() throws RecognitionException {
		try {
			int _type = OPENING_PARENTHESIS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:120:21: ( '(' )
			// CalcLab.g:120:23: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPENING_PARENTHESIS"

	// $ANTLR start "CLOSING_PARENTHESIS"
	public final void mCLOSING_PARENTHESIS() throws RecognitionException {
		try {
			int _type = CLOSING_PARENTHESIS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:121:21: ( ')' )
			// CalcLab.g:121:23: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLOSING_PARENTHESIS"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:122:9: ( ( '\\r' )? '\\n' )
			// CalcLab.g:122:11: ( '\\r' )? '\\n'
			{
			// CalcLab.g:122:11: ( '\\r' )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='\r') ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// CalcLab.g:122:11: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	// $ANTLR start "DECIMAL_SEPARATOR"
	public final void mDECIMAL_SEPARATOR() throws RecognitionException {
		try {
			int _type = DECIMAL_SEPARATOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:123:19: ( '.' )
			// CalcLab.g:123:21: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DECIMAL_SEPARATOR"

	// $ANTLR start "ARGUMENTS_SEPARATOR"
	public final void mARGUMENTS_SEPARATOR() throws RecognitionException {
		try {
			int _type = ARGUMENTS_SEPARATOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:124:21: ( ',' )
			// CalcLab.g:124:23: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ARGUMENTS_SEPARATOR"

	// $ANTLR start "EXPRESSIONS_SEPARATOR"
	public final void mEXPRESSIONS_SEPARATOR() throws RecognitionException {
		try {
			int _type = EXPRESSIONS_SEPARATOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:125:23: ( ( NEWLINE )* ';' ( NEWLINE )* )
			// CalcLab.g:125:25: ( NEWLINE )* ';' ( NEWLINE )*
			{
			// CalcLab.g:125:25: ( NEWLINE )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='\n'||LA4_0=='\r') ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// CalcLab.g:125:25: NEWLINE
					{
					mNEWLINE(); 

					}
					break;

				default :
					break loop4;
				}
			}

			match(';'); 
			// CalcLab.g:125:38: ( NEWLINE )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0=='\n'||LA5_0=='\r') ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// CalcLab.g:125:38: NEWLINE
					{
					mNEWLINE(); 

					}
					break;

				default :
					break loop5;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXPRESSIONS_SEPARATOR"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:126:3: ( ( ' ' | '\\n' | '\\r' )+ )
			// CalcLab.g:126:5: ( ' ' | '\\n' | '\\r' )+
			{
			// CalcLab.g:126:5: ( ' ' | '\\n' | '\\r' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0=='\n'||LA6_0=='\r'||LA6_0==' ') ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// CalcLab.g:
					{
					if ( input.LA(1)=='\n'||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// CalcLab.g:1:8: ( PLUS | MINUS | MULTIPLY | DIVISION | INVOLUTION | FACTORIAL | DIGIT | NAME | OPENING_PARENTHESIS | CLOSING_PARENTHESIS | NEWLINE | DECIMAL_SEPARATOR | ARGUMENTS_SEPARATOR | EXPRESSIONS_SEPARATOR | WS )
		int alt7=15;
		alt7 = dfa7.predict(input);
		switch (alt7) {
			case 1 :
				// CalcLab.g:1:10: PLUS
				{
				mPLUS(); 

				}
				break;
			case 2 :
				// CalcLab.g:1:15: MINUS
				{
				mMINUS(); 

				}
				break;
			case 3 :
				// CalcLab.g:1:21: MULTIPLY
				{
				mMULTIPLY(); 

				}
				break;
			case 4 :
				// CalcLab.g:1:30: DIVISION
				{
				mDIVISION(); 

				}
				break;
			case 5 :
				// CalcLab.g:1:39: INVOLUTION
				{
				mINVOLUTION(); 

				}
				break;
			case 6 :
				// CalcLab.g:1:50: FACTORIAL
				{
				mFACTORIAL(); 

				}
				break;
			case 7 :
				// CalcLab.g:1:60: DIGIT
				{
				mDIGIT(); 

				}
				break;
			case 8 :
				// CalcLab.g:1:66: NAME
				{
				mNAME(); 

				}
				break;
			case 9 :
				// CalcLab.g:1:71: OPENING_PARENTHESIS
				{
				mOPENING_PARENTHESIS(); 

				}
				break;
			case 10 :
				// CalcLab.g:1:91: CLOSING_PARENTHESIS
				{
				mCLOSING_PARENTHESIS(); 

				}
				break;
			case 11 :
				// CalcLab.g:1:111: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 12 :
				// CalcLab.g:1:119: DECIMAL_SEPARATOR
				{
				mDECIMAL_SEPARATOR(); 

				}
				break;
			case 13 :
				// CalcLab.g:1:137: ARGUMENTS_SEPARATOR
				{
				mARGUMENTS_SEPARATOR(); 

				}
				break;
			case 14 :
				// CalcLab.g:1:157: EXPRESSIONS_SEPARATOR
				{
				mEXPRESSIONS_SEPARATOR(); 

				}
				break;
			case 15 :
				// CalcLab.g:1:179: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA7 dfa7 = new DFA7(this);
	static final String DFA7_eotS =
		"\13\uffff\1\20\1\21\5\uffff\2\20";
	static final String DFA7_eofS =
		"\24\uffff";
	static final String DFA7_minS =
		"\1\12\12\uffff\2\12\5\uffff\2\12";
	static final String DFA7_maxS =
		"\1\172\12\uffff\1\12\1\73\5\uffff\1\12\1\73";
	static final String DFA7_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\2\uffff\1\14\1\15"+
		"\1\16\1\17\1\13\2\uffff";
	static final String DFA7_specialS =
		"\24\uffff}>";
	static final String[] DFA7_transitionS = {
			"\1\14\2\uffff\1\13\22\uffff\1\20\1\6\6\uffff\1\11\1\12\1\3\1\1\1\16\1"+
			"\2\1\15\1\4\12\7\1\uffff\1\17\5\uffff\32\10\3\uffff\1\5\1\10\1\uffff"+
			"\32\10",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\14",
			"\1\23\2\uffff\1\22\22\uffff\1\20\32\uffff\1\17",
			"",
			"",
			"",
			"",
			"",
			"\1\23",
			"\1\23\2\uffff\1\22\55\uffff\1\17"
	};

	static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
	static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
	static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
	static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
	static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
	static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
	static final short[][] DFA7_transition;

	static {
		int numStates = DFA7_transitionS.length;
		DFA7_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
		}
	}

	protected class DFA7 extends DFA {

		public DFA7(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 7;
			this.eot = DFA7_eot;
			this.eof = DFA7_eof;
			this.min = DFA7_min;
			this.max = DFA7_max;
			this.accept = DFA7_accept;
			this.special = DFA7_special;
			this.transition = DFA7_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( PLUS | MINUS | MULTIPLY | DIVISION | INVOLUTION | FACTORIAL | DIGIT | NAME | OPENING_PARENTHESIS | CLOSING_PARENTHESIS | NEWLINE | DECIMAL_SEPARATOR | ARGUMENTS_SEPARATOR | EXPRESSIONS_SEPARATOR | WS );";
		}
	}

}
