package com.calclab.operands.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONException;
import org.json.JSONObject;

import com.calclab.core.calculations.Calculable;
import com.calclab.core.calculations.CalculationFactory;
import com.calclab.core.calculations.CalculationStatus;
import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.functions.Function;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.InternalExpression;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;
import com.calclab.operands.common.internal.FunctionOperand;
import com.calclab.operands.common.internal.Variable;
import com.calclab.operands.common.monitors.NullStepMonitor;

import junit.framework.TestCase;

public class VariableTest extends TestCase {

	private CommonOperandFactory operFactory = CommonOperandFactory.getInstance();
	private CalculationFactory calcFactory = new CalculationFactory();

	public void testVariable_1() {
		Variable a = createVariable("a", "5");

		assertEquals("a", a.toString());
		assertEquals("5", a.getResult().toString());
	}

	/**
	 * a=2+2
	 */
	public void testVariable_2() {
		Operand operand = createCompositeOperand("2", "+", "2");
		Calculable calculation = calcFactory.createCalculation(operand);
		Variable var = (Variable) operFactory.createVariableOperand("a", calculation);
		calculation.calculate();

		assertEquals("a", var.toString());
		assertEquals("4", var.getResult().toString());
	}

	/**
	 * a=2+2
	 * b=a*3
	 * c=3*a
	 */
	public void testPerform_1() {
		Operand operand = createCompositeOperand("2", "+", "2");
		Calculable calculation = calcFactory.createCalculation(operand);
		Variable varA = (Variable) operFactory.createVariableOperand("a", calculation);
		calculation.calculate();

		AbstractNumber numberC = operFactory.createNumber("3");
		Operand op2 = operFactory.createCompositeOperand(varA, createOperation("*"), numberC);
		Calculable calculation2 = calcFactory.createCalculation(op2);
		Variable varB = (Variable) operFactory.createVariableOperand("b", calculation2);
		calculation2.calculate();

		Operand op3 = operFactory.createCompositeOperand(numberC, createOperation("*"), varA);
		Calculable calculation3 = calcFactory.createCalculation(op3);
		Variable varC = (Variable) operFactory.createVariableOperand("c", calculation3);
		calculation3.calculate();

		assertEquals("b", varB.toString());
		assertEquals("12", varB.getResult().toString());

		assertEquals("c", varC.toString());
		assertEquals("12", varC.getResult().toString());
	}

	/**
	 * a=2
	 * b=8
	 * log(a,b)
	 */
	public void testPerform_2() {
		Variable a = createVariable("a", "2");
		Variable b = createVariable("b", "8");
		
		List<Operand> arguments = new ArrayList<>();
		arguments.add(a);
		arguments.add(b);
		
		FunctionOperand functionOperand = new FunctionOperand("mock", arguments);
		functionOperand.setFunction(new FunctionMock());
		functionOperand.getFunction().setArguments(arguments);

		Calculable calculation = calcFactory.createCalculation(functionOperand);
		calculation.calculate();
		
		assertEquals("mock(2,8)", functionOperand.toString());
	}

	/**
	 * a=2
	 * -a
	 * 
	 * @throws InternalExpression
	 * @throws InvalidActionException
	 * @throws OperatorNotFoundException
	 */
	public void testPerform_3() throws OperatorNotFoundException, InvalidActionException, InternalExpression {
		Variable a = createVariable("a", "2");
		Operand b = a.perform(createOperation("-"), NullStepMonitor.getInstance());

		assertEquals("(-2)", b.toString());
	}

	/**
	 * a=-2
	 * -a
	 * 
	 * @throws InternalExpression
	 * @throws InvalidActionException
	 * @throws OperatorNotFoundException
	 */
	public void testPerform_4() throws OperatorNotFoundException, InvalidActionException, InternalExpression {
		Variable a = createVariable("a", "-2");
		Operand b = a.perform(createOperation("-"), NullStepMonitor.getInstance());
		assertEquals("2", b.toString());
	}

	private Operand createCompositeOperand(String a, String operation, String b) {
		AbstractNumber numberA = operFactory.createNumber(a);
		AbstractNumber numberB = operFactory.createNumber(b);
		return operFactory.createCompositeOperand(numberA, createOperation(operation), numberB);
	}

	private Operation createOperation(String operation) {
		return new Operation() {
			@Override
			public String getName() {
				return operation;
			}
		};
	}

	private Variable createVariable(String name, String value) {
		AbstractNumber number = operFactory.createNumber(value);
		Calculable calculation = calcFactory.createCalculation(number);
		Variable var = (Variable) operFactory.createVariableOperand(name, calculation);
		calculation.calculate();
		return var;
	}

	class FunctionMock implements Function {

		protected List<Operand> arguments = new ArrayList<Operand>();
		protected CalculationStatus status = new CalculationStatus();
		protected Operand result = null;
		protected boolean exact = true;
		private StepsMonitor monitor;

		@Override
		public Operand perform(Operation operation, StepsMonitor monitor) throws OperatorNotFoundException,
				InvalidActionException, InternalExpression {
			calculate();
			if (status.isDone()) {
				return result.perform(operation, monitor);
			}
			throw new InternalExpression(status);
		}

		@Override
		public Operand perform(Operation operation, Operand operand, StepsMonitor monitor)
				throws OperatorNotFoundException, InvalidActionException, InternalExpression {
			calculate();
			if (status.isDone()) {
				return result.perform(operation, operand, monitor);
			}
			throw new InternalExpression(status);
		}

		@Override
		public boolean isExact() {
			return exact;
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
			return result;
		}

		@Override
		public void setArguments(List<Operand> arguments) {
			this.arguments = arguments;
		}

		@Override
		public String getInput() {
			return "";
		}

		@Override
		public Operand calculate() {
			assertEquals(2, arguments.size());
			assertTrue(arguments.get(0) instanceof AbstractNumber);
			assertTrue(arguments.get(1) instanceof AbstractNumber);
			return null;
		}

		@Override
		public String getName() {
			return "mock";
		}

		@Override
		public String toString() {
			String args = arguments.stream().map(object -> object.toString())
					.collect(Collectors.joining(","));
			return getName() + "(" + args + ")";
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
				jsonResult.put("value", result.toJSON());
				jsonResult.put("exact", isExact());

			} catch (JSONException e) {
				e.printStackTrace();
			}
			return jsonResult;
		}

	}
}
