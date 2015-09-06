package com.calclab.core.parser.extensions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private CalcLabParser antlrParser = null;
	private static final String column = ";";

	public synchronized static Parser getInstance() {
		if (instance == null) {
			instance = new CalculationParser();
		}
		return instance;
	}

	private CalculationParser() {
	}

	@Override
	public void parse(CalculationInput input) throws InputException {
		String inputExpressions = input.getExpressions();
		CalcLabLexer lex = new CalcLabLexer(new ANTLRStringStream(inputExpressions));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		Map<String, Calculable> variables = getVariables();
		antlrParser = new CalcLabParser(tokens);
		antlrParser.getVariables().putAll(variables);
		if (inputExpressions.isEmpty() || inputExpressions.equals(column)) {
			return;
		}
		try {
			antlrParser.calculation();
		} catch (RecognitionException e) {
			throw new SyntaxErrorException(e.line, e.charPositionInLine, e.getMessage());
		}
	}

	@Override
	public List<Calculable> getExpressions() {
		if (antlrParser != null) {
			return antlrParser.getCalculations();
		}
		return new ArrayList<Calculable>();
	}

	@Override
	public Map<String, Calculable> getVariables() {
		if (antlrParser != null) {
			return antlrParser.getVariables();
		}
		return new HashMap<String, Calculable>();
	}

	@Override
	public String prepareInputHook(String input) {
		return input;
	}

}
