package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.*;
import org.junit.*;

public class RangeTest{
	
	private Range exampleRange;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

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

	@Test
	public void BrianTestPositiveOrdered() {
		Range range = new Range(0.0, 1.0);
		
		double result = range.getLength();
		assertEquals(1.0, result, 0.000001d);
	}

	@Test
	public void BrianTestNegativeOrdered() {
		Range range = new Range(-1.0, 0.0);
		
		double result = range.getLength();
		assertEquals(1.0, result, 0.000001d);
	}

	@Test (expected = IllegalArgumentException.class)
	public void BrianTestPositiveUnordered() {
		Range range = new Range(1.0, 0.0);
		
		double result = range.getLength();
		assertEquals(1.0, result, 0.000001d);
	}

	@Test (expected = IllegalArgumentException.class)
	public void BrianTestNegativeUnordered() {
		Range range = new Range(0.0, -1.0);
		
		double result = range.getLength();
		assertEquals(1.0, result, 0.000001d);
	}

	@Test
	public void BrianTestMixedOrdered() {
		Range range = new Range(-1.0, 1.0);
		
		double result = range.getLength();
		assertEquals(2.0, result, 0.000001d);
	}

	@Test(expected = IllegalArgumentException.class)
	public void BrianTestMixedUnordered() {
		Range range = new Range(1.0, -1.0);
		double result = range.getLength();

		assertEquals(2.0, result, 0.000001d);
	}
	
	@Test
	public void BrianTestEqualValuedRange() {
		Range range = new Range(0.0, 0.0);
		
		double result = range.getLength();
		assertEquals(0.0, result, 0.000001d);
	}
	
	@Test
	public void BrianTestMaxDoublePositive() {
		Range range = new Range(0.0, Double.MAX_VALUE);
		
		double result = range.getLength();
		assertEquals(Double.MAX_VALUE, result, 0.000001d);
	}
	
	@Test
	public void BrianTestMaxDoubleNegative() {
		Range range = new Range(-Double.MAX_VALUE, 0.0);
		
		double result = range.getLength();
		assertEquals(Double.MAX_VALUE, result, 0.000001d);
	}
	
	@Test
	public void BrianTestMaxDoubleSpanning() {
		Range range = new Range(-(Double.MAX_VALUE/2), (Double.MAX_VALUE/2));
		
		double result = range.getLength();
		assertEquals(Double.MAX_VALUE, result, 0.000001d);
	}
	
	@SuppressWarnings("null")
	@Test (expected = NullPointerException.class)
	public void BrianTestNullRange() {
		Range range = new Range((Double) null, 0.0);
		
		double result = range.getLength();
		assertEquals((Double) null, result, 0.000001d);
		
	}
	
	@Test
	public void BrianTestCharacterRangeCasted() {
		Range range = new Range((double)'a', (double)'b');
	
		double result = range.getLength();
		assertEquals(1.0, result, 0.000001d);
	}

	@Test
	public void BrianTestCharacterRangeUncasted() {
		Range range = new Range('a', 'b');
	
		double result = range.getLength();
		assertEquals(1.0, result, 0.000001d);
	}
	
	@Test
	public void BrianTestHexRange() {
		Range range = new Range(0x00, 0xFF);
		
		double result = range.getLength();
		assertEquals(0xFF, result, 0.00001d);
	}
	
	@Test
	public void BrianTestSmallRange() {
		double small = Double.MIN_NORMAL;
		Range range = new Range(0.0, small);
		
		double result = range.getLength();
		assertEquals(small, result, 0.00000000001d);
		
	}
	
	@Test
	public void BrianTestPositiveValuedRange() {
		Range range = new Range(1.0, 5.0);
		
		double result = range.getLength();
		assertEquals(4.0, result, 0.000001d);
	}
	
	@Test
	public void BrianTestNegativeValuedRange() {
		Range range = new Range(-5.0, -1.0);
		
		double result = range.getLength();
		assertEquals(4.0, result, 0.000001d);
	}
	
	@Test
	public void BrianPositiveShift() {
		Range range = new Range(1.0, 3.0);
		double delta = 1.0;
		Range expect = new Range(2.0, 4.0);
		Range result = Range.shift(range, delta);
		assertEquals(expect, result);
	
	}
	
	@Test
	public void BrianNegativeShift() {
		Range range = new Range(1.0, 3.0);
		double delta = -1.0;
		Range expect = new Range(0.0, 2.0);
		Range result = Range.shift(range, delta);
		assertEquals(expect, result);
	
	}
	
	@Test
	public void BrianShiftHalfAcrossZeroPositiveDelta() {
		Range range = new Range(-1.0, 1.0);
		double delta = 2.0;
		Range result = Range.shift(range, delta);
		Exception expect = new Exception();
		assertEquals(expect, result);
	
	}
	
	@Test
	public void BrianShiftCompletelyAcrossZeroPositiveDelta() {
		Range range = new Range(-2.0, -1.0);
		double delta = 3.0;
		Range result = Range.shift(range, delta);
		Exception expect = new Exception();
		assertEquals(expect, result);

	}
	
	@Test
	public void BrianShiftBelowZeroPositiveDelta() {
		Range range = new Range(-3.0, -2.0);
		double delta = 1.0;
		Range expect = new Range(-2.0, -1.0);
		Range result = Range.shift(range, delta);
		assertEquals(expect, result);
	
	}

	@Test 
	public void BrianShiftHalfAcrossZeroNegativeDelta() {
		Range range = new Range(0.5, 2.0);
		double delta = -1.0;
		Range result = Range.shift(range, delta);
		Exception expect = new Exception();
		assertEquals(expect, result);
	
	}

	@Test 
	public void BrianShiftCompletelyAcrossZeroNegativeDelta() {
		Range range = new Range(1.0, 2.0);
		double delta = -5.0;
		Range result = Range.shift(range, delta);
		Exception expect = new Exception();
		assertEquals(expect, result);
	
	}
	
	@Test
	public void BrianShiftBelowZeroNegativeDelta() {
		Range range = new Range(-2.0, -1.0);
		double delta = -1.0;
		Range expect = new Range(-3.0, -2.0);
		Range result = Range.shift(range, delta);
		assertEquals(expect, result);
	
	}
	
	@Test
	public void BrianShiftByDoubleMAXPositive() {
		Range range = new Range(0.0, 1.0);
		double delta = Double.MAX_VALUE;
		Range expect = new Range(Double.MAX_VALUE, Double.MAX_VALUE);
		Range result = Range.shift(range, delta);
		assertEquals(expect, result);
	
	}
	
	@Test
	public void BrianShiftRangeWithOneNaN() {
		Range range = new Range(Double.NaN, 2.0);
		double delta = 1.0;
		Range expect = new Range(Double.NaN, 3.0);
		Range result = Range.shift(range, delta);
		assertEquals(expect, result);
	
	}
	
	@Test
	public void BrianShiftRangeWithTwoNaNs() {
		Range range = new Range(Double.NaN, Double.NaN);
		double delta = 1.0;
		Range expect = new Range(Double.NaN, Double.NaN);
		Range result = Range.shift(range, delta);
		assertEquals(expect, result);
	
	}
	
	@Test
	public void BrianShiftRangeWithNullDelta() {
		Range range = new Range(1.0, 2.0);
		double delta = Double.NaN;
		Range expect = new Range(Double.NaN, Double.NaN);
		Range result = Range.shift(range, delta);
		assertEquals(expect, result);
	
	}
	
	@Test
	public void BrianShiftEqualRangeAtZeroPositiveDelta() {
		Range range = new Range(0.0, 0.0);
		double delta = 1.0;
		Range expect = new Range(1.0, 1.0);
		Range result = Range.shift(range, delta);
		assertEquals(expect, result);
	
	}
	
	@Test
	public void BrianShiftEqualRangeAtZeroNegativeDelta() {
		Range range = new Range(0.0, 0.0);
		double delta = -1.0;
		Range expect = new Range(-1.0, -1.0);
		Range result = Range.shift(range, delta);
		assertEquals(expect, result);
	
	}
	
	@Test
	public void BrianShiftPositiveRangeWithZeroDelta() {
		Range range = new Range(1.0, 2.0);
		double delta = 0.0;
		Range expect = new Range(1.0, 2.0);
		Range result = Range.shift(range, delta);
		assertEquals(expect, result);
	
	}
	
	@Test (expected = NullPointerException.class)
	public void BrianShiftNullRange() {
		double delta = 1.0;
		Range expect = new Range(Double.NaN, Double.NaN);
		Range result = Range.shift(null, delta);
		assertEquals(expect, result);
	
	}
	
	//contains TESTS START FROM HERE
	@Test
	//For the method contains in the class Range, testing to see if the range contains
	//a positive double value
	public void UmmeyRangeContainsPositiveDouble() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain 40.0", true, exampleRange.contains(40.0));
//		System.out.printf("1st test: %b%n", exampleRange.contains(40.0));
	}

	@Test
	//For the method contains in the class Range, testing to see if the range contains
	//a negative double value
	public void UmmeyRangeContainsNegativeDouble() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain -40.0", true, exampleRange.contains(-40.0));
//		System.out.printf("2nd test: %b%n", exampleRange.contains(-40.0));
	}	

	@Test
	//For the method contains in the class Range, testing to see if the range contains
	//a value of 0
	public void UmmeyRangeContainsZero() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain 0.0", true, exampleRange.contains(0.0));
//		System.out.printf("3rd test: %b%n", exampleRange.contains(0.0));
	}	

	@Test
	//For the method contains in the class Range, testing to see if the range contains
	//a positive decimal value
	public void UmmeyRangeContainsPositiveDecimalValue() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain 1.9", true, exampleRange.contains(1.9));
//		System.out.printf("4th test: %b%n", exampleRange.contains(1.9));
	}
	
	@Test
	//For the method contains in the class Range, testing to see if the range contains
	//a negative 
	public void UmmeyRangeContainsNegativeDecimalValue() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain 2.8", true, exampleRange.contains(2.8));
//		System.out.printf("5th test: %b%n", exampleRange.contains(2.8));
	}
	
	@Test
	//For the method contains in the class Range, testing to see if the range contains
	//a float value
	public void UmmeyRangeContainsFloatValue() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain 2.28354795785", true, exampleRange.contains(2.28354795785));
//		System.out.printf("6th test: %b%n", exampleRange.contains(2.28354795785));
	}
	
	@Test
	//For the method contains in the class Range, testing to see if the range contains
	//an ascii character value
	public void UmmeyRangeContainsCharValue() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain the ASCII value of 'a'", true, exampleRange.contains('a'));
//		System.out.printf("7th test: %b%n", exampleRange.contains('a'));
	}
	
	@Test
	//For the method contains in the class Range, testing to see if the range contains
	//an ascii character value
	public void UmmeyRangeDoesNotContainsCharValue() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should not contain the ASCII value of 'f'", false, exampleRange.contains('f'));
//		System.out.printf("8th test: %b%n", exampleRange.contains('f'));
	}
	
	@Test
	//For the method contains in the class Range, testing to see if the range contains
	//a negative ascii character value
	public void UmmeyRangeContainsNegativeCharValue() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain the ASCII value of -'a'", true, exampleRange.contains(-'a'));
//		System.out.printf("9th test: %b%n", exampleRange.contains(-'a'));
	}
	
	@Test
	//For the method contains in the class Range, testing to see if the range contains
	//a negative ascii character value
	public void UmmeyRangeDoesNotContainsNegativeCharValue() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should not contain the ASCII value of -'f'", false, exampleRange.contains(-'f'));
//		System.out.printf("10th test: %b%n", exampleRange.contains(-'f'));
	}
	
	@Test
	//For the method contains in the class Range, testing to see if the range contains
	//an ascii value of space
	public void UmmeyRangeContainsASCIIValueOfSpace() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain the ASCII value of ' '", true, exampleRange.contains(' '));
//		System.out.printf("11th test: %b%n", exampleRange.contains(' '));
	}
	
	@Test
	//For the method contains in the class Range, testing to see if the range contains
	//an ascii value of null
	public void UmmeyRangeDoesNotContainsNull() {	
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should not contain null", false, exampleRange.contains(Double.NaN));
//		System.out.printf("12th test: %b%n", exampleRange.contains(Double.NaN));
	}
	
	@Test
	//For the method contains in the class Range, testing to see if the range contains
	//a positive value that is not in the range
	public void UmmeyRangeDoesNotContainsValueOutOfRange() {	
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should not contain 110.0", false, exampleRange.contains(110.0));
//		System.out.printf("13th test: %b%n", exampleRange.contains(110.0));
	}
	
	@Test
	//For the method contains in the class Range, testing to see if the range contains
	//a double.MIN_VALUE in the range
	public void UmmeyRangeDoesContainDoubleMinValue() {	
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should not contain double min value", true, exampleRange.contains(Double.MIN_VALUE));
//		System.out.printf("14th test: %b%n", exampleRange.contains(Double.MIN_VALUE));
	}
	
	@Test
	//For the method contains in the class Range, testing to see if the range contains
	//a double.MAX_VALUE in the range
	public void UmmeyRangeDoesContainDoubleMaxValue() {	
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should not contain double min value", false, exampleRange.contains(Double.MAX_VALUE));
//		System.out.printf("15th test: %b%n", exampleRange.contains(Double.MAX_VALUE));
	}
	
	@Test
	//For the method contains in the class Range, testing to see if the range contains
	//a hexadecimal value in the range
	public void UmmeyRangeDoesContainHexValue() {	
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain hex value of 0x00", true, exampleRange.contains(0x00));
//		System.out.printf("16th test: %b%n", exampleRange.contains(0x00));
	}
	
	@Test
	//For the method contains in the class Range, testing to see if the range contains
	//a decimal value in the range
	public void UmmeyRangeDoesNotContainDecimalValue() {	
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should not contain 100.1", false, exampleRange.contains(100.1));
//		System.out.printf("17th test: %b%n", exampleRange.contains(100.1));
	}
	
	@Test
	//For the method contains in the class Range, testing to see if the range contains
	//a long double value in the range
	public void UmmeyRangeContainLongDoubleValue() {	
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain 0000000000001.1", true, exampleRange.contains(0000000000001.1));
//		System.out.printf("18th test: %b%n", exampleRange.contains(0000000000001.1));
	}
	
	@Test
	//For the method contains in the class Range, testing to see if the range contains
	//a binary value in the range
	public void UmmeyRangeContainBinaryValue() {	
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The range of -100.0 and 100.0 should contain binary value 0b111000", true, exampleRange.contains(0b111000));
//		System.out.printf("19th test: %b%n", exampleRange.contains(0b111000));
	}
	
	
	
	//getCentralValue TESTS START FROM HERE
	@Test
	//For the method getCentralValue in the class Range, testing to see if the central
	//value can be 0 in the range
	public void UmmeyCentralValueShouldBeZero() {
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of -100.0 and 100.0 should be 0.0", 0.0, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("1st test central value: ");
//		System.out.println(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	//For the method getCentralValue in the class Range, testing to see if the central
	//value can be negative decimal value in the range
	public void UmmeyCentralValueShouldBeNegativeDecimal() {
		exampleRange = new Range(-100.5, 100.3);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of -100.5 and 100.3 should be -1.0", -0.1, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("2nd test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	//For the method getCentralValue in the class Range, testing to see if the central
	//value can be a positive decimal value in the range
	public void UmmeyCentralValueShouldBePositiveDecimal() {
		exampleRange = new Range(-100.0, 110.9);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of -100.0 and 110.9 should be 5.45", 5.45, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("3rd test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	//For the method getCentralValue in the class Range, testing to see if the central
	//value can be a float in the range
	public void UmmeyCentralValueShouldBeFloat() {
		exampleRange = new Range(-100.200038256, 100.377364642);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of -100.200038256 and 100.377364642 should be 0.088663193", 0.088663193, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("4th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	//For the method getCentralValue in the class Range, testing to see if the central
	//value of two unmatched number of decimal is still correct
	public void UmmeyCentralValueShouldBeFloatWithUnmatchedNumOfDecimal() {
		exampleRange = new Range(-100.200038256, 100.377364);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of -100.200038256 and 100.377364 should be 0.088662872", 0.088662872, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("5th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	
	@Test
	//For the method getCentralValue in the class Range, testing to see if the central
	//value can be a positive hexadecimal value in the range
	public void UmmeyCentralValueShouldBePositiveHexValue() {
		exampleRange = new Range(-0x2, 0x62);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of -0x2 and 0x62 should be 0x30", 0x30, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("6th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	//For the method getCentralValue in the class Range, testing to see if the central
	//value can be a negative hexadecimal value in the range
	public void UmmeyCentralValueShouldBeNegativeHexValue() {
		exampleRange = new Range(-0x62, 0x2);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of -0x62 and 0x2 should be -0x30", -0x30, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("7th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	//For the method getCentralValue in the class Range, testing to see if the central
	//value can be a positive binary value in the range
	public void UmmeyCentralValueShouldBePositiveBinaryValue() {
		exampleRange = new Range(-0b10, 0b1100010);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of -0b10 and 0b1100010 should be 0b110000", 0b110000, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("8th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	//For the method getCentralValue in the class Range, testing to see if the central
	//value can be a pnegative binary value in the range
	public void UmmeyCentralValueShouldBeNegativeBinaryValue() {
		exampleRange = new Range(-0b1100010, 0b10);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of -0b1100010 and 0b10 should be -0b110000", -0b110000, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("9th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	//For the method getCentralValue in the class Range, testing to see if the central
	//value can be the value between MIN_VALUE and MAX_VALUE in that range
	public void UmmeyCentralValueShouldBeBetweenMaxAndMin() {
		exampleRange = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of Double.MIN_VALUE and Double.MAX_VALUE should be (Double.MIN_VALUE+Double.MAX_VALUE)/2", (Double.MIN_VALUE+Double.MAX_VALUE)/2, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("10th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	//For the method getCentralValue in the class Range, testing to see if the central
	//value can be a very small number in an equally small range
	public void UmmeyCentralValueShouldBeAVerySmallNumber() {
		exampleRange = new Range(0.00000000001, 0.00000000002);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of 0.00000000001 and 0.00000000002 should be 1.5e-11", 1.5e-11, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("11th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	//For the method getCentralValue in the class Range, testing to see if the central
	//value of the same number range is correct
	public void UmmeyCentralValueOfTheSameRange() {
		exampleRange = new Range(2,2);
		//assertEquals(String message, Object expected, Object actual)
		assertEquals("The central value of 2 and 2 should be 2", 2, exampleRange.getCentralValue(), .000000001d);
//		System.out.print("12th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	
	@Test
	//For the method getCentralValue in the class Range, testing to see if the central
	//value is corrected to a reversed range
	public void UmmeyCentralValueOfReverseRange() {
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
	//For the method getCentralValue in the class Range, testing to see if the central
	//value is correct for a long range with leading zeros
	public void UmmeyCentralValueOfLongRangeWithLeadingZeros() {
		exampleRange = new Range(-00000000016273673, 00000000026273673);
		try {
			assertEquals("The central value of -00000000016273673625 and 00000000026273673625 should be 5000000", 5000000, exampleRange.getCentralValue(), .000000001d);	
		} catch(Exception e) {
			fail(e.toString());
		}
//		System.out.print("14th test central value: ");
//		System.out.print(exampleRange.getCentralValue() + "\n");
	}
	
	@Test
	public void testBasicR1andR2() {
		Range OmarR1 = new Range(-1.0, 1.0);
		Range omarR2 = new Range(2.0, 3.0);
		Range omarexpectedResult = new Range(-1.0, 3.0);
		Range omaractualResult = null;
		try {
			omaractualResult = Range.combine(OmarR1, omarR2);
			assertEquals(omarexpectedResult.toString(), omaractualResult.toString());
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testBasicR2andR1() {
		Range omarR1 = new Range(-1.0, 1.0);
		Range omarR2 = new Range(2.0, 3.0);
		Range omarexpectedResult = new Range(-1, 3.0);
		try {
		Range omaractualResult = Range.combine(omarR2, omarR1);
			assertEquals(omarexpectedResult.toString(), omaractualResult.toString());
		}catch(Exception e) {
			fail();
		}
	}

	@Test
	public void testR1EncompasesR2() {
		Range omarR1 = new Range(-5, 5);
		Range omarR2 = new Range(-1, 1);

		Range omarexpectedResult = new Range(-5.0, 5);
		Range omaractualResult = null;
		try {
			omaractualResult = Range.combine(omarR1, omarR2);
			System.out.println(omaractualResult.toString());
			assertEquals(omarexpectedResult.toString(), omaractualResult.toString());
		} catch (Exception e) {
			fail();
		}
		
	}
	
	@Test
	public void testR2EncompasesR1() {
		Range omarR1 = new Range(-5.0, 5.0);
		Range omarR2 = new Range(-1.0, 1.0);

		Range omarexpectedResult = new Range(-5.0, 5.0);
		Range omaractualResult = null;
		try {
			omaractualResult = Range.combine(omarR2, omarR1);
			System.out.println(omaractualResult.toString());
			assertEquals(omarexpectedResult.toString(), omaractualResult.toString());
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testR1Null() {
		Range omarR1 = null;
		Range omarR2 = new Range(-1.0,1.0);
		
		Range omarexpectedResult = new Range(-1.0,1.0);
		Range omaractualResult = null;
		
		try {
			omaractualResult = Range.combine(omarR1, omarR2);

			assertEquals(omarexpectedResult.toString(), omaractualResult.toString());
		}catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testR2Null() {
		Range omarR1 = new Range(-1.0,1.0);
		Range omarR2 = null;
		
		Range omarexpectedResult = new Range(-1.0,1.0);
		
		Range omaractualResult = null;
		
		try {
			omaractualResult = Range.combine(omarR1, omarR2);

			assertEquals(omarexpectedResult.toString(), omaractualResult.toString());
		}catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testR1andR2Null() {
		Range omarR1 = null;
		Range omarR2 = null;
	
		Range omaractualResult = null;
		
		try {
			omaractualResult = Range.combine(omarR1, omarR2);

			assertNull(omaractualResult);
		}catch (Exception e) {
			fail();
		}	
	}

	//ASG#3 STARTS HERE - CODE COVERAGE FOR THE REST OF RANGE CLASS
	@Test
	//For the method intersects in the class Range, testing to see if the range
	//intersects where the lower bound in the new range is less than the lower bound
	//in the intersects range
	public void UmmeyRangeIntersectsLowerBoundIsLessThanLower() {
		exampleRange = new Range(-1, 10);
		assertTrue("Testing range intersection where the new range is less than the lower bound", exampleRange.intersects(0, 5));
	}

	
	@Test
	//For the method constrain in the class Range, testing to see if it contains
	//the value of 0.0
	public void UmmeyRangeConstrainDoesContainValue() {
		exampleRange = new Range(-1, 10);
		double value = 0.0;
		double result = exampleRange.constrain(value);
		assertEquals("Testing constrain to see if it contains the value.", 0.0, result, 0.000001d);
	}
	
	@Test
	//For the method constrain in the class Range, testing to see if it does not contain
	//the value 11.0 and the result is greater than the upper bound limit
	public void UmmeyRangeConstrainDoesNotContainValueAndResultIsUpper() {
		exampleRange = new Range(-1, 10);
		double value = 11.0;
		double result = exampleRange.constrain(value);
		assertEquals("Testing constrain to see if it contains the value while the"
				+ "	result is greater than the upper bound limit.", 10.0, result, 0.000001d);
	}
	
	@Test
	//For the method constrain in the class Range, testing to see if it contains
	//the value of -2.0 and the result is less than the lower bound limit
	public void UmmeyRangeConstrainDoesNotContainValueAndResultIsLower() {
		exampleRange = new Range(-1, 10);
		double value = -2.0;
		double result = exampleRange.constrain(value);
		assertEquals("Testing constrain to see if it contains the value while the"
				+ " result is less than the lower bound limit.", -1.0, result, 0.000001d);
	}
	
	@Test
	//For the method expandToInclude in the class Range, testing to see if the
	//value is less than the lower bound limit of the range
	public void UmmeyRangeExpandToIncludeIfValueLessThanLowerBoundOfRange() {
		Range range = new Range(0, 10);
  		double value = -2.0;
 		Range expected = new Range(-2.0, 10);
 		Range actual = null;
		actual = Range.expandToInclude(range, value);
		assertEquals("Testing range expand where value is less than lower bound of range.", expected.toString(), actual.toString());
	}
	
	@Test
	//For the method expandToInclude in the class Range, testing to see if the
	//value is greater than the upper bound limit of the range
	public void UmmeyRangeExpandToIncludeIfValueGreaterThanUpperBoundOfRange() {
		Range range = new Range(0, 10);
  		double value = 11.0;
 		Range expected = new Range(0, 11);
 		Range actual = null;
		actual = Range.expandToInclude(range, value);
		assertEquals("Testing range expandToInclude where value is greater than upper bound of range", expected.toString(), actual.toString());
	}
	
	@Test
	//For the method expandToInclude in the class Range, testing to see if the
	//value is equal to upper bound of the range
	public void UmmeyRangeExpandToIncludeIfValueIsEqualToUpperBoundOfRange() {
		Range range = new Range(0, 10);
  		double value = 10.0;
 		Range expected = new Range(0, 10);
 		Range actual = null;
		actual = Range.expandToInclude(range, value);
		assertEquals("Testing range expandToInclude where value is equal to upper bound of range.", expected.toString(), actual.toString());
	}
	
	@Test
	//For the method expandToInclude in the class Range, testing to see if the
	//range is null
	public void UmmeyRangeExpandToIncludeIfRangeIsNull() {
		Range range = null;
  		double value = 10.0;
 		Range expected = new Range(10, 10);
 		Range actual = null;
		actual = Range.expandToInclude(range, value);
		assertEquals("Testing range expandToInclude where range is null.",expected.toString(), actual.toString());
	}
	
	@Test
	//For the method expand in the class Range, testing to see if the
	//range is null
	public void UmmeyRangeExpandIfRangeIsNull() {
		Range range = null;
		double lowerMargin = 0;
		double upperMargin = 4;
		try {
	 		Range actual = Range.expand(range, lowerMargin, upperMargin);
			assertNull("Testing range expand where range is null.", actual);
		}catch (IllegalArgumentException e) {
			fail("Null 'range' argument.");
		}	
	}
	
	@Test
	//For the method expand in the class Range, testing to see if the given range with
	//the given lower and upper margin returns the new range
	public void UmmeyRangeExpandReturnNewRange() {
		Range range = new Range(3, 6);
		double lowerMargin = 2;
		double upperMargin = 7;
		double length = range.getLength();
        double lower = length * lowerMargin;//6
        double upper = length * upperMargin;//21
 		Range expected = new Range(-3, 27);//(-3,27)
 		Range actual = null;
		actual = Range.expand(range, lowerMargin, upperMargin);
		assertEquals("Testing range expand given a range, lower margin and upper margin.", expected.toString(), actual.toString());
	}
	
	
	@Test
	//For the method shift in the class Range, testing to see if the given range with
	//the given delta returns the new range
	public void UmmeyRangeShiftIfStatemnt() {
		Range range = new Range(-1.0, 0.0);
		double delta = -1.0;
		Range expect = new Range(-2.0, -1.0);
		Range result = Range.shift(range, delta);
		assertEquals("Testing raneg shift where given range and delta, returns new range.", expect, result);
	}
	
	@Test 
	//For the method shift in the class Range, testing to see if the given range with
	//the given delta and setting the allowZeroCrossing flag will return the new range
	public void UmmeyRangeShiftAcrossZeroDelta() {
		Range range = new Range(-1.0, 3.0);
		double delta = 1.0;
		boolean allowZeroCrossing = true;
		Range expect = new Range(0.0, 4.0);
		Range result = Range.shift(range, delta, allowZeroCrossing);
		assertEquals("Testing range shift with allowZeroCross flag.", expect, result);	
	}
	
	@Test
	//For the method equals in the class Range, testing to see if the object instance
	//of range will return false
	public void UmmeyRangeEqualsIfNotInstanceOfRange() {
		exampleRange = new Range(0, 10);
		assertFalse("Testing range equals where object is not an instance of range.", exampleRange.equals(-1));
	}
	
	@Test
	//For the method hashCode in the class Range, testing to see if the given range 
	//with the temp and result will returns the correct result
	public void UmmeyRangeHashCodeReturnResult() {
		exampleRange = new Range(0, 10); 
		int result;
	    long temp;
	    temp = Double.doubleToLongBits(0);
	    result = (int) (temp ^ (temp >>> 32));
	    temp = Double.doubleToLongBits(10);
	    result = 29 * result + (int) (temp ^ (temp >>> 32));
	    int expected = result;
 		int actual = exampleRange.hashCode();
		assertEquals("Testing range hashCode where given range, result, and temp, returns the result.", expected, actual);
	}
}
