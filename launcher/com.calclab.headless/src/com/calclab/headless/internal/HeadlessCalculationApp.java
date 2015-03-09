package com.calclab.headless.internal;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import com.calclab.core.input.ICalculationInput;
import com.calclab.core.input.InputException;
import com.calclab.headless.CalculationConfiguration;
import com.calclab.headless.input.InputFactory;
import com.calclab.headless.utils.HeadlessCalculationHelper;

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
		ICalculationInput input = inputFactory.createCalculationInput(config);
		try {
			System.out.println(input.getExpressions());
		} catch (InputException e) {
			// TODO Auto-generated catch block
		}
		return IApplication.EXIT_OK;
	}

}
