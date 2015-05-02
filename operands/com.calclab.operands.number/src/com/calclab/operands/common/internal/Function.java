package com.calclab.operands.common.internal;

import java.util.List;

import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.InternalExpression;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;

public class Function implements Operand {

	private final String name;
	private final List<Operand> arguments;

	public Function(String name, List<Operand> arguments) {
		this.name = name;
		this.arguments = arguments;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		final int size = arguments.size();
		for (int i = 0; i < size; i++) {
			sb.append(arguments.get(i).toString());
			if (i != (size - 1)) {
				sb.append(",");
			}
		}
		return this.name + "(" + sb.toString() + ")";
	}

	@Override
	public Operand perform(Operation operation, StepsMonitor monitor) throws OperatorNotFoundException,
			InvalidActionException, InternalExpression {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operand perform(Operation operation, Operand operand, StepsMonitor monitor)
			throws OperatorNotFoundException, InvalidActionException, InternalExpression {
		// TODO Auto-generated method stub
		return null;
	}

}
