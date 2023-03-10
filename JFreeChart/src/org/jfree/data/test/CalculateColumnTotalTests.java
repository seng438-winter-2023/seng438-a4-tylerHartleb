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
public class CalculateColumnTotalTests {
	@RunWith(Parameterized.class)
	public static class CalculateColumnTotal_parameterizedTests {
		private Mockery mockingContext;
		private static Values2D valuesToTest;
		
		private Function<Values2D, Expectations> expectationsBuilder;
		private double expected;
		private String message;
		
		public CalculateColumnTotal_parameterizedTests(String message, Function<Values2D, Expectations> expectationsBuilder, double expected) {
			this.message = message;
			this.expectationsBuilder = expectationsBuilder;
			this.expected = expected;
		}
		
		@Parameters
		public static Collection<Object[]> parameters() {
			List<Integer> keyList =new ArrayList<Integer>();
			keyList.add(0);
			keyList.add(1);
			keyList.add(2);
			
			// The following function below return a function that applys expectations to
			// a values2d object.
			
			// 1st test
			Function<Values2D, Expectations> bothPositive = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getRowCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(1.0));
			            one(valuesToTest).getValue(1, 0);
			            will(returnValue(1.0));
					}
				};
			};
			
			// 2nd test
			// Col 0 = positive, col 1 = negative
			Function<Values2D, Expectations> positiveNegative = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getRowCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(1.0));
			            one(valuesToTest).getValue(1, 0);
			            will(returnValue(-1.0));
					}
				};
			};
			
			// 3rd test
			// Col 0 = positive, col 1 = 0
			Function<Values2D, Expectations> positiveZero = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getRowCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(1.0));
			            one(valuesToTest).getValue(1, 0);
			            will(returnValue(0.0));
					}
				};
			};
			
			// 4th test
			// Col 0 = negative, col 1 = positive
			Function<Values2D, Expectations> negativePositive = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getRowCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(-1.0));
			            one(valuesToTest).getValue(1, 0);
			            will(returnValue(1.0));
					}
				};
			};
			
			// 5th test
			// Col 0 = negative, col 1 = negative
			Function<Values2D, Expectations> negativeNegative = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getRowCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(-1.0));
			            one(valuesToTest).getValue(1, 0);
			            will(returnValue(-1.0));
					}
				};
			};
			
			// 6th test
			// Col 0 = negative, col 1 = zero
			Function<Values2D, Expectations> negativeZero = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getRowCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(-1.0));
			            one(valuesToTest).getValue(1, 0);
			            will(returnValue(0.0));
					}
				};
			};
			
			// 7th test
			// Col 0 = zero, col 1 = positive
			Function<Values2D, Expectations> zeroPositive = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getRowCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(0.0));
			            one(valuesToTest).getValue(1, 0);
			            will(returnValue(1.0));
					}
				};
			};
			
			// 8th test
			// Col 0 = zero, col 1 = negative
			Function<Values2D, Expectations> zeroNegative = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getRowCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(0.0));
			            one(valuesToTest).getValue(1, 0);
			            will(returnValue(-1.0));
					}
				};
			};
			
			// 9th test
			// Col 0 = zero, col 1 = zero
			Function<Values2D, Expectations> zeroZero = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getRowCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(0.0));
			            one(valuesToTest).getValue(1, 0);
			            will(returnValue(0.0));
					}
				};
			};
			
			// 10th test
			// Col 0 = null, col 1 = positive
			Function<Values2D, Expectations> nullPositive = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getRowCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(null));
			            one(valuesToTest).getValue(1, 0);
			            will(returnValue(1.0));
					}
				};
			};
			
			// 11th test
			// Col 0 = null, col 1 = negative
			Function<Values2D, Expectations> nullNegative = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getRowCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(null));
			            one(valuesToTest).getValue(1, 0);
			            will(returnValue(-1.0));
					}
				};
			};
			
			// 12th test
			// Col 0 = null, col 1 = zero
			Function<Values2D, Expectations> nullZero = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getRowCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(null));
			            one(valuesToTest).getValue(1, 0);
			            will(returnValue(0.0));
					}
				};
			};
			
			// 13th test
			// Col 0 = 1.0, col 1 = null
			Function<Values2D, Expectations> positiveNull = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getRowCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(1.0));
			            one(valuesToTest).getValue(1, 0);
			            will(returnValue(null));
					}
				};
			};
			
			// 14th test
			// Col 0 = -1.0, col 1 = null
			Function<Values2D, Expectations> negativeNull = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getRowCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(-1.0));
			            one(valuesToTest).getValue(1, 0);
			            will(returnValue(null));
					}
				};
			};
			
			// 15th test
			// Col 0 = 0.0, col 1 = null
			Function<Values2D, Expectations> zeroNull = (values2D) -> {
				return new Expectations() {
					{
						one(values2D).getRowCount();
			            will(returnValue(2));
			            one(valuesToTest).getValue(0, 0);
			            will(returnValue(0.0));
			            one(valuesToTest).getValue(1, 0);
			            will(returnValue(null));
					}
				};
			};
			
			Object[][] testingData = {
					{"Col 1: 1.0 Col 2: 1.0", bothPositive, 2.0},
					{"Col 1: 1.0 Col 2: -1.0", positiveNegative, 0.0},
					{"Col 1: 1.0 Col 2: 0.0", positiveZero, 1.0},
					{"Col 1: -1.0 Col 2: 1.0", negativePositive, 0.0},
					{"Col 1: -1.0 Col 2: -1.0", negativeNegative, -2.0},
					{"Col 1: -1.0 Col 2: 0.0", negativeZero, -1.0},
					{"Col 1: 0.0 Col 2: 1.0", zeroPositive, 1.0},
					{"Col 1: 0.0 Col 2: -1.0", zeroNegative, -1.0},
					{"Col 1: 0.0 Col 2: 0.0", zeroZero, 0.0},
					{"Col 1: null Col 2: 1.0", nullPositive, 1.0},
					{"Col 1: null Col 2: -1.0", nullNegative, -1.0},
					{"Col 1: null Col 2: 0.0", nullZero, 0.0},
					{"Col 1: 1.0 Col 2: null", positiveNull, 1.0},
					{"Col 1: -1.0 Col 2: null", negativeNull, -1.0},
					{"Col 1: 0.0 Col 2: null", zeroNull, 0.0},
					
			};
			return Arrays.asList(testingData);
		}
		
		@Before
		public void setUp() throws Exception {
			// Mocking Values2D
			this.mockingContext = new Mockery();
			valuesToTest = mockingContext.mock(Values2D.class);
			
			this.mockingContext.checking(this.expectationsBuilder.apply(valuesToTest));
		}
		
		@Test
		public void calculateColumnTotal_parameters() {
			double result = DataUtilities.calculateColumnTotal(valuesToTest, 0);
			assertEquals(this.message, this.expected, result, 0.00001d);
		}
	}
	
	// Parameterized Test
	public static class CalculateColumnTotal_invalidValues2DTests {
		// This test case tests passing in a null data
		@Test(expected = IllegalArgumentException.class)
		public void calculateColumnTotal_nullData() {
			DataUtilities.calculateColumnTotal(null, 0);
		}
	}
	
	public static class CalculateColumnTotal_zeroLengthTests {
		private Mockery mockingContext;
		private Values2D valuesToTest;
		
		@Before
		public void setUp() throws Exception {
			this.mockingContext = new Mockery();
			this.valuesToTest = this.mockingContext.mock(Values2D.class);
			
			this.mockingContext.checking(new Expectations () {
				{
					allowing(valuesToTest).getRowCount();
		            will(returnValue(0));
				}	
			});
		}
		
		// This test case tests a value with a row length of 0
		@Test
		public void calculateColumnTotal_zeroLengthData() {
			assertEquals("Zero length test", 0.0, DataUtilities.calculateColumnTotal(this.valuesToTest, 0), 0.001d);
		}
	}
	
	// Boundary Cases
	public static class CalculateColumnTotal_invalidColumnTests {
		private Mockery mockingContext;
		private Values2D valuesToTest;
		
		@Before
		public void setUp() throws Exception {
			this.mockingContext = new Mockery();
			this.valuesToTest = this.mockingContext.mock(Values2D.class);
			
			this.mockingContext.checking(new Expectations() {
				{
					allowing(valuesToTest).getRowCount();
		            will(returnValue(2));
		            one(valuesToTest).getValue(0, 0);
		            will(returnValue(1.0));
		            one(valuesToTest).getValue(1, 0);
		            will(returnValue(1.0));
		            allowing(valuesToTest).getValue(0, -1);
		            will(throwException(new IndexOutOfBoundsException()));
		            allowing(valuesToTest).getValue(1, -1);
		            will(throwException(new IndexOutOfBoundsException()));
		            allowing(valuesToTest).getValue(0, 2);
		            will(throwException(new IndexOutOfBoundsException()));
		            allowing(valuesToTest).getValue(1, 2);
		            will(throwException(new IndexOutOfBoundsException()));
				}
			});
		}
		
		@Test(expected = IndexOutOfBoundsException.class)
		public void calculateColumnTotal_negativeIndex() {
			DataUtilities.calculateColumnTotal(this.valuesToTest, -1);
		}
		
		@Test(expected = IndexOutOfBoundsException.class)
		public void calculateColumnTotal_biggerIndex() {
			DataUtilities.calculateColumnTotal(this.valuesToTest, 2);
		}
	}
}
