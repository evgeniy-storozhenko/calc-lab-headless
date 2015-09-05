package com.calclab.core.nls;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.calclab.core.nls.messages"; //$NON-NLS-1$
	public static String FunctionRegistry_2;
	public static String FunctionRegistry_3;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
