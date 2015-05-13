package com.book.util.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PropertyResourceBundle;

import junit.framework.TestCase;

import org.json.simple.parser.JSONParser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.book.enity.FileFormat;
import com.book.util.BookUtil;

public class BookUtilTest extends TestCase {

	private String fileName = null;
	private String resourceFile = null;
	private String txtFileData = null;
	private String jsonFileData = null;

	public BookUtilTest(String testSuiteName) {
		super(testSuiteName);
	}

	@Before
	public void setUp() throws Exception {
		fileName = "resource/input/input.txt";
		resourceFile = "config/book-info-converter.properties";
		txtFileData = BookUtil.readInputFile("resource/input/input.txt");
		jsonFileData = BookUtil.readInputFile("resource/input/input");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetJSONParser() {
		JSONParser parser = BookUtil.getJSONParser();
		assertNotNull("Could not get JSONParser object", parser);
	}

	@Test
	public void testGetBufferedReader() throws IOException {
		BufferedReader buffer = BookUtil.getBufferedReader(fileName);
		assertNotNull("Could not get BufferedReader object", buffer);
	}

	@Test
	public void testFailedGetBufferedReader() {
		try {
			BufferedReader buffer = BookUtil.getBufferedReader("");
			assert false;
		} catch (IOException  e) {
			assert true;
		}
	}

	@Test
	public void testDetectFileFormat() {
		FileFormat fileFormat = BookUtil.detectFileFormat(jsonFileData);
		assertEquals("File data is in JSON but detected Format is not JSON",
				fileFormat, FileFormat.JSON);
		fileFormat = BookUtil.detectFileFormat(txtFileData);
		assertEquals("File data is in TXT but detected Format is not JSON",
				fileFormat, FileFormat.TXT);
	}

	@Test
	public void testFailedDetectFileFormat() {
		FileFormat fileFormat = BookUtil.detectFileFormat(txtFileData);
		assertNotSame("File data is in JSON but detected Format is not JSON",
				fileFormat, FileFormat.JSON);
		fileFormat = BookUtil.detectFileFormat(jsonFileData);
		assertNotSame("File data is in TXT but detected Format is not JSON",
				fileFormat, FileFormat.TXT);
	}

	@Test
	public void testReadInputFile() {
		String fileData = BookUtil.readInputFile(fileName);
		assertNotNull("Could not read from file", fileData);
	}

	@Test
	public void testFailedReadInputFile() {
		String fileData = BookUtil.readInputFile("test");
		assertSame("unexpectedly  read a file", fileData, null);
	}

	@Test
	public void testReadParameter() throws FileNotFoundException, IOException {
		PropertyResourceBundle prb = new PropertyResourceBundle(
				new FileInputStream(resourceFile));
		String targetFormat = BookUtil.readParameter(prb, "targetFormat", "");
		assertNotNull("targetFormat is not found", targetFormat);
	}
}
