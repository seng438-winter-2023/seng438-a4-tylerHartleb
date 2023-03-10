package org.jfree.data.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.security.InvalidParameterException ;
import org.jfree.data.DataUtilities;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Enclosed.class)
public class CreateNumberArrayTests {
	public static class CreateNumberArrayTests_boundryTest{
		/*
		 * This test class is responsible for 
		 * testing the method when it is called with null argument. 
		 * This is test partition AU1.
		 * */
		@Test(expected = InvalidParameterException.class)
		public void test() {
			DataUtilities.createNumberArray(null);
			fail("InvalidParameterException not thrown.");
		}
	};
	
	/*
	 * The following parameterized test class is responsible for covering the AE1, and AE2 test partitions. */
	@RunWith(Parameterized.class)
	public static class CreateNumberArrayTests_parameterizedTests{
		double[] arg;
		Number[] expected;
		String msg;
		
		public CreateNumberArrayTests_parameterizedTests(double[] arg, Number[] expected, String msg) {
			this.arg = arg;
			this.expected = expected;
			this.msg = msg;
		}
		
		@Parameters
		public static Collection<Object[]> testingData(){
			return Arrays.asList(new Object[][] {
				{new double[] {1,2,3,4,5} , new Number[] {1,2,3,4,5}, "5 elements. Whole numbers."},
				{new double[] {-1.2, 1, 3.1415, -3.23, -49, 212.1,-1.2, 1, 3.1415, -3.23, -49, 212.1}, new Number[] {-1.2, 1, 3.1415, -3.23, -49, 212.1,-1.2, 1, 3.1415, -3.23, -49, 212.1},"12 elements. Positive and negative decimal and whole values." },
				{new double[] {}, new Number[] {}, "Empty array."},
				{new double[] {-1.2, 3.4, 3.14159}, new Number[] {-1.2, 3.4, 3.14159}, "3 elements. Positive and negative all decimal values."},
				{new double[] {Double.MIN_VALUE, Double.MAX_VALUE}, new Number[] {Double.MIN_VALUE, Double.MAX_VALUE}, "2 elements. Double.MIN_VALUE and Double.MAX_VALUE"},
				{new double[] {-Double.MAX_VALUE, Double.MAX_VALUE}, new Number[] {-Double.MAX_VALUE, Double.MAX_VALUE}, "2 elements. -Double.MAX_VALUE and Double.MAX_VALUE"}
			});
			
		}
		@Test
		public void test() {
			Number[] results = DataUtilities.createNumberArray(arg);
			assertArrayEquals(msg, expected, results);
		}
	};
}
