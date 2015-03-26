package com.calclab.core.parser.extensions;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.input.CalculationInput;
import com.calclab.core.parser.Parser;

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
	public Calculable[] parse(CalculationInput input) {
		// TODO Auto-generated method stub
		return null;
	}

}
