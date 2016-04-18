package com.calclab.operands.common;

import java.math.BigDecimal;

import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.operands.common.internal.CLNumber;

import junit.framework.TestCase;

public class CLNumberTest extends TestCase {

	public CLNumberTest(String testName) {
		super(testName);
		AbstractNumber.scaleToDisplay = 15;
	}

	/**
	 * Test of getNumerator method, of class CLNumber.
	 */
	public void testGetNumerator_1() {
		String str = "823764876239840.12894712987301";
		CLNumber num = new CLNumber(str);
		BigDecimal expResult = new BigDecimal("823764876239840.125");
		BigDecimal result = num.getNumerator();
		assertEquals(expResult, result);
	}

	public void testGetNumerator_2() {
		String str = "82376487623984012894712987301234234224124";
		CLNumber num = new CLNumber(str);
		BigDecimal expResult = new BigDecimal(
				"82376487623984014007855816115669172224000");
		BigDecimal result = num.getNumerator();
		assertEquals(expResult, result);

	}

	public void testGetNumerator_3() {
		String str = "0.823764876239840128947129873012342342241241232132131232";
		CLNumber num = new CLNumber(str);
		BigDecimal expResult = new BigDecimal(
				"0.8237648762398401824924576430930756032466888427734375");
		BigDecimal result = num.getNumerator();
		assertEquals(expResult, result);

	}

	public void testGetNumerator_4() {
		String str = "-10823769.99999999999999999999";
		CLNumber num = new CLNumber(str);
		BigDecimal expResult = new BigDecimal("-10823770");
		BigDecimal result = num.getNumerator();
		assertEquals(expResult, result);
	}

	/**
	 * Test of toString method, of class CLNumber.
	 */
	public void testToString_1() {
		String str = "124098102840798174012";
		CLNumber num = new CLNumber(str);
		String expResult = str;
		String result = num.toString();
		assertEquals("1.2409810284079817E20", result);
	}

	public void testToString_2() {
		String str = "823764876239840.12894712987301";
		CLNumber num = new CLNumber(str);
		String expResult = str;
		String result = num.toString();
		assertEquals("8.237648762398401E14", result);
	}

	public void testToString_3() {
		String str = "0.12894712987301";
		CLNumber num = new CLNumber(str);
		String expResult = str;
		String result = num.toString();
		assertEquals(expResult, result);
	}

	public void testToString_4() {
		String str = "12894712987301.0000000";
		CLNumber num = new CLNumber(str);
		String expResult = "1.2894712987301E13";
		String result = num.toString();
		assertEquals(expResult, result);
	}

	public void testToString_5() {
		String str = "-12894712987301453525555555555556";
		CLNumber num = new CLNumber(str);
		String expResult = "(-1.2894712987301454E31)";
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
		CLNumber num = new CLNumber(str);
		String expResult = str;
		String result = num.toString();
		assertEquals("0.10000000344444444", result);
	}

	public void testAdd_1() {
		CLNumber num_1 = new CLNumber("-111.111");
		CLNumber num_2 = new CLNumber("111.111");
		num_1 = num_1.add(num_2);
		CLNumber expResult = new CLNumber("0");
		assertEquals(expResult, num_1);
	}

	public void testAdd_2() {
		CLNumber num_1 = new CLNumber("111.111");
		CLNumber num_2 = new CLNumber("111.111");
		num_1 = num_1.add(num_2);
		CLNumber expResult = new CLNumber("222.222");
		assertEquals(expResult, num_1);
	}

	public void testAdd_3() {
		CLNumber num_1 = new CLNumber("111.111");
		CLNumber num_2 = new CLNumber("-94554.445");
		num_1 = num_1.add(num_2);
		CLNumber expResult = new CLNumber("-94443.334");
		assertEquals(expResult, num_1);
	}

	public void testAdd_4() {
		CLNumber num_1 = new CLNumber("100000000");
		CLNumber num_2 = new CLNumber("54577788");
		num_1 = num_1.add(num_2);
		CLNumber expResult = new CLNumber("154577788");
		assertEquals(expResult, num_1);
	}

	public void testSubtract_1() {
		CLNumber num_1 = new CLNumber("10000000");
		CLNumber num_2 = new CLNumber("-10000000");
		num_1 = num_1.subtract(num_2);
		CLNumber expResult = new CLNumber("20000000");
		assertEquals(expResult, num_1);
	}

	public void testSubtract_2() {
		CLNumber num_1 = new CLNumber("-10000000");
		CLNumber num_2 = new CLNumber("-10000000");
		num_1 = num_1.subtract(num_2);
		CLNumber expResult = new CLNumber("0");
		assertEquals(expResult, num_1);
	}

	public void testSubtract_3() {
		CLNumber num_1 = new CLNumber("-10000000.111");
		CLNumber num_2 = new CLNumber("10000000");
		num_1 = num_1.subtract(num_2);
		CLNumber expResult = new CLNumber("-20000000.111");
		assertEquals(expResult, num_1);
	}

	public void testSubtract_4() {
		CLNumber num_1 = new CLNumber("999.999");
		CLNumber num_2 = new CLNumber("999.888");
		num_1 = num_1.subtract(num_2);
		CLNumber expResult = new CLNumber("0.11099999999999");
		assertEquals(expResult, num_1);
	}

	public void testMultiply_1() {
		CLNumber num_1 = new CLNumber("0");
		CLNumber num_2 = new CLNumber("999.888");
		num_1 = num_1.multiply(num_2);
		CLNumber expResult = new CLNumber("0");
		assertEquals(expResult, num_1);
	}

	public void testMultiply_2() {
		CLNumber num_1 = new CLNumber("-10");
		CLNumber num_2 = new CLNumber("999.888");
		num_1 = num_1.multiply(num_2);
		CLNumber expResult = new CLNumber("-9998.880000000001");
		assertEquals(expResult, num_1);
	}

	public void testMultiply_3() {
		CLNumber num_1 = new CLNumber("-1000");
		CLNumber num_2 = new CLNumber("-999.888");
		num_1 = num_1.multiply(num_2);
		CLNumber expResult = new CLNumber("999888");
		assertEquals(expResult, num_1);
	}

	public void testMultiply_4() {
		CLNumber num_1 = new CLNumber("8982452");
		CLNumber num_2 = new CLNumber("45.120214534");
		num_1 = num_1.multiply(num_2);
		CLNumber expResult = new CLNumber("405290161.281357368");
		assertEquals(expResult, num_1);
	}

	public void testDivide_1() {
		CLNumber num_1 = new CLNumber("0");
		CLNumber num_2 = new CLNumber("45.120214534");
		num_1 = (CLNumber) num_1.divide(num_2);
		CLNumber expResult = new CLNumber("0");
		assertEquals(expResult, num_1);
	}

	public void testDivide_2() {
		CLNumber num_1 = new CLNumber("100.456");
		CLNumber num_2 = new CLNumber("45.120214534");
		num_1 = (CLNumber) num_1.divide(num_2);
		assertEquals(num_1.toString(), "2.2264078537193597");
	}

	public void testDivide_3() {
		CLNumber num_1 = new CLNumber("10");
		CLNumber num_2 = new CLNumber("-45.12021");
		num_1 = (CLNumber) num_1.divide(num_2);
		CLNumber expResult = new CLNumber("-0.2216301741503419421141878550653"
				+ "90874732187638311080555697768");
		assertEquals(expResult, num_1);
	}

	public void testDivide_4() {
		CLNumber num_1 = new CLNumber("-100");
		CLNumber num_2 = new CLNumber("-100");
		num_1 = (CLNumber) num_1.divide(num_2);
		CLNumber expResult = new CLNumber("1");
		assertEquals(expResult, num_1);
	}

	public void testDivide_5() {
		CLNumber num_1 = new CLNumber("-100");
		CLNumber num_2 = new CLNumber("1");
		num_1 = (CLNumber) num_1.divide(num_2);
		CLNumber expResult = new CLNumber("-100");
		assertEquals(expResult, num_1);
	}

	public void testDivide_6() {
		CLNumber num_1 = new CLNumber("4");
		CLNumber num_2 = new CLNumber("3");
		CLNumber num_3 = (CLNumber) num_1.divide(num_2);
		assertEquals("1.3333333333333333", num_3.toString());
	}

	public void testDivide_7() {
		CLNumber num_1 = new CLNumber("4");
		CLNumber num_2 = new CLNumber("3");
		CLNumber num_3 = new CLNumber("6");
		CLNumber num_4 = (CLNumber) num_1.divide(num_2).multiply(num_3);
		assertEquals("8", num_4.toString());
	}

	public void testEquals_1() {
		CLNumber num_1 = new CLNumber("-100");
		CLNumber num_2 = new CLNumber("-100");
		assertEquals(true, num_1.equals(num_2));
	}

	public void testEquals_2() {
		CLNumber num_1 = new CLNumber("-100");
		CLNumber num_2 = new CLNumber("0");
		assertEquals(false, num_1.equals(num_2));
	}

	public void test_3() {
		CLNumber a1 = new CLNumber("4");
		CLNumber a2 = new CLNumber("2");
		CLNumber a3 = (CLNumber) a1.divide(a2);

		CLNumber b1 = new CLNumber("10");
		CLNumber b2 = new CLNumber("5");
		CLNumber b3 = (CLNumber) b1.divide(b2);

		assertTrue(a3.equals(b3));
	}

	public void testObjectLinks() {
		CLNumber a = new CLNumber("1");
		CLNumber b = new CLNumber("2");
		CLNumber c = new CLNumber("2");

		CLNumber d = (CLNumber) a.divide(b).add(c);

		assertEquals(a.toString(), "1");
		assertEquals(b.toString(), "2");
		assertEquals(c.toString(), "2");
		assertEquals(d.toString(), "2.5");
	}

	public void testIsFractionalNumber() {
		assertTrue(new CLNumber("1.5").isFractionalNumber());
		assertTrue(new CLNumber("-1.5").isFractionalNumber());
		assertTrue(new CLNumber("0.3333333").isFractionalNumber());
		assertTrue(new CLNumber("-0.3333333").isFractionalNumber());
		assertFalse(new CLNumber("3333333").isFractionalNumber());
		assertFalse(new CLNumber("-3333333").isFractionalNumber());
	}

	/**
	 * 2^3
	 */
	public void testPow_1() {
		CLNumber a = new CLNumber("2");
		CLNumber b = new CLNumber("3");
		AbstractNumber c = a.pow(b);

		assertEquals("8", c.toString());
	}

	/**
	 * 1^15
	 */
	public void testPow_2() {
		CLNumber a = new CLNumber("1");
		CLNumber b = new CLNumber("15");
		AbstractNumber c = a.pow(b);

		assertEquals(c.toString(), "1");
	}

	/**
	 * (-2)^2
	 */
	public void testPow_3() {
		CLNumber a = new CLNumber("-2");
		CLNumber b = new CLNumber("2");
		AbstractNumber c = a.pow(b);

		assertEquals(c.toString(), "4");
	}

	/**
	 * (-1)^16
	 */
	public void testPow_4() {
		CLNumber a = new CLNumber("-1");
		CLNumber b = new CLNumber("16");
		AbstractNumber c = a.pow(b);

		assertEquals(c.toString(), "1");
	}

	/**
	 * (-2)^3
	 */
	public void testPow_5() {
		CLNumber a = new CLNumber("-2");
		CLNumber b = new CLNumber("3");
		AbstractNumber c = a.pow(b);

		assertEquals(c.toString(), "(-8)");
	}

	/**
	 * (-3)^2
	 */
	public void testPow_6() {
		CLNumber a = new CLNumber("-3");
		CLNumber b = new CLNumber("2");
		AbstractNumber c = a.pow(b);

		assertEquals(c.toString(), "9");
	}

	/**
	 * (-3)^3
	 */
	public void testPow_7() {
		CLNumber a = new CLNumber("-3");
		CLNumber b = new CLNumber("3");
		AbstractNumber c = a.pow(b);

		assertEquals(c.toString(), "(-27)");
	}

	/**
	 * 4^(-2)
	 */
	public void testPow_8() {
		CLNumber a = new CLNumber("4");
		CLNumber b = new CLNumber("-2");
		AbstractNumber c = a.pow(b);

		assertEquals(c.toString(), "0.0625");
	}

	/**
	 * 2^(-3)
	 */
	public void testPow_9() {
		CLNumber a = new CLNumber("2");
		CLNumber b = new CLNumber("-3");
		AbstractNumber c = a.pow(b);

		assertEquals("0.125", c.toString());
	}

	/**
	 * 2000^10
	 */
	public void testPow_10() {
		CLNumber a = new CLNumber("2000");
		CLNumber b = new CLNumber("10");
		AbstractNumber c = a.pow(b);

		assertEquals("1.024E33", c.toString());
	}

	/**
	 * 2^93
	 */
	public void testPow_11() {
		CLNumber a = new CLNumber("2");
		CLNumber b = new CLNumber("93");
		AbstractNumber c = a.pow(b);

		assertEquals("9.903520314283042E27", c.toString());
	}

	/**
	 * 2000^93
	 */
	public void testPow_12() {
		CLNumber a = new CLNumber("2000");
		CLNumber b = new CLNumber("93");
		AbstractNumber c = a.pow(b);

		assertEquals(
				"9.903520314283042E306",
				c.toString());
	}

	/**
	 * 2000^93.5
	 */
	public void testPow_13() {
		CLNumber a = new CLNumber("2000");
		CLNumber b = new CLNumber("93.5");
		AbstractNumber c = a.pow(b);

		assertEquals(c.toString(), "Infinity");
	}

	/**
	 * 2000^(-93.5)
	 */
	public void testPow_14() {
		AbstractNumber.scaleToDisplay = 8;
		CLNumber a = new CLNumber("2000");
		CLNumber b = new CLNumber("-93.5");
		AbstractNumber c = a.pow(b);

		assertEquals("2.25785165934874E-309", c.toScientificNotation());
		AbstractNumber.scaleToDisplay = 1000;
	}

	/**
	 * 2000.5^(-93.5)
	 */
	public void testPow_15() {
		AbstractNumber.scaleToDisplay = 8;
		CLNumber a = new CLNumber("2000.5");
		CLNumber b = new CLNumber("-93.5");
		AbstractNumber c = a.pow(b);

		assertEquals("2.205692876763176E-309", c.toScientificNotation());
		AbstractNumber.scaleToDisplay = 1000;
	}

	/**
	 * -0.0000000000000000000000000000000000000000000000000000000000000000000235378224278505652343786^41
	 */
	public void testPow_18() {
		AbstractNumber.scaleToDisplay = 8;
		CLNumber a = new CLNumber("-0.00000000000000000000000000000000000000000000000000000000"
				+ "00000000000235378224278505652343786");
		CLNumber b = new CLNumber("41");
		AbstractNumber c = a.pow(b);

		assertEquals("-0", c.toScientificNotation());
		AbstractNumber.scaleToDisplay = 1000;
	}

	/**
	 * 5!
	 */
	public void testFactorial() {
		CLNumber a = new CLNumber("5");
		try {
			CLNumber c = a.factorial();
			assertEquals("120", c.toString());
		} catch (InvalidActionException e) {
			assertTrue(false);
		}
	}

	/**
	 * 26!
	 */
	public void testFactorial_2() {
		CLNumber a = new CLNumber("26");
		try {
			CLNumber c = a.factorial();
			assertEquals("4.0329146112660565E26", c.toString());
		} catch (InvalidActionException e) {
			assertTrue(false);
		}
	}


	/**
	 * 5 % 3 = 2
	 */
	public void testDivideAndRemainder() {
		CLNumber num_1 = new CLNumber("5");
		CLNumber num_2 = new CLNumber("3");
		AbstractNumber[] res = num_1.divideAndRemainder(num_2);
		CLNumber expResult = new CLNumber("2");
		assertEquals(expResult, res[1]);
	}

	/**
	 * 6.8 % 4 = 2.8
	 */
	public void testDivideAndRemainder_2() {
		CLNumber num_1 = new CLNumber("6.8");
		CLNumber num_2 = new CLNumber("4");
		AbstractNumber[] res = num_1.divideAndRemainder(num_2);
		CLNumber expResult = new CLNumber("2.8");
		assertEquals(expResult, res[1]);
	}

	/**
	 * -8.5 % 4 = -(0.5)
	 */
	public void testDivideAndRemainder_3() {
		CLNumber num_1 = new CLNumber("-8.5");
		CLNumber num_2 = new CLNumber("4");
		AbstractNumber[] res = num_1.divideAndRemainder(num_2);
		CLNumber expResult = new CLNumber("-0.5");
		assertEquals(expResult, res[1]);
	}

}
