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
public class ContainsTest {
	@RunWith(Parameterized.class)
	public static class ContainsTest_parameterizedTests {
		private String message;
		private double valueToTest;
		private boolean expected;
		
		private Range range = new Range(1.1, 51.2);
		
		public ContainsTest_parameterizedTests(String message, double value, boolean expected) {
			this.message = message;
			this.valueToTest = value;
			this.expected = expected;
		} 
		
		@Parameters
		public static Collection<Object[]> parameters() {
			Object[][] testingData = {
					{"Range(1.1, 51.2) does not contain value 51.3", 51.3, false},
					{"Range(1.1, 51.2) contains value 51.2", 51.2, true},
					{"Range(1.1, 51.2) contains value 51.1", 51.1, true},
					{"Range(1.1, 51.2) contains value 25", 25, true},
					{"Range(1.1, 51.2) contains value 1.2", 1.2, true},
					{"Range(1.1, 51.2) contains value 1.1", 1.1, true},
					{"Range(1.1, 51.2) does not contain value 1.0", 1.0, false},
			};
			return Arrays.asList(testingData);
		}
		
		@Test
		public void contains_inRangeTest() {
			assertEquals(this.message, this.expected, this.range.contains(valueToTest));
		}
	}

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
}
