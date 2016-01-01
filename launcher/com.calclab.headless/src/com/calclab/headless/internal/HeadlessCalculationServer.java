package com.calclab.headless.internal;

import org.eclipse.equinox.app.IApplication;

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
}
