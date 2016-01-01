package com.calclab.headless.internal;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import com.calclab.core.CalculationConfiguration;
import com.calclab.core.calculator.CalcaulationJobFactory;
import com.calclab.core.calculator.CalculationJob;
import com.calclab.core.calculator.CalculationView;
import com.calclab.core.calculator.view.HtmlView;
import com.calclab.core.calculator.view.JsonView;
import com.calclab.core.calculator.view.RowView;
import com.calclab.core.input.CalculationInput;
import com.calclab.core.input.InputFactory;
import com.calclab.core.input.InputType;
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
		if (config.getPort() > 0) {
			return HeadlessCalculationServer.getInstance().listen(config.getPort());
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
		String output = "";
		if (config.getOutputType().equals(InputType.JSON)) {
			CalculationView jsonView = new JsonView();
			jsonView.setCalculationProcess(process);
			output = jsonView.output();
		} else if (config.getOutputType().equals(InputType.HTML)) {
			CalculationView htmlView = new HtmlView();
			htmlView.setCalculationProcess(process);
			output = htmlView.output();
		} else if (config.getOutputType().equals(InputType.ROW)) {
			CalculationView htmlView = new RowView(false);
			htmlView.setCalculationProcess(process);
			output = htmlView.output();
		} else {
			CalculationView rowViewStdin = new RowView(true);
			rowViewStdin.setCalculationProcess(process);
			rowViewStdin.output();
		}
		System.out.println(output);
	}
}
