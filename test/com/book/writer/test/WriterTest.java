package com.book.writer.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.book.enity.Author;
import com.book.enity.Book;
import com.book.util.BookSetting;
import com.book.writer.JsonWriter;
import com.book.writer.StorageWriter;
import com.book.writer.TxtWriter;
import com.book.writer.Writer;
import com.book.writer.XMLWriter;

public class WriterTest extends TestCase {
	private Writer<Book> writer = null;
	private Book book = null;

	public WriterTest(String testSuiteName) {
		super(testSuiteName);
	}

	@Before
	public void setUp() throws Exception {
		List<Author> authors = new ArrayList<Author>();
		authors.add(new Author("Bruce Eckel"));
		authors.add(new Author("Michael Easter"));
		book = new Book("Thinking in Java", "u9348984995898493", authors,
				"May 2013");
		BookSetting.storageFile = "resource/output/out";
	}

	@Override
	protected void tearDown() throws Exception {
		book = null;
	}

	@Test
	public void testCreateTxtWriter() {
		writer = new TxtWriter();
		assertNotNull("Could not create TxtParser Object", writer);
	}

	@Test
	public void testCreateJsonWriter() {
		writer = new JsonWriter();
		assertNotNull("Could not create TxtParser Object", writer);
	}

	@Test
	public void testWriteBookToTxt() {
		System.out.println("testWriteBookToTxt: writing object to TXT");
		writer = new TxtWriter();
		writer.write(book);
		System.out.println();
	}

	@Test
	public void testWriteBookToJson() {
		System.out.println("testWriteBookToJson: writing object to JSON");
		writer = new JsonWriter();
		writer.write(book);
	}

	@Test
	public void testWriteBookToStorage() {
		System.out.println("testWriteBookToStorage: writing object to Storage");
		File file = new File(BookSetting.storageFile);
		long fileSize = 0;
		if (file.exists()) {
			fileSize = file.length();
		}
		writer = new StorageWriter();
		writer.write(book);

		assertEquals("File could not created", file.exists(), true);
		assertNotSame("File size is not changed after write", file.length(),
				fileSize);
	}
	@Test
	public void testWriteBookToXML() {
		System.out.println("testWriteBookToXML: writing object to JSON");
		writer = new XMLWriter();
		writer.write(book);
	}

}
