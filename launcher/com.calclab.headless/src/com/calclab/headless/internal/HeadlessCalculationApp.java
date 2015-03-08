package com.calclab.headless.internal;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

import com.calclab.headless.CalculationConfiguration;
import com.calclab.headless.utils.HeadlessCalculationHelper;

public class HeadlessCalculationApp implements IApplication {

	public static final int ILLEGAL_ARGUMENT = 64;

	@Override
	public Object start(IApplicationContext context) throws Exception {
		CalculationConfiguration conf = new CalculationConfiguration();
		if (!conf.processArgs(parseArgs(context))) {
			conf.showHelp();
			return ILLEGAL_ARGUMENT;
		}

		return perform(conf);
	}

	private String[] parseArgs(IApplicationContext context) {
		return HeadlessCalculationHelper.deQuoteArgs((String[]) context
				.getArguments().get(IApplicationContext.APPLICATION_ARGS));
	}

	@Override
	public void stop() {
	}

	private int perform(CalculationConfiguration conf) {
		// TODO Auto-generated method stub
		return IApplication.EXIT_OK;
	}

}
