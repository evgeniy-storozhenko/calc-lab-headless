package com.calclab.headless.internal;

import org.eclipse.equinox.app.IApplication;

import com.calclab.core.CalculationConfiguration;
import com.calclab.core.calculator.CalcaulationJobFactory;
import com.calclab.core.calculator.CalculationJob;
import com.calclab.core.calculator.CalculationView;
import com.calclab.core.calculator.view.RowView;
import com.calclab.core.input.CalculationInput;
import com.calclab.core.input.InputFactory;

/**
 * Bootstrap type for an application.
 */
public class HeadlessCalculationServer {

	private static HeadlessCalculationServer instance = null;

	private HeadlessCalculationServer() {
	}

	public synchronized static HeadlessCalculationServer getInstance() {
		if (instance == null) {
			instance = new HeadlessCalculationServer();
		}
		return instance;
	}

	public int listen(int port) {

		return IApplication.EXIT_OK;
	}

	private int perform(final CalculationConfiguration config) {

		InputFactory inputFactory = new InputFactory();
		CalcaulationJobFactory calcProcessFactory = new CalcaulationJobFactory();

		CalculationInput input = inputFactory.createCalculationInput(config);
		CalculationJob process = calcProcessFactory.createCalculationJob(input, config.getScale(),
				config.getScaleToDisplay());

		do {
			process.run();
			output(process, config);
			input.setExpressions(null);
		} while (input.isExpectedMoreData() && !process.getStatus().isError());
		return IApplication.EXIT_OK;
	}

	private void output(final CalculationJob process, final CalculationConfiguration config) {
		CalculationView rowView;
		String output = "";

		if (config.getHtmlFileOutput() == null && config.getRowFileOutput() == null) {
			if (output.isEmpty()) {
				boolean isStdIn = config.getInputData() == null && config.getInputFile() == null;
				rowView = new RowView(isStdIn);
				rowView.setCalculationProcess(process);
				output = rowView.output();
			}
			System.out.println(output); // TODO replace
		}
	}
}
