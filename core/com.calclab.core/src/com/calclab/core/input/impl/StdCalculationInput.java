package com.calclab.core.input.impl;

import java.util.Scanner;

import com.calclab.core.input.CalculationInput;
import com.calclab.core.input.exceptions.InputException;

public class StdCalculationInput implements CalculationInput {

	private String expressions = null;
	private Scanner scanner = new Scanner(System.in);
	private boolean expectedMoreData = true;
	private static final String column = ";";

	@Override
	public String getExpressions() throws InputException {
		System.out.print(">> ");

		if (expressions == null) {
			expressions = scanner.nextLine().trim();
			if (!getLastChar().equals(column)) {
				expressions += column;
			}
		}
		return expressions;
	}

	private String getLastChar() {
		if (!expressions.isEmpty()) {
			return "" + expressions.charAt(expressions.length() - 1);
		}
		return "";
	}

	@Override
	public boolean isExpectedMoreData() {
		return expectedMoreData;
	}

	@Override
	public void setExpressions(String expressions) {
		this.expressions = expressions;
	}

}
