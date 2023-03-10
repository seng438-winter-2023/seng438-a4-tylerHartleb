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
public class ShiftTests {
	
	public static class shiftTest_2ArgTest{
		@Test
		public void test() {
			Range expected = new Range(3.2,12.2);
			Range result = Range.shift(new Range(1,10), 2.2);
			assert(expected.equals(result));
		}
	};
	
	@RunWith(Parameterized.class)
	public static class shiftTest_parameterizedTests{
		String msg;
		Range range;
		boolean allowZeroCrossing;
		double delta;
		Range expected;
		public shiftTest_parameterizedTests(String msg, Range range, boolean allowZeroCrossing, double delta, Range expected) {
			this.msg = msg;
			this.range = range;
			this.delta = delta;
			this.allowZeroCrossing = allowZeroCrossing;
			this.expected = expected;
		}
		@Parameters
		public static Collection<Object[]> data() {
			return Arrays.asList(new Object[][] {
				{"range = [1,6], delta = 1.3, allowZeroCrossing = true, expected = [2.3,7.3]", new Range(1,6), true, 1.3, new Range(2.3,7.3)},
				{"range = [0,0], delta = 2.2, allowZeroCrossing = false, expected = [2.2,2.2]", new Range(0,0), false, 2.2, new Range(2.2,2.2)},
				{"range = [-20, -5], delta = 1.45, allowZeroCrossing = false, expected = [-18.55,-3.55]", new Range(-20,-5), false, 1.45, new Range(-18.55,-3.55)}
			});
		}
		@Test
		public void test() {
			Range result = Range.shift(range, delta, allowZeroCrossing);
			assert(expected.equals(result));
		}
	}

}
