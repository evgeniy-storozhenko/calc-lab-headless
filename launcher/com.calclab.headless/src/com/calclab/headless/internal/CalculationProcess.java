package com.calclab.headless.internal;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.input.CalculationInput;
import com.calclab.core.parser.CalculationParser;
import com.calclab.core.parser.ParserFactory;

public class CalculationProcess implements Runnable {

	private final CalculationInput input;
	private final CalculationParser parser;

	public CalculationProcess(CalculationInput input) {
		this.input = input;
		this.parser = ParserFactory.createCalculationParser();
	}

	@Override
	public void run() {
		Calculable[] expressions = parser.parse(input);
		for (Calculable expression : expressions) {
			expression.calculate();
		}
	}

}
