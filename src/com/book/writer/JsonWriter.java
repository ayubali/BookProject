package com.book.writer;

import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONValue;

import com.book.enity.Book;

/**
 * This class provides the support of writing book info to JSON
 * 
 * @author ayub
 *
 */
public class JsonWriter implements Writer<Book> {

	/*
	 * This method write book information into JSON format
	 * 
	 * @param book an instance of Book
	 */
	@Override
	public void write(Book book) {
		Map<String, Object> obj = new LinkedHashMap<String, Object>();
		obj.put("name", book.getName());
		obj.put("authors", book.getAuthors());
		obj.put("published­date", book.getPublished­Date());
		Map<String, Object> root = new LinkedHashMap<String, Object>();
		root.put("book", obj);
		StringWriter out = new StringWriter();
		try {
			JSONValue.writeJSONString(root, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String jsonText = out.toString();
		System.out.print(jsonText);
	}

}
