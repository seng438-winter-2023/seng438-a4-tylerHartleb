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
public class CombineTests {
	
	@RunWith(Parameterized.class)
	public static class combineTest_parameterizedTests{
		String msg;
		Range range1;
		Range range2;
		Range expected;
		public combineTest_parameterizedTests(String msg, Range range1, Range range2, Range expected) {
			this.msg = msg;
			this.range1 = range1;
			this.range2 = range2;
			this.expected = expected;
		}
		@Parameters
		public static Collection<Object[]> data() {
			return Arrays.asList(new Object[][] {
				{"range1 = null, range2 = [1,5], expected = [1,5]", null, new Range(1,5), new Range(1,5)},
				{"range1 = [-5,20], range2 = null, expected = [-5,20]", new Range(-5,20), null, new Range(-5,20)},
				{"range1 = [-5,0], range2 = [2, 24], expected = [-5,24]", new Range(-5,20), new Range(2,24), new Range(-5,24)},
				{"range1 = null, range2 = null, expected = null", null, null, null}
				
			});
		}
		@Test
		public void test() {
			Range result = Range.combine(range1, range2);
			if(expected == null)
			{
				assert(result == null);
			}
			else {
			assert(expected.equals(result));
			}		}
	}

}
