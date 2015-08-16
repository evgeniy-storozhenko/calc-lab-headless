package com.calclab.core.calculator;

import java.io.File;

public interface CalculationView {

	void setCalculationProcess(CalculationJob calcProcess);

	void setOutputFile(File file);

	String output();

}
