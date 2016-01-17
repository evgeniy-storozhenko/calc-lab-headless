package com.calclab.core.parser;

public class ParserFactory {

	public static Parser createCalculationParser() {
		return CalculationParser.getInstance();
	}

}
