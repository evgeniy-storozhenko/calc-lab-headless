package com.calclab.core.operand.number;

import java.math.BigDecimal;

import com.calclab.operands.common.internal.Number;

import junit.framework.TestCase;

public class NumberTest extends TestCase {

	public NumberTest(String testName) {
		super(testName);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetNumerator_1() {
		System.out.println("getNumerator");
		String str = "823764876239840.12894712987301";
		Number num = new Number(str);
		BigDecimal expResult = new BigDecimal("82376487623984012894712987301");
		BigDecimal result = num.getNumerator();
		assertEquals(expResult, result);

	}

	public void testGetNumerator_2() {
		System.out.println("getNumerator");
		String str = "82376487623984012894712987301234234224124";
		Number num = new Number(str);
		BigDecimal expResult = new BigDecimal("82376487623984012894712987301234234224124");
		BigDecimal result = num.getNumerator();
		assertEquals(expResult, result);

	}

	public void testGetNumerator_3() {
		System.out.println("getNumerator");
		String str = "0.823764876239840128947129873012342342241241232132131232";
		Number num = new Number(str);
		BigDecimal expResult = new BigDecimal("823764876239840128947129873012342342241241232132131232");
		BigDecimal result = num.getNumerator();
		assertEquals(expResult, result);

	}

	public void testGetNumerator_4() {
		System.out.println("getNumerator");
		String str = "-10823769.99999999999999999999";
		Number num = new Number(str);
		BigDecimal expResult = new BigDecimal("-1082376999999999999999999999");
		BigDecimal result = num.getNumerator();
		assertEquals(expResult, result);

	}

	/**
	 * Test of toString method, of class Number.
	 */
	public void testToString_1() {
		System.out.println("toString");
		String str = "124098102840798174012";
		Number num = new Number(str);
		String expResult = str;
		String result = num.toString();
		assertEquals(expResult, result);
	}

	public void testToString_2() {
		System.out.println("toString");
		String str = "823764876239840.12894712987301";
		Number num = new Number(str);
		String expResult = str;
		String result = num.toString();
		assertEquals(expResult, result);
	}

	public void testToString_3() {
		System.out.println("toString");
		String str = "0.12894712987301";
		Number num = new Number(str);
		String expResult = str;
		String result = num.toString();
		assertEquals(expResult, result);
	}

	public void testToString_4() {
		System.out.println("toString");
		String str = "12894712987301.0000000";
		Number num = new Number(str);
		String expResult = "12894712987301";
		String result = num.toString();
		assertEquals(expResult, result);
	}

	public void testToString_5() {
		System.out.println("toString");
		String str = "-12894712987301453525555555555556";
		Number num = new Number(str);
		String expResult = str;
		String result = num.toString();
		assertEquals(expResult, result);
	}

	public void testToString_6() {
		System.out.println("toString");
		String str = "0.10000000344444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444499999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
		Number num = new Number(str);
		String expResult = str;
		String result = num.toString();
		assertEquals(expResult, result);
	}

}