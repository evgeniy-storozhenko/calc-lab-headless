package com.calclab.headless.internal;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import com.calclab.core.calculator.CalcaulationProcessFactory;
import com.calclab.core.calculator.CalculationJob;
import com.calclab.core.calculator.CalculationView;
import com.calclab.core.calculator.view.HtmlView;
import com.calclab.core.calculator.view.RowView;
import com.calclab.core.input.CalculationInput;
import com.calclab.headless.CalculationConfiguration;
import com.calclab.headless.input.InputFactory;
import com.calclab.headless.utils.HeadlessCalculationHelper;

/**
 * Bootstrap type for an application.
 */
public class HeadlessCalculationApp implements IApplication {

	public static final int ILLEGAL_ARGUMENT = 64;

	@Override
	public Object start(IApplicationContext context) throws Exception {
		final CalculationConfiguration config = new CalculationConfiguration();
		if (!config.processArgs(parseArgs(context))) {
			config.showHelp();
			return ILLEGAL_ARGUMENT;
		}
		return perform(config);
	}

	private String[] parseArgs(IApplicationContext context) {
		return HeadlessCalculationHelper.deQuoteArgs((String[]) context
				.getArguments().get(IApplicationContext.APPLICATION_ARGS));
	}

	@Override
	public void stop() {
	}

	private int perform(final CalculationConfiguration config) {

		InputFactory inputFactory = new InputFactory();
		CalcaulationProcessFactory calcProcessFactory = new CalcaulationProcessFactory();

		CalculationInput input = inputFactory.createCalculationInput(config);
		CalculationJob process = calcProcessFactory.createCalculationProcess(input);

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
		if (config.getHtmlFileOutput() != null) {
			CalculationView htmlView = new HtmlView();
			htmlView.setCalculationProcess(process);
			htmlView.output();
		}
		if (config.getRowFileOutput() != null) {
			rowView = new RowView(false);
			rowView.setCalculationProcess(process);
			output = rowView.output();
		}

		if (config.getHtmlFileOutput() == null && config.getRowFileOutput() == null) {
			if (output.isEmpty()) {
				boolean isStdIn = config.getInputData() == null && config.getInputFile() == null;
				rowView = new RowView(isStdIn);
				rowView.setCalculationProcess(process);
				output = rowView.output();
			}
			System.out.println(output);
		}
	}
}
