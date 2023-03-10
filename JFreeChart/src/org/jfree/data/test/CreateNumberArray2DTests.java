package org.jfree.data.test;
import java.security.InvalidParameterException ;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.jfree.data.DataUtilities;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class CreateNumberArray2DTests {
	/*
	 * This test class is responsible for 
	 * testing the method when it is called with null argument. 
	 * This is test partition DAU1.
	 * */
	public static class CreateNumberArray2_boundryTest {
		@Test(expected = InvalidParameterException.class)
		public void test() {
			DataUtilities.createNumberArray2D(null);
			fail("InvalidParameterException not thrown.");
		}
	}
	
	
	/*
	 * The following parameterized test class is responsible for covering the DAE1, DAE2, and DAE3 test partitions. */
	@RunWith(Parameterized.class)
	public static class CreateNumberArray2D_parameterizedTests {
		double[][] arg;
		Number[][] expected;
		String msg;

		public CreateNumberArray2D_parameterizedTests(double[][] initial, Number[][] expected, String msg) {
			this.arg = initial;
			this.expected = expected;
			this.msg = msg;
		}

		@Parameters
		public static Collection<Object[]> testingData() {
			// Column, Expected
			return Arrays.asList(new Object[][] { { new double[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } },
					new Number[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, "3x3 All positive whole numbers." },
					{ new double[][] { { 1.1, 2.1, -5.34, 1.69 }, { -3, 4, 2.2, 3.334 }, { 1.320, -2.3 },
							{ 1.45, 24.123, -98.22 } },
							new Number[][] { { 1.1, 2.1, -5.34, 1.69 }, { -3, 4, 2.2, 3.334 }, { 1.320, -2.3 },
									{ 1.45, 24.123, -98.22 } },
							"Variable sizes. Positive and negative decimal and whole values." },
					{ new double[][] {}, new Number[][] {}, "Empty array." },
					{ new double[][] { { 0 } }, new Number[][] { { 0 } }, "1x1 with 0" },
					{new double[][] {{Double.MIN_VALUE, Double.MAX_VALUE},{Double.MIN_VALUE, Double.MAX_VALUE}}, new Number[][] {{Double.MIN_VALUE, Double.MAX_VALUE},{Double.MIN_VALUE, Double.MAX_VALUE}}, "2x2 with Double.MIN_VALUE and DOUBLE.MAX_VALUE"},
					{new double[][] {{-Double.MAX_VALUE, Double.MAX_VALUE},{-Double.MAX_VALUE, Double.MAX_VALUE}}, new Number[][] {{-Double.MAX_VALUE, Double.MAX_VALUE},{-Double.MAX_VALUE, Double.MAX_VALUE}}, "2x2 with -Double.MAX_VALUE and DOUBLE.MAX_VALUE"}

			});
		}

		@Test
		public void test() {
			Number[][] result = DataUtilities.createNumberArray2D(arg);
			assertArrayEquals(msg, expected, result);
		}
	}}


