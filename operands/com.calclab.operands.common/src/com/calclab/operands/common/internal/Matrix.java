package com.calclab.operands.common.internal;

import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.InternalExpression;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;

public class Matrix implements Operand {

	private final Operand[][] value;
	private final int width;
	private final int height;

	public Matrix(Operand[][] value) {
		this.value = value;
		this.height = value.length;
		this.width = value[0].length;
	}

	@Override
	public Operand perform(Operation operation, StepsMonitor monitor)
			throws OperatorNotFoundException, InvalidActionException, InternalExpression {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Operand perform(Operation operation, Operand operand, StepsMonitor monitor)
			throws OperatorNotFoundException, InvalidActionException, InternalExpression {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExact() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		builder.append(System.lineSeparator());
		for (int i = 0; i < height; i++) {
			builder.append("	");
			for (int j = 0; j < width; j++) {
				builder.append(value[i][j].toString());
				if (j != width - 1) {
					builder.append(",");
				}
			}
			if (i != height - 1) {
				builder.append(System.lineSeparator());
			}
		}
		builder.append(System.lineSeparator());
		builder.append("]");
		return builder.toString();
	}

}