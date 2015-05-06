package com.calclab.core.operand.number;

import java.math.BigDecimal;

import com.calclab.operands.common.internal.Number;

import junit.framework.TestCase;

public class NumberTest extends TestCase {

	public NumberTest(String testName) {
		super(testName);
	}

	/**
	 * Test of getNumerator method, of class Number.
	 */
	public void testGetNumerator_1() {
		String str = "823764876239840.12894712987301";
		Number num = new Number(str);
		BigDecimal expResult = new BigDecimal("82376487623984012894712987301");
		BigDecimal result = num.getNumerator();
		assertEquals(expResult, result);

	}

	public void testGetNumerator_2() {
		String str = "82376487623984012894712987301234234224124";
		Number num = new Number(str);
		BigDecimal expResult = new BigDecimal(
				"82376487623984012894712987301234234224124");
		BigDecimal result = num.getNumerator();
		assertEquals(expResult, result);

	}

	public void testGetNumerator_3() {
		String str = "0.823764876239840128947129873012342342241241232132131232";
		Number num = new Number(str);
		BigDecimal expResult = new BigDecimal(
				"823764876239840128947129873012342342241241232132131232");
		BigDecimal result = num.getNumerator();
		assertEquals(expResult, result);

	}

	public void testGetNumerator_4() {
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
		String str = "124098102840798174012";
		Number num = new Number(str);
		String expResult = str;
		String result = num.toString();
		assertEquals(expResult, result);
	}

	public void testToString_2() {
		String str = "823764876239840.12894712987301";
		Number num = new Number(str);
		String expResult = str;
		String result = num.toString();
		assertEquals(expResult, result);
	}

	public void testToString_3() {
		String str = "0.12894712987301";
		Number num = new Number(str);
		String expResult = str;
		String result = num.toString();
		assertEquals(expResult, result);
	}

	public void testToString_4() {
		String str = "12894712987301.0000000";
		Number num = new Number(str);
		String expResult = "12894712987301";
		String result = num.toString();
		assertEquals(expResult, result);
	}

	public void testToString_5() {
		String str = "-12894712987301453525555555555556";
		Number num = new Number(str);
		String expResult = "(" + str + ")";
		String result = num.toString();
		assertEquals(expResult, result);
	}

	public void testToString_6() {
		String str = "0.1000000034444444444444444444444444444444444444444444444"
				+ "44444444444444444444444444444444444444444444444444444"
				+ "44444444444444444444444444444444444444444444444444444"
				+ "44444444444444444444444444444444444444444444444444444"
				+ "44444444444444444444444444444444444444444444444444444"
				+ "44444444444444444444444444444444444444444444444444444"
				+ "44444444444444444444444444444444444444444444444444444"
				+ "44444444444444444444999999999999999999999999999999999"
				+ "99999999999999999999999999999999999999999999999999999999";
		Number num = new Number(str);
		String expResult = str;
		String result = num.toString();
		assertEquals(expResult, result);
	}

	public void testAdd_1() {
		Number num_1 = new Number("-111.111");
		Number num_2 = new Number("111.111");
		num_1 = num_1.Add(num_2);
		Number expResult = new Number("0");
		assertEquals(expResult, num_1);
	}

	public void testAdd_2() {
		Number num_1 = new Number("111.111");
		Number num_2 = new Number("111.111");
		num_1 = num_1.Add(num_2);
		Number expResult = new Number("222.222");
		assertEquals(expResult, num_1);
	}

	public void testAdd_3() {
		Number num_1 = new Number("111.111");
		Number num_2 = new Number("-94554.445");
		num_1 = num_1.Add(num_2);
		Number expResult = new Number("-94443.334");
		assertEquals(expResult, num_1);
	}

	public void testAdd_4() {
		Number num_1 = new Number("100000000");
		Number num_2 = new Number("54577788");
		num_1 = num_1.Add(num_2);
		Number expResult = new Number("154577788");
		assertEquals(expResult, num_1);
	}

	public void testSubtract_1() {
		Number num_1 = new Number("10000000");
		Number num_2 = new Number("-10000000");
		num_1 = num_1.Subtract(num_2);
		Number expResult = new Number("20000000");
		assertEquals(expResult, num_1);
	}

	public void testSubtract_2() {
		Number num_1 = new Number("-10000000");
		Number num_2 = new Number("-10000000");
		num_1 = num_1.Subtract(num_2);
		Number expResult = new Number("0");
		assertEquals(expResult, num_1);
	}

	public void testSubtract_3() {
		Number num_1 = new Number("-10000000.111");
		Number num_2 = new Number("10000000");
		num_1 = num_1.Subtract(num_2);
		Number expResult = new Number("-20000000.111");
		assertEquals(expResult, num_1);
	}

	public void testSubtract_4() {
		Number num_1 = new Number("999.999");
		Number num_2 = new Number("999.888");
		num_1 = num_1.Subtract(num_2);
		Number expResult = new Number("0.111");
		assertEquals(expResult, num_1);
	}

	public void testMultiply_1() {
		Number num_1 = new Number("0");
		Number num_2 = new Number("999.888");
		num_1 = num_1.Multiply(num_2);
		Number expResult = new Number("0");
		assertEquals(expResult, num_1);
	}

	public void testMultiply_2() {
		Number num_1 = new Number("-10");
		Number num_2 = new Number("999.888");
		num_1 = num_1.Multiply(num_2);
		Number expResult = new Number("-9998.88");
		assertEquals(expResult, num_1);
	}

	public void testMultiply_3() {
		Number num_1 = new Number("-1000");
		Number num_2 = new Number("-999.888");
		num_1 = num_1.Multiply(num_2);
		Number expResult = new Number("999888");
		assertEquals(expResult, num_1);
	}

	public void testMultiply_4() {
		Number num_1 = new Number("8982452");
		Number num_2 = new Number("45.120214534");
		num_1 = num_1.Multiply(num_2);
		Number expResult = new Number("405290161.281357368");
		assertEquals(expResult, num_1);
	}

	public void testDivide_1() {
		Number num_1 = new Number("0");
		Number num_2 = new Number("45.120214534");
		num_1 = num_1.Divide(num_2);
		Number expResult = new Number("0");
		assertEquals(expResult, num_1);
	}

	public void testDivide_2() {
		Number num_1 = new Number("100.456");
		Number num_2 = new Number("45.120214534");
		num_1 = num_1.Divide(num_2);
		assertTrue(num_1.toString()
				.contains("2.2264078537193597112341247805468601542531841189582"
						+ "9395836356"));
	}

	public void testDivide_3() {
		Number num_1 = new Number("10");
		Number num_2 = new Number("-45.12021");
		num_1 = num_1.Divide(num_2);
		Number expResult = new Number("-0.221630174150342");
		assertEquals(expResult, num_1);
	}

	public void testDivide_4() {
		Number num_1 = new Number("-100");
		Number num_2 = new Number("-100");
		num_1 = num_1.Divide(num_2);
		Number expResult = new Number("1");
		assertEquals(expResult, num_1);
	}

	public void testDivide_5() {
		Number num_1 = new Number("-100");
		Number num_2 = new Number("1");
		num_1 = num_1.Divide(num_2);
		Number expResult = new Number("-100");
		assertEquals(expResult, num_1);
	}

	public void testDivide_6() {
		Number num_1 = new Number("4");
		Number num_2 = new Number("3");
		Number num_3 = num_1.Divide(num_2);
		assertEquals("1.333333333333333333333333333333333333333333333333333333333334",
				num_3.toString());
	}

	public void testDivide_7() {
		Number num_1 = new Number("4");
		Number num_2 = new Number("3");
		Number num_3 = new Number("6");
		Number num_4 = num_1.Divide(num_2).Multiply(num_3);
		assertEquals("8", num_4.toString());
	}

	public void testEquals_1() {
		Number num_1 = new Number("-100");
		Number num_2 = new Number("-100");
		assertEquals(true, num_1.equals(num_2));
	}

	public void testEquals_2() {
		Number num_1 = new Number("-100");
		Number num_2 = new Number("0");
		assertEquals(false, num_1.equals(num_2));
	}

	public void test_3() {
		Number a1 = new Number("4");
		Number a2 = new Number("2");
		Number a3 = a1.Divide(a2);

		Number b1 = new Number("10");
		Number b2 = new Number("5");
		Number b3 = b1.Divide(b2);

		assertTrue(a3.equals(b3));
	}

	public void testObjectLinks() {
		Number a = new Number("1");
		Number b = new Number("2");
		Number c = new Number("2");

		Number d = a.Divide(b).Add(c);

		assertEquals(a.toString(), "1");
		assertEquals(b.toString(), "2");
		assertEquals(c.toString(), "2");
		assertEquals(d.toString(), "2.5");
	}

}
