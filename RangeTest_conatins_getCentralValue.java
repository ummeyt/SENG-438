/**
 * 
 */
package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author ummey
 *
 */
public class RangeTest {
	private Range exampleRange;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-100.0, 100.0);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	//contains TESTS START FROM HERE
	@Test
	public void rangeContainsPositiveDouble() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain 40.0", true, exampleRange.contains(40.0));
//		System.out.printf("1st test: %b%n", exampleRange.contains(40.0));
	}

	@Test
	public void rangeContainsNegativeDouble() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain -40.0", true, exampleRange.contains(-40.0));
//		System.out.printf("2nd test: %b%n", exampleRange.contains(-40.0));
	}	

	@Test
	public void rangeContainsZero() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain 0.0", true, exampleRange.contains(0.0));
//		System.out.printf("3rd test: %b%n", exampleRange.contains(0.0));
	}	

	@Test
	public void rangeContainsPositiveDecimalValue() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain 1.9", true, exampleRange.contains(1.9));
//		System.out.printf("4th test: %b%n", exampleRange.contains(1.9));
	}
	
	@Test
	public void rangeContainsNegativeDecimalValue() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain 2.8", true, exampleRange.contains(2.8));
//		System.out.printf("5th test: %b%n", exampleRange.contains(2.8));
	}
	
	@Test
	public void rangeContainsFloatValue() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain 2.28354795785", true, exampleRange.contains(2.28354795785));
//		System.out.printf("6th test: %b%n", exampleRange.contains(2.28354795785));
	}
	
	@Test
	public void rangeContainsCharValue() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain the ASCII value of 'a'", true, exampleRange.contains('a'));
//		System.out.printf("7th test: %b%n", exampleRange.contains('a'));
	}
	
	@Test
	public void rangeDoesNotContainsCharValue() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should not contain the ASCII value of 'f'", false, exampleRange.contains('f'));
//		System.out.printf("8th test: %b%n", exampleRange.contains('f'));
	}
	
	@Test
	public void rangeContainsNegativeCharValue() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain the ASCII value of -'a'", true, exampleRange.contains(-'a'));
//		System.out.printf("9th test: %b%n", exampleRange.contains(-'a'));
	}
	
	@Test
	public void rangeDoesNotContainsNegativeCharValue() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should not contain the ASCII value of -'f'", false, exampleRange.contains(-'f'));
//		System.out.printf("10th test: %b%n", exampleRange.contains(-'f'));
	}
	
	@Test
	public void rangeContainsASCIIValueOfSpace() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain the ASCII value of ' '", true, exampleRange.contains(' '));
//		System.out.printf("11th test: %b%n", exampleRange.contains(' '));
	}
	
	@Test
	public void rangeDoesNotContainsNull() {	
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should not contain null", false, exampleRange.contains(Double.NaN));
//		System.out.printf("12th test: %b%n", exampleRange.contains(Double.NaN));
	}
	
	@Test
	public void rangeDoesNotContainsValueOutOfRange() {	
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should not contain 110.0", false, exampleRange.contains(110.0));
//		System.out.printf("13th test: %b%n", exampleRange.contains(110.0));
	}
	
	@Test
	public void rangeDoesContainDoubleMinValue() {	
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should not contain double min value", true, exampleRange.contains(Double.MIN_VALUE));
//		System.out.printf("14th test: %b%n", exampleRange.contains(Double.MIN_VALUE));
	}
	
	@Test
	public void rangeDoesContainDoubleMaxValue() {	
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should not contain double min value", false, exampleRange.contains(Double.MAX_VALUE));
//		System.out.printf("15th test: %b%n", exampleRange.contains(Double.MAX_VALUE));
	}
	
	@Test
	public void rangeDoesContainHexValue() {	
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain hex value of 0x00", true, exampleRange.contains(0x00));
//		System.out.printf("16th test: %b%n", exampleRange.contains(0x00));
	}
	
	@Test
	public void rangeDoesNotContainDecimalValue() {	
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should not contain 100.1", false, exampleRange.contains(100.1));
//		System.out.printf("17th test: %b%n", exampleRange.contains(100.1));
	}
	
	@Test
	public void rangeContainLongDoubleValue() {	
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain 0000000000001.1", true, exampleRange.contains(0000000000001.1));
//		System.out.printf("18th test: %b%n", exampleRange.contains(0000000000001.1));
	}
	
	@Test
	public void rangeContainBinaryValue() {	
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain binary value 0b111000", true, exampleRange.contains(0b111000));
//		System.out.printf("19th test: %b%n", exampleRange.contains(0b111000));
	}
	
	
	
	//getCentralValue TESTS START FROM HERE
	@Test
	public void centralValueShouldBeZero() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of -100.0 and 100.0 should be 0.0", 0.0, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("1st test central value: ");
//		System.out.println(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	public void centralValueShouldBeNegativeDecimal() {
		exampleRange = new Range(-100.5, 100.3);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of -100.5 and 100.3 should be -1.0", -0.1, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("2nd test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	public void centralValueShouldBePositiveDecimal() {
		exampleRange = new Range(-100.0, 110.9);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of -100.0 and 110.9 should be 5.45", 5.45, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("3rd test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	public void centralValueShouldBeFloat() {
		exampleRange = new Range(-100.200038256, 100.377364642);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of -100.200038256 and 100.377364642 should be 0.088663193", 0.088663193, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("4th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	public void centralValueShouldBeFloatWithUnmatchedNumOfDecimal() {
		exampleRange = new Range(-100.200038256, 100.377364);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of -100.200038256 and 100.377364 should be 0.088662872", 0.088662872, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("5th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	
	@Test
	public void centralValueShouldBePositiveHexValue() {
		exampleRange = new Range(-0x2, 0x62);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of -0x2 and 0x62 should be 0x30", 0x30, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("6th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	public void centralValueShouldBeNegativeHexValue() {
		exampleRange = new Range(-0x62, 0x2);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of -0x62 and 0x2 should be -0x30", -0x30, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("7th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	public void centralValueShouldBePositiveBonaryValue() {
		exampleRange = new Range(-0b10, 0b1100010);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of -0b10 and 0b1100010 should be 0b110000", 0b110000, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("8th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	public void centralValueShouldBeNegativeBinaryValue() {
		exampleRange = new Range(-0b1100010, 0b10);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of -0b1100010 and 0b10 should be -0b110000", -0b110000, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("9th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	public void centralValueShouldBeBetweenMaxAndMin() {
		exampleRange = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of Double.MIN_VALUE and Double.MAX_VALUE should be (Double.MIN_VALUE+Double.MAX_VALUE)/2", (Double.MIN_VALUE+Double.MAX_VALUE)/2, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("10th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	public void centralValueShouldBeAVerySmallNumber() {
		exampleRange = new Range(0.00000000001, 0.00000000002);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of 0.00000000001 and 0.00000000002 should be 1.5e-11", 1.5e-11, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("11th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	public void centralValueOfTheSameRange() {
		exampleRange = new Range(2,2);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of 2 and 2 should be 2", 2, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("12th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	
	@Test
	public void centralValueOfReverseRange() {
		try {
			exampleRange = new Range(40,-39);
			assertEquals("The central value of 40 and -39 should be 0.5", 0.5, exampleRange.getCentralValue(), .000000001d);
			fail("Did not catch invaid parameter exception");	
		} 
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}
//		System.out.print("13th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	
	@Test
	public void centralValueOfTwoLongRangeWithLeadingZeros() {
		exampleRange = new Range(-00000000016273673, 00000000026273673);
		try {
			assertEquals("The central value of -00000000016273673625 and 00000000026273673625 should be 5000000", 5000000, exampleRange.getCentralValue(), .000000001d);	
		} catch(Exception e) {
			fail(e.toString());
		}
//		System.out.print("14th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
}
