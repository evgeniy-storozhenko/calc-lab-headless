package com.calclab.operands.common.internal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

import org.json.JSONException;
import org.json.JSONObject;

import com.calclab.core.calculations.StepsMonitor;
import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.Operand;
import com.calclab.core.operands.exceptions.InternalExpression;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.core.operands.exceptions.OperatorNotFoundException;
import com.calclab.core.operations.Operation;

public class Infinity extends AbstractNumber {

	private static final long serialVersionUID = 3824496678243946527L;

	@Override
	public String toString() {
		return "∞";
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
		return true;
	}

	@Override
	public int compareTo(AbstractNumber o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Number getNumerator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Number getDenominator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNumerator(Number numerator) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDenominator(Number denominator) {
		// TODO Auto-generated method stub

	}

	@Override
	public AbstractNumber setScale(int newScale, RoundingMode roundingMode) {
		return this;
	}

	@Override
	public AbstractNumber multiply(AbstractNumber number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractNumber divide(AbstractNumber number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractNumber divideToIntegralValue(AbstractNumber number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractNumber[] divideAndRemainder(AbstractNumber number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractNumber add(AbstractNumber number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractNumber subtract(AbstractNumber number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractNumber pow(AbstractNumber number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractNumber negate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractNumber round(MathContext mc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractNumber abs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean withinLimitsOfDouble() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNegative() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEven() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFractionalNumber() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void optimize() {
		// TODO Auto-generated method stub

	}

	@Override
	public BigDecimal toBigDecimal() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigInteger toBigInteger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toScientificNotation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractNumber clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int signum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public JSONObject toJSON() {
		JSONObject jsonResult = new JSONObject();
		try {
			jsonResult.put("type", "infinity");
			jsonResult.put("value", toString());
			jsonResult.put("exect", isExact());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonResult;
	}

}
