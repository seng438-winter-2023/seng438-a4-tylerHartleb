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
public class GetCentralValueTest {
	@RunWith(Parameterized.class)
	public static class GetCentralValueTest_parameterizedTests {
		private Range rangeToTest;
		private double expected;
		private String message;
		
		public GetCentralValueTest_parameterizedTests(String message, Range range, double expected) {
			this.message = message;
			this.rangeToTest = range;
			this.expected = expected;
		}
		
		@Parameters
		public static Collection<Object[]> parameters() {
			BiFunction<Double, Double, Double> getMidPoint = (d1, d2) -> {
				return (d1 + d2) / 2;
			};
			
			Object[][] testingData = {
				// Equivalence Classes
				{"Range(-2.0 to -1.0)", new Range(-2.0, -1.0), -1.50},
				{"Range(-1.0 to 2.0)", new Range(-1.0, 2.0), 0.50},
				{"Range(1.0 to 2.0)", new Range(1.0, 2.0), 1.50},
				{"Range(0.0 to 2.0)", new Range(0.0, 2.0), 1.0},
				{"Range(-1.0 to 0.0)", new Range(-1.0, 0.0), -.50},
				{"Range(0.0 to 0.0)", new Range(0.0, 0.0), 0},
				{"Range(0.0 to Double.MAX_VALUE)", new Range(0.0, Double.MAX_VALUE), getMidPoint.apply(0.0, Double.MAX_VALUE)},
				// Boundary tests
				{"Range(Double.MAX_VALUE to Double.MAX_VALUE)", new Range(Double.MAX_VALUE, Double.MAX_VALUE), Double.MAX_VALUE},
				{"Range(-Double.MAX_VALUE to Double.MAX_VALUE)", new Range(-Double.MAX_VALUE, Double.MAX_VALUE), getMidPoint.apply(-Double.MAX_VALUE, Double.MAX_VALUE)},
				{"Range(-Double.MIN_VALUE to Double.MAX_VALUE)", new Range(-Double.MIN_VALUE, Double.MAX_VALUE), getMidPoint.apply(-Double.MIN_VALUE, Double.MAX_VALUE)},
				{"Range(Double.MIN_VALUE to Double.MAX_VALUE)", new Range(Double.MIN_VALUE, Double.MAX_VALUE), getMidPoint.apply(Double.MIN_VALUE, Double.MAX_VALUE)},
				{"Range(-Double.MAX_VALUE to -Double.MAX_VALUE)", new Range(-Double.MAX_VALUE, -Double.MAX_VALUE), -Double.MAX_VALUE},
				{"Range(Double.NEGATIVE_INFINITY to -Double.MAX_VALUE)", new Range(Double.NEGATIVE_INFINITY, -Double.MAX_VALUE), getMidPoint.apply(Double.NEGATIVE_INFINITY, -Double.MAX_VALUE)},
				{"Range(0.0 to Double.MIN_VALUE)", new Range(0.0, Double.MIN_VALUE), getMidPoint.apply(0.0, Double.MIN_VALUE)},
				{"Range(-Double.MIN_VALUE to Double.MIN_VALUE)", new Range(-Double.MIN_VALUE, Double.MIN_VALUE), getMidPoint.apply(-Double.MIN_VALUE, Double.MIN_VALUE)},
				{"Range(-Double.MIN_VALUE to -Double.MIN_VALUE)", new Range(-Double.MIN_VALUE, -Double.MIN_VALUE), -Double.MIN_VALUE},
				{"Range(0.0 to Double.POSITIVE_INFINITY)", new Range(0.0, Double.POSITIVE_INFINITY), Double.POSITIVE_INFINITY},
				{"Range(Double.NEGATIVE_INFINITY to Double.NEGATIVE_INFINITY)", new Range(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY), Double.NEGATIVE_INFINITY},
			};
			return Arrays.asList(testingData);
		}
		
		// Parameterized test that tests central values in a range against the expected
		@Test
		public void getCentralValue_inRangeTest() {
			assertEquals(this.message, this.expected, this.rangeToTest.getCentralValue(), 0.0001d);
		}
	}
}
