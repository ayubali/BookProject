package com.book.provider;

import com.book.enity.Book;
import com.book.perser.JsonParser;
import com.book.perser.Parser;
import com.book.perser.TxtParser;

/**
 * This class implements Services
 * 
 * @author ayub
 *
 */
public class ServiceProvider extends Service {

	private static ServiceProvider provider = new ServiceProvider();
	Parser<Book> parser = null;

	private ServiceProvider() {
	}

	public static ServiceProvider getServiceProvider() {
		return provider;
	}

	@Override
	public Book parseFromTxt(String fileData) {
		parser = new TxtParser();
		return parser.parse(fileData);
	}

	@Override
	public Book parseFromJson(String fileData) {
		parser = new JsonParser();
		return parser.parse(fileData);
	}

	@Override
	public void WriteToTxt(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void WriteToJson(Book book) {
		// TODO Auto-generated method stub

	}

}
