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
		Starter.main(new String[] { "resource/input/input" });
	}
	@Test
	public void testFailedMain() {
		Starter.main(new String[] {"tee.txt"});
	}
	
	@Test
	public void testMainWithWebUrl() {
		Starter.main(new String[] { "http://api.geonames.org/citiesJSON?north=44.1&south=-9.9&east=-22.4&west=55.2&lang=de&username=demo" });
		
	}

}
