/**
 * 
 */
package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
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
public class DataUtilitiesTest {

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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void calculateColumnTotalForTwoValues() {
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
		assertEquals(result, 10.0, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void zeroColumnTotal() {
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
		assertEquals(result, 0.0, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void negativeColumnTotal() {
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
		assertEquals(result, -2.0, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void nullValuesColumnTotal() {
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
			assertTrue(true);
		}
	}

	@Test
	public void addingToMaxDoubleValue() {
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
		assertEquals(result, Double.MAX_VALUE + 2, .000000001d);
	}

	@Test
	public void subtractingFromNegativeMaxDoubleValue() {
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
		assertEquals(result, -Double.MAX_VALUE - 5, .000000001d);
	}

	@Test
	public void decimalColumnTotal() {
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
		assertEquals(result, 0.1, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void longDecimalColumnTotal() {
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
		assertEquals(result, 0.00000905, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void longMismatchDecimalColumnTotal() {
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
		assertEquals(result, 0.00000701, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void multipleColumnsColumnTotal() {
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
		assertEquals(result, 12.0, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void oneRowNullColumn() {
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
				assertEquals(Double.NaN, result, .000000001d);
			else
				fail();
		}
		catch (Exception e)
		{
			fail(e.toString());
		}
	}

	@Test
	public void zeroRowZeroColumn() {
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
		assertEquals(result, 0.0, .000000001d);
	}

	@Test
	public void zeroRowsTwoColumns() {
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
				assertEquals(2.0, result, .000000001d);
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
	public void oneRowNegativeColumn() {
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
				assertEquals(0.0, result, .000000001d);
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
	public void binaryRowsBinaryColumnBinaryValues() {
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
		assertEquals(result, 0b1101, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void hexRowsHexColumnHexValues() {
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
		assertEquals(result, 0x1C, .000000001d);
		// tear-down: NONE in this test method
	}

	@Test
	public void twoNegativeValuesForColumnTotal() {
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
		assertEquals(result, -6.0, .000000001d);
		// tear-down: NONE in this test method
	}
}
