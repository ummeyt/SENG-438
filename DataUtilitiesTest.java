/**
 * 
 */
package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {
	
	Mockery mockingContext;
	KeyedValues values;
	Mockery omarmockingContext = null;
	Values2D omarvalues = null;


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
		// setup
		omarmockingContext = new Mockery();
		omarvalues = omarmockingContext.mock(Values2D.class);

		mockingContext = new Mockery();
		values = mockingContext.mock(KeyedValues.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		mockingContext = null;
		values = null;
		
		omarmockingContext = null;
		omarvalues = null;

	}
	// Testing zero-valued 2D array <One Column, One Row>	
	@Test
	public void BrianArray2DForOneColumnAndOneRow() {
		double[][] values = new double[1][];
		values[0] = new double[] {0.0};
		
		Number[][] expected = new Number[1][];
		expected[0] = new Number[] {0.0};
		
		Number[][] result = DataUtilities.createNumberArray2D(values);
		
		assertEquals(1, result.length);
		assertEquals(1, result[0].length);
		assertArrayEquals("2D Array for <One Column, One Row>", expected, result);
		
	}
	
	// Testing zero-valued 2D array <Two Columns, One Row>
	@Test
	public void BrianArray2DForTwoColumnsAndOneRow() {
		double[][] values = new double[1][];
		values[0] = new double[] {0.0, 0.0};
		
		Number[][] expected = new Number[1][];
		expected[0] = new Number[] {0.0, 0.0};
		
		Number[][] result = DataUtilities.createNumberArray2D(values);
		
		assertEquals(1, result.length);
		assertEquals(2, result[0].length);
		assertArrayEquals("2D Array for <Two Columns, One Row> ",expected, result);
	}	
	
	// Testing zero-valued 2D array <One Column, Two Rows>
	@Test
	public void BrianArray2DForOneColumnAndTwoRows() {
		double[][] values = new double[2][];
		values[0] = new double[] {0.0};
		values[1] = new double[] {0.0};
		
		Number[][] expected = new Number[2][];
		expected[0] = new Number[] {0.0};
		expected[1] = new Number[] {0.0};
		
		Number[][] result = DataUtilities.createNumberArray2D(values);
		
		assertEquals(2, result.length);
		assertEquals(1, result[0].length);
		assertArrayEquals("2D Array for <One Column, Two Rows>", expected, result);
		

	}	

	// Testing zero-valued 2D array <Two Columns, Two Rows>
	@Test
	public void BrianArray2DForTwoColumnsAndTwoRows() {
		double[][] values = new double[2][];
		values[0] = new double[] {0.0, 0.0};
		values[1] = new double[] {0.0, 0.0};
		
		Number[][] expected = new Number[2][];
		expected[0] = new Number[] {0.0, 0.0};
		expected[1] = new Number[] {0.0, 0.0};
		
		Number[][] result = DataUtilities.createNumberArray2D(values);
		
		assertEquals(2, result.length);
		assertEquals(2, result[0].length);
		assertArrayEquals("2D Array for <Two Columns, Two Rows>", expected, result);

	}
	
	// Testing zero-valued 2D array that is diagonal
	@Test public void BrianArray2DForDiagonalArray() {
		double[][] values = new double[2][];
		values[0] = new double[] {0.0};
		values[1] = new double[] {0.0, 0.0};
		
		Number[][] expected = new Number[2][];
		expected[0] = new Number[] {0.0};
		expected[1] = new Number[] {0.0, 0.0};
		
		Number[][] result = DataUtilities.createNumberArray2D(values);
		
		assertEquals(2, result.length);
		assertEquals(1, result[0].length);
		assertEquals(2, result[1].length);
		assertArrayEquals("2D Array for Diagonal Array", expected, result);
		
	}
	
	// Testing NONZERO-valued 2D array <One Column, One Row>
	@Test public void BrianArray2DForOneColumnOneRowNONZERO(){
		double[][] values = new double[1][];
		values[0] = new double[] {1.1};
		
		Number[][] expected = new Number[1][];
		expected[0] = new Number[] {1.1};
		
		Number[][] result = DataUtilities.createNumberArray2D(values);
		
		assertEquals(1, result.length);
		assertEquals(1, result[0].length);
		assertArrayEquals("2D Array for <One Column, One Row> NONZERO",expected, result);
		
	}

	// Testing NONZERO-valued 2D array <Two Columns, One Row>
	@Test
	public void BrianArray2DForTwoColumnsAndOneRowNONZERO() {
		double[][] values = new double[1][];
		values[0] = new double[] {1.1, 2.2};
		
		Number[][] expected = new Number[1][];
		expected[0] = new Number[] {1.1, 2.2};
		
		Number[][] result = DataUtilities.createNumberArray2D(values);
		
		assertEquals(1, result.length);
		assertEquals(2, result[0].length);
		assertArrayEquals("2D Array for <Two Columns, One Row> NONZERO",expected, result);
		
	}
	
	// Testing NONZERO-valued 2D array <One Column, Two Rows>
	@Test
	public void BrianArray2DForOneColumnAndTwoRowsNONZERO() {
		double[][] values = new double[2][];
		values[0] = new double[] {1.1};
		values[1] = new double[] {1.1};
		
		Number[][] expected = new Number[2][];
		expected[0] = new Number[] {1.1};
		expected[1] = new Number[] {1.1};
		
		Number[][] result = DataUtilities.createNumberArray2D(values);
		
		assertEquals(2, result.length);
		assertEquals(1, result[0].length);
		assertArrayEquals("2D Array for <One Column, Two Rows> NONZERO", expected, result);
		
	}
	
	// Testing NONZERO-valued 2D array <Two Columns, Two Rows>
	@Test
	public void BrianArray2DForTwoColumnsAndTwoRowsNONZERO() {
		double[][] values = new double[2][];
		values[0] = new double[] {1.1, 2.2};
		values[1] = new double[] {1.1, 2.2};
		
		Number[][] expected = new Number[2][];
		expected[0] = new Number[] {1.1, 2.2};
		expected[1] = new Number[] {1.1, 2.2};
		
		Number[][] result = DataUtilities.createNumberArray2D(values);
		
		assertEquals(2, result.length);
		assertEquals(2, result[0].length);
		assertArrayEquals("2D Array for <Two Columns, Two Rows> NONZERO", expected, result);

	}
	
	// Testing NONZERO-valued 2D Diagonal
	@Test
	public void BrianArray2DForDiagonalArrayNONZERO() {
		double[][] values = new double[2][];
		values[0] = new double[] {1.1};
		values[1] = new double[] {1.1, 2.2};
		
		Number[][] expected = new Number[2][];
		expected[0] = new Number[] {1.1};
		expected[1] = new Number[] {1.1, 2.2};
		
		Number[][] result = DataUtilities.createNumberArray2D(values);
		
		assertEquals(2, result.length);
		assertEquals(1, result[0].length);
		assertEquals(2, result[1].length);
		assertArrayEquals("2D Array for Diagonal NONZERO",expected, result);

	}
	
	// Testing NONZERO-valued 2D Empty Array
	@Test
	public void BrianArray2DForEmptyArray() {
		double[][] values = new double[0][0];
		
		Number[][] expected = new Number[0][0];
		
		Number[][] result = DataUtilities.createNumberArray2D(values);
		
		assertEquals(0, result.length);
		assertArrayEquals("2d Array for Empty Array", expected, result);
				
	}
	
	// Testing NaN-valued 2D Array
	@Test
	public void BrianArray2DForNAN() {
		double[][] values = new double[1][];
		values[0] = new double[] {Double.NaN};
		
		Number[][] expected = new Number[1][];
		expected[0] = new Number[] {null};
		
		Number[][] result = DataUtilities.createNumberArray2D(values);
		
		assertArrayEquals("2D Array for NaN",expected, result);
		
	}
	
	/*
	 * Generate the Keys and Values and feed it into getCumulativePercentages.
	 * Checks whether the output for key# 0 is correct. 
	 */
	@Test
	public void BenGetCumulativePercentageTestOne() {

		mockingContext.checking(new Expectations() {
		{
			allowing(values).getKey(0);
			will(returnValue(0));
			allowing(values).getValue(0);
			will(returnValue(5));
			
			allowing(values).getKey(1);
			will(returnValue(1));
			allowing(values).getValue(1);
			will(returnValue(9));
			
			allowing(values).getKey(2);
			will(returnValue(2));
			allowing(values).getValue(2);
			will(returnValue(2));
			
			allowing(values).getItemCount();
			will(returnValue(3));
		}
		});
		// exercise 
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		
		// verify
		assertEquals("Output: (5 / 16) = 0.3125", 0.3125, (Double)result.getValue(result.getKey(0)), .00009d);
	}
	
	/*
	 * Generate the Keys and Values and feed it into getCumulativePercentages.
	 * Checks whether the output for key# 1 is correct. 
	 */
	@Test
	public void BenGetCumulativePercentageTestTwo() {

		mockingContext.checking(new Expectations() {
		{
			allowing(values).getKey(0);
			will(returnValue(0));
			allowing(values).getValue(0);
			will(returnValue(5));
			
			allowing(values).getKey(1);
			will(returnValue(1));
			allowing(values).getValue(1);
			will(returnValue(9));
			
			allowing(values).getKey(2);
			will(returnValue(2));
			allowing(values).getValue(2);
			will(returnValue(2));
			
			allowing(values).getItemCount();
			will(returnValue(3));
		}
		});
		// exercise 
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		
		// verify
		assertEquals("Output: ((5 + 9) / 16) = 0.875", 0.875, (Double)result.getValue(result.getKey(1)), .0009d);
	}
	
	/*
	 * Generate the Keys and Values and feed it into getCumulativePercentages.
	 * Checks whether the output for key# 2 is correct. 
	 */
	@Test
	public void BenGetCumulativePercentageTestThree() {

		mockingContext.checking(new Expectations() {
		{
			allowing(values).getKey(0);
			will(returnValue(0));
			allowing(values).getValue(0);
			will(returnValue(5));
			
			allowing(values).getKey(1);
			will(returnValue(1));
			allowing(values).getValue(1);
			will(returnValue(9));
			
			allowing(values).getKey(2);
			will(returnValue(2));
			allowing(values).getValue(2);
			will(returnValue(2));
			
			allowing(values).getItemCount();
			will(returnValue(3));
		}
		});
		// exercise 
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		
		// verify
		assertEquals("Output: ((5 + 9 + 2) / 16 = 1.0", 0.3125, (Double)result.getValue(result.getKey(2)), .09d);
	}
	
	/*
	 * Generate the Keys and Values from test# 1 and try to access key �3�
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void BenGetCumulativePercentageTestFour() {
		mockingContext.checking(new Expectations() {
		{
			allowing(values).getKey(0);
			will(returnValue(0));
			allowing(values).getValue(0);
			will(returnValue(5));
			
			allowing(values).getKey(1);
			will(returnValue(1));
			allowing(values).getValue(1);
			will(returnValue(9));
			
			allowing(values).getKey(2);
			will(returnValue(2));
			allowing(values).getValue(2);
			will(returnValue(2));
			
			allowing(values).getItemCount();
			will(returnValue(3));
		}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		
		Double test = null;
		test = (Double)result.getValue(result.getKey(3));
		assertNull("The variable is not null", test);
	}

	/*
	 * Generate an empty KeyedValue data and feed it into the getCumulativePercentages function.
	 * The function should throw InvalidParameterException if invalid data object is passed in
	 */
	@Test
	public void BenGetCumulativePercentageTestFive() {
		values = null;
		try {
			KeyedValues result = DataUtilities.getCumulativePercentages(values);
		}catch(InvalidParameterException e) {
			assertTrue("pass", true);
		}catch(Exception e) {
			fail(e.toString());
		}
	}
		
	/*
	 * Generate double_max as the value for key# 0
	 */
	@Test
	public void BenGetCumulativePercentageTestSix() {
		mockingContext.checking(new Expectations() {
		{
			allowing(values).getKey(0);
			will(returnValue(0));
			allowing(values).getValue(0);
			will(returnValue(2));
			
			allowing(values).getItemCount();
			will(returnValue(1));
		}
		});	
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals("Output: 1.0", 1.0, (Double)result.getValue(result.getKey(0)), .09d);
	}

	/*
	 * Generate the value for key# 0 as zero
	 */
	@Test
	public void BenGetCumulativePercentageTestSeven() {
		mockingContext.checking(new Expectations() {
		{
			allowing(values).getKey(0);
			will(returnValue(0));
			allowing(values).getValue(0);
			will(returnValue(0));
			
			allowing(values).getItemCount();
			will(returnValue(1));
		}
		});	
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		try {
			Double temp = (Double)result.getValue(result.getKey(0));
		}catch(ArithmeticException e) {
			assertTrue("ArithmetricException catched", true);
		}catch(Exception e) {
			fail(e.toString());
		}
	}
	
	/*
	 * Generate the value for key# 0 as a Double Min
	 */
	@Test
	public void BenGetCumulativePercentageTestEight() {
		mockingContext.checking(new Expectations() {
		{
			allowing(values).getKey(0);
			will(returnValue(0));
			allowing(values).getValue(0);
			will(returnValue(Double.MIN_VALUE));
			
			allowing(values).getItemCount();
			will(returnValue(1));
		}
		});	
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals("Output: 1.0", 1.0, (Double)result.getValue(result.getKey(0)), .09d);
	}
	
	/*
	 * Generate the value for key# 0 as an negative number
	 */
	@Test
	public void BenGetCumulativePercentageTestNine() {
		mockingContext.checking(new Expectations() {
		{
			allowing(values).getKey(0);
			will(returnValue(0));
			allowing(values).getValue(0);
			will(returnValue(-1));
			
			allowing(values).getItemCount();
			will(returnValue(1));
		}
		});	
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals("Output: 1.0", 1.0, (Double)result.getValue(result.getKey(0)), .09d);
	}
	
	/*
	 * Generate the value for key# 0 as an negative number and key# 1 as double max
	 */
	@Test
	public void BenGetCumulativePercentageTestTen() {
		mockingContext.checking(new Expectations() {
		{
			allowing(values).getKey(0);
			will(returnValue(0));
			allowing(values).getValue(0);
			will(returnValue(-1));
			
			allowing(values).getKey(1);
			will(returnValue(1));
			allowing(values).getValue(1);
			will(returnValue(Double.MAX_VALUE));
			
			allowing(values).getItemCount();
			will(returnValue(2));
		}
		});	
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals("Output: -5.562684646268003E-309", -5.562684646268003E-309, (Double)result.getValue(result.getKey(0)), .09d);
	}
	
	/*
	 * Generate the value for key# 0 as an negative number and key# 1 as double max
	 */
	@Test
	public void BenGetCumulativePercentageTestEleven() {
		mockingContext.checking(new Expectations() {
		{
			allowing(values).getKey(0);
			will(returnValue(0));
			allowing(values).getValue(0);
			will(returnValue(-1));
			
			allowing(values).getKey(1);
			will(returnValue(1));
			allowing(values).getValue(1);
			will(returnValue(Double.MAX_VALUE));
			
			allowing(values).getItemCount();
			will(returnValue(2));
		}
		});	
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals("Output: 1.0", 1.0, (Double)result.getValue(result.getKey(1)), .09d);
	}
	
	/*
	 * Generate the value for key# 0 as an zero and key# 1 as double max
	 */
	@Test
	public void BenGetCumulativePercentageTestTwelve() {
		mockingContext.checking(new Expectations() {
		{
			allowing(values).getKey(0);
			will(returnValue(0));
			allowing(values).getValue(0);
			will(returnValue(0));
			
			allowing(values).getKey(1);
			will(returnValue(1));
			allowing(values).getValue(1);
			will(returnValue(Double.MAX_VALUE));
			
			allowing(values).getItemCount();
			will(returnValue(2));
		}
		});	
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals("Output: 0.0", 0.0, (Double)result.getValue(result.getKey(0)), .09d);
	}
	
	/*
	 * Generate the value for key# 0 as an zero and key# 1 as double max
	 */
	@Test
	public void BenGetCumulativePercentageTestThirteen() {
		mockingContext.checking(new Expectations() {
		{
			allowing(values).getKey(0);
			will(returnValue(0));
			allowing(values).getValue(0);
			will(returnValue(0));
			
			allowing(values).getKey(1);
			will(returnValue(1));
			allowing(values).getValue(1);
			will(returnValue(Double.MAX_VALUE));
			
			allowing(values).getItemCount();
			will(returnValue(2));
		}
		});	
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals("Output: 1.0", 1.0, (Double)result.getValue(result.getKey(1)), .09d);
	}
	
	/*
	 * Generate the value for key# 0 as double max and key# 1 as an zero
	 */
	@Test
	public void BenGetCumulativePercentageTestFourteen() {
		mockingContext.checking(new Expectations() {
		{
			allowing(values).getKey(0);
			will(returnValue(0));
			allowing(values).getValue(0);
			will(returnValue(Double.MAX_VALUE));
			
			allowing(values).getKey(1);
			will(returnValue(1));
			allowing(values).getValue(1);
			will(returnValue(-1));
			
			allowing(values).getItemCount();
			will(returnValue(2));
		}
		});	
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals("Output: 1.0", 1.0, (Double)result.getValue(result.getKey(0)), .09d);
	}
	
	/*
	 * Generate the value for key# 0 as double max and key# 1 as an zero
	 */
	@Test
	public void BenGetCumulativePercentageTestFifteen() {
		mockingContext.checking(new Expectations() {
		{
			allowing(values).getKey(0);
			will(returnValue(0));
			allowing(values).getValue(0);
			will(returnValue(Double.MAX_VALUE));
			
			allowing(values).getKey(1);
			will(returnValue(1));
			allowing(values).getValue(1);
			will(returnValue(-1));
			
			allowing(values).getItemCount();
			will(returnValue(2));
		}
		});	
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals("Output: 1.0", 1.0, (Double)result.getValue(result.getKey(1)), .09d);
	}
	
	/*
	 * Generate the value for key# 0 as double max and key# 1 as an zero
	 */
	@Test
	public void BenGetCumulativePercentageTestSixteen() {
		mockingContext.checking(new Expectations() {
		{
			allowing(values).getKey(0);
			will(returnValue(0));
			allowing(values).getValue(0);
			will(returnValue(Double.MAX_VALUE));
			
			allowing(values).getKey(1);
			will(returnValue(1));
			allowing(values).getValue(1);
			will(returnValue(0));
			
			allowing(values).getItemCount();
			will(returnValue(2));
		}
		});	
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals("Output: 1.0", 1.0, (Double)result.getValue(result.getKey(0)), .09d);
	}
	
	/*
	 * Generate the value for key# 0 as double max and key# 1 as an zero
	 */
	@Test
	public void BenGetCumulativePercentageTestSeventeen() {
		mockingContext.checking(new Expectations() {
		{
			allowing(values).getKey(0);
			will(returnValue(0));
			allowing(values).getValue(0);
			will(returnValue(Double.MAX_VALUE));
			
			allowing(values).getKey(1);
			will(returnValue(1));
			allowing(values).getValue(1);
			will(returnValue(0));
			
			allowing(values).getItemCount();
			will(returnValue(2));
		}
		});	
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals("Output: 1.0", 1.0, (Double)result.getValue(result.getKey(1)), .09d);
	}
	
	/*
	 * Generate the value for key# 0 as double max and key# 1 as double min
	 */
	@Test
	public void BenGetCumulativePercentageTestEighteen() {
		mockingContext.checking(new Expectations() {
		{
			allowing(values).getKey(0);
			will(returnValue(0));
			allowing(values).getValue(0);
			will(returnValue(Double.MAX_VALUE));
			
			allowing(values).getKey(1);
			will(returnValue(1));
			allowing(values).getValue(1);
			will(returnValue(Double.MIN_VALUE));
			
			allowing(values).getItemCount();
			will(returnValue(2));
		}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals("Output: 1.0", 1.0, (Double)result.getValue(result.getKey(0)), .09d);
	}
	
	/*
	 * Generate the value for key# 0 as double max and key# 1 as double min
	 */
	@Test
	public void BenGetCumulativePercentageTestNineteen() {
		mockingContext.checking(new Expectations() {
		{
			allowing(values).getKey(0);
			will(returnValue(0));
			allowing(values).getValue(0);
			will(returnValue(Double.MAX_VALUE));
			
			allowing(values).getKey(1);
			will(returnValue(1));
			allowing(values).getValue(1);
			will(returnValue(Double.MIN_VALUE));
			
			allowing(values).getItemCount();
			will(returnValue(2));
		}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals("Output: 1.0", 1.0, (Double)result.getValue(result.getKey(1)), .09d);
	}
	
	/*
	 * Create double array data which contains {1.0} and feed it into the method
	 */
	@Test
	public void BenCreateNumberArrayOne() {
		double[] data = {1.0};
		Number[] result = DataUtilities.createNumberArray(data);
		try {
			result[0].doubleValue();	
			assertTrue("Pass: the pointer is not null", true);
		} catch(NullPointerException e){
			fail(e.toString());	
		}	
	}
	
	/*
	 * Create double array data which contains {1.0, 2.0} and feed it into the method
	 */
	@Test
	public void BenCreateNumberArrayTwo() {
		double[] data = {1.0, 2.0};
		Number[] result = DataUtilities.createNumberArray(data);
		try {
			result[0].doubleValue();
			result[1].doubleValue();
			assertTrue("Pass: the pointes are not null", true);
		} catch(NullPointerException e){
			fail(e.toString());	
		}	
	}
	
	/*
	 * Create double array data which contains {1.0, 2.0, 3.0} and feed it into the method
	 */
	@Test
	public void BenCreateNumberArrayThree() {
		double[] data = {1.0, 2.0, 3.0};
		Number[] result = DataUtilities.createNumberArray(data);
		try {
			result[0].doubleValue();
			result[1].doubleValue();
			result[2].doubleValue();
			assertTrue("Pass: the pointes are not null", true);
		} catch(NullPointerException e){
			fail(e.toString());	
		}	
	}
	
	/*
	 * Create double array data which contains {Double_Max, Double_Max} and feed it into the method
	 */
	@Test
	public void BenCreateNumberArrayFour() {
		double[] data = {Double.MAX_VALUE, Double.MAX_VALUE};
		Number[] result = DataUtilities.createNumberArray(data);
		try {
			result[0].doubleValue();
			result[1].doubleValue();
			assertTrue("Pass: the pointes are not null", true);
		} catch(NullPointerException e){
			fail(e.toString());	
		}	
	}
	
	/*
	 * Create double array data which contains {Double_Min, Double_Min} and feed it into the method
	 */
	@Test
	public void BenCreateNumberArrayFive() {
		double[] data = {Double.MIN_VALUE, Double.MIN_VALUE};
		Number[] result = DataUtilities.createNumberArray(data);
		try {
			result[0].doubleValue();
			result[1].doubleValue();
			assertTrue("Pass: the pointes are not null", true);
		} catch(NullPointerException e){
			fail(e.toString());	
		}	
	}
	
	/*
	 * Create double array data which contains {Double_Min, Double_Min} and feed it into the method
	 */
	@Test
	public void BenCreateNumberArraySix() {
		double[] data = {Double.NaN, Double.NaN};
		Number[] result = DataUtilities.createNumberArray(data);
		try {
			result[0].doubleValue();
			result[1].doubleValue();
			assertTrue("Pass: the pointes are not null", true);
		} catch(NullPointerException e){
			fail(e.toString());	
		}	
	}
	
	/*
	 * Create an empty double array and feed it into the function
	 */
	@Test
	public void BenCreateNumberArraySeven() {
		double[] data = null;
		try {
			Number[] result = DataUtilities.createNumberArray(data);
		}catch(InvalidParameterException e){
			assertTrue("Pass: InvalidParameterException catched", true);	
		}catch(Exception e) {
			fail(e.toString());
		}
	}
	
	@Test
	//For method calculateColumnTotal in Range class, testing to see if it returns the correct
	//column total for two values
	public void UmmeyCalculateColumnTotalForTwoValues() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(2));
				allowing(values).getValue(0, 0);
				will(returnValue(7.5));
				allowing(values).getValue(1, 0);
				will(returnValue(2.5));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
		// assertEquals(String message, Object expected, Object actual)
		assertEquals("Testing range calculateColumnTotal which calculates column total for two values.", result, 10.0, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	//For method calculateColumnTotal in Range class, testing to see if it can correctly return
	//zero as the column total for a value
	public void UmmeyZeroColumnTotal() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(1));
				allowing(values).getValue(0, 0);
				will(returnValue(0.0));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
		// assertEquals(String message, Object expected, Object actual)
		assertEquals("Testing range calculateColumnTotal which returns zero as column total.", result, 0.0, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	//For method calculateColumnTotal in Range class, testing to see if it returns the correct
	//column total for two values, which is negative
	public void UmmeyNegativeColumnTotal() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(2));
				allowing(values).getValue(0, 0);
				will(returnValue(3.0));
				allowing(values).getValue(1, 0);
				will(returnValue(-5.0));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
		// assertEquals(String message, Object expected, Object actual)
		assertEquals("Testing range calculateColumnTotal which returns negative as column total.", result, -2.0, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	//For method calculateColumnTotal in Range class, testing to see if it returns the correct
	//column total for null, which should be null
	public void UmmeyNullValuesColumnTotal() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(1));
				allowing(values).getValue(0, 0);
				will(returnValue(Double.NaN));
			}
		});
		try {
			double result = DataUtilities.calculateColumnTotal(values, 0);
			fail("Did not catch invaid parameter exception");
		} catch (InvalidParameterException e) {
			assertTrue("Testing range calculateColumnTotal which has null row.", true);
		}
	}

	@Test
	//For method calculateColumnTotal in Range class, testing to see if it returns the correct
	//column total for two values and adding to MAX_VALUE
	public void UmmeyAddingToMaxDoubleValue() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(2));
				allowing(values).getValue(0, 0);
				will(returnValue(Double.MAX_VALUE));
				allowing(values).getValue(1, 0);
				will(returnValue(2.0));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("Testing range calculateColumnTotal which returns column total and adds to MAX_VALUE.", result, Double.MAX_VALUE + 2, .000000001d);
	}

	@Test
	//For method calculateColumnTotal in Range class, testing to see if it returns the correct
	//column total for two values and subtracting from MIN_VALUE
	public void UmmeySubtractingFromNegativeMaxDoubleValue() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(2));
				allowing(values).getValue(0, 0);
				will(returnValue(-Double.MAX_VALUE));
				allowing(values).getValue(1, 0);
				will(returnValue(-5.0));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("Testing range calculateColumnTotal which returns column total and subtracts from MIN_VALUE.", result, -Double.MAX_VALUE - 5, .000000001d);
	}

	@Test
	//For method calculateColumnTotal in Range class, testing to see if it returns the correct
	//column total for two values in decimal
	public void UmmeyDecimalColumnTotal() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(2));
				allowing(values).getValue(0, 0);
				will(returnValue(0.0));
				allowing(values).getValue(1, 0);
				will(returnValue(0.1));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
		// assertEquals(String message, Object expected, Object actual)
		assertEquals("Testing range calculateColumnTotal which returns a decimal value as the column total.", result, 0.1, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	//For method calculateColumnTotal in Range class, testing to see if it returns the correct
	//column total for two values in terms of long decimal value
	public void UmmeyLongDecimalColumnTotal() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(2));
				allowing(values).getValue(0, 0);
				will(returnValue(0.00000652));
				allowing(values).getValue(1, 0);
				will(returnValue(0.00000253));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
		// assertEquals(String message, Object expected, Object actual)
		assertEquals("Testing range calculateColumnTotal which adds two long decimals as the column total.", result, 0.00000905, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	//For method calculateColumnTotal in Range class, testing to see if it returns the correct
	//column total for two long values that are mismatched 
	public void UmmeyLongMismatchDecimalColumnTotal() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(2));
				allowing(values).getValue(0, 0);
				will(returnValue(0.00000271));
				allowing(values).getValue(1, 0);
				will(returnValue(0.0000043));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
		// assertEquals(String message, Object expected, Object actual)
		assertEquals("Testing range calculateColumnTotal which adds two mismatched decimals as the column total.", result, 0.00000701, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	//For method calculateColumnTotal in Range class, testing to see if it returns the correct
	//column total for multiple valuies
	public void UmmeyMultipleColumnsColumnTotal() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(1));
				allowing(values).getValue(0, 0);
				will(returnValue(10.0));
				allowing(values).getValue(0, 1);
				will(returnValue(11.0));
				allowing(values).getValue(0, 3);
				will(returnValue(12.0));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 3);
		// verify
		// assertEquals(String message, Object expected, Object actual)
		assertEquals("Testing range calculateColumnTotal which adds multiple columns and calculates the column total.", result, 12.0, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	//For method calculateColumnTotal in Range class, testing to see if it returns the correct
	//column total for one row and null column
	public void UmmeyOneRowNullColumn() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(1));
				allowing(values).getValue(0, (int) Double.NaN);
				will(throwException(new InvalidParameterException()));
			}
		});
		
		Double result = Double.NaN;
		try {
			result = DataUtilities.calculateColumnTotal(values, (int) Double.NaN);
		} catch (InvalidParameterException e) {
			if (result.isNaN())
				assertEquals("Testing range calculateColumnTotal which has one row and null column.", Double.NaN, result, .000000001d);
			else
				fail();
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
	}

	@Test
	//For method calculateColumnTotal in Range class, testing to see if it returns the correct
	//column total for zero row and zero column
	public void UmmeyZeroRowZeroColumn() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(0));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("Testing range calculateColumnTotal which has zero row and zero column.", result, 0.0, .000000001d);
	}

	@Test
	//For method calculateColumnTotal in Range class, testing to see if it returns the correct
	//column total for zero row and two column
	public void UmmeyZeroRowsTwoColumns() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(0));
				allowing(values).getValue(0, 0);
				will(returnValue(3.0));
				allowing(values).getValue(0, 1);
				will(returnValue(2.0));
			}
		});
		Double result = Double.NaN;
		try {
			result = DataUtilities.calculateColumnTotal(values, 1);
		} catch (InvalidParameterException e) {
			if (!result.isNaN())
				assertEquals("Testing range calculateColumnTotal which has zero row and two columns.", 2.0, result, .000000001d);
			else
			{
				fail();
			}
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
	}

	@Test
	//For method calculateColumnTotal in Range class, testing to see if it returns the correct
	//column total for one row and negative column
	public void UmmeyOneRowNegativeColumn() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(1));
				allowing(values).getValue(0, -1);
				will(throwException(new InvalidParameterException()));
			}
		});
		Double result = Double.NaN;
		try {
			result = DataUtilities.calculateColumnTotal(values, -1);
		} catch (InvalidParameterException e) {
			if (!result.isNaN())
				assertEquals("Testing range calculateColumnTotal which has one row and negative column.", 0.0, result, .000000001d);
			else {
				fail();
			}
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
	}

	@Test
	//For method calculateColumnTotal in Range class, testing to see if it returns the correct
	//column total for two rows, which are in binary
	public void UmmeyBinaryRowsBinaryColumnBinaryValues() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(0b10));
				allowing(values).getValue(0, 0);
				will(returnValue(0b101));
				allowing(values).getValue(1, 0);
				will(returnValue(0b1000));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
		// assertEquals(String message, Object expected, Object actual)
		assertEquals("Testing range calculateColumnTotal which has two rows in binary.", result, 0b1101, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	//For method calculateColumnTotal in Range class, testing to see if it returns the correct
	//column total for two rows, which are in hexadecimal
	public void UmmeyHexRowsHexColumnHexValues() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(0x2));
				allowing(values).getValue(0, 0);
				will(returnValue(0xB));
				allowing(values).getValue(1, 0);
				will(returnValue(0x11));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
		// assertEquals(String message, Object expected, Object actual)
		assertEquals("Testing range calculateColumnTotal which has two rows in hexadecimal.", result, 0x1C, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	//For method calculateColumnTotal in Range class, testing to see if it returns the correct
	//column total for two negative row values
	public void UmmeyTwoNegativeValuesForColumnTotal() {
		// setup
		Mockery mockingContext = new Mockery();
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations() {
			{
				allowing(values).getRowCount();
				will(returnValue(2));
				allowing(values).getValue(0, 0);
				will(returnValue(-4.0));
				allowing(values).getValue(1, 0);
				will(returnValue(-2.0));
			}
		});
		// exercise
		double result = DataUtilities.calculateColumnTotal(values, 0);
		// verify
		// assertEquals(String message, Object expected, Object actual)
		assertEquals("Testing range calculateColumnTotal which has two negative values for rows.", result, -6.0, .000000001d);
		// tear-down: NONE in this test method
	}



	@Test 
	public void calculateRowTotalR1isNegative() {
		//setup
		omarmockingContext.checking(new Expectations() {
			{
				allowing(omarvalues).getColumnCount();
				will(returnValue(2));
				allowing(omarvalues).getValue(0,0);
				will(returnValue(-1.0));
				allowing(omarvalues).getValue(0, 1);
				will(returnValue(2.0));
			}
		});
		Double result = Double.NaN;
		Double expected = 1.0;
		try {
			result = DataUtilities.calculateRowTotal(omarvalues, 0);
		}catch(Exception e) {
			fail();
		}
		assertEquals(expected,result,0.00001d);
	}
	
	@Test
	public void calculateRowTotalEverythingNegative() {
		//setup
		omarmockingContext.checking(new Expectations() {
			{
				allowing(omarvalues).getColumnCount();
				will(returnValue(2));
				allowing(omarvalues).getValue(0, 0);
				will(returnValue(-1.0));
				allowing(omarvalues).getValue(0, 1);
				will(returnValue(-2.0));
			}
		});
		Double result = Double.NaN;
		Double expected = -3.0;
		
		try {
			result = DataUtilities.calculateRowTotal(omarvalues, 0);
		}catch(Exception e) {
			fail();
		}
		assertEquals(expected, result, 0.000001d);
	}
	@Test
	public void calculateRowTotalForNonExistingRow() {
		//setup
		omarmockingContext.checking(new Expectations() {
			{
				allowing(omarvalues).getColumnCount();
				will(returnValue(1));
				allowing(omarvalues).getValue(0, 0);
				will(returnValue(1.0));
				allowing(omarvalues).getRowCount();
				will(returnValue(1));
				allowing(omarvalues).getValue(2, 0);
				will(returnValue(null));
			}
		});
		Double result = Double.NaN;
		Double expected = 0.0;
		try {
			result = DataUtilities.calculateRowTotal(omarvalues, 2);
		}catch(InvalidParameterException e) {
			assertEquals(expected, result, 0.00000001d);
		}catch(Exception e) {
			fail();
		}
		fail();
		
	}
	
	@Test
	public void CalcColTotalNisNull() {
		omarmockingContext.checking(new Expectations() {
			{
				allowing(omarvalues).getRowCount();
				will(returnValue(2));
				allowing(omarvalues).getValue(0, 0);
				will(returnValue(null));
				allowing(omarvalues).getValue(1, 0);
				will(returnValue(3.0));
			}
		});
		double result = DataUtilities.calculateColumnTotal(omarvalues, 0);
		assertEquals(3.0, result, 0.0001d);
		
	}

	
	@Test
	public void calculateRowTotalNullTableValue() {
		// setup
		omarmockingContext.checking(new Expectations() {
			{
				one(omarvalues).getColumnCount();
				will(returnValue(2));
				one(omarvalues).getValue(0, 0);
				will(returnValue(null));
				one(omarvalues).getValue(0, 1);
				will(returnValue(3.0));
			}
		});
		Double result = Double.NaN;
		try {
			result = DataUtilities.calculateRowTotal(omarvalues, 0);
		} catch (InvalidParameterException e) {
			if (result == 0.0) {
				assertTrue(true);
			}
		} catch (Exception e) {
			fail();
		}
		if (!result.isNaN()) {
			assertEquals(0.0, result, 0.001d);
		} else {
			fail();
		}
	}

	@Test 
	public void calculateRowTotalNegativeRowPosition() throws Exception {
		// setup
		omarmockingContext.checking(new Expectations() {
			{
				one(omarvalues).getColumnCount();
				will(returnValue(2));
				one(omarvalues).getValue(0, 0);
				will(returnValue(2.0));
				one(omarvalues).getValue(0, 1);
				will(returnValue(3.0));
				one(omarvalues).getValue(-1,0);
				will(throwException(new InvalidParameterException()));
			}
		});
		Double result = Double.NaN;
		try {
			result = DataUtilities.calculateRowTotal(omarvalues, -1);
		} catch(InvalidParameterException e){
			if (!result.isNaN()) {
				assertEquals(0.0, result, 0.001d);
			} else {
				fail();
			}
		}catch(Exception e) {
			fail(e.toString());
		}
	}

	@Test
	public void calculateRowTotalLessThanDoubleMinValue() {
		// setup
		omarmockingContext.checking(new Expectations() {
			{
				one(omarvalues).getColumnCount();
				will(returnValue(2));
				one(omarvalues).getValue(0, 0);
				will(returnValue(-Double.MAX_VALUE));
				one(omarvalues).getValue(0, 1);
				will(returnValue(-2.0));
			}
		});
		Double result = Double.NaN;

		try {
			result = (Double) DataUtilities.calculateRowTotal(omarvalues, 0);
		} catch (Exception e) {
			fail();
		}
		if (!result.isNaN() && result != -Double.MAX_VALUE) {
			assertEquals((-Double.MAX_VALUE - 2.0), result, 0.001d);
		} else {
			fail();
		}
	}

	@Test
	public void calculateRowTotalBiggerThanDoubleMaxValue() {
		// setup
		omarmockingContext.checking(new Expectations() {
			{
				one(omarvalues).getColumnCount();
				will(returnValue(2));
				one(omarvalues).getValue(0, 0);
				will(returnValue(Double.MAX_VALUE));
				one(omarvalues).getValue(0, 1);
				will(returnValue(-2.0));
			}
		});
		Double result = Double.NaN;
		try {
			result = (Double) DataUtilities.calculateRowTotal(omarvalues, 0);
		} catch (Exception e) {
			fail();
		}

		// this test should fail. it is failing because Java takes shortcuts and doesn't
		// do operations properly
		// look more into it and ask the TA/prof
		if (result.isNaN()) {
			assertEquals(Double.MAX_VALUE + 2.0, result, 0.001d);
		} else {
			fail();
		}
	}

	@Test
	public void calculateRowTotalForTwoValues() {
		// setup
		omarmockingContext.checking(new Expectations() {
			{
				one(omarvalues).getColumnCount();
				will(returnValue(2));
				one(omarvalues).getValue(0, 0);
				will(returnValue(2.0));
				one(omarvalues).getValue(0, 1);
				will(returnValue(3.0));
			}
		});
		double result = DataUtilities.calculateRowTotal(omarvalues, 0);
		assertEquals(5.0, result, 0.000001d);
	}

	@Test
	public void totalRowWithZeroColumns() {
		omarmockingContext.checking(new Expectations() {
			{
				one(omarvalues).getColumnCount();
				will(returnValue(0));
			}
		});
		Double result = Double.NaN;
		try {
			result = DataUtilities.calculateRowTotal(omarvalues, 0);
		} catch (Exception e) {
			fail();
		}
		if (!result.isNaN()) {
			assertEquals(0.0, result, 0.00001d);
		} else {
			fail();
		}
	}

	@Test(expected = InvalidParameterException.class)
	public void rowStartsWithNull() {
		omarmockingContext.checking(new Expectations() {
			{
				one(omarvalues).getColumnCount();
				will(returnValue(1));
				one(omarvalues).getValue(0, 0);
				will(returnValue(Double.NaN));
				one(omarvalues).getValue(0, 1);
				will(returnValue(1.0));
			}
		});
		Double result = Double.NaN;

		result = DataUtilities.calculateRowTotal(omarvalues, 0);
	}
	
	
	
	@Test 
	public void firstParameterNull() {
		Double result = Double.NaN;
		omarvalues = null;
		try {
		result = DataUtilities.calculateRowTotal(omarvalues, 0);
		}catch(InvalidParameterException e) {
			if(!result.isNaN() && result == 0.0) {
				assertTrue(true);
			}
		}catch(Exception e){
			fail();
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void nullDataCreateNumberArray2D() {
		assertArrayEquals("it should fail and throw an IllegalArgumentException", null, DataUtilities.createNumberArray2D(null));
	}
	@Test
	public void nullKeyedValuesElementsGetCumulativePercentages() {
		omarmockingContext.checking(new Expectations() {
			{
				allowing(values).getItemCount();
				will(returnValue(1));
				allowing(values).getValue(0);
				will(returnValue(null));
				allowing(values).getKey(0);
				will(returnValue(null));
			}
		});
		assertNull("", DataUtilities.getCumulativePercentages(values));
	}
	
	@Test
	public void secondParameterNull() {
		Double result = Double.NaN;
		
		omarmockingContext.checking(new Expectations() {
			{
				one(omarvalues).getColumnCount();
				will(returnValue(2));
				one(omarvalues).getValue(0, 0);
				will(returnValue(3.0));
				one(omarvalues).getValue(0, 1);
				will(returnValue(3.0));
			}
		});
		try {
			Integer tempNull = null;
			result = DataUtilities.calculateRowTotal(omarvalues, tempNull);			
		}catch(InvalidParameterException e) {
			if(!result.isNaN() && result == 0.0) {
				assertTrue(true);
			}
		}catch(Exception e) {
			fail();
		}
	}
	
	@SuppressWarnings("null")
	@Test
	public void bothParametersNull() {
		Double result = Double.NaN;
		omarvalues = null;
		try {
			result = DataUtilities.calculateRowTotal(omarvalues, (Integer)null);
		}catch(InvalidParameterException e) {
			if (!result.isNaN() && result == 0.0) {
				assertTrue(true);
			}
		}catch(Exception e) {
			fail();
		}
	}
	

	
}
