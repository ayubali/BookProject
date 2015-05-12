package com.book.util.test;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.book.enity.FileFormat;
import com.book.util.BookSetting;

public class BookSettingTest extends TestCase {

	private String fileName = null;

	public BookSettingTest(String testSuiteName) {
		super(testSuiteName);
	}

	@Before
	public void setUp() throws Exception {
		fileName = "config/book-info-converter.properties";
	}

	@After
	public void tearDown() throws Exception {
		fileName = null;
	}

	@Test
	public void testLoadPorojectSetting() {
		BookSetting.targetFormat = FileFormat.NOVALUE;
		BookSetting.loadProjectSetting(fileName);
		System.out.println(BookSetting.targetFormat);
		assertNotSame("Could not load the project setting from property file",
				BookSetting.targetFormat, FileFormat.NOVALUE);
	}

}
