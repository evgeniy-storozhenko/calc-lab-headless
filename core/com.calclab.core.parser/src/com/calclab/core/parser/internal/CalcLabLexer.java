// $ANTLR 3.5.2 CalcLab.g 2016-04-09 17:54:09

	package com.calclab.core.parser.internal;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CalcLabLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int ARGUMENTS_SEPARATOR=4;
	public static final int CHAR=5;
	public static final int CLOSING_PARENTHESIS=6;
	public static final int CLOSING_SQ_PARENTHESIS=7;
	public static final int DECIMAL_SEPARATOR=8;
	public static final int DIGIT=9;
	public static final int DIVISION=10;
	public static final int EQUALS=11;
	public static final int EXPRESSIONS_SEPARATOR=12;
	public static final int FACTORIAL=13;
	public static final int HELP=14;
	public static final int ID=15;
	public static final int INVOLUTION=16;
	public static final int MINUS=17;
	public static final int MULTIPLY=18;
	public static final int NAME=19;
	public static final int OPENING_PARENTHESIS=20;
	public static final int OPENING_SQ_PARENTHESIS=21;
	public static final int PLUS=22;
	public static final int REMAINDER=23;
	public static final int S=24;

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

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:11:7: ( ' ' )
			// CalcLab.g:11:9: ' '
			{
			match(' '); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:12:7: ( 'E' )
			// CalcLab.g:12:9: 'E'
			{
			match('E'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:13:7: ( '\\n' )
			// CalcLab.g:13:9: '\\n'
			{
			match('\n'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:14:7: ( '\\r' )
			// CalcLab.g:14:9: '\\r'
			{
			match('\r'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:15:7: ( '\\t' )
			// CalcLab.g:15:9: '\\t'
			{
			match('\t'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:16:7: ( 'e' )
			// CalcLab.g:16:9: 'e'
			{
			match('e'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__30"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:205:7: ( ( S )* '+' ( S )* )
			// CalcLab.g:205:9: ( S )* '+' ( S )*
			{
			// CalcLab.g:205:9: ( S )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\t' && LA1_0 <= '\n')||LA1_0=='\r'||LA1_0==' ') ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// CalcLab.g:205:9: S
					{
					mS(); 

					}
					break;

				default :
					break loop1;
				}
			}

			match('+'); 
			// CalcLab.g:205:16: ( S )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '\t' && LA2_0 <= '\n')||LA2_0=='\r'||LA2_0==' ') ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// CalcLab.g:205:16: S
					{
					mS(); 

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
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:206:7: ( ( S )* '-' ( S )* )
			// CalcLab.g:206:9: ( S )* '-' ( S )*
			{
			// CalcLab.g:206:9: ( S )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '\t' && LA3_0 <= '\n')||LA3_0=='\r'||LA3_0==' ') ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// CalcLab.g:206:9: S
					{
					mS(); 

					}
					break;

				default :
					break loop3;
				}
			}

			match('-'); 
			// CalcLab.g:206:16: ( S )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '\t' && LA4_0 <= '\n')||LA4_0=='\r'||LA4_0==' ') ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// CalcLab.g:206:16: S
					{
					mS(); 

					}
					break;

				default :
					break loop4;
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
	// $ANTLR end "MINUS"

	// $ANTLR start "MULTIPLY"
	public final void mMULTIPLY() throws RecognitionException {
		try {
			int _type = MULTIPLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:207:10: ( ( S )* '*' ( S )* )
			// CalcLab.g:207:12: ( S )* '*' ( S )*
			{
			// CalcLab.g:207:12: ( S )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= '\t' && LA5_0 <= '\n')||LA5_0=='\r'||LA5_0==' ') ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// CalcLab.g:207:12: S
					{
					mS(); 

					}
					break;

				default :
					break loop5;
				}
			}

			match('*'); 
			// CalcLab.g:207:19: ( S )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '\t' && LA6_0 <= '\n')||LA6_0=='\r'||LA6_0==' ') ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// CalcLab.g:207:19: S
					{
					mS(); 

					}
					break;

				default :
					break loop6;
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
	// $ANTLR end "MULTIPLY"

	// $ANTLR start "DIVISION"
	public final void mDIVISION() throws RecognitionException {
		try {
			int _type = DIVISION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:208:10: ( ( S )* '/' ( S )* )
			// CalcLab.g:208:12: ( S )* '/' ( S )*
			{
			// CalcLab.g:208:12: ( S )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '\t' && LA7_0 <= '\n')||LA7_0=='\r'||LA7_0==' ') ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// CalcLab.g:208:12: S
					{
					mS(); 

					}
					break;

				default :
					break loop7;
				}
			}

			match('/'); 
			// CalcLab.g:208:19: ( S )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '\t' && LA8_0 <= '\n')||LA8_0=='\r'||LA8_0==' ') ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// CalcLab.g:208:19: S
					{
					mS(); 

					}
					break;

				default :
					break loop8;
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
	// $ANTLR end "DIVISION"

	// $ANTLR start "EQUALS"
	public final void mEQUALS() throws RecognitionException {
		try {
			int _type = EQUALS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:209:8: ( ( S )* '=' ( S )* )
			// CalcLab.g:209:10: ( S )* '=' ( S )*
			{
			// CalcLab.g:209:10: ( S )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '\t' && LA9_0 <= '\n')||LA9_0=='\r'||LA9_0==' ') ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// CalcLab.g:209:10: S
					{
					mS(); 

					}
					break;

				default :
					break loop9;
				}
			}

			match('='); 
			// CalcLab.g:209:17: ( S )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= '\t' && LA10_0 <= '\n')||LA10_0=='\r'||LA10_0==' ') ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// CalcLab.g:209:17: S
					{
					mS(); 

					}
					break;

				default :
					break loop10;
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
	// $ANTLR end "EQUALS"

	// $ANTLR start "REMAINDER"
	public final void mREMAINDER() throws RecognitionException {
		try {
			int _type = REMAINDER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:210:11: ( ( S )* '%' ( S )* )
			// CalcLab.g:210:13: ( S )* '%' ( S )*
			{
			// CalcLab.g:210:13: ( S )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= '\t' && LA11_0 <= '\n')||LA11_0=='\r'||LA11_0==' ') ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// CalcLab.g:210:13: S
					{
					mS(); 

					}
					break;

				default :
					break loop11;
				}
			}

			match('%'); 
			// CalcLab.g:210:20: ( S )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( ((LA12_0 >= '\t' && LA12_0 <= '\n')||LA12_0=='\r'||LA12_0==' ') ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// CalcLab.g:210:20: S
					{
					mS(); 

					}
					break;

				default :
					break loop12;
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
	// $ANTLR end "REMAINDER"

	// $ANTLR start "INVOLUTION"
	public final void mINVOLUTION() throws RecognitionException {
		try {
			int _type = INVOLUTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:213:12: ( ( S )* '^' ( S )* )
			// CalcLab.g:213:14: ( S )* '^' ( S )*
			{
			// CalcLab.g:213:14: ( S )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( ((LA13_0 >= '\t' && LA13_0 <= '\n')||LA13_0=='\r'||LA13_0==' ') ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// CalcLab.g:213:14: S
					{
					mS(); 

					}
					break;

				default :
					break loop13;
				}
			}

			match('^'); 
			// CalcLab.g:213:21: ( S )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( ((LA14_0 >= '\t' && LA14_0 <= '\n')||LA14_0=='\r'||LA14_0==' ') ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// CalcLab.g:213:21: S
					{
					mS(); 

					}
					break;

				default :
					break loop14;
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
	// $ANTLR end "INVOLUTION"

	// $ANTLR start "FACTORIAL"
	public final void mFACTORIAL() throws RecognitionException {
		try {
			int _type = FACTORIAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:214:11: ( ( S )* '!' ( S )* )
			// CalcLab.g:214:13: ( S )* '!' ( S )*
			{
			// CalcLab.g:214:13: ( S )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( ((LA15_0 >= '\t' && LA15_0 <= '\n')||LA15_0=='\r'||LA15_0==' ') ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// CalcLab.g:214:13: S
					{
					mS(); 

					}
					break;

				default :
					break loop15;
				}
			}

			match('!'); 
			// CalcLab.g:214:20: ( S )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( ((LA16_0 >= '\t' && LA16_0 <= '\n')||LA16_0=='\r'||LA16_0==' ') ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// CalcLab.g:214:20: S
					{
					mS(); 

					}
					break;

				default :
					break loop16;
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
	// $ANTLR end "FACTORIAL"

	// $ANTLR start "HELP"
	public final void mHELP() throws RecognitionException {
		try {
			int _type = HELP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:217:5: ( 'help' ( S )* )
			// CalcLab.g:217:7: 'help' ( S )*
			{
			match("help"); 

			// CalcLab.g:217:14: ( S )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( ((LA17_0 >= '\t' && LA17_0 <= '\n')||LA17_0=='\r'||LA17_0==' ') ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// CalcLab.g:217:14: S
					{
					mS(); 

					}
					break;

				default :
					break loop17;
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
	// $ANTLR end "HELP"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			int _type = DIGIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:220:7: ( ( '0' .. '9' )+ )
			// CalcLab.g:220:9: ( '0' .. '9' )+
			{
			// CalcLab.g:220:9: ( '0' .. '9' )+
			int cnt18=0;
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( ((LA18_0 >= '0' && LA18_0 <= '9')) ) {
					alt18=1;
				}

				switch (alt18) {
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
					if ( cnt18 >= 1 ) break loop18;
					EarlyExitException eee = new EarlyExitException(18, input);
					throw eee;
				}
				cnt18++;
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
			// CalcLab.g:221:6: ( ( S )* ID ( ID | DIGIT )* ( S )* )
			// CalcLab.g:221:8: ( S )* ID ( ID | DIGIT )* ( S )*
			{
			// CalcLab.g:221:8: ( S )*
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( ((LA19_0 >= '\t' && LA19_0 <= '\n')||LA19_0=='\r'||LA19_0==' ') ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// CalcLab.g:221:8: S
					{
					mS(); 

					}
					break;

				default :
					break loop19;
				}
			}

			mID(); 

			// CalcLab.g:221:14: ( ID | DIGIT )*
			loop20:
			while (true) {
				int alt20=3;
				int LA20_0 = input.LA(1);
				if ( ((LA20_0 >= 'A' && LA20_0 <= 'Z')||LA20_0=='_'||(LA20_0 >= 'a' && LA20_0 <= 'z')) ) {
					alt20=1;
				}
				else if ( ((LA20_0 >= '0' && LA20_0 <= '9')) ) {
					alt20=2;
				}

				switch (alt20) {
				case 1 :
					// CalcLab.g:221:15: ID
					{
					mID(); 

					}
					break;
				case 2 :
					// CalcLab.g:221:19: DIGIT
					{
					mDIGIT(); 

					}
					break;

				default :
					break loop20;
				}
			}

			// CalcLab.g:221:27: ( S )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( ((LA21_0 >= '\t' && LA21_0 <= '\n')||LA21_0=='\r'||LA21_0==' ') ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// CalcLab.g:221:27: S
					{
					mS(); 

					}
					break;

				default :
					break loop21;
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
			// CalcLab.g:222:13: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) )
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
			// CalcLab.g:223:15: ( 'A' .. 'z' )
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
			// CalcLab.g:224:21: ( ( S )* '(' ( S )* )
			// CalcLab.g:224:23: ( S )* '(' ( S )*
			{
			// CalcLab.g:224:23: ( S )*
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( ((LA22_0 >= '\t' && LA22_0 <= '\n')||LA22_0=='\r'||LA22_0==' ') ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// CalcLab.g:224:23: S
					{
					mS(); 

					}
					break;

				default :
					break loop22;
				}
			}

			match('('); 
			// CalcLab.g:224:30: ( S )*
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( ((LA23_0 >= '\t' && LA23_0 <= '\n')||LA23_0=='\r'||LA23_0==' ') ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// CalcLab.g:224:30: S
					{
					mS(); 

					}
					break;

				default :
					break loop23;
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
	// $ANTLR end "OPENING_PARENTHESIS"

	// $ANTLR start "CLOSING_PARENTHESIS"
	public final void mCLOSING_PARENTHESIS() throws RecognitionException {
		try {
			int _type = CLOSING_PARENTHESIS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:225:21: ( ( S )* ')' ( S )* )
			// CalcLab.g:225:23: ( S )* ')' ( S )*
			{
			// CalcLab.g:225:23: ( S )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( ((LA24_0 >= '\t' && LA24_0 <= '\n')||LA24_0=='\r'||LA24_0==' ') ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// CalcLab.g:225:23: S
					{
					mS(); 

					}
					break;

				default :
					break loop24;
				}
			}

			match(')'); 
			// CalcLab.g:225:30: ( S )*
			loop25:
			while (true) {
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( ((LA25_0 >= '\t' && LA25_0 <= '\n')||LA25_0=='\r'||LA25_0==' ') ) {
					alt25=1;
				}

				switch (alt25) {
				case 1 :
					// CalcLab.g:225:30: S
					{
					mS(); 

					}
					break;

				default :
					break loop25;
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
	// $ANTLR end "CLOSING_PARENTHESIS"

	// $ANTLR start "OPENING_SQ_PARENTHESIS"
	public final void mOPENING_SQ_PARENTHESIS() throws RecognitionException {
		try {
			int _type = OPENING_SQ_PARENTHESIS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:226:24: ( ( S )* '[' ( S )* )
			// CalcLab.g:226:26: ( S )* '[' ( S )*
			{
			// CalcLab.g:226:26: ( S )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( ((LA26_0 >= '\t' && LA26_0 <= '\n')||LA26_0=='\r'||LA26_0==' ') ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// CalcLab.g:226:26: S
					{
					mS(); 

					}
					break;

				default :
					break loop26;
				}
			}

			match('['); 
			// CalcLab.g:226:33: ( S )*
			loop27:
			while (true) {
				int alt27=2;
				int LA27_0 = input.LA(1);
				if ( ((LA27_0 >= '\t' && LA27_0 <= '\n')||LA27_0=='\r'||LA27_0==' ') ) {
					alt27=1;
				}

				switch (alt27) {
				case 1 :
					// CalcLab.g:226:33: S
					{
					mS(); 

					}
					break;

				default :
					break loop27;
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
	// $ANTLR end "OPENING_SQ_PARENTHESIS"

	// $ANTLR start "CLOSING_SQ_PARENTHESIS"
	public final void mCLOSING_SQ_PARENTHESIS() throws RecognitionException {
		try {
			int _type = CLOSING_SQ_PARENTHESIS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:227:24: ( ( S )* ']' ( S )* )
			// CalcLab.g:227:26: ( S )* ']' ( S )*
			{
			// CalcLab.g:227:26: ( S )*
			loop28:
			while (true) {
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( ((LA28_0 >= '\t' && LA28_0 <= '\n')||LA28_0=='\r'||LA28_0==' ') ) {
					alt28=1;
				}

				switch (alt28) {
				case 1 :
					// CalcLab.g:227:26: S
					{
					mS(); 

					}
					break;

				default :
					break loop28;
				}
			}

			match(']'); 
			// CalcLab.g:227:33: ( S )*
			loop29:
			while (true) {
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( ((LA29_0 >= '\t' && LA29_0 <= '\n')||LA29_0=='\r'||LA29_0==' ') ) {
					alt29=1;
				}

				switch (alt29) {
				case 1 :
					// CalcLab.g:227:33: S
					{
					mS(); 

					}
					break;

				default :
					break loop29;
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
	// $ANTLR end "CLOSING_SQ_PARENTHESIS"

	// $ANTLR start "DECIMAL_SEPARATOR"
	public final void mDECIMAL_SEPARATOR() throws RecognitionException {
		try {
			int _type = DECIMAL_SEPARATOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:228:19: ( '.' )
			// CalcLab.g:228:21: '.'
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
			// CalcLab.g:229:21: ( ',' )
			// CalcLab.g:229:23: ','
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
			// CalcLab.g:230:23: ( ( S )* ';' ( S )* )
			// CalcLab.g:230:25: ( S )* ';' ( S )*
			{
			// CalcLab.g:230:25: ( S )*
			loop30:
			while (true) {
				int alt30=2;
				int LA30_0 = input.LA(1);
				if ( ((LA30_0 >= '\t' && LA30_0 <= '\n')||LA30_0=='\r'||LA30_0==' ') ) {
					alt30=1;
				}

				switch (alt30) {
				case 1 :
					// CalcLab.g:230:25: S
					{
					mS(); 

					}
					break;

				default :
					break loop30;
				}
			}

			match(';'); 
			// CalcLab.g:230:32: ( S )*
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( ((LA31_0 >= '\t' && LA31_0 <= '\n')||LA31_0=='\r'||LA31_0==' ') ) {
					alt31=1;
				}

				switch (alt31) {
				case 1 :
					// CalcLab.g:230:32: S
					{
					mS(); 

					}
					break;

				default :
					break loop31;
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

	// $ANTLR start "S"
	public final void mS() throws RecognitionException {
		try {
			int _type = S;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:231:2: ( ( ' ' | '\\n' | '\\r' | '\\t' )+ )
			// CalcLab.g:231:4: ( ' ' | '\\n' | '\\r' | '\\t' )+
			{
			// CalcLab.g:231:4: ( ' ' | '\\n' | '\\r' | '\\t' )+
			int cnt32=0;
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( ((LA32_0 >= '\t' && LA32_0 <= '\n')||LA32_0=='\r'||LA32_0==' ') ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// CalcLab.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
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
					if ( cnt32 >= 1 ) break loop32;
					EarlyExitException eee = new EarlyExitException(32, input);
					throw eee;
				}
				cnt32++;
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
	// $ANTLR end "S"

	@Override
	public void mTokens() throws RecognitionException {
		// CalcLab.g:1:8: ( T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | PLUS | MINUS | MULTIPLY | DIVISION | EQUALS | REMAINDER | INVOLUTION | FACTORIAL | HELP | DIGIT | NAME | OPENING_PARENTHESIS | CLOSING_PARENTHESIS | OPENING_SQ_PARENTHESIS | CLOSING_SQ_PARENTHESIS | DECIMAL_SEPARATOR | ARGUMENTS_SEPARATOR | EXPRESSIONS_SEPARATOR | S )
		int alt33=25;
		alt33 = dfa33.predict(input);
		switch (alt33) {
			case 1 :
				// CalcLab.g:1:10: T__25
				{
				mT__25(); 

				}
				break;
			case 2 :
				// CalcLab.g:1:16: T__26
				{
				mT__26(); 

				}
				break;
			case 3 :
				// CalcLab.g:1:22: T__27
				{
				mT__27(); 

				}
				break;
			case 4 :
				// CalcLab.g:1:28: T__28
				{
				mT__28(); 

				}
				break;
			case 5 :
				// CalcLab.g:1:34: T__29
				{
				mT__29(); 

				}
				break;
			case 6 :
				// CalcLab.g:1:40: T__30
				{
				mT__30(); 

				}
				break;
			case 7 :
				// CalcLab.g:1:46: PLUS
				{
				mPLUS(); 

				}
				break;
			case 8 :
				// CalcLab.g:1:51: MINUS
				{
				mMINUS(); 

				}
				break;
			case 9 :
				// CalcLab.g:1:57: MULTIPLY
				{
				mMULTIPLY(); 

				}
				break;
			case 10 :
				// CalcLab.g:1:66: DIVISION
				{
				mDIVISION(); 

				}
				break;
			case 11 :
				// CalcLab.g:1:75: EQUALS
				{
				mEQUALS(); 

				}
				break;
			case 12 :
				// CalcLab.g:1:82: REMAINDER
				{
				mREMAINDER(); 

				}
				break;
			case 13 :
				// CalcLab.g:1:92: INVOLUTION
				{
				mINVOLUTION(); 

				}
				break;
			case 14 :
				// CalcLab.g:1:103: FACTORIAL
				{
				mFACTORIAL(); 

				}
				break;
			case 15 :
				// CalcLab.g:1:113: HELP
				{
				mHELP(); 

				}
				break;
			case 16 :
				// CalcLab.g:1:118: DIGIT
				{
				mDIGIT(); 

				}
				break;
			case 17 :
				// CalcLab.g:1:124: NAME
				{
				mNAME(); 

				}
				break;
			case 18 :
				// CalcLab.g:1:129: OPENING_PARENTHESIS
				{
				mOPENING_PARENTHESIS(); 

				}
				break;
			case 19 :
				// CalcLab.g:1:149: CLOSING_PARENTHESIS
				{
				mCLOSING_PARENTHESIS(); 

				}
				break;
			case 20 :
				// CalcLab.g:1:169: OPENING_SQ_PARENTHESIS
				{
				mOPENING_SQ_PARENTHESIS(); 

				}
				break;
			case 21 :
				// CalcLab.g:1:192: CLOSING_SQ_PARENTHESIS
				{
				mCLOSING_SQ_PARENTHESIS(); 

				}
				break;
			case 22 :
				// CalcLab.g:1:215: DECIMAL_SEPARATOR
				{
				mDECIMAL_SEPARATOR(); 

				}
				break;
			case 23 :
				// CalcLab.g:1:233: ARGUMENTS_SEPARATOR
				{
				mARGUMENTS_SEPARATOR(); 

				}
				break;
			case 24 :
				// CalcLab.g:1:253: EXPRESSIONS_SEPARATOR
				{
				mEXPRESSIONS_SEPARATOR(); 

				}
				break;
			case 25 :
				// CalcLab.g:1:275: S
				{
				mS(); 

				}
				break;

		}
	}


	protected DFA33 dfa33 = new DFA33(this);
	static final String DFA33_eotS =
		"\1\uffff\1\31\1\33\1\34\1\35\1\36\1\37\10\uffff\1\21\12\uffff\1\41\5\uffff"+
		"\1\21\1\uffff\1\21\2\45\1\uffff";
	static final String DFA33_eofS =
		"\46\uffff";
	static final String DFA33_minS =
		"\7\11\10\uffff\1\145\12\uffff\1\11\5\uffff\1\154\1\uffff\1\160\2\11\1"+
		"\uffff";
	static final String DFA33_maxS =
		"\7\172\10\uffff\1\145\12\uffff\1\172\5\uffff\1\154\1\uffff\1\160\1\172"+
		"\1\40\1\uffff";
	static final String DFA33_acceptS =
		"\7\uffff\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\uffff\1\20\1\21\1\22"+
		"\1\23\1\24\1\25\1\26\1\27\1\30\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\1\uffff"+
		"\1\31\3\uffff\1\17";
	static final String DFA33_specialS =
		"\46\uffff}>";
	static final String[] DFA33_transitionS = {
			"\1\5\1\3\2\uffff\1\4\22\uffff\1\1\1\16\3\uffff\1\14\2\uffff\1\22\1\23"+
			"\1\11\1\7\1\27\1\10\1\26\1\12\12\20\1\uffff\1\30\1\uffff\1\13\3\uffff"+
			"\4\21\1\2\25\21\1\24\1\uffff\1\25\1\15\1\21\1\uffff\4\21\1\6\2\21\1\17"+
			"\22\21",
			"\2\32\2\uffff\1\32\22\uffff\1\32\1\16\3\uffff\1\14\2\uffff\1\22\1\23"+
			"\1\11\1\7\1\uffff\1\10\1\uffff\1\12\13\uffff\1\30\1\uffff\1\13\3\uffff"+
			"\32\21\1\24\1\uffff\1\25\1\15\1\21\1\uffff\32\21",
			"\2\21\2\uffff\1\21\22\uffff\1\21\17\uffff\12\21\7\uffff\32\21\4\uffff"+
			"\1\21\1\uffff\32\21",
			"\2\32\2\uffff\1\32\22\uffff\1\32\1\16\3\uffff\1\14\2\uffff\1\22\1\23"+
			"\1\11\1\7\1\uffff\1\10\1\uffff\1\12\13\uffff\1\30\1\uffff\1\13\3\uffff"+
			"\32\21\1\24\1\uffff\1\25\1\15\1\21\1\uffff\32\21",
			"\2\32\2\uffff\1\32\22\uffff\1\32\1\16\3\uffff\1\14\2\uffff\1\22\1\23"+
			"\1\11\1\7\1\uffff\1\10\1\uffff\1\12\13\uffff\1\30\1\uffff\1\13\3\uffff"+
			"\32\21\1\24\1\uffff\1\25\1\15\1\21\1\uffff\32\21",
			"\2\32\2\uffff\1\32\22\uffff\1\32\1\16\3\uffff\1\14\2\uffff\1\22\1\23"+
			"\1\11\1\7\1\uffff\1\10\1\uffff\1\12\13\uffff\1\30\1\uffff\1\13\3\uffff"+
			"\32\21\1\24\1\uffff\1\25\1\15\1\21\1\uffff\32\21",
			"\2\21\2\uffff\1\21\22\uffff\1\21\17\uffff\12\21\7\uffff\32\21\4\uffff"+
			"\1\21\1\uffff\32\21",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\40",
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
			"\2\32\2\uffff\1\32\22\uffff\1\32\1\16\3\uffff\1\14\2\uffff\1\22\1\23"+
			"\1\11\1\7\1\uffff\1\10\1\uffff\1\12\13\uffff\1\30\1\uffff\1\13\3\uffff"+
			"\32\21\1\24\1\uffff\1\25\1\15\1\21\1\uffff\32\21",
			"",
			"",
			"",
			"",
			"",
			"\1\42",
			"",
			"\1\43",
			"\2\44\2\uffff\1\44\22\uffff\1\44\17\uffff\12\21\7\uffff\32\21\4\uffff"+
			"\1\21\1\uffff\32\21",
			"\2\44\2\uffff\1\44\22\uffff\1\44",
			""
	};

	static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
	static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
	static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
	static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
	static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
	static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
	static final short[][] DFA33_transition;

	static {
		int numStates = DFA33_transitionS.length;
		DFA33_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
		}
	}

	protected class DFA33 extends DFA {

		public DFA33(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 33;
			this.eot = DFA33_eot;
			this.eof = DFA33_eof;
			this.min = DFA33_min;
			this.max = DFA33_max;
			this.accept = DFA33_accept;
			this.special = DFA33_special;
			this.transition = DFA33_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | PLUS | MINUS | MULTIPLY | DIVISION | EQUALS | REMAINDER | INVOLUTION | FACTORIAL | HELP | DIGIT | NAME | OPENING_PARENTHESIS | CLOSING_PARENTHESIS | OPENING_SQ_PARENTHESIS | CLOSING_SQ_PARENTHESIS | DECIMAL_SEPARATOR | ARGUMENTS_SEPARATOR | EXPRESSIONS_SEPARATOR | S );";
		}
	}

}
