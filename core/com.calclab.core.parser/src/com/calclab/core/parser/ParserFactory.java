package com.calclab.core.parser;

import com.calclab.core.parser.internal.CalculationParserImpl;

public class ParserFactory {

	public static CalculationParser createCalculationParser() {
		return CalculationParserImpl.getInstance();
	}

}
