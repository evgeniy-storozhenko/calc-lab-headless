package com.calclab.core.calculator;

import java.util.List;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.calculations.CalculationStatus;

public interface CalculationProcess {

	public void run();

	public CalculationStatus getStatus();

	public List<Calculable> getExpressions();

	public int getScale();

}
