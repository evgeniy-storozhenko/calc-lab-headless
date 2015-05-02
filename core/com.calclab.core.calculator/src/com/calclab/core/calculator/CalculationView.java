package com.calclab.core.calculator;

import java.io.File;

public interface CalculationView {

	void setCalculationProcess(CalculationProcess calcProcess);

	void setOutputFile(File file);

	String output();

}
