package com.calclab.core.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.parser.internal.CalcLabLexer;
import com.calclab.core.parser.internal.CalcLabParser;

import junit.framework.TestCase;

public class CalcLabParserTest extends TestCase {

	public void testParse_1() {
		isParseEquals("0;");
	}

	public void testParse_2() {
		isParseEquals("2;");
	}

	public void testParse_3() {
		isParseEquals("3;");
	}

	public void testParse_4() {
		isParseEquals("13;");
	}

	public void testParse_5() {
		isParseEquals("1.6;");
	}

	public void testParse_6() {
		isParseEquals("38.77;");
	}

	public void testParse_7() {
		isParseEquals("-3;", "(-3);");
	}

	public void testParse_8() {
		isParseEquals("-12.9;", "(-12.9);");
	}

	public void testParse_9() {
		isParseEquals("6!;");
	}

	public void testParse_10() {
		isParseEquals("8.3!;");
	}

	public void testParse_11() {
		isParseEquals("-3!;", "(-3)!;");
	}

	public void testParse_12() {
		isParseEquals("2+2;", "(2+2);");
	}

	public void testParse_13() {
		isParseEquals("1.3*0.3;", "(1.3*0.3);");
	}

	public void testParse_14() {
		isParseEquals("1.3-0.3;", "(1.3-0.3);");
	}

	public void testParse_15() {
		isParseEquals("3.5+2.9;", "(3.5+2.9);");
	}

	public void testParse_16() {
		isParseEquals("1.3-0.3;", "(1.3-0.3);");
	}

	public void testParse_17() {
		isParseEquals("-5-10;", "((-5)-10);");
	}

	public void testParse_18() {
		isParseEquals("2^4;", "(2^4);");
	}

	public void testParse_19() {
		isParseEquals("-2^3;", "((-2)^3);");
	}

	public void testParse_20() {
		isParseEquals("2+3+6*2;", "((2+3)+(6*2));");
	}

	public void testParse_21() {
		isParseEquals("9-4/2+11^2+72;", "(((9-(4/2))+(11^2))+72);");
	}

	public void testParse_22() {
		isParseEquals("3*(2+2);", "(3*(2+2));");
	}

	public void testParse_23() {
		isParseEquals("2^(2+4*2);", "(2^(2+(4*2)));");
	}

	public void testParse_24() {
		isParseEquals("-2^(2+4*2);", "((-2)^(2+(4*2)));");
	}

	public void testParse_25() {
		isParseEquals("4^(-2);", "(4^(-2));");
	}

	public void testParse_26() {
		isParseEquals("-(-2);", "(-(-2));");
	}

	public void testParse_27() {
		isParseEquals("-2*(-2);", "((-2)*(-2));");
	}

	public void testParse_28() {
		isParseEquals("-(2+2);", "(-(2+2));");
	}

	public void testParse_29() {
		isParseEquals("-(4+2)-42-(5+5);", "(((-(4+2))-42)-(5+5));");
	}

	public void testParse_30() {
		isParseEquals("-(-(-(-(-(-2)))));", "(-(-(-(-(-(-2))))));");
	}

	public void testParse_31() {
		isParseEquals("sin(3.14);", "sin(3.14);");
	}

	public void testParse_32() {
		isParseEquals("log(8,2);", "log(8,2);");
	}

	public void testParse_33() {
		isParseEquals("myFunction4calc1(313);", "myFunction4calc1(313);");
	}

	public void testParse_34() {
		isParseEquals("sin(log(8,2));", "sin(log(8,2));");
	}

	public void testParse_35() {
		isParseEquals("a=5;", "5;");
	}

	public void testParse_36() {
		CalcLabParser parser = parseExpressions("a=2*4;b=a*2;");
		assertEquals("(2*4);", parser.getVariables().get("a").toString());
		assertEquals("(a*2);", parser.getVariables().get("b").toString());
	}

	public void testParse_37() {
		CalcLabParser parser = parseExpressions("a=2;b=-a;");
		assertEquals("2;", parser.getVariables().get("a").toString());
		assertEquals("(-a);", parser.getVariables().get("b").toString());
	}

	public void testParse_38() {
		isParseEquals("-sind(30);", "(-sind(30));");
	}

	public void testParse_39() {
		String expect = "[" + System.lineSeparator()
				+ "	1,2,3" + System.lineSeparator() + "];";
		isParseEquals("[1,2,3];", expect);
	}

	private void isParseEquals(String input) {
		Calculable calculation = parse(input);
		assertEquals(input, calculation.toString());
	}

	private void isParseEquals(String input, String parsed) {
		Calculable calculation = parse(input);
		assertEquals(parsed, calculation.toString());
	}

	private Calculable parse(String input) {
		CalcLabLexer lex = new CalcLabLexer(new ANTLRStringStream(input));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		CalcLabParser parser = new CalcLabParser(tokens);
		try {
			parser.calculation();
		} catch (RecognitionException e) {
			e.printStackTrace();
			fail();
		}
		return parser.getCalculations().get(0);
	}

	private CalcLabParser parseExpressions(String input) {
		CalcLabLexer lex = new CalcLabLexer(new ANTLRStringStream(input));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		CalcLabParser parser = new CalcLabParser(tokens);
		try {
			parser.calculation();
		} catch (RecognitionException e) {
			e.printStackTrace();
			fail();
		}
		return parser;
	}

}
