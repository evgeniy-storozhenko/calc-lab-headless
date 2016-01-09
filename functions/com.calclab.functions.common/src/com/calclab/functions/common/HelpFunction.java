package com.calclab.functions.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.JSONException;
import org.json.JSONObject;

import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.calculations.StepFactory;
import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.functions.Function;
import com.calclab.core.functions.FunctionClient;
import com.calclab.core.functions.FunctionRegistry;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.InternalExpression;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;
import com.calclab.functions.common.nls.Messages;
import com.calclab.operands.common.CommonOperandFactory;

public class HelpFunction implements Function {

	private CalculationStatus status = new CalculationStatus();
	private List<Operand> arguments = new ArrayList<>();
	private StepFactory stepFactory = StepFactory.getInstance();
	private StepsMonitor monitor;

	@Override
	public String getName() {
		return "help";
	}

	@Override
	public Operand calculate() {
		if (!status.isWaiting()) {
			return CommonOperandFactory.getInstance().createVoidOperand();
		}
		status.setStage(CalculationStatus.Stage.INPROCESS);
		if (arguments.size() > 0) {
			getHelpInfoAbout(arguments.get(0));
		} else {
			getAllHelpInfo();
		}
		status.setStage(CalculationStatus.Stage.DONE);
		return CommonOperandFactory.getInstance().createVoidOperand();
	}

	private void getHelpInfoAbout(Operand operand) {
		FunctionClient info = FunctionRegistry.getInstance().getInfoAbout(operand.toString());
		if (info != null) {
			monitor.addStep(stepFactory.createDefaultStep(info.toString()));
		} else {
			monitor.addStep(stepFactory.createDefaultStep(Messages.getString("FunctionNotFound")));
		}
	}

	private void getAllHelpInfo() {
		Map<String, FunctionClient> functionsInfo = FunctionRegistry.getInstance().getInfo();
		for (Map.Entry<String, FunctionClient> info : functionsInfo.entrySet()) {
			monitor.addStep(stepFactory.createDefaultStep(info.getValue().toString()));
		}
	}

	@Override
	public Operand perform(Operation operation, StepsMonitor monitor)
			throws OperatorNotFoundException, InvalidActionException, InternalExpression {
		throw new OperatorNotFoundException(Messages.getString("ExpFunction.1") +
				operation + Messages.getString("ExpFunction.2"));
	}

	@Override
	public Operand perform(Operation operation, Operand operand, StepsMonitor monitor)
			throws OperatorNotFoundException, InvalidActionException, InternalExpression {
		throw new OperatorNotFoundException(Messages.getString("ExpFunction.1") +
				operation + Messages.getString("ExpFunction.2"));
	}

	@Override
	public boolean isExact() {
		return true;
	}

	@Override
	public StepsMonitor getStepMonitor() {
		return monitor;
	}

	@Override
	public CalculationStatus getStatus() {
		return status;
	}

	@Override
	public Operand getResult() {
		return CommonOperandFactory.getInstance().createVoidOperand();
	}

	@Override
	public String getInput() {
		return toString();
	}

	@Override
	public void setArguments(List<Operand> arguments) {
		this.arguments = arguments;
	}

	@Override
	public void setStepMonitor(StepsMonitor monitor) {
		this.monitor = monitor;
	}

	@Override
	public JSONObject toJSON() {
		JSONObject jsonResult = new JSONObject();
		try {
			List<JSONObject> args = arguments.stream()
					.filter(item -> item != null)
					.map(item -> item.toJSON())
					.collect(Collectors.toList());

			jsonResult.put("type", "func");
			jsonResult.put("name", getName());
			jsonResult.put("args", args);
			jsonResult.put("value", toString());
			jsonResult.put("exact", isExact());

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonResult;
	}

}
