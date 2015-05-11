package com.calclab.core.functions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import com.calclab.core.input.exceptions.FunctionNotFoundException;
import com.calclab.core.operands.Operand;

public class FunctionRegistry {

	private static final String extensionType = "com.calclab.function";
	private static FunctionRegistry instance = null;

	private final Map<String, IConfigurationElement> extensions = new HashMap<String, IConfigurationElement>();

	private FunctionRegistry() {
		initialize();
	}

	private synchronized void initialize() {
		IConfigurationElement[] configurations = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(extensionType);
		for (IConfigurationElement cfg : configurations) {
			extensions.put(cfg.getAttribute("name"), cfg);
		}
	}

	public synchronized static FunctionRegistry getInstance() {
		if (instance == null) {
			instance = new FunctionRegistry();
		}
		return instance;
	}

	public Map<String, IConfigurationElement> getExtensions() {
		return extensions;
	}

	public boolean contains(String name) {
		return extensions.containsKey(name);
	}

	public Function createFunction(String name, List<Operand> arguments)
			throws CoreException, FunctionNotFoundException {
		if (!contains(name)) {
			String msg = "Function '" + name + "' can not be found.";
			throw new FunctionNotFoundException(msg, new Throwable());
		}
		Function provider = (Function) extensions.get(name).createExecutableExtension("class");
		provider.setArguments(arguments);
		return provider;
	}
}
