package com.calclab.headless.internal;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.input.CalculationInput;
import com.calclab.core.input.exceptions.InputException;
import com.calclab.core.parser.Parser;
import com.calclab.core.parser.ParserFactory;

public class CalculationProcess {

	private final CalculationInput input;
	private final Parser parser;

	private Calculable[] expressions;

	public CalculationProcess(CalculationInput input) {
		this.input = input;
		this.parser = ParserFactory.createCalculationParser();
	}

	public void run() throws InputException {
		expressions = parser.parse(input);
		for (Calculable expression : expressions) {
			expression.calculate();
		}
	}

}
