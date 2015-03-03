package com.calclab.headless.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class HeadlessCalculationPlugin implements BundleActivator {

	public static final String PLUGIN_ID = "com.calclab.headless";

	private static HeadlessCalculationPlugin plugin;

	public static HeadlessCalculationPlugin getDefault() {
		return plugin;
	}

	@Override
	public void start(final BundleContext context) throws Exception {
		plugin = this;
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		plugin = null;
	}

}
