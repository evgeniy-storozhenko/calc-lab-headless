package com.calclab.core.parser;

import java.util.List;

import junit.framework.TestCase;

import org.antlr.runtime.*;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.parser.internal.CalcLabLexer;
import com.calclab.core.parser.internal.CalcLabParser;

public class CalcLabParserTest extends TestCase {

	public void testParse1() {
		String input = "1.3*0.3;";
		Calculable calculation = parse(input);
		assertEquals(input, calculation.toString() + ";");
	}

	public void testParse2() {
		String input = "1.3-0.3;";
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

// 0;
// 2;
// 13;
// 1.6;
// 38.77;
// -3;
// -12.9;
// 6!;
// 8.3!;
// -3!;
// 2+2;
// 3.5+2.9;
// 1.3-0.3;
// -5-10;
// 2^4;
// 2^(4);
// -2^3;
// 2+3+6*2;
// 9-4/2+11^2+72;
// 3*(2+2);
// 2^(2+4*2);
// -2^(2+4*2);
// 4^(-2);
// -(-2);
// -2*(-2);
// -(2+2);
// -(4+2)-42-(5+5);
// sin(3.14);
// log(8,2);
// myFunction4calc1(313);
// sin(log(8,2));