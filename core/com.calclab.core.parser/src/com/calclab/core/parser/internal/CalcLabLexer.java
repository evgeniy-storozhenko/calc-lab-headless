// $ANTLR 3.5.2 CalcLab.g 2015-08-31 11:57:26

package com.calclab.core.parser.internal;

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;

@SuppressWarnings("all")
public class CalcLabLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public CalcLabLexer() {
	}

	public CalcLabLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}

	public CalcLabLexer(CharStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override
	public String getGrammarFileName() {
		return "CalcLab.g";
	}

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:11:7: ( ' ' )
			// CalcLab.g:11:9: ' '
			{
				match(' ');
			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__24"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:191:7: ( ( S )* '+' ( S )* )
			// CalcLab.g:191:9: ( S )* '+' ( S )*
			{
				// CalcLab.g:191:9: ( S )*
				loop1: while (true) {
					int alt1 = 2;
					int LA1_0 = input.LA(1);
					if (((LA1_0 >= '\t' && LA1_0 <= '\n') || LA1_0 == '\r' || LA1_0 == ' ')) {
						alt1 = 1;
					}

					switch (alt1) {
					case 1:
					// CalcLab.g:191:9: S
					{
						mS();

					}
						break;

					default:
						break loop1;
					}
				}

				match('+');
				// CalcLab.g:191:16: ( S )*
				loop2: while (true) {
					int alt2 = 2;
					int LA2_0 = input.LA(1);
					if (((LA2_0 >= '\t' && LA2_0 <= '\n') || LA2_0 == '\r' || LA2_0 == ' ')) {
						alt2 = 1;
					}

					switch (alt2) {
					case 1:
					// CalcLab.g:191:16: S
					{
						mS();

					}
						break;

					default:
						break loop2;
					}
				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:192:7: ( ( S )* '-' ( S )* )
			// CalcLab.g:192:9: ( S )* '-' ( S )*
			{
				// CalcLab.g:192:9: ( S )*
				loop3: while (true) {
					int alt3 = 2;
					int LA3_0 = input.LA(1);
					if (((LA3_0 >= '\t' && LA3_0 <= '\n') || LA3_0 == '\r' || LA3_0 == ' ')) {
						alt3 = 1;
					}

					switch (alt3) {
					case 1:
					// CalcLab.g:192:9: S
					{
						mS();

					}
						break;

					default:
						break loop3;
					}
				}

				match('-');
				// CalcLab.g:192:16: ( S )*
				loop4: while (true) {
					int alt4 = 2;
					int LA4_0 = input.LA(1);
					if (((LA4_0 >= '\t' && LA4_0 <= '\n') || LA4_0 == '\r' || LA4_0 == ' ')) {
						alt4 = 1;
					}

					switch (alt4) {
					case 1:
					// CalcLab.g:192:16: S
					{
						mS();

					}
						break;

					default:
						break loop4;
					}
				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "MULTIPLY"
	public final void mMULTIPLY() throws RecognitionException {
		try {
			int _type = MULTIPLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:193:10: ( ( S )* '*' ( S )* )
			// CalcLab.g:193:12: ( S )* '*' ( S )*
			{
				// CalcLab.g:193:12: ( S )*
				loop5: while (true) {
					int alt5 = 2;
					int LA5_0 = input.LA(1);
					if (((LA5_0 >= '\t' && LA5_0 <= '\n') || LA5_0 == '\r' || LA5_0 == ' ')) {
						alt5 = 1;
					}

					switch (alt5) {
					case 1:
					// CalcLab.g:193:12: S
					{
						mS();

					}
						break;

					default:
						break loop5;
					}
				}

				match('*');
				// CalcLab.g:193:19: ( S )*
				loop6: while (true) {
					int alt6 = 2;
					int LA6_0 = input.LA(1);
					if (((LA6_0 >= '\t' && LA6_0 <= '\n') || LA6_0 == '\r' || LA6_0 == ' ')) {
						alt6 = 1;
					}

					switch (alt6) {
					case 1:
					// CalcLab.g:193:19: S
					{
						mS();

					}
						break;

					default:
						break loop6;
					}
				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULTIPLY"

	// $ANTLR start "DIVISION"
	public final void mDIVISION() throws RecognitionException {
		try {
			int _type = DIVISION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:194:10: ( ( S )* '/' ( S )* )
			// CalcLab.g:194:12: ( S )* '/' ( S )*
			{
				// CalcLab.g:194:12: ( S )*
				loop7: while (true) {
					int alt7 = 2;
					int LA7_0 = input.LA(1);
					if (((LA7_0 >= '\t' && LA7_0 <= '\n') || LA7_0 == '\r' || LA7_0 == ' ')) {
						alt7 = 1;
					}

					switch (alt7) {
					case 1:
					// CalcLab.g:194:12: S
					{
						mS();

					}
						break;

					default:
						break loop7;
					}
				}

				match('/');
				// CalcLab.g:194:19: ( S )*
				loop8: while (true) {
					int alt8 = 2;
					int LA8_0 = input.LA(1);
					if (((LA8_0 >= '\t' && LA8_0 <= '\n') || LA8_0 == '\r' || LA8_0 == ' ')) {
						alt8 = 1;
					}

					switch (alt8) {
					case 1:
					// CalcLab.g:194:19: S
					{
						mS();

					}
						break;

					default:
						break loop8;
					}
				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIVISION"

	// $ANTLR start "EQUALS"
	public final void mEQUALS() throws RecognitionException {
		try {
			int _type = EQUALS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:195:8: ( ( S )* '=' ( S )* )
			// CalcLab.g:195:10: ( S )* '=' ( S )*
			{
				// CalcLab.g:195:10: ( S )*
				loop9: while (true) {
					int alt9 = 2;
					int LA9_0 = input.LA(1);
					if (((LA9_0 >= '\t' && LA9_0 <= '\n') || LA9_0 == '\r' || LA9_0 == ' ')) {
						alt9 = 1;
					}

					switch (alt9) {
					case 1:
					// CalcLab.g:195:10: S
					{
						mS();

					}
						break;

					default:
						break loop9;
					}
				}

				match('=');
				// CalcLab.g:195:17: ( S )*
				loop10: while (true) {
					int alt10 = 2;
					int LA10_0 = input.LA(1);
					if (((LA10_0 >= '\t' && LA10_0 <= '\n') || LA10_0 == '\r' || LA10_0 == ' ')) {
						alt10 = 1;
					}

					switch (alt10) {
					case 1:
					// CalcLab.g:195:17: S
					{
						mS();

					}
						break;

					default:
						break loop10;
					}
				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQUALS"

	// $ANTLR start "REMAINDER"
	public final void mREMAINDER() throws RecognitionException {
		try {
			int _type = REMAINDER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:196:11: ( ( S )* '%' ( S )* )
			// CalcLab.g:196:13: ( S )* '%' ( S )*
			{
				// CalcLab.g:196:13: ( S )*
				loop11: while (true) {
					int alt11 = 2;
					int LA11_0 = input.LA(1);
					if (((LA11_0 >= '\t' && LA11_0 <= '\n') || LA11_0 == '\r' || LA11_0 == ' ')) {
						alt11 = 1;
					}

					switch (alt11) {
					case 1:
					// CalcLab.g:196:13: S
					{
						mS();

					}
						break;

					default:
						break loop11;
					}
				}

				match('%');
				// CalcLab.g:196:20: ( S )*
				loop12: while (true) {
					int alt12 = 2;
					int LA12_0 = input.LA(1);
					if (((LA12_0 >= '\t' && LA12_0 <= '\n') || LA12_0 == '\r' || LA12_0 == ' ')) {
						alt12 = 1;
					}

					switch (alt12) {
					case 1:
					// CalcLab.g:196:20: S
					{
						mS();

					}
						break;

					default:
						break loop12;
					}
				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REMAINDER"

	// $ANTLR start "INVOLUTION"
	public final void mINVOLUTION() throws RecognitionException {
		try {
			int _type = INVOLUTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:199:12: ( ( S )* '^' ( S )* )
			// CalcLab.g:199:14: ( S )* '^' ( S )*
			{
				// CalcLab.g:199:14: ( S )*
				loop13: while (true) {
					int alt13 = 2;
					int LA13_0 = input.LA(1);
					if (((LA13_0 >= '\t' && LA13_0 <= '\n') || LA13_0 == '\r' || LA13_0 == ' ')) {
						alt13 = 1;
					}

					switch (alt13) {
					case 1:
					// CalcLab.g:199:14: S
					{
						mS();

					}
						break;

					default:
						break loop13;
					}
				}

				match('^');
				// CalcLab.g:199:21: ( S )*
				loop14: while (true) {
					int alt14 = 2;
					int LA14_0 = input.LA(1);
					if (((LA14_0 >= '\t' && LA14_0 <= '\n') || LA14_0 == '\r' || LA14_0 == ' ')) {
						alt14 = 1;
					}

					switch (alt14) {
					case 1:
					// CalcLab.g:199:21: S
					{
						mS();

					}
						break;

					default:
						break loop14;
					}
				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INVOLUTION"

	// $ANTLR start "FACTORIAL"
	public final void mFACTORIAL() throws RecognitionException {
		try {
			int _type = FACTORIAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:200:11: ( ( S )* '!' ( S )* )
			// CalcLab.g:200:13: ( S )* '!' ( S )*
			{
				// CalcLab.g:200:13: ( S )*
				loop15: while (true) {
					int alt15 = 2;
					int LA15_0 = input.LA(1);
					if (((LA15_0 >= '\t' && LA15_0 <= '\n') || LA15_0 == '\r' || LA15_0 == ' ')) {
						alt15 = 1;
					}

					switch (alt15) {
					case 1:
					// CalcLab.g:200:13: S
					{
						mS();

					}
						break;

					default:
						break loop15;
					}
				}

				match('!');
				// CalcLab.g:200:20: ( S )*
				loop16: while (true) {
					int alt16 = 2;
					int LA16_0 = input.LA(1);
					if (((LA16_0 >= '\t' && LA16_0 <= '\n') || LA16_0 == '\r' || LA16_0 == ' ')) {
						alt16 = 1;
					}

					switch (alt16) {
					case 1:
					// CalcLab.g:200:20: S
					{
						mS();

					}
						break;

					default:
						break loop16;
					}
				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FACTORIAL"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			int _type = DIGIT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:204:7: ( ( '0' .. '9' )+ )
			// CalcLab.g:204:9: ( '0' .. '9' )+
			{
				// CalcLab.g:204:9: ( '0' .. '9' )+
				int cnt17 = 0;
				loop17: while (true) {
					int alt17 = 2;
					int LA17_0 = input.LA(1);
					if (((LA17_0 >= '0' && LA17_0 <= '9'))) {
						alt17 = 1;
					}

					switch (alt17) {
					case 1:
					// CalcLab.g:
					{
						if ((input.LA(1) >= '0' && input.LA(1) <= '9')) {
							input.consume();
						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}
					}
						break;

					default:
						if (cnt17 >= 1)
							break loop17;
						EarlyExitException eee = new EarlyExitException(17, input);
						throw eee;
					}
					cnt17++;
				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "NAME"
	public final void mNAME() throws RecognitionException {
		try {
			int _type = NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:205:6: ( ( S )* ID ( ID | DIGIT )* ( S )* )
			// CalcLab.g:205:8: ( S )* ID ( ID | DIGIT )* ( S )*
			{
				// CalcLab.g:205:8: ( S )*
				loop18: while (true) {
					int alt18 = 2;
					int LA18_0 = input.LA(1);
					if (((LA18_0 >= '\t' && LA18_0 <= '\n') || LA18_0 == '\r' || LA18_0 == ' ')) {
						alt18 = 1;
					}

					switch (alt18) {
					case 1:
					// CalcLab.g:205:8: S
					{
						mS();

					}
						break;

					default:
						break loop18;
					}
				}

				mID();

				// CalcLab.g:205:14: ( ID | DIGIT )*
				loop19: while (true) {
					int alt19 = 3;
					int LA19_0 = input.LA(1);
					if (((LA19_0 >= 'A' && LA19_0 <= 'Z') || LA19_0 == '_' || (LA19_0 >= 'a' && LA19_0 <= 'z'))) {
						alt19 = 1;
					} else if (((LA19_0 >= '0' && LA19_0 <= '9'))) {
						alt19 = 2;
					}

					switch (alt19) {
					case 1:
					// CalcLab.g:205:15: ID
					{
						mID();

					}
						break;
					case 2:
					// CalcLab.g:205:19: DIGIT
					{
						mDIGIT();

					}
						break;

					default:
						break loop19;
					}
				}

				// CalcLab.g:205:27: ( S )*
				loop20: while (true) {
					int alt20 = 2;
					int LA20_0 = input.LA(1);
					if (((LA20_0 >= '\t' && LA20_0 <= '\n') || LA20_0 == '\r' || LA20_0 == ' ')) {
						alt20 = 1;
					}

					switch (alt20) {
					case 1:
					// CalcLab.g:205:27: S
					{
						mS();

					}
						break;

					default:
						break loop20;
					}
				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NAME"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			// CalcLab.g:206:13: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) )
			// CalcLab.g:
			{
				if ((input.LA(1) >= 'A' && input.LA(1) <= 'Z') || input.LA(1) == '_'
						|| (input.LA(1) >= 'a' && input.LA(1) <= 'z')) {
					input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}
			}

		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "CHAR"
	public final void mCHAR() throws RecognitionException {
		try {
			// CalcLab.g:207:15: ( 'A' .. 'z' )
			// CalcLab.g:
			{
				if ((input.LA(1) >= 'A' && input.LA(1) <= 'z')) {
					input.consume();
				} else {
					MismatchedSetException mse = new MismatchedSetException(null, input);
					recover(mse);
					throw mse;
				}
			}

		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR"

	// $ANTLR start "OPENING_PARENTHESIS"
	public final void mOPENING_PARENTHESIS() throws RecognitionException {
		try {
			int _type = OPENING_PARENTHESIS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:208:21: ( ( S )* '(' ( S )* )
			// CalcLab.g:208:23: ( S )* '(' ( S )*
			{
				// CalcLab.g:208:23: ( S )*
				loop21: while (true) {
					int alt21 = 2;
					int LA21_0 = input.LA(1);
					if (((LA21_0 >= '\t' && LA21_0 <= '\n') || LA21_0 == '\r' || LA21_0 == ' ')) {
						alt21 = 1;
					}

					switch (alt21) {
					case 1:
					// CalcLab.g:208:23: S
					{
						mS();

					}
						break;

					default:
						break loop21;
					}
				}

				match('(');
				// CalcLab.g:208:30: ( S )*
				loop22: while (true) {
					int alt22 = 2;
					int LA22_0 = input.LA(1);
					if (((LA22_0 >= '\t' && LA22_0 <= '\n') || LA22_0 == '\r' || LA22_0 == ' ')) {
						alt22 = 1;
					}

					switch (alt22) {
					case 1:
					// CalcLab.g:208:30: S
					{
						mS();

					}
						break;

					default:
						break loop22;
					}
				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPENING_PARENTHESIS"

	// $ANTLR start "CLOSING_PARENTHESIS"
	public final void mCLOSING_PARENTHESIS() throws RecognitionException {
		try {
			int _type = CLOSING_PARENTHESIS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:209:21: ( ( S )* ')' ( S )* )
			// CalcLab.g:209:23: ( S )* ')' ( S )*
			{
				// CalcLab.g:209:23: ( S )*
				loop23: while (true) {
					int alt23 = 2;
					int LA23_0 = input.LA(1);
					if (((LA23_0 >= '\t' && LA23_0 <= '\n') || LA23_0 == '\r' || LA23_0 == ' ')) {
						alt23 = 1;
					}

					switch (alt23) {
					case 1:
					// CalcLab.g:209:23: S
					{
						mS();

					}
						break;

					default:
						break loop23;
					}
				}

				match(')');
				// CalcLab.g:209:30: ( S )*
				loop24: while (true) {
					int alt24 = 2;
					int LA24_0 = input.LA(1);
					if (((LA24_0 >= '\t' && LA24_0 <= '\n') || LA24_0 == '\r' || LA24_0 == ' ')) {
						alt24 = 1;
					}

					switch (alt24) {
					case 1:
					// CalcLab.g:209:30: S
					{
						mS();

					}
						break;

					default:
						break loop24;
					}
				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLOSING_PARENTHESIS"

	// $ANTLR start "OPENING_SQ_PARENTHESIS"
	public final void mOPENING_SQ_PARENTHESIS() throws RecognitionException {
		try {
			int _type = OPENING_SQ_PARENTHESIS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:210:24: ( ( S )* '[' ( S )* )
			// CalcLab.g:210:26: ( S )* '[' ( S )*
			{
				// CalcLab.g:210:26: ( S )*
				loop25: while (true) {
					int alt25 = 2;
					int LA25_0 = input.LA(1);
					if (((LA25_0 >= '\t' && LA25_0 <= '\n') || LA25_0 == '\r' || LA25_0 == ' ')) {
						alt25 = 1;
					}

					switch (alt25) {
					case 1:
					// CalcLab.g:210:26: S
					{
						mS();

					}
						break;

					default:
						break loop25;
					}
				}

				match('[');
				// CalcLab.g:210:33: ( S )*
				loop26: while (true) {
					int alt26 = 2;
					int LA26_0 = input.LA(1);
					if (((LA26_0 >= '\t' && LA26_0 <= '\n') || LA26_0 == '\r' || LA26_0 == ' ')) {
						alt26 = 1;
					}

					switch (alt26) {
					case 1:
					// CalcLab.g:210:33: S
					{
						mS();

					}
						break;

					default:
						break loop26;
					}
				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPENING_SQ_PARENTHESIS"

	// $ANTLR start "CLOSING_SQ_PARENTHESIS"
	public final void mCLOSING_SQ_PARENTHESIS() throws RecognitionException {
		try {
			int _type = CLOSING_SQ_PARENTHESIS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:211:24: ( ( S )* ']' ( S )* )
			// CalcLab.g:211:26: ( S )* ']' ( S )*
			{
				// CalcLab.g:211:26: ( S )*
				loop27: while (true) {
					int alt27 = 2;
					int LA27_0 = input.LA(1);
					if (((LA27_0 >= '\t' && LA27_0 <= '\n') || LA27_0 == '\r' || LA27_0 == ' ')) {
						alt27 = 1;
					}

					switch (alt27) {
					case 1:
					// CalcLab.g:211:26: S
					{
						mS();

					}
						break;

					default:
						break loop27;
					}
				}

				match(']');
				// CalcLab.g:211:33: ( S )*
				loop28: while (true) {
					int alt28 = 2;
					int LA28_0 = input.LA(1);
					if (((LA28_0 >= '\t' && LA28_0 <= '\n') || LA28_0 == '\r' || LA28_0 == ' ')) {
						alt28 = 1;
					}

					switch (alt28) {
					case 1:
					// CalcLab.g:211:33: S
					{
						mS();

					}
						break;

					default:
						break loop28;
					}
				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLOSING_SQ_PARENTHESIS"

	// $ANTLR start "DECIMAL_SEPARATOR"
	public final void mDECIMAL_SEPARATOR() throws RecognitionException {
		try {
			int _type = DECIMAL_SEPARATOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:212:19: ( '.' )
			// CalcLab.g:212:21: '.'
			{
				match('.');
			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DECIMAL_SEPARATOR"

	// $ANTLR start "ARGUMENTS_SEPARATOR"
	public final void mARGUMENTS_SEPARATOR() throws RecognitionException {
		try {
			int _type = ARGUMENTS_SEPARATOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:213:21: ( ',' )
			// CalcLab.g:213:23: ','
			{
				match(',');
			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ARGUMENTS_SEPARATOR"

	// $ANTLR start "EXPRESSIONS_SEPARATOR"
	public final void mEXPRESSIONS_SEPARATOR() throws RecognitionException {
		try {
			int _type = EXPRESSIONS_SEPARATOR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:214:23: ( ( S )* ';' ( S )* )
			// CalcLab.g:214:25: ( S )* ';' ( S )*
			{
				// CalcLab.g:214:25: ( S )*
				loop29: while (true) {
					int alt29 = 2;
					int LA29_0 = input.LA(1);
					if (((LA29_0 >= '\t' && LA29_0 <= '\n') || LA29_0 == '\r' || LA29_0 == ' ')) {
						alt29 = 1;
					}

					switch (alt29) {
					case 1:
					// CalcLab.g:214:25: S
					{
						mS();

					}
						break;

					default:
						break loop29;
					}
				}

				match(';');
				// CalcLab.g:214:32: ( S )*
				loop30: while (true) {
					int alt30 = 2;
					int LA30_0 = input.LA(1);
					if (((LA30_0 >= '\t' && LA30_0 <= '\n') || LA30_0 == '\r' || LA30_0 == ' ')) {
						alt30 = 1;
					}

					switch (alt30) {
					case 1:
					// CalcLab.g:214:32: S
					{
						mS();

					}
						break;

					default:
						break loop30;
					}
				}

			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXPRESSIONS_SEPARATOR"

	// $ANTLR start "S"
	public final void mS() throws RecognitionException {
		try {
			int _type = S;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// CalcLab.g:215:2: ( ( ' ' | '\\n' | '\\r' | '\\t' )+ )
			// CalcLab.g:215:4: ( ' ' | '\\n' | '\\r' | '\\t' )+
			{
				// CalcLab.g:215:4: ( ' ' | '\\n' | '\\r' | '\\t' )+
				int cnt31 = 0;
				loop31: while (true) {
					int alt31 = 2;
					int LA31_0 = input.LA(1);
					if (((LA31_0 >= '\t' && LA31_0 <= '\n') || LA31_0 == '\r' || LA31_0 == ' ')) {
						alt31 = 1;
					}

					switch (alt31) {
					case 1:
					// CalcLab.g:
					{
						if ((input.LA(1) >= '\t' && input.LA(1) <= '\n') || input.LA(1) == '\r' || input.LA(1) == ' ') {
							input.consume();
						} else {
							MismatchedSetException mse = new MismatchedSetException(null, input);
							recover(mse);
							throw mse;
						}
					}
						break;

					default:
						if (cnt31 >= 1)
							break loop31;
						EarlyExitException eee = new EarlyExitException(31, input);
						throw eee;
					}
					cnt31++;
				}

				_channel = HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		} finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "S"

	@Override
	public void mTokens() throws RecognitionException {
		// CalcLab.g:1:8: ( T__24 | PLUS | MINUS | MULTIPLY | DIVISION | EQUALS | REMAINDER | INVOLUTION | FACTORIAL |
		// DIGIT | NAME | OPENING_PARENTHESIS | CLOSING_PARENTHESIS | OPENING_SQ_PARENTHESIS | CLOSING_SQ_PARENTHESIS |
		// DECIMAL_SEPARATOR | ARGUMENTS_SEPARATOR | EXPRESSIONS_SEPARATOR | S )
		int alt32 = 19;
		alt32 = dfa32.predict(input);
		switch (alt32) {
		case 1:
		// CalcLab.g:1:10: T__24
		{
			mT__24();

		}
			break;
		case 2:
		// CalcLab.g:1:16: PLUS
		{
			mPLUS();

		}
			break;
		case 3:
		// CalcLab.g:1:21: MINUS
		{
			mMINUS();

		}
			break;
		case 4:
		// CalcLab.g:1:27: MULTIPLY
		{
			mMULTIPLY();

		}
			break;
		case 5:
		// CalcLab.g:1:36: DIVISION
		{
			mDIVISION();

		}
			break;
		case 6:
		// CalcLab.g:1:45: EQUALS
		{
			mEQUALS();

		}
			break;
		case 7:
		// CalcLab.g:1:52: REMAINDER
		{
			mREMAINDER();

		}
			break;
		case 8:
		// CalcLab.g:1:62: INVOLUTION
		{
			mINVOLUTION();

		}
			break;
		case 9:
		// CalcLab.g:1:73: FACTORIAL
		{
			mFACTORIAL();

		}
			break;
		case 10:
		// CalcLab.g:1:83: DIGIT
		{
			mDIGIT();

		}
			break;
		case 11:
		// CalcLab.g:1:89: NAME
		{
			mNAME();

		}
			break;
		case 12:
		// CalcLab.g:1:94: OPENING_PARENTHESIS
		{
			mOPENING_PARENTHESIS();

		}
			break;
		case 13:
		// CalcLab.g:1:114: CLOSING_PARENTHESIS
		{
			mCLOSING_PARENTHESIS();

		}
			break;
		case 14:
		// CalcLab.g:1:134: OPENING_SQ_PARENTHESIS
		{
			mOPENING_SQ_PARENTHESIS();

		}
			break;
		case 15:
		// CalcLab.g:1:157: CLOSING_SQ_PARENTHESIS
		{
			mCLOSING_SQ_PARENTHESIS();

		}
			break;
		case 16:
		// CalcLab.g:1:180: DECIMAL_SEPARATOR
		{
			mDECIMAL_SEPARATOR();

		}
			break;
		case 17:
		// CalcLab.g:1:198: ARGUMENTS_SEPARATOR
		{
			mARGUMENTS_SEPARATOR();

		}
			break;
		case 18:
		// CalcLab.g:1:218: EXPRESSIONS_SEPARATOR
		{
			mEXPRESSIONS_SEPARATOR();

		}
			break;
		case 19:
		// CalcLab.g:1:240: S
		{
			mS();

		}
			break;

		}
	}

	protected DFA32 dfa32 = new DFA32(this);
	static final String DFA32_eotS = "\1\uffff\1\24\1\25\23\uffff";
	static final String DFA32_eofS = "\26\uffff";
	static final String DFA32_minS = "\3\11\23\uffff";
	static final String DFA32_maxS = "\3\172\23\uffff";
	static final String DFA32_acceptS = "\3\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1" +
			"\17\1\20\1\21\1\22\1\1\1\23";
	static final String DFA32_specialS = "\26\uffff}>";
	static final String[] DFA32_transitionS = {
			"\2\2\2\uffff\1\2\22\uffff\1\1\1\12\3\uffff\1\10\2\uffff\1\15\1\16\1\5" +
					"\1\3\1\22\1\4\1\21\1\6\12\13\1\uffff\1\23\1\uffff\1\7\3\uffff\32\14\1" +
					"\17\1\uffff\1\20\1\11\1\14\1\uffff\32\14",
			"\2\2\2\uffff\1\2\22\uffff\1\2\1\12\3\uffff\1\10\2\uffff\1\15\1\16\1" +
					"\5\1\3\1\uffff\1\4\1\uffff\1\6\13\uffff\1\23\1\uffff\1\7\3\uffff\32\14" +
					"\1\17\1\uffff\1\20\1\11\1\14\1\uffff\32\14",
			"\2\2\2\uffff\1\2\22\uffff\1\2\1\12\3\uffff\1\10\2\uffff\1\15\1\16\1" +
					"\5\1\3\1\uffff\1\4\1\uffff\1\6\13\uffff\1\23\1\uffff\1\7\3\uffff\32\14" +
					"\1\17\1\uffff\1\20\1\11\1\14\1\uffff\32\14",
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
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA32_eot = DFA.unpackEncodedString(DFA32_eotS);
	static final short[] DFA32_eof = DFA.unpackEncodedString(DFA32_eofS);
	static final char[] DFA32_min = DFA.unpackEncodedStringToUnsignedChars(DFA32_minS);
	static final char[] DFA32_max = DFA.unpackEncodedStringToUnsignedChars(DFA32_maxS);
	static final short[] DFA32_accept = DFA.unpackEncodedString(DFA32_acceptS);
	static final short[] DFA32_special = DFA.unpackEncodedString(DFA32_specialS);
	static final short[][] DFA32_transition;

	static {
		int numStates = DFA32_transitionS.length;
		DFA32_transition = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			DFA32_transition[i] = DFA.unpackEncodedString(DFA32_transitionS[i]);
		}
	}

	protected class DFA32 extends DFA {

		public DFA32(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 32;
			this.eot = DFA32_eot;
			this.eof = DFA32_eof;
			this.min = DFA32_min;
			this.max = DFA32_max;
			this.accept = DFA32_accept;
			this.special = DFA32_special;
			this.transition = DFA32_transition;
		}

		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__24 | PLUS | MINUS | MULTIPLY | DIVISION | EQUALS | REMAINDER | INVOLUTION | FACTORIAL | DIGIT | NAME | OPENING_PARENTHESIS | CLOSING_PARENTHESIS | OPENING_SQ_PARENTHESIS | CLOSING_SQ_PARENTHESIS | DECIMAL_SEPARATOR | ARGUMENTS_SEPARATOR | EXPRESSIONS_SEPARATOR | S );";
		}
	}

}
