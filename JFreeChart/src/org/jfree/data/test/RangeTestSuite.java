package org.jfree.data.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ContainsTest.class,
	ExpandTest.class,
	GetLengthTest.class,
	GetCentralValueTest.class,
	ToStringTest.class,
	ScaleTests.class,
	ShiftTests.class,
	CombineTests.class,
	CombineIgnoringNaNTests.class
})
public class RangeTestSuite {
}
