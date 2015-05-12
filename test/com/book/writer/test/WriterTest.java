package com.book.writer.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import com.book.enity.Author;
import com.book.enity.Book;
import com.book.writer.JsonWriter;
import com.book.writer.TxtWriter;
import com.book.writer.Writer;

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
		book = new Book("Thinking in Java", authors, "May 2013");
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
		System.out.println("testWriteBookToJson: writing object to Json");
		writer = new JsonWriter();
		writer.write(book);
	}

}
