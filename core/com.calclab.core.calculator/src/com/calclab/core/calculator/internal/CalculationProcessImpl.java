package com.calclab.core.calculator.internal;

import java.util.List;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.calculator.CalculationProcess;
import com.calclab.core.input.CalculationInput;
import com.calclab.core.input.exceptions.InputException;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.parser.Parser;
import com.calclab.core.parser.ParserFactory;
import com.calclab.core.parser.extensions.SyntaxErrorException;

public class CalculationProcessImpl implements CalculationProcess {

	private final int scale;
	private final Parser parser;
	private final CalculationInput input;
	private final CalculationStatus status = new CalculationStatus();

	private List<Calculable> expressions;

	public CalculationProcessImpl(CalculationInput input) {
		this.scale = 60;
		this.input = input;
		this.parser = ParserFactory.createCalculationParser();
	}

	public CalculationProcessImpl(CalculationInput input, int scale) {
		this.scale = scale;
		this.input = input;
		this.parser = ParserFactory.createCalculationParser();
	}

	@Override
	public void run() {
		try {
			setScale();
			status.setStage(CalculationStatus.Stage.INPROCESS);
			expressions = parser.parse(input);
			for (Calculable expression : expressions) {
				expression.calculate();
			}
			status.setStage(CalculationStatus.Stage.DONE);
		} catch (InputException | SyntaxErrorException e) {
			status.setStage(CalculationStatus.Stage.ERROR);
			status.setMessage(e.toString());
		}
	}

	private void setScale() {
		AbstractNumber.scale = scale;
	}

	@Override
	public CalculationStatus getStatus() {
		return status;
	}

	@Override
	public List<Calculable> getExpressions() {
		return expressions;
	}

	@Override
	public int getScale() {
		return scale;
	}

}
