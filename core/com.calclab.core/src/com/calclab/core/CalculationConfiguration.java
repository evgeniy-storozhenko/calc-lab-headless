package com.calclab.core;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;

import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.app.IApplication;

import com.calclab.core.input.InputType;
import com.calclab.core.nls.Messages;

public class CalculationConfiguration {

	private int scale = 60;
	private int scaleToDisplay = 8;
	private int port = 0;
	private String inputData = null;
	private File inputFile = null;
	private InputType outputType = InputType.ROW;
	public static final String PLUGIN_ID = "com.calclab.core"; //$NON-NLS-1$

	enum CommandArg {
		InputData(Messages.CalculationConfiguration_0, "input", "i"),  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
		InputFile(Messages.CalculationConfiguration_3, "file", "f"),  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
		OutputType(Messages.CalculationConfiguration_1, "type", "t"), //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
		Port(Messages.CalculationConfiguration_14, "port", "p"), //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
		Scale(Messages.CalculationConfiguration_10, "scale", "s"),  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
		ScaleToDisplay(Messages.CalculationConfiguration_4, "display", "d"), //$NON-NLS-2$ //$NON-NLS-3$
		Help(Messages.CalculationConfiguration_12, "help", "h", "?"),  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		Version(Messages.CalculationConfiguration_13, "version", "v"); //$NON-NLS-1$ //$NON-NLS-2$

		CommandArg(String message, String... val) {
			this.val = val;
			this.message = message;
		}

		private String message;
		private String[] val;

		public String[] getCommands() {
			return val;
		}

		public String getMessage() {
			return message;
		}
	};

	public boolean processArgs(String[] args) {
		Iterator<String> i = Arrays.asList(args).iterator();
		while (i.hasNext()) {
			final String arg = i.next();
			CommandArg cmdArg = findArg(arg);
			if (cmdArg == null) {
				System.out.println(Messages.CalculationConfiguration_19 + arg);
				continue;
			}
			switch (cmdArg) {
			case InputData:
				inputData = i.next();
				break;
			case Port:
				try {
					port = Integer.parseInt(i.next());
				} catch (NumberFormatException e) {
					return false;
				}
				break;
			case InputFile:
				getFileInputArg(i);
				break;
			case Help:
				showHelp();
				exit();
			case Version:
				showVersion();
				exit();
			case OutputType:
				String type = i.next();
				if (type.toUpperCase().equals("HTML")) {
					outputType = InputType.HTML;
				} else if (type.toUpperCase().equals("JSON")) {
					outputType = InputType.JSON;
				} else if (type.toUpperCase().equals("ROW")) {
					outputType = InputType.ROW;
				} else {
					return false;
				}
				break;
			case Scale:
				try {
					scale = Integer.parseInt(i.next());
				} catch (NumberFormatException e) {
					return false;
				}
				break;
			case ScaleToDisplay:
				try {
					scaleToDisplay = Integer.parseInt(i.next());
				} catch (NumberFormatException e) {
					return false;
				}
				break;
			default:
				break;
			}
		}
		return true;
	}

	private void getFileInputArg(Iterator<String> i) {
		final String fileInputPath = i.next();
		final File fileInput = new File(fileInputPath);
		if (fileInput.exists() && fileInput.isFile() && fileInput.canRead()) {
			inputFile = fileInput;
		} else {
			System.out.println(String.format(
					Messages.CalculationConfiguration_20, fileInputPath));
		}
	}

	private CommandArg findArg(String arg) {
		CommandArg[] values = CommandArg.values();
		for (CommandArg commandArg : values) {
			String[] val = commandArg.getCommands();
			for (String s : val) {
				if (("-" + s).equals(arg) || ("--" + s).equals(arg)) { //$NON-NLS-1$ //$NON-NLS-2$
					return commandArg;
				}
			}
		}
		return null;
	}

	public void showHelp() {
		System.out.println(Messages.CalculationConfiguration_2);
		for (CommandArg v : CommandArg.values()) {
			System.out.print("\t"); //$NON-NLS-1$
			String[] commands = v.getCommands();
			for (int k = 0; k < commands.length; ++k) {
				System.out.print("-" + commands[k]); //$NON-NLS-1$
				if (k != commands.length - 1) {
					System.out.print(", "); //$NON-NLS-1$
				}
			}
			System.out.print(":\t" + v.getMessage()); //$NON-NLS-1$
			System.out.println();
		}
	}

	public void showVersion() {
		System.out.println(String.format(Messages.CalculationConfiguration_28,
				getRunnerVersion()));
	}

	public static String getRunnerVersion() {
		String version = Platform.getBundle(PLUGIN_ID).getHeaders()
				.get("Bundle-Version"); //$NON-NLS-1$
		if (version == null)
			return "[unknown]"; //$NON-NLS-1$
		int dotPos = version.lastIndexOf('.');
		if (dotPos < 0)
			return version;
		return version.substring(0, dotPos);
	}

	private void exit() {
		System.exit(IApplication.EXIT_OK);
	}

	public String getInputData() {
		return inputData;
	}

	public File getInputFile() {
		return inputFile;
	}

	public int getScale() {
		return scale;
	}

	public int getScaleToDisplay() {
		return scaleToDisplay;
	}

	public int getPort() {
		return port;
	}

	public InputType getOutputType() {
		return outputType;
	}

}
