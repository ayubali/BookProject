package com.book.starter.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.book.starter.Starter;

public class StarterTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMain() {
		Starter.main(new String[] { "resource/input/input.txt" });
	}
	@Test
	public void testFailedMain() {
		Starter.main(new String[] {"tee.txt"});
	}

}
