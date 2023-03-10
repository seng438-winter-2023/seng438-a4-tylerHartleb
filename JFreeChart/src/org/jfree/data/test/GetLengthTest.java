package org.jfree.data.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.jfree.data.Range;
import org.junit.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class GetLengthTest {
	@RunWith(Parameterized.class)
	public static class GetLengthTest_parameterizedTests {
		private String message;
		private Range rangeToTest;
		private double expected;
				
		public GetLengthTest_parameterizedTests(String message, Range range, double expected) {
			this.message = message;
			this.rangeToTest = range;
			this.expected = expected;
		}
		
		@Parameters
		public static Collection<Object[]> parameters() {
			
			Object[][] testingData = {
					{"Range(-3.3, -1.0)", new Range(-3.3, -1.0), 2.3},
					{"Range(-1.0, 2.5)", new Range(-1.0, 2.5), 3.5},
					{"Range(10.0, 11.0)", new Range(10.0, 11.0), 1.0},
					{"Range(0, Double.MIN_VALUE)", new Range(0.0, Double.MIN_VALUE), Double.MIN_VALUE},
					{"Range(0, Double.MAX_VALUE)", new Range(0.0, Double.MAX_VALUE), Double.MAX_VALUE},
					{"Range(-Double.MIN_VALUE, 0.0)", new Range(-Double.MIN_VALUE, 0.0), Double.MIN_VALUE},
					{"Range(-Double.MAX_VALUE,0)", new Range(-Double.MAX_VALUE, 0), Double.MAX_VALUE},
					{"Range(0, 0)", new Range(0, 0), 0},
					{"Range(Double.MAX_VALUE, Double.MAX_VALUE)", new Range(Double.MAX_VALUE, Double.MAX_VALUE), 0},
					{"Range(-Double.MAX_VALUE, -Double.MAX_VALUE)", new Range(-Double.MAX_VALUE, -Double.MAX_VALUE), 0},
			};
			System.out.println(-Double.MIN_VALUE);
			return Arrays.asList(testingData);
		}

//	    @BeforeClass 
//	    public static void setUpBeforeClass() throws Exception {
//	    }
//
//	    @Before
//	    public void setUp() throws Exception { exampleRange = new Range(-1, 1);
//	    }
		
	    @Test
	    public void getLength_inRangeTest() {
	    	System.out.println(this.rangeToTest.getLength());
	        assertEquals(this.message, this.expected, this.rangeToTest.getLength(), 0.0001d);
	    }
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
