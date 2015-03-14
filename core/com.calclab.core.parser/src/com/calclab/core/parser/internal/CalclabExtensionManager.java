package com.calclab.core.parser.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.calclab.core.operands.Operand;

public class CalclabExtensionManager {

	private Map<String, Operand> operands = null;
	private static CalclabExtensionManager instance = null;

	private CalclabExtensionManager() {
		initialize();
	}

	private synchronized void initialize() {
		if (operands != null) {
			return;
		}
		operands = new HashMap<String, Operand>();

		IConfigurationElement[] elements = Platform.getExtensionRegistry()
				.getConfigurationElementsFor("com.calclab.operand");
		for (IConfigurationElement cfg : elements) {
			Operand provider;
			try {
				provider = (Operand) cfg.createExecutableExtension("class");
				operands.put("" ,provider); // TODO
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized static CalclabExtensionManager getInstance() {
		if (instance == null) {
			instance = new CalclabExtensionManager();
		}
		return instance;
	}

}
