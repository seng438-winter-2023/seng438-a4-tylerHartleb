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
public class ScaleTests {
	
	public static class scaleTest_negativeFactorTest{
		@Test(expected = IllegalArgumentException.class)
		public void test() {
			Range.scale(new Range(0,0), -1);
		}
	}
	
	@RunWith(Parameterized.class)
	public static class scaleTest_parameterizedTests{
		String msg;
		Range range;
		Range expected;
		double factor;
		public scaleTest_parameterizedTests(String msg, Range range, double factor, Range expected) {
			this.msg = msg;
			this.range = range;
			this.factor = factor;
			this.expected = expected;
		}
		@Parameters
		public static Collection<Object[]> data() {
			return Arrays.asList(new Object[][] {
				{"range = [0,0], factor = 2.2, expected = [0,0]", new Range(0,0), 2.2, new Range(0,0)},
				{"range = [1,6], factor = 6, expected = [0,0]", new Range(1,6), 6, new Range(6,36)}
			});
		}
		@Test
		public void test() {
			Range result = Range.scale(range, factor);
			assert(expected.equals(result));
		}
	}

}
