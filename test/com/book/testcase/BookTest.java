package com.book.testcase;

import static org.junit.Assert.fail;
import junit.framework.TestCase;
import org.junit.Test;



public class BookTest extends TestCase {

	private int value1;
	private int value2;

	public BookTest(String testName) {
		super(testName);
	}

	@Override
	protected void setUp() throws Exception {
		value1 = 15;
		value2 = 10;
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		value1 = 0;
		value2 = 0;
		super.tearDown();
	}

	@Test
	public void testAdd() {
		int total = 25;
		int sum = value1 + value2;
		assertEquals(sum, total);
	}

}
