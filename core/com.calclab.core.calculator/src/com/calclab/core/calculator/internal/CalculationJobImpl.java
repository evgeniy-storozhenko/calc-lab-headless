package com.calclab.core.calculator.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.calculations.CalculationFactory;
import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.calculations.Expression;
import com.calclab.core.calculations.impl.Calculation;
import com.calclab.core.calculator.CalculationJob;
import com.calclab.core.input.CalculationInput;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.parser.Parser;
import com.calclab.core.parser.ParserFactory;

public class CalculationJobImpl implements CalculationJob {

	private final int scale;
	private final int scaleToDisplay;
	private final Parser parser;
	private final CalculationInput input;
	private final CalculationStatus status = new CalculationStatus();

	private List<Calculable> expressions = new ArrayList<>();
	private Map<String, Calculable> variables = new HashMap<>();

	public CalculationJobImpl(CalculationInput input) {
		this.scale = 60;
		this.scaleToDisplay = 8;
		this.input = input;
		this.parser = ParserFactory.createCalculationParser();
	}

	public CalculationJobImpl(CalculationInput input, int scale, int scaleToDisplay) {
		this.input = input;
		this.scale = scale;
		this.scaleToDisplay = scaleToDisplay;
		this.parser = ParserFactory.createCalculationParser();
	}

	@Override
	public void run() {
		try {
			initParams();
			status.setStage(CalculationStatus.Stage.INPROCESS);
			input.setExpressions(parser.prepareInputHook(input.getExpressions()));
			parser.parse(input);
			variables.putAll(parser.getVariables());
			expressions = parser.getExpressions();
			for (Calculable expression : expressions) {
				expression.calculate();
			}
			wrapAnswer();
			status.setStage(CalculationStatus.Stage.DONE);
		} catch (Exception e) {
			status.setStage(CalculationStatus.Stage.ERROR);
			status.setMessage(e.toString());
		}
	}

	private void wrapAnswer() {
		if (!input.isStdIn() || expressions.size() == 0) {
			return;
		}
		CalculationFactory calcFactory = new CalculationFactory();
		Calculable lastExpression = expressions.get(expressions.size() - 1);
		if (lastExpression instanceof Calculation
				&& ((Calculation) lastExpression).getVariable() != null) {
			return;
		}
		if (lastExpression instanceof Expression) {
			expressions.remove(expressions.size() - 1);
			Operand operand = ((Expression) lastExpression).getOperand();
			String input = resultVar + " = " + lastExpression.getInput();
			Calculable ans = calcFactory.createCalculation(resultVar, operand, input,
					lastExpression.getStatus(), lastExpression.getResult());

			expressions.add(ans);
			parser.getVariables().put(resultVar, lastExpression);
		}
	}

	private void initParams() {
		setScale();
		setScaleToDisplay();
	}

	private void setScale() {
		AbstractNumber.scale = scale;
	}

	private void setScaleToDisplay() {
		AbstractNumber.scaleToDisplay = scaleToDisplay;
	}

	@Override
	public CalculationStatus getStatus() {
		return status;
	}

	@Override
	public int getScale() {
		return scale;
	}

	@Override
	public List<Calculable> getExpressions() {
		return expressions;
	}

	@Override
	public Map<String, Calculable> getVariables() {
		return variables;
	}

}
