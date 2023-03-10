package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class GetCumulativePercentagesTest {
	@RunWith(Parameterized.class)
	public static class GetCumulativePercentages_parameterizedTests {
		private Mockery mockingContext;
		private static KeyedValues valuesToTest;
		
		private String message;
		private Function<KeyedValues, Expectations> expectationsBuilder;
		private ArrayList<Double> expected;
		
		public GetCumulativePercentages_parameterizedTests(String message, Function<KeyedValues, Expectations> expectations, ArrayList<Double> expected) {
			this.message = message;
			this.expectationsBuilder = expectations;
			this.expected = expected;
		}
		
		@Parameters
		public static Collection<Object[]> parameters() {
			List<Integer> keyList =new ArrayList<Integer>();
			keyList.add(0);
			keyList.add(1);
			keyList.add(2);
			
			// The following functions return a function that applies
			// an expectations object to a KeyedValues object
			// This is used for mocking
			
			// 1st parameter
			// This tests normal values for all values
			Function<KeyedValues, Expectations> positiveValues = (keyedValue) -> {
				return new Expectations() {
					{
						allowing(keyedValue).getItemCount();
						will(returnValue(3));
						oneOf(keyedValue).getKeys();
						will(returnValue(keyList));
						// First key
						oneOf(keyedValue).getKey(0);
						will(returnValue(0));
						oneOf(keyedValue).getIndex(0);
						will(returnValue(0));
						allowing(keyedValue).getValue(0);
						will(returnValue(5));
						// Second Key
						oneOf(keyedValue).getKey(1);
						will(returnValue(1));
						oneOf(keyedValue).getIndex(1);
						will(returnValue(1));
						allowing(keyedValue).getValue(1);
						will(returnValue(9));
						// Third key
						oneOf(keyedValue).getKey(2);
						will(returnValue(2));
						oneOf(keyedValue).getIndex(2);
						will(returnValue(2));
						allowing(keyedValue).getValue(2);
						will(returnValue(2));
					}
				};
			};
			
			List<Double> positiveValuesExpected = new ArrayList<Double>();
			positiveValuesExpected.add(0.3125);
			positiveValuesExpected.add(0.875);
			positiveValuesExpected.add(1.0);
			
			// 2nd parameter
			// This uses normal values for the first two values and the last value is zero
			Function<KeyedValues, Expectations> lastValueIsZero = (keyedValue) -> {
				return new Expectations() {
					{
						allowing(keyedValue).getItemCount();
						will(returnValue(3));
						oneOf(keyedValue).getKeys();
						will(returnValue(keyList));
						// First key
						oneOf(keyedValue).getKey(0);
						will(returnValue(0));
						oneOf(keyedValue).getIndex(0);
						will(returnValue(0));
						allowing(keyedValue).getValue(0);
						will(returnValue(5));
						// Second Key
						oneOf(keyedValue).getKey(1);
						will(returnValue(1));
						oneOf(keyedValue).getIndex(1);
						will(returnValue(1));
						allowing(keyedValue).getValue(1);
						will(returnValue(5));
						// Third key
						oneOf(keyedValue).getKey(2);
						will(returnValue(2));
						oneOf(keyedValue).getIndex(2);
						will(returnValue(2));
						allowing(keyedValue).getValue(2);
						will(returnValue(0));
					}
				};
			};
			
			List<Double> lastValueIsZeroExpected = new ArrayList<Double>();
			lastValueIsZeroExpected.add(0.5);
			lastValueIsZeroExpected.add(1.0);
			lastValueIsZeroExpected.add(1.0);
			
			// 3rd parameter
			// All values in this test are set to zero
			Function<KeyedValues, Expectations> allValuesZero = (keyedValue) -> {
				return new Expectations() {
					{
						allowing(keyedValue).getItemCount();
						will(returnValue(3));
						oneOf(keyedValue).getKeys();
						will(returnValue(keyList));
						// First key
						oneOf(keyedValue).getKey(0);
						will(returnValue(0));
						oneOf(keyedValue).getIndex(0);
						will(returnValue(0));
						allowing(keyedValue).getValue(0);
						will(returnValue(0));
						// Second Key
						oneOf(keyedValue).getKey(1);
						will(returnValue(1));
						oneOf(keyedValue).getIndex(1);
						will(returnValue(1));
						allowing(keyedValue).getValue(1);
						will(returnValue(0));
						// Third key
						oneOf(keyedValue).getKey(2);
						will(returnValue(2));
						oneOf(keyedValue).getIndex(2);
						will(returnValue(2));
						allowing(keyedValue).getValue(2);
						will(returnValue(0));
					}
				};
			};
			
			List<Double> allValuesZeroExpected = new ArrayList<Double>();
			allValuesZeroExpected.add(1.0);
			allValuesZeroExpected.add(1.0);
			allValuesZeroExpected.add(1.0);
			
			// 4th parameter
			// This test uses normal values for the first two and a negative value for the last
			Function<KeyedValues, Expectations> lastValueIsNegative = (keyedValue) -> {
				return new Expectations() {
					{
						allowing(keyedValue).getItemCount();
						will(returnValue(3));
						oneOf(keyedValue).getKeys();
						will(returnValue(keyList));
						// First key
						oneOf(keyedValue).getKey(0);
						will(returnValue(0));
						oneOf(keyedValue).getIndex(0);
						will(returnValue(0));
						allowing(keyedValue).getValue(0);
						will(returnValue(5));
						// Second Key
						oneOf(keyedValue).getKey(1);
						will(returnValue(1));
						oneOf(keyedValue).getIndex(1);
						will(returnValue(1));
						allowing(keyedValue).getValue(1);
						will(returnValue(5));
						// Third key
						oneOf(keyedValue).getKey(2);
						will(returnValue(2));
						oneOf(keyedValue).getIndex(2);
						will(returnValue(2));
						allowing(keyedValue).getValue(2);
						will(returnValue(-5));
					}
				};
			};
			
			List<Double> lastValueIsNegativeExpected = new ArrayList<Double>();
			lastValueIsNegativeExpected.add(5.0 / 15.0);
			lastValueIsNegativeExpected.add(10.0 / 15.0);
			lastValueIsNegativeExpected.add(1.0);
			
			// 4th parameter
			// This test uses normal values for the first two and a negative value for the last
			Function<KeyedValues, Expectations> lastValueIsNull = (keyedValue) -> {
				return new Expectations() {
					{
						allowing(keyedValue).getItemCount();
						will(returnValue(3));
						oneOf(keyedValue).getKeys();
						will(returnValue(keyList));
						// First key
						oneOf(keyedValue).getKey(0);
						will(returnValue(0));
						oneOf(keyedValue).getIndex(0);
						will(returnValue(0));
						allowing(keyedValue).getValue(0);
						will(returnValue(5));
						// Second Key
						oneOf(keyedValue).getKey(1);
						will(returnValue(1));
						oneOf(keyedValue).getIndex(1);
						will(returnValue(1));
						allowing(keyedValue).getValue(1);
						will(returnValue(5));
						// Third key
						oneOf(keyedValue).getKey(2);
						will(returnValue(2));
						oneOf(keyedValue).getIndex(2);
						will(returnValue(2));
						allowing(keyedValue).getValue(2);
						will(returnValue(null));
					}
				};
			};
			
			List<Double> lastValueIsNullExpected = new ArrayList<Double>();
			lastValueIsNullExpected.add(0.5);
			lastValueIsNullExpected.add(1.0);
			lastValueIsNullExpected.add(1.0);
			
			
			
			Object[][] testingData = {
					{"All positive values", positiveValues, positiveValuesExpected},
					{"Last value is zero", lastValueIsZero, lastValueIsZeroExpected},
					{"All values are zero", allValuesZero, allValuesZeroExpected},
					{"last value is negative", lastValueIsNegative, lastValueIsNegativeExpected},
					{"last value is null", lastValueIsNull, lastValueIsNullExpected}
			};
			return Arrays.asList(testingData);
		}

		@Before
		public void setUp() throws Exception {
			// Mocking object
			mockingContext = new Mockery();
			valuesToTest = mockingContext.mock(KeyedValues.class);
			
			mockingContext.checking(this.expectationsBuilder.apply(valuesToTest));
		}
		
		@After
		public void tearDown() throws Exception {
			mockingContext = null;
			valuesToTest = null;
		}
		
		// We have three tests where we test each row in KeyedValues
		
		@Test
		public void getCumulativePercentages_key0() {
			// this test cases tests the first key result
			KeyedValues result = DataUtilities.getCumulativePercentages(valuesToTest);
			assertEquals(this.message, this.expected.get(0), result.getValue(0));
		}
		
		@Test
		public void getCumulativePercentages_key1() {
			// this test cases tests the second key result
			KeyedValues result = DataUtilities.getCumulativePercentages(valuesToTest);
			assertEquals(this.message, this.expected.get(1), result.getValue(1));
		}
		
		@Test
		public void getCumulativePercentages_key2() {
			// this test cases tests the third key result
			KeyedValues result = DataUtilities.getCumulativePercentages(valuesToTest);
			assertEquals(this.message, this.expected.get(2), result.getValue(2));
		}
	}
	
	public static class GetCumulativePercentages_boundaryTests {
		// This tests passing in a null object into the function
		@Test(expected = IllegalArgumentException.class)
		public void getCumulativePercentages_nullData() {
			DataUtilities.getCumulativePercentages(null);
		}
		
		// this tests passing in an empty object
		@Test
		public void getCumulativePercentages_emptyData() {
			KeyedValues emptyValues = new DefaultKeyedValues();
			KeyedValues result = DataUtilities.getCumulativePercentages(emptyValues);
			assertEquals("Empty data test", 0, result.getItemCount());
		}
	}
}
