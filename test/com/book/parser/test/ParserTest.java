package com.book.parser.test;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.book.enity.Book;
import com.book.perser.JsonParser;
import com.book.perser.Parser;
import com.book.perser.TxtParser;
import com.book.util.BookUtil;

public class ParserTest extends TestCase {

	private Parser<Book> parser = null;
	private String txtFileData = null;
	private String jsonFileData = null;

	public ParserTest(String testSuiteName) {
		super(testSuiteName);
	}

	@Before
	public void setUp() throws Exception {
		txtFileData = BookUtil.readInputFile("resource/input/input.txt");
		jsonFileData = BookUtil.readInputFile("resource/input/input");
	}

	@After
	public void tearDown() throws Exception {
		txtFileData = null;
		jsonFileData = null;
		parser = null;
	}

	@Test
	public void testCreateTxtParser() {
		parser = new TxtParser();
		assertNotNull("Could not create TxtParser Object", parser);
	}

	@Test
	public void testCreateJsonParser() {
		parser = new JsonParser();
		assertNotNull("Could not create Json Object", parser);
	}

	@Test
	public void testParseTxtFile() {
		parser = new TxtParser();
		Book book = parser.parse(txtFileData);
		assertNotNull("Could not parse txt file to book Object", book);
	}

	@Test
	public void testParseJsonFile() {
		parser = new JsonParser();
		Book book = parser.parse(jsonFileData);
		assertNotNull("Could not parse txt file to book Object", book);
	}

}
