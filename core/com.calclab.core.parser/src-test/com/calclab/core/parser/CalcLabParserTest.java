package com.calclab.core.parser;

import junit.framework.TestCase;

import org.antlr.runtime.*;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.parser.internal.CalcLabLexer;
import com.calclab.core.parser.internal.CalcLabParser;

public class CalcLabParserTest extends TestCase {

	public void testParse1() {
		isParseEquals("0;");
	}

	public void testParse2() {
		isParseEquals("2;");
	}

	public void testParse3() {
		isParseEquals("3;");
	}

	public void testParse4() {
		isParseEquals("13;");
	}

	public void testParse5() {
		isParseEquals("1.6;");
	}

	public void testParse6() {
		isParseEquals("38.77;");
	}

	public void testParse7() {
		isParseEquals("-3;");
	}

	public void testParse8() {
		isParseEquals("-12.9;");
	}

	public void testParse9() {
		isParseEquals("6!;");
	}

	public void testParse10() {
		isParseEquals("8.3!;");
	}

	public void testParse11() {
		isParseEquals("-3!;");
	}

	public void testParse12() {
		isParseEquals("2+2;");
	}

	public void testParse13() {
		isParseEquals("1.3*0.3;");
	}

	public void testParse14() {
		isParseEquals("1.3-0.3;");
	}

	public void testParse15() {
		isParseEquals("3.5+2.9;");
	}

	public void testParse16() {
		isParseEquals("1.3-0.3;");
	}

	public void testParse17() {
		isParseEquals("-5-10;");
	}

	public void testParse18() {
		isParseEquals("2^4;");
	}

	public void testParse19() {
		isParseEquals("-2^3;");
	}

	public void testParse20() {
		isParseEquals("2+3+6*2;");
	}

	public void testParse21() {
		isParseEquals("9-4/2+11^2+72;");
	}

	public void testParse22() {
		isParseEquals("3*(2+2);");
	}

	public void testParse23() {
		isParseEquals("2^(2+4*2);");
	}

	public void testParse24() {
		isParseEquals("-2^(2+4*2);");
	}

	private void isParseEquals(String input) {
		Calculable calculation = parse(input);
		assertEquals(input, calculation.toString() + ";");
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

}

// 4^(-2);
// -(-2);
// -2*(-2);
// -(2+2);
// -(4+2)-42-(5+5);
// sin(3.14);
// log(8,2);
// myFunction4calc1(313);
// sin(log(8,2));