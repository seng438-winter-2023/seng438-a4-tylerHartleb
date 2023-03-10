package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class CalculateRowTotalTests {
	@RunWith(Parameterized.class)
	public static class CalculateRowTotal_parameterizedTests {
		private Mockery mockingContext;
		private static Values2D valuesToTest;
		
		private Function<Values2D, Expectations> expectationsBuilder;
		private double expected;
		private String message;
		
		public CalculateRowTotal_parameterizedTests(String message, Function<Values2D, Expectations> expectationsBuilder, double expected) {
			this.message = message;
			this.expectationsBuilder = expectationsBuilder;
			this.expected = expected;
		}
		
		// Parameters to test equivilance classes for calculateRowTotal()
		@Parameters
		public static Collection<Object[]> parameters() {
			List<Integer> keyList =new ArrayList<Integer>();
			keyList.add(0);
			keyList.add(1);
			keyList.add(2);
			
			// 1st test
			Function<Values2D, Expectations> bothPositive = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getColumnCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(1.0));
			            one(valuesToTest).getValue(0, 1);
			            will(returnValue(1.0));
					}
				};
			};
			
			// 2nd test
			// Row 0 = positive, Row 1 = negative
			Function<Values2D, Expectations> positiveNegative = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getColumnCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(1.0));
			            one(valuesToTest).getValue(0, 1);
			            will(returnValue(-1.0));
					}
				};
			};
			
			// 3rd test
			// Row 0 = positive, Row 1 = 0
			Function<Values2D, Expectations> positiveZero = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getColumnCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(1.0));
			            one(valuesToTest).getValue(0, 1);
			            will(returnValue(0.0));
					}
				};
			};
			
			// 4th test
			// Row 0 = negative, Row 1 = positive
			Function<Values2D, Expectations> negativePositive = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getColumnCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(-1.0));
			            one(valuesToTest).getValue(0, 1);
			            will(returnValue(1.0));
					}
				};
			};
			
			// 5th test
			// Row 0 = negative, Row 1 = negative
			Function<Values2D, Expectations> negativeNegative = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getColumnCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(-1.0));
			            one(valuesToTest).getValue(0, 1);
			            will(returnValue(-1.0));
					}
				};
			};
			
			// 6th test
			// Row 0 = negative, Row 1 = zero
			Function<Values2D, Expectations> negativeZero = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getColumnCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(-1.0));
			            one(valuesToTest).getValue(0, 1);
			            will(returnValue(0.0));
					}
				};
			};
			
			// 7th test
			// Row 0 = zero, Row 1 = positive
			Function<Values2D, Expectations> zeroPositive = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getColumnCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(0.0));
			            one(valuesToTest).getValue(0, 1);
			            will(returnValue(1.0));
					}
				};
			};
			
			// 8th test
			// Row 0 = zero, Row 1 = negative
			Function<Values2D, Expectations> zeroNegative = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getColumnCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(0.0));
			            one(valuesToTest).getValue(0, 1);
			            will(returnValue(-1.0));
					}
				};
			};
			
			// 9th test
			// Row 0 = zero, Row 1 = zero
			Function<Values2D, Expectations> zeroZero = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getColumnCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(0.0));
			            one(valuesToTest).getValue(0, 1);
			            will(returnValue(0.0));
					}
				};
			};
			
			// 10th test
			// Row 0 = null, Row 1 = positive
			Function<Values2D, Expectations> nullPositive = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getColumnCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(null));
			            one(valuesToTest).getValue(0, 1);
			            will(returnValue(1.0));
					}
				};
			};
			
			// 11th test
			// Row 0 = null, Row 1 = negative
			Function<Values2D, Expectations> nullNegative = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getColumnCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(null));
			            one(valuesToTest).getValue(0, 1);
			            will(returnValue(-1.0));
					}
				};
			};
			
			// 12th test
			// Row 0 = null, Row 1 = zero
			Function<Values2D, Expectations> nullZero = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getColumnCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(null));
			            one(valuesToTest).getValue(0, 1);
			            will(returnValue(0.0));
					}
				};
			};
			
			// 13th test
			// Row 0 = 1.0, Row 1 = null
			Function<Values2D, Expectations> positiveNull = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getColumnCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(1.0));
			            one(valuesToTest).getValue(0, 1);
			            will(returnValue(null));
					}
				};
			};
			
			// 14th test
			// Row 0 = -1.0, Row 1 = null
			Function<Values2D, Expectations> negativeNull = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getColumnCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(-1.0));
			            one(valuesToTest).getValue(0, 1);
			            will(returnValue(null));
					}
				};
			};
			
			// 15th test
			// Row 0 = 0.0, Row 1 = null
			Function<Values2D, Expectations> zeroNull = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getColumnCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(0.0));
			            one(valuesToTest).getValue(0, 1);
			            will(returnValue(null));
					}
				};
			};
			// testing data for the paramatarized tests
			Object[][] testingData = {
					{"Row 1: 1.0 Row 2: 1.0", bothPositive, 2.0},
					{"Row 1: 1.0 Row 2: -1.0", positiveNegative, 0.0},
					{"Row 1: 1.0 Row 2: 0.0", positiveZero, 1.0},
					{"Row 1: -1.0 Row 2: 1.0", negativePositive, 0.0},
					{"Row 1: -1.0 Row 2: -1.0", negativeNegative, -2.0},
					{"Row 1: -1.0 Row 2: 0.0", negativeZero, -1.0},
					{"Row 1: 0.0 Row 2: 1.0", zeroPositive, 1.0},
					{"Row 1: 0.0 Row 2: -1.0", zeroNegative, -1.0},
					{"Row 1: 0.0 Row 2: 0.0", zeroZero, 0.0},
					{"Row 1: null Row 2: 1.0", nullPositive, 1.0},
					{"Row 1: null Row 2: -1.0", nullNegative, -1.0},
					{"Row 1: null Row 2: 0.0", nullZero, 0.0},
					{"Row 1: 1.0 Row 2: null", positiveNull, 1.0},
					{"Row 1: -1.0 Row 2: null", negativeNull, -1.0},
					{"Row 1: 0.0 Row 2: null", zeroNull, 0.0},
					
			};
			return Arrays.asList(testingData);
		}
		
		// We need to mock the Values2D class
		@Before
		public void setUp() throws Exception {
			this.mockingContext = new Mockery();
			valuesToTest = mockingContext.mock(Values2D.class);
			
			this.mockingContext.checking(this.expectationsBuilder.apply(valuesToTest));
		}
		// Test for calculateRowTotal() paramaterized tests
		@Test
		public void calculateRowTotal_parameters() {
			double result = DataUtilities.calculateRowTotal(valuesToTest, 0);
			assertEquals(this.message, this.expected, result, 0.00001d);
		}
	}
	// Test for invalid Values2D ctype as input to the method
	public static class CalculateRowTotal_invalidValues2DTests {
		// This test case tests passing in a null data
		@Test(expected = InvalidParameterException.class)
		public void calculateRowTotal_nullData() {
			DataUtilities.calculateRowTotal(null, 0);
		}
	}
	
	public static class CalculateRowTotal_zeroLengthTests {
		private Mockery mockingContext;
		private Values2D valuesToTest;
		
		@Before
		public void setUp() throws Exception {
			this.mockingContext = new Mockery();
			this.valuesToTest = this.mockingContext.mock(Values2D.class);
			
			this.mockingContext.checking(new Expectations () {
				{
					allowing(valuesToTest).getColumnCount();
		            will(returnValue(0));
				}	
			});
		}
		
		// This test case tests a value with a column length of 0
		@Test
		public void calculateRowTotal_zeroLengthData() {
			assertEquals("Zero length test", 0.0, DataUtilities.calculateRowTotal(this.valuesToTest, 0), 0.001d);
		}
	}
	
	// Test for if an invalid row index is given as input to the method
	public static class CalculateRowTotal_invalidRowTests {
		private Mockery mockingContext;
		private Values2D valuesToTest;
		
		@Before
		public void setUp() throws Exception {
			this.mockingContext = new Mockery();
			this.valuesToTest = this.mockingContext.mock(Values2D.class);
			
			this.mockingContext.checking(new Expectations() {
				{
					allowing(valuesToTest).getColumnCount();
		            will(returnValue(2));
		            one(valuesToTest).getValue(0, 0);
		            will(returnValue(1.0));
		            one(valuesToTest).getValue(0, 1);
		            will(returnValue(1.0));
		            allowing(valuesToTest).getValue(-1, 0);
		            will(throwException(new IndexOutOfBoundsException()));
		            allowing(valuesToTest).getValue(-1, 1);
		            will(throwException(new IndexOutOfBoundsException()));
		            allowing(valuesToTest).getValue(2, 0);
		            will(throwException(new IndexOutOfBoundsException()));
		            allowing(valuesToTest).getValue(2, 1);
		            will(throwException(new IndexOutOfBoundsException()));
				}
			});
		}
		// Tests if input index for a row is negative
		@Test
		public void calculateRowTotal_negativeIndex() {
			double result = DataUtilities.calculateRowTotal(this.valuesToTest, -1);
			assertEquals("Testing a negative row value", 0.0, result, 0.00001d);
		}
		// tests for if input index for a row is larger than the number of rows in input Values2D type
		@Test
		public void calculateRowTotal_biggerIndex() {
			double result = DataUtilities.calculateRowTotal(this.valuesToTest, 2);
			assertEquals("Testing a row value that is longer than the length of Values2D", 0.0, result, 0.00001d);
		}
	}
}

