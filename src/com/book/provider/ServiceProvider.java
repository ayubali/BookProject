package com.book.provider;

import com.book.enity.Book;
import com.book.util.BookSetting;

public abstract class ServiceProvider {

	public Book doParse(String fileData) {
		Book book = null;
		switch (BookSetting.inputFileFormat) {
		case JSON:
			book = parseFromJson(fileData);
			break;

		case TXT:
			book = parseFromTxt(fileData);
			break;
		default:
			System.err.println("ERROR: input file not in corrent format");
			break;
		}
		return book;

	}

	public Book doWrite(Book book) {

		switch (BookSetting.outFileFormat) {
		case JSON:
			WriteToJson(book);
			break;

		case TXT:
			WriteToTxt(book);
			break;
		default:
			System.err.println("ERROR: input file not in corrent format");
			break;
		}
		return book;

	}

	public abstract Book parseFromTxt(String fileData);

	public abstract Book parseFromJson(String fileData);

	public abstract void WriteToTxt(Book book);

	public abstract void WriteToJson(Book book);

}
