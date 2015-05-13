package com.book.services.test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.book.enity.Author;
import com.book.enity.Book;
import com.book.services.Service;
import com.book.services.ServiceProvider;
import com.book.util.BookSetting;
import com.book.util.BookUtil;

public class ServiceProviderTest extends TestCase {
	private String txtFileData = null;
	private String jsonFileData = null;
	private Service service = null;
	private Book book = null;

	@Before
	public void setUp() throws Exception {
		BookSetting.loadProjectSetting("config/book-info-converter.properties");
		BookSetting.storageFile = "resource/output/out";
		txtFileData = BookUtil.readInputFile("resource/input/input.txt");
		jsonFileData = BookUtil.readInputFile("resource/input/input");
		service = ServiceProvider.getServiceProvider();
		List<Author> authors = new ArrayList<Author>();
		authors.add(new Author("Bruce Eckel"));
		authors.add(new Author("Michael Easter"));
		book = new Book("Thinking in Java", "u9348984995898493", authors,
				"May 2013");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoParse() {
		BookSetting.inputFormat = BookUtil.detectFileFormat(txtFileData);
		Book book = service.doParse(txtFileData);
		assertNotNull("Could not parse txt file to book Object", book);

		BookSetting.inputFormat = BookUtil.detectFileFormat(jsonFileData);
		book = service.doParse(jsonFileData);
		assertNotNull("Could not parse json file to book Object", book);
	}

	@Test
	public void testDoWrite() {
		service.doWrite(book);
	}

	@Test
	public void testParseFromTxt() throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		Class cls = ServiceProvider.class;
		Method A_init;
		A_init = cls.getDeclaredMethod("parseFromTxt", String.class);
		A_init.setAccessible(true);
		Book book = (Book) A_init.invoke(service, txtFileData);
		assertNotNull("Could not parse TXT to book Object", book);
	}

	@Test
	public void testParseFromJson() throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		Class cls = ServiceProvider.class;
		Method A_init;
		A_init = cls.getDeclaredMethod("parseFromJson", String.class);
		A_init.setAccessible(true);
		Book book = (Book) A_init.invoke(service, jsonFileData);
		assertNotNull("Could not parse JSON to book Object", book);
	}

	@Test
	public void testWriteToTxt() throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		Class cls = ServiceProvider.class;
		Method A_init;
		A_init = cls.getDeclaredMethod("writeToTxt", Book.class);
		A_init.setAccessible(true);
		A_init.invoke(service, book);
	}

	@Test
	public void testWriteToJson() throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		Class cls = ServiceProvider.class;
		Method A_init;
		A_init = cls.getDeclaredMethod("writeToJson", Book.class);
		A_init.setAccessible(true);
		A_init.invoke(service, book);
	}

	@Test
	public void testWriteToStorage() throws NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		File file = new File(BookSetting.storageFile);
		long fileSize = 0;
		if (file.exists()) {
			fileSize = file.length();
		}

		Class cls = ServiceProvider.class;
		Method A_init;
		A_init = cls.getDeclaredMethod("writeToStorage", Book.class);
		A_init.setAccessible(true);
		A_init.invoke(service, book);
		assertEquals("File could not created", file.exists(), true);
		assertNotSame("File size is not changed after write", file.length(),
				fileSize);
	}
}
