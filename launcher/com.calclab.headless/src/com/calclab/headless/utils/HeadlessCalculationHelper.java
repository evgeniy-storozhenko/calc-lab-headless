package com.calclab.headless.utils;

import java.util.ArrayList;
import java.util.List;

public abstract class HeadlessCalculationHelper {

	public static final String SEPARATOR = ";";

	public static String[] deQuoteArgs(String[] args) {
		List<String> result = new ArrayList<String>();
		for (String arg : args) {
			result.add(deQuote(arg));
		}
		return result.toArray(new String[result.size()]);
	}

	public static String deQuote(String line) {
		if (line != null) {
			if (line.startsWith("'") && line.endsWith("'")) {
				line = line.substring(1, line.length() - 1);
			}
			if (line.startsWith("\"") && line.endsWith("\"")) {
				line = line.substring(1, line.length() - 1);
			}
		}
		return line;
	}

}
