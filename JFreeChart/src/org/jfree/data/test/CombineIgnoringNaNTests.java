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
				{"range1 = null, range2 = NaN Range, expected = null", null, new Range(Double.NaN,Double.NaN), null},
				{"range1 = NaN Range, range2 = null, expected = null", new Range(Double.NaN,Double.NaN), null, null},
				{"range1 = null, range2 = [1,5], expected = [1,5]", null, new Range(1,5), new Range(1,5)},
				{"range1 = [10,20]. range2 = null, expected  = [5,20]", new Range(10,20), null, new Range(10,20)},
				{"range1 = NaN Range, range2 = NaN Range, expected = null", new Range(Double.NaN,Double.NaN), new Range(Double.NaN,Double.NaN), null},
				{"range1 = [-5,0], range2 = [-2,21], expected = [-5, 21]", new Range(-5,0), new Range(-2,21), new Range(-5,21)},
				/* extra test case to increase instruction coverage of private max and min functions */
				{"range1 = [-2,20], range2 = NaN Range, expected = [-2,20]", new Range(-2,20), new Range(Double.NaN,Double.NaN), new Range(-2,20)},
			});
		}
		@Test
		public void test() {
			Range result = Range.combineIgnoringNaN(range1, range2);
			if(expected == null) {
				assert(result == null);
			}
			else {
				assert(expected.equals(result));	
			}
		}
	}

}