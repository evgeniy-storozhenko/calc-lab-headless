package com.calclab.operands.common.internal;

import org.json.JSONException;
import org.json.JSONObject;

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

	private boolean exect = true;

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
		return exect;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(System.lineSeparator());
		builder.append("\t[");
		builder.append(System.lineSeparator());
		for (int i = 0; i < height; i++) {
			builder.append("\t\t");
			for (int j = 0; j < width; j++) {
				builder.append(value[i][j].toString());
				if (j != width - 1) {
					builder.append(" ");
				}
			}
			if (i != height - 1) {
				builder.append(System.lineSeparator());
			}
		}
		builder.append("\t]");
		return builder.toString();
	}

	@Override
	public JSONObject toJSON() {
		JSONObject jsonResult = new JSONObject();
		try {
			jsonResult.put("type", "matrix");
			JSONObject[][] jsonValue = new JSONObject[height][];
			for (int i = 0; i < height; i++) {
				jsonValue[i] = new JSONObject[width];
				for (int j = 0; j < width; j++) {
					jsonValue[i][j] = value[i][j].toJSON();
				}
			}
			jsonResult.put("value", jsonValue);
			jsonResult.put("exect", isExact());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonResult;
	}

}
