package com.calclab.operands.common.internal;

import org.json.JSONException;
import org.json.JSONObject;

import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.InternalExpression;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;
import com.calclab.operands.common.nls.Messages;

public class StringOperand implements Operand {

	private String value;

	public StringOperand(String value) {
		this.value = value;
	}

	@Override
	public Operand perform(Operation operation, StepsMonitor monitor) throws OperatorNotFoundException,
			InvalidActionException, InternalExpression {
		throw new OperatorNotFoundException(Messages.getString("BigNumber.0")
				+ operation.toString() + Messages.getString("BigNumber.1"));
	}

	@Override
	public Operand perform(Operation operation, Operand operand, StepsMonitor monitor)
			throws OperatorNotFoundException, InvalidActionException, InternalExpression {
		throw new OperatorNotFoundException(Messages.getString("BigNumber.0")
				+ operation.toString() + Messages.getString("BigNumber.1"));
	}

	@Override
	public boolean isExact() {
		return true;
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public JSONObject toJSON() {
		JSONObject jsonResult = new JSONObject();
		try {
			jsonResult.put("type", "string");
			jsonResult.put("value", value);
			jsonResult.put("exact", isExact());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonResult;
	}

}
