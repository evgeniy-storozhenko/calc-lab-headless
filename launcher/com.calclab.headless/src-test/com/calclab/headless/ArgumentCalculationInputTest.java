package com.calclab.headless;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Assert;

import com.calclab.core.input.ICalculationInput;
import com.calclab.core.input.InputException;
import com.calclab.headless.CalculationConfiguration;
import com.calclab.headless.input.InputFactory;

import junit.framework.TestCase;

public class ArgumentCalculationInputTest extends TestCase {

	public void testGetExpressions() {
		final String expressions = "2+2;" + System.lineSeparator() + "9/3;" + System.lineSeparator();
		File temp = null;
		BufferedWriter writer = null;
		try {
			temp = File.createTempFile("input", ".tmp");
			writer = new BufferedWriter(new FileWriter(temp, true));
			writer.write(expressions);
			System.out.println("Temp file : " + temp.getAbsolutePath());
		} catch (IOException e) {
			Assert.fail();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				Assert.fail();
			}
		}

		CalculationConfiguration config = new CalculationConfiguration();
		String[] args = new String[] { "-f", temp.getAbsolutePath() };
		if (!config.processArgs(args)) {
			Assert.fail();
		}
		InputFactory inputFactory = new InputFactory();
		ICalculationInput input = inputFactory.createCalculationInput(config);
		try {
			Assert.assertEquals(expressions, input.getExpressions());
		} catch (InputException e) {
			Assert.fail();
		}
	}

}
