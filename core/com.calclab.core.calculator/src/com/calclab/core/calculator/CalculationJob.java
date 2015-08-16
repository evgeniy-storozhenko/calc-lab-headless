package com.calclab.core.calculator;

import java.util.List;
import java.util.Map;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.calculations.CalculationStatus;

public interface CalculationJob {

	public void run();

	public CalculationStatus getStatus();

	public List<Calculable> getExpressions();

	public Map<String, Calculable> getVariables();

	public int getScale();

}
