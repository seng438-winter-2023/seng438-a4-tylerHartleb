package org.jfree.data.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.experimental.runners.Enclosed;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Enclosed.class)
public class CombineIgnoringNaNTests {
	
	@RunWith(Parameterized.class)
	public static class combineIgnoringNaNTest_parameterizedTests{
		String msg;
		Range range1;
		Range range2;
		Range expected;
		public combineIgnoringNaNTest_parameterizedTests(String msg, Range range1, Range range2, Range expected) {
			this.msg = msg;
			this.range1 = range1;
			this.range2 = range2;
			this.expected = expected;
		}
		@Parameters
		public static Collection<Object[]> data() {
			return Arrays.asList(new Object[][] {
				{"range1 = NaN Range, range2 = NaN Range, expected = null", new Range(Double.NaN, Double.NaN), new Range(Double.NaN, Double.NaN), null},
				{"range1 = [-5,0], range2 = [-2,21], expected = [-5, 21]", new Range(-5,0), new Range(-2,21), new Range(-5,21)},
				/* extra test case to increase instruction coverage of private max and min functions */
				{"range1 = [-2,20], range2 = NaN Range, expected = [-2,20]", new Range(-2,20), new Range(Double.NaN, Double.NaN), new Range(-2,20)},
			});
		}
		@Test
		public void test() {
			Range result = Range.combineIgnoringNaN(range1, range2);
			assertEquals(this.msg, this.expected, result);
		}
	}

	// added to cover additional mutants
	public static class CombineIgnoringNaN_BoundaryTests {
		@Test
		public void combineIgnoringNaN_NullRanges() {
			Range result = Range.combineIgnoringNaN(null, null);
			assertNull("Both ranges are null", result);
		}
		
		@Test
		public void combineIgnoringNaN_FirstRangeIsNull() {
			Range result = Range.combineIgnoringNaN(null, new Range(1,5));
			Range expected = new Range(1, 5);
			assertEquals("First range is null", expected, result);
		}
		
		@Test
		public void combineIgnoringNaN_SecondRangeIsNull() {
			Range result = Range.combineIgnoringNaN(new Range(10,20), null);
			Range expected = new Range(10,20);
			assertEquals("First range is null", expected, result);
		}
	}
}