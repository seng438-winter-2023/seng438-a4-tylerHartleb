package org.jfree.data.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.jfree.data.Range;

@RunWith(Enclosed.class)
public class ExpandTest {
	
	// equal() function to compare the two Range objects
	public static boolean equal(Range r1, Range r2) {
		if (r1.getLength() == r2.getLength()) {
			if (r1.getLowerBound() == r2.getLowerBound()) {
				return true;
			}
		}
		return false;
	}

	@RunWith(Parameterized.class)
	public static class ExpandTest_parameterizedTests {
		private String message;
		private double lower;
		private double upper;
		private Range expected; 
		
		// Default Range object to be used in the test
		private Range range = new Range (0.0, 100.0);
		
		public ExpandTest_parameterizedTests(String message, double lower, double upper, Range expected) {
			this.message = message;
			this.lower = lower;
			this.upper = upper;
			this.expected = expected;
		}
		
		@Parameters
		public static Collection<Object[]> parameters() {
			
			Object[][] testingData = {
					{"lowerMargin = 1, upperMargin = 1", 1, 1, new Range(-100, 200)},
					{"lowerMargin = 1, upperMargin = 0.9", 1, 0.9, new Range(-100, 190)},
					{"lowerMargin = 1, upperMargin = 0.5", 1, 0.5, new Range(-100, 150)},
					{"lowerMargin = 1, upperMargin = 0.1", 1, 0.1, new Range(-100, 110)},
					{"lowerMargin = 1, upperMargin = 0", 1, 0, new Range(-100, 100)},
					{"lowerMargin = 0.5, upperMargin = -0.1", 0.5, -0.1, new Range(-50, 90)},
					{"lowerMargin = 0.5, upperMargin = 1.1", 0.5, 1.1, new Range(-50, 110)},
					{"lowerMargin = 0.9, upperMargin = 1", 0.9, 1, new Range(-90, 200)},
					{"lowerMargin = 0.5, upperMargin = 1", 0.5, 1, new Range(-50, 200)},
					{"lowerMargin = 0.1, upperMargin = 1", 0.1, 1, new Range(-10, 200)},
					{"lowerMargin = 0, upperMargin = 1", 0, 1, new Range(0, 200)},
					{"lowerMargin = -0.1, upperMargin = 0.5", -0.1, 0.5, new Range(10, 150)},
					{"lowerMargin = 1.1, upperMargin = 0.5", 1.1, 0.5, new Range(-110, 150)},
					{"lowerMargin = -1, upperMargin = -0.5", -1, -0.5, new Range(0, 10)}, // new case added to simulate a situation where lower > upper during the expansion
			};
			return Arrays.asList(testingData);
		} 
		
		@Test
		public void expand_inRangeTest() {
			Range actualRange = Range.expand(this.range, this.lower, this.upper);
			// System.out.println("expected: " + this.expected.getLength() + " lowerbound: " + this.expected.getLowerBound());
			// System.out.println("actual: " + actualRange.getLength() + " lowerbound: " + actualRange.getLowerBound());
			// System.out.println("equal? " + equal(actualRange, this.expected));
			assertEquals(message, true, equal(this.expected, actualRange));
		}
	}
	
//	public static class ExpandTest_InvalidParameterExceptionTests{
//		
//		@Test // InvalidParameterException is thrown if null Range object is passed in
//		public void expand_nullRange() {
//			Range actualRange = Range.expand(null, 0.5, 0.5);
//			assertEquals("null Range is passed ", true, equal(null, actualRange));	
//		}
//	}

}
