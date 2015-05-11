package com.calclab.core.functions;

import java.util.List;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.operands.Operand;

public interface Function extends Operand, Calculable {

	String getName();

	void setArguments(List<Operand> arguments);

}
