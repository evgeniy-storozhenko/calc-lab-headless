package com.calclab.operands.common;

import java.math.BigDecimal;

import com.calclab.core.operands.AbstractNumber;
import com.calclab.core.operands.exceptions.InvalidActionException;
import com.calclab.operands.common.internal.BigNumber;

import junit.framework.TestCase;

public class BigNumberTest extends TestCase {

	public BigNumberTest(String testName) {
		super(testName);
		AbstractNumber.scaleToDisplay = 1000;
	}

	/**
	 * Test of getNumerator method, of class BigNumber.
	 */
	public void testGetNumerator_1() {
		String str = "823764876239840.12894712987301";
		BigNumber num = new BigNumber(str);
		BigDecimal expResult = new BigDecimal("82376487623984012894712987301");
		BigDecimal result = num.getNumerator();
		assertEquals(expResult, result);

	}

	public void testGetNumerator_2() {
		String str = "82376487623984012894712987301234234224124";
		BigNumber num = new BigNumber(str);
		BigDecimal expResult = new BigDecimal(
				"82376487623984012894712987301234234224124");
		BigDecimal result = num.getNumerator();
		assertEquals(expResult, result);

	}

	public void testGetNumerator_3() {
		String str = "0.823764876239840128947129873012342342241241232132131232";
		BigNumber num = new BigNumber(str);
		BigDecimal expResult = new BigDecimal(
				"823764876239840128947129873012342342241241232132131232");
		BigDecimal result = num.getNumerator();
		assertEquals(expResult, result);

	}

	public void testGetNumerator_4() {
		String str = "-10823769.99999999999999999999";
		BigNumber num = new BigNumber(str);
		BigDecimal expResult = new BigDecimal("-1082376999999999999999999999");
		BigDecimal result = num.getNumerator();
		assertEquals(expResult, result);

	}

	/**
	 * Test of toString method, of class BigNumber.
	 */
	public void testToString_1() {
		String str = "124098102840798174012";
		BigNumber num = new BigNumber(str);
		String expResult = str;
		String result = num.toString();
		assertEquals(expResult, result);
	}

	public void testToString_2() {
		String str = "823764876239840.12894712987301";
		BigNumber num = new BigNumber(str);
		String expResult = str;
		String result = num.toString();
		assertEquals(expResult, result);
	}

	public void testToString_3() {
		String str = "0.12894712987301";
		BigNumber num = new BigNumber(str);
		String expResult = str;
		String result = num.toString();
		assertEquals(expResult, result);
	}

	public void testToString_4() {
		String str = "12894712987301.0000000";
		BigNumber num = new BigNumber(str);
		String expResult = "12894712987301";
		String result = num.toString();
		assertEquals(expResult, result);
	}

	public void testToString_5() {
		String str = "-12894712987301453525555555555556";
		BigNumber num = new BigNumber(str);
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
		BigNumber num = new BigNumber(str);
		String expResult = str;
		String result = num.toString();
		assertEquals(expResult, result);
	}

	public void testAdd_1() {
		BigNumber num_1 = new BigNumber("-111.111");
		BigNumber num_2 = new BigNumber("111.111");
		num_1 = num_1.add(num_2);
		BigNumber expResult = new BigNumber("0");
		assertEquals(expResult, num_1);
	}

	public void testAdd_2() {
		BigNumber num_1 = new BigNumber("111.111");
		BigNumber num_2 = new BigNumber("111.111");
		num_1 = num_1.add(num_2);
		BigNumber expResult = new BigNumber("222.222");
		assertEquals(expResult, num_1);
	}

	public void testAdd_3() {
		BigNumber num_1 = new BigNumber("111.111");
		BigNumber num_2 = new BigNumber("-94554.445");
		num_1 = num_1.add(num_2);
		BigNumber expResult = new BigNumber("-94443.334");
		assertEquals(expResult, num_1);
	}

	public void testAdd_4() {
		BigNumber num_1 = new BigNumber("100000000");
		BigNumber num_2 = new BigNumber("54577788");
		num_1 = num_1.add(num_2);
		BigNumber expResult = new BigNumber("154577788");
		assertEquals(expResult, num_1);
	}

	public void testSubtract_1() {
		BigNumber num_1 = new BigNumber("10000000");
		BigNumber num_2 = new BigNumber("-10000000");
		num_1 = num_1.subtract(num_2);
		BigNumber expResult = new BigNumber("20000000");
		assertEquals(expResult, num_1);
	}

	public void testSubtract_2() {
		BigNumber num_1 = new BigNumber("-10000000");
		BigNumber num_2 = new BigNumber("-10000000");
		num_1 = num_1.subtract(num_2);
		BigNumber expResult = new BigNumber("0");
		assertEquals(expResult, num_1);
	}

	public void testSubtract_3() {
		BigNumber num_1 = new BigNumber("-10000000.111");
		BigNumber num_2 = new BigNumber("10000000");
		num_1 = num_1.subtract(num_2);
		BigNumber expResult = new BigNumber("-20000000.111");
		assertEquals(expResult, num_1);
	}

	public void testSubtract_4() {
		BigNumber num_1 = new BigNumber("999.999");
		BigNumber num_2 = new BigNumber("999.888");
		num_1 = num_1.subtract(num_2);
		BigNumber expResult = new BigNumber("0.111");
		assertEquals(expResult, num_1);
	}

	public void testMultiply_1() {
		BigNumber num_1 = new BigNumber("0");
		BigNumber num_2 = new BigNumber("999.888");
		num_1 = num_1.multiply(num_2);
		BigNumber expResult = new BigNumber("0");
		assertEquals(expResult, num_1);
	}

	public void testMultiply_2() {
		BigNumber num_1 = new BigNumber("-10");
		BigNumber num_2 = new BigNumber("999.888");
		num_1 = num_1.multiply(num_2);
		BigNumber expResult = new BigNumber("-9998.88");
		assertEquals(expResult, num_1);
	}

	public void testMultiply_3() {
		BigNumber num_1 = new BigNumber("-1000");
		BigNumber num_2 = new BigNumber("-999.888");
		num_1 = num_1.multiply(num_2);
		BigNumber expResult = new BigNumber("999888");
		assertEquals(expResult, num_1);
	}

	public void testMultiply_4() {
		BigNumber num_1 = new BigNumber("8982452");
		BigNumber num_2 = new BigNumber("45.120214534");
		num_1 = num_1.multiply(num_2);
		BigNumber expResult = new BigNumber("405290161.281357368");
		assertEquals(expResult, num_1);
	}

	public void testDivide_1() {
		BigNumber num_1 = new BigNumber("0");
		BigNumber num_2 = new BigNumber("45.120214534");
		num_1 = (BigNumber) num_1.divide(num_2);
		BigNumber expResult = new BigNumber("0");
		assertEquals(expResult, num_1);
	}

	public void testDivide_2() {
		BigNumber num_1 = new BigNumber("100.456");
		BigNumber num_2 = new BigNumber("45.120214534");
		num_1 = (BigNumber) num_1.divide(num_2);
		assertTrue(num_1.toString()
				.contains("2.2264078537193597112341247805468601542531841189582"
						+ "9395836356"));
	}

	public void testDivide_3() {
		BigNumber num_1 = new BigNumber("10");
		BigNumber num_2 = new BigNumber("-45.12021");
		num_1 = (BigNumber) num_1.divide(num_2);
		BigNumber expResult = new BigNumber("-0.2216301741503419421141878550653"
				+ "90874732187638311080555697768");
		assertEquals(expResult, num_1);
	}

	public void testDivide_4() {
		BigNumber num_1 = new BigNumber("-100");
		BigNumber num_2 = new BigNumber("-100");
		num_1 = (BigNumber) num_1.divide(num_2);
		BigNumber expResult = new BigNumber("1");
		assertEquals(expResult, num_1);
	}

	public void testDivide_5() {
		BigNumber num_1 = new BigNumber("-100");
		BigNumber num_2 = new BigNumber("1");
		num_1 = (BigNumber) num_1.divide(num_2);
		BigNumber expResult = new BigNumber("-100");
		assertEquals(expResult, num_1);
	}

	public void testDivide_6() {
		BigNumber num_1 = new BigNumber("4");
		BigNumber num_2 = new BigNumber("3");
		BigNumber num_3 = (BigNumber) num_1.divide(num_2);
		assertEquals("1.333333333333333333333333333333333333333333333333333333333334",
				num_3.toString());
	}

	public void testDivide_7() {
		BigNumber num_1 = new BigNumber("4");
		BigNumber num_2 = new BigNumber("3");
		BigNumber num_3 = new BigNumber("6");
		BigNumber num_4 = (BigNumber) num_1.divide(num_2).multiply(num_3);
		assertEquals("8", num_4.toString());
	}

	public void testEquals_1() {
		BigNumber num_1 = new BigNumber("-100");
		BigNumber num_2 = new BigNumber("-100");
		assertEquals(true, num_1.equals(num_2));
	}

	public void testEquals_2() {
		BigNumber num_1 = new BigNumber("-100");
		BigNumber num_2 = new BigNumber("0");
		assertEquals(false, num_1.equals(num_2));
	}

	public void test_3() {
		BigNumber a1 = new BigNumber("4");
		BigNumber a2 = new BigNumber("2");
		BigNumber a3 = (BigNumber) a1.divide(a2);

		BigNumber b1 = new BigNumber("10");
		BigNumber b2 = new BigNumber("5");
		BigNumber b3 = (BigNumber) b1.divide(b2);

		assertTrue(a3.equals(b3));
	}

	public void testObjectLinks() {
		BigNumber a = new BigNumber("1");
		BigNumber b = new BigNumber("2");
		BigNumber c = new BigNumber("2");

		BigNumber d = (BigNumber) a.divide(b).add(c);

		assertEquals(a.toString(), "1");
		assertEquals(b.toString(), "2");
		assertEquals(c.toString(), "2");
		assertEquals(d.toString(), "2.5");
	}

	public void testIsFractionalNumber() {
		assertTrue(new BigNumber("1.5").isFractionalNumber());
		assertTrue(new BigNumber("-1.5").isFractionalNumber());
		assertTrue(new BigNumber("0.3333333").isFractionalNumber());
		assertTrue(new BigNumber("-0.3333333").isFractionalNumber());
		assertFalse(new BigNumber("3333333").isFractionalNumber());
		assertFalse(new BigNumber("-3333333").isFractionalNumber());
	}

	/**
	 * 2^3
	 */
	public void testPow_1() {
		BigNumber a = new BigNumber("2");
		BigNumber b = new BigNumber("3");
		AbstractNumber c = a.pow(b);

		assertEquals("8", c.toString());
	}

	/**
	 * 1^15
	 */
	public void testPow_2() {
		BigNumber a = new BigNumber("1");
		BigNumber b = new BigNumber("15");
		AbstractNumber c = a.pow(b);

		assertEquals(c.toString(), "1");
	}

	/**
	 * (-2)^2
	 */
	public void testPow_3() {
		BigNumber a = new BigNumber("-2");
		BigNumber b = new BigNumber("2");
		AbstractNumber c = a.pow(b);

		assertEquals(c.toString(), "4");
	}

	/**
	 * (-1)^16
	 */
	public void testPow_4() {
		BigNumber a = new BigNumber("-1");
		BigNumber b = new BigNumber("16");
		AbstractNumber c = a.pow(b);

		assertEquals(c.toString(), "1");
	}

	/**
	 * (-2)^3
	 */
	public void testPow_5() {
		BigNumber a = new BigNumber("-2");
		BigNumber b = new BigNumber("3");
		AbstractNumber c = a.pow(b);

		assertEquals(c.toString(), "(-8)");
	}

	/**
	 * (-3)^2
	 */
	public void testPow_6() {
		BigNumber a = new BigNumber("-3");
		BigNumber b = new BigNumber("2");
		AbstractNumber c = a.pow(b);

		assertEquals(c.toString(), "9");
	}

	/**
	 * (-3)^3
	 */
	public void testPow_7() {
		BigNumber a = new BigNumber("-3");
		BigNumber b = new BigNumber("3");
		AbstractNumber c = a.pow(b);

		assertEquals(c.toString(), "(-27)");
	}

	/**
	 * 4^(-2)
	 */
	public void testPow_8() {
		BigNumber a = new BigNumber("4");
		BigNumber b = new BigNumber("-2");
		AbstractNumber c = a.pow(b);

		assertEquals(c.toString(), "0.0625");
	}

	/**
	 * 2^(-3)
	 */
	public void testPow_9() {
		BigNumber a = new BigNumber("2");
		BigNumber b = new BigNumber("-3");
		AbstractNumber c = a.pow(b);

		assertEquals("0.125", c.toString());
	}

	/**
	 * 2000^10
	 */
	public void testPow_10() {
		BigNumber a = new BigNumber("2000");
		BigNumber b = new BigNumber("10");
		AbstractNumber c = a.pow(b);

		assertEquals("1024000000000000000000000000000000", c.toString());
	}

	/**
	 * 2^93
	 */
	public void testPow_11() {
		BigNumber a = new BigNumber("2");
		BigNumber b = new BigNumber("93");
		AbstractNumber c = a.pow(b);

		assertEquals("9903520314283042199192993792", c.toString());
	}

	/**
	 * 2000^93
	 */
	public void testPow_12() {
		BigNumber a = new BigNumber("2000");
		BigNumber b = new BigNumber("93");
		AbstractNumber c = a.pow(b);

		assertEquals(
				"9903520314283042199192993792000000000000000000000000000000"
						+ "000000000000000000000000000000000000000000000000"
						+ "000000000000000000000000000000000000000000000000"
						+ "000000000000000000000000000000000000000000000000"
						+ "000000000000000000000000000000000000000000000000"
						+ "000000000000000000000000000000000000000000000000"
						+ "000000000",
				c.toString());
	}

	/**
	 * 2000^93.5
	 */
	public void testPow_13() {
		BigNumber a = new BigNumber("2000");
		BigNumber b = new BigNumber("93.5");
		AbstractNumber c = a.pow(b);
		int ordersOfMagnitude = c.toString().split(AbstractNumber.dsecimalMarkRegEx)[0].length();

		assertTrue(c.toString().contains("442898"));
		assertTrue(ordersOfMagnitude == 309);
	}

	/**
	 * 2000^(-93.5)
	 */
	public void testPow_14() {
		AbstractNumber.scaleToDisplay = 8;
		BigNumber a = new BigNumber("2000");
		BigNumber b = new BigNumber("-93.5");
		AbstractNumber c = a.pow(b);

		assertEquals("22578516e-316", c.toScientificNotation());
		AbstractNumber.scaleToDisplay = 1000;
	}

	/**
	 * 2000.5^(-93.5)
	 */
	public void testPow_15() {
		AbstractNumber.scaleToDisplay = 8;
		BigNumber a = new BigNumber("2000.5");
		BigNumber b = new BigNumber("-93.5");
		AbstractNumber c = a.pow(b);

		assertEquals("22056928e-316", c.toScientificNotation());
		AbstractNumber.scaleToDisplay = 1000;
	}

	/**
	 * -2000.5^(-93.5)
	 */
	public void testPow_16() {
		AbstractNumber.scaleToDisplay = 8;
		BigNumber a = new BigNumber("-2000.5");
		BigNumber b = new BigNumber("-93.5");
		AbstractNumber c = a.pow(b);

		assertEquals("(-22056928e-316)", c.toScientificNotation());
		AbstractNumber.scaleToDisplay = 1000;
	}

	/**
	 * 0.0000000000000000000000000000000000000000000000000000000000000000000235378224278505652343786^41
	 */
	public void testPow_17() {
		AbstractNumber.scaleToDisplay = 8;
		BigNumber a = new BigNumber("0.00000000000000000000000000000000000000000000000000000000"
				+ "00000000000235378224278505652343786");
		BigNumber b = new BigNumber("41");
		AbstractNumber c = a.pow(b);

		assertEquals("17475015e-2780", c.toScientificNotation());
		AbstractNumber.scaleToDisplay = 1000;
	}

	/**
	 * -0.0000000000000000000000000000000000000000000000000000000000000000000235378224278505652343786^41
	 */
	public void testPow_18() {
		AbstractNumber.scaleToDisplay = 8;
		BigNumber a = new BigNumber("-0.00000000000000000000000000000000000000000000000000000000"
				+ "00000000000235378224278505652343786");
		BigNumber b = new BigNumber("41");
		AbstractNumber c = a.pow(b);

		assertEquals("(-17475015e-2780)", c.toScientificNotation());
		AbstractNumber.scaleToDisplay = 1000;
	}

	/**
	 * -0.0000000000000000000000000000000000000000000000000000000000000000000235378224278505652343786^(-41)
	 */
	public void testPow_19() {
		AbstractNumber.scaleToDisplay = 8;
		BigNumber a = new BigNumber("-0.00000000000000000000000000000000000000000000000000000000"
				+ "00000000000235378224278505652343786");
		BigNumber b = new BigNumber("-41");
		AbstractNumber c = a.pow(b);

		assertEquals("(-57224555e+2765)", c.toScientificNotation());
		AbstractNumber.scaleToDisplay = 1000;
	}

	/**
	 * 5!
	 */
	public void testFactorial() {
		BigNumber a = new BigNumber("5");
		try {
			BigNumber c = a.factorial();
			assertEquals("120", c.toString());
		} catch (InvalidActionException e) {
			assertTrue(false);
		}
	}

	/**
	 * 26!
	 */
	public void testFactorial_2() {
		BigNumber a = new BigNumber("26");
		try {
			BigNumber c = a.factorial();
			assertEquals("403291461126605635584000000", c.toString());
		} catch (InvalidActionException e) {
			assertTrue(false);
		}
	}

	/**
	 * 199!
	 */
	public void testFactorial_3() {
		BigNumber a = new BigNumber("199");
		try {
			BigNumber c = a.factorial();
			assertEquals("394328933682395251776181606966092531147567988843586631647371266622179"
					+ "724981701671460152142005992311952088606069459819415128821395121318552530"
					+ "963312476414965556731428635381658618698494471961222810725832120127016645"
					+ "932065613714147426638762121203786951620160628702789784330113015952085162"
					+ "031175850429398089461111394811851948687360000000000000000000000000000000"
					+ "0000000000000000", c.toString());
		} catch (InvalidActionException e) {
			assertTrue(false);
		}
	}

	/**
	 * 5 % 3 = 2
	 */
	public void testDivideAndRemainder() {
		BigNumber num_1 = new BigNumber("5");
		BigNumber num_2 = new BigNumber("3");
		AbstractNumber[] res = num_1.divideAndRemainder(num_2);
		BigNumber expResult = new BigNumber("2");
		assertEquals(expResult, res[1]);
	}

	/**
	 * 6.9 % 4 = 2.9
	 */
	public void testDivideAndRemainder_2() {
		BigNumber num_1 = new BigNumber("6.9");
		BigNumber num_2 = new BigNumber("4");
		AbstractNumber[] res = num_1.divideAndRemainder(num_2);
		BigNumber expResult = new BigNumber("2.9");
		assertEquals(expResult, res[1]);
	}

	/**
	 * -8.1 % 4 = -(0.1)
	 */
	public void testDivideAndRemainder_3() {
		BigNumber num_1 = new BigNumber("-8.1");
		BigNumber num_2 = new BigNumber("4");
		AbstractNumber[] res = num_1.divideAndRemainder(num_2);
		BigNumber expResult = new BigNumber("-0.1");
		assertEquals(expResult, res[1]);
	}

	public void testToScientificNotation() {
		AbstractNumber.scaleToDisplay = 8;

		BigNumber a = new BigNumber("41124124124219594634735214235346241241265434525");
		BigNumber b = new BigNumber("41124124124219594634735214235346241241.65434525");
		BigNumber c = new BigNumber("41124124124.21959463473521423534624121265434525");
		BigNumber d = new BigNumber("4.112412412421959463473521423534624141265434525");
		BigNumber e = new BigNumber("0.000000000000000094634735214235346412412654345");
		BigNumber f = new BigNumber("0.000946347352142353464124126543423534641241265");
		BigNumber g = new BigNumber("0.000946");

		assertEquals("41124124e+39", a.toString());
		assertEquals("41124124e+30", b.toString());
		assertEquals("41124124e+3", c.toString());
		assertEquals("4.112412", d.toString());
		assertEquals("94634735e-24", e.toString());
		assertEquals("94634735e-11", f.toString());
		assertEquals("0.000946", g.toString());

		BigNumber na = new BigNumber("-41124124124219594634735214235346241241265434525");
		BigNumber nb = new BigNumber("-41124124124219594634735214235346241241.65434525");
		BigNumber nc = new BigNumber("-41124124124.21959463473521423534624121265434525");
		BigNumber nd = new BigNumber("-4.112412412421959463473521423534624141265434525");
		BigNumber ne = new BigNumber("-0.000000000000000094634735214235346412412654345");
		BigNumber nf = new BigNumber("-0.000946347352142353464124126543423534641241265");
		BigNumber ng = new BigNumber("-0.000946");

		assertEquals("(-41124124e+39)", na.toString());
		assertEquals("(-41124124e+30)", nb.toString());
		assertEquals("(-41124124e+3)", nc.toString());
		assertEquals("(-4.112412)", nd.toString());
		assertEquals("(-94634735e-24)", ne.toString());
		assertEquals("(-94634735e-11)", nf.toString());
		assertEquals("(-0.000946)", ng.toString());

		AbstractNumber.scaleToDisplay = 1000;
	}

}
