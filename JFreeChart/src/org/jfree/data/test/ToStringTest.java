package org.jfree.data.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.BiFunction;

import org.jfree.data.Range;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class ToStringTest {
	@RunWith(Parameterized.class)
	public static class ToStringTest_parameterizedTests {
		private Range rangeToTest;
		private String expected;
		private String message;
		
		public ToStringTest_parameterizedTests(String message, Range range, String expected) {
			this.message = message;
			this.rangeToTest = range;
			this.expected = expected;
		}
		
		@Parameters
		public static Collection<Object[]> parameters() {
			BiFunction<Double, Double, String> toString = (d1, d2) -> {
				return "Range["+d1+","+d2+"]";
			};
			
			// testing data used to test all equivilance classes for method toString()
			Object[][] testingData = {
				{"Range between 0.0 to 0.0", new Range(0.0, 0.0), "Range[0.0,0.0]"},
				{"Range between 0.0 to 1.0", new Range(0.0, 1.0), "Range[0.0,1.0]"},
				{"Range between -1.0 to 1.0", new Range(-1.0, 1.0), "Range[-1.0,1.0]"},
				{"Range between 1.0 to 1.0", new Range(1.0, 1.0), "Range[1.0,1.0]"},
				{"Range between 0.0 to Double.MAX_VALUE", new Range(0.0, Double.MAX_VALUE), toString.apply(0.0, Double.MAX_VALUE)},
				{"Range between 0.0 to Double.MIN_VALUE", new Range(0.0, Double.MIN_VALUE), toString.apply(0.0, Double.MIN_VALUE)},
				{"Range between -Double.MAX_VALUE to Double.MAX_VALUE", new Range(-Double.MAX_VALUE, Double.MAX_VALUE), toString.apply(-Double.MAX_VALUE, Double.MAX_VALUE)},
				{"Range between Double.MIN_VALUE to Double.MAX_VALUE", new Range(Double.MIN_VALUE, Double.MAX_VALUE), toString.apply(Double.MIN_VALUE, Double.MAX_VALUE)},
				{"Range between Double.NEGATIVE_INFINITY to Double.POSITIVE_INFINITY", new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY), toString.apply(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)},
				{"Range between 0.0 to Double.POSITIVE_INFINITY", new Range(0.0, Double.POSITIVE_INFINITY), toString.apply(0.0, Double.POSITIVE_INFINITY)},
				{"Range between Double.NEGATIVE_INFINITY to 0.0", new Range(Double.NEGATIVE_INFINITY, 0.0), toString.apply(Double.NEGATIVE_INFINITY, 0.0)}
			};
			return Arrays.asList(testingData);
		}
		
		// Test for method toString(), checking to see if expected string matches actual string created.
		@Test
		public void toString_inRangeTest() {
			assertEquals(this.message, this.expected, this.rangeToTest.toString());
		}
	}
}
