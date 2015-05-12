package com.book.services;

import com.book.enity.Book;
import com.book.perser.JsonParser;
import com.book.perser.Parser;
import com.book.perser.TxtParser;
import com.book.writer.JsonWriter;
import com.book.writer.TxtWriter;
import com.book.writer.Writer;

/**
 * This class implements conversion Services
 * 
 * @author ayub
 *
 */
public class ServiceProvider extends Service {

	private static ServiceProvider provider = new ServiceProvider();
	Parser<Book> parser = null;
	Writer<Book> writer = null;

	private ServiceProvider() {
	}

	public static ServiceProvider getServiceProvider() {
		return provider;
	}

	@Override
	protected Book parseFromTxt(String fileData) {
		parser = new TxtParser();
		return parser.parse(fileData);
	}

	@Override
	protected Book parseFromJson(String fileData) {
		parser = new JsonParser();
		return parser.parse(fileData);
	}

	@Override
	protected void writeToTxt(Book book) {
		writer = new TxtWriter();
		writer.write(book);
	}

	@Override
	protected void writeToJson(Book book) {
		writer = new JsonWriter();
		writer.write(book);

	}

}
