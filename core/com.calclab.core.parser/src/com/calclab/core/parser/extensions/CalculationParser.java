package com.calclab.core.parser.extensions;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.input.CalculationInput;
import com.calclab.core.input.exceptions.InputException;
import com.calclab.core.parser.Parser;
import com.calclab.core.parser.internal.CalcLabLexer;
import com.calclab.core.parser.internal.CalcLabParser;

public class CalculationParser implements Parser {

	private static Parser instance = null;

	public synchronized static Parser getInstance() {
		if (instance == null) {
			instance = new CalculationParser();
		}
		return instance;
	}

	private CalculationParser() {
		CalclabExtensionManager.getInstance(); // TODO remove
	}

	@Override
	public Calculable[] parse(CalculationInput input) throws InputException {
		String inputExpressions = input.getExpressions();
		CalcLabLexer lex = new CalcLabLexer(new ANTLRStringStream(inputExpressions));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		CalcLabParser g = new CalcLabParser(tokens);
		try {
			g.calculation();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println();
		return null;
	}

}
