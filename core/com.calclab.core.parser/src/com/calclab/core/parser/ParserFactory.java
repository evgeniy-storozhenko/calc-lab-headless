package com.calclab.core.parser;

import com.calclab.core.parser.extensions.CalculationParser;

public class ParserFactory {

	public static Parser createCalculationParser() {
		return CalculationParser.getInstance();
	}

}
