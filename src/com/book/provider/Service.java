package com.book.provider;

import com.book.enity.Book;
import com.book.util.BookSetting;

/**
 * This class provides conversion services
 * 
 * @author ayub
 *
 */
public abstract class Service {

	/**
	 * This method parse a file of type JSON and txt, return a book object
	 * 
	 * @param fileData
	 *            file data
	 * @return an instance of book if successful parse file data, null otherwise
	 */
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

	/**
	 * This method takes an instance of object and write into JSON or txt format
	 * 
	 * @param book
	 *            an intance of book
	 */
	public void doWrite(Book book) {

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
	}

	/**
	 * This method parse txt file data and form book object
	 * 
	 * @param fileData
	 *            file data
	 * @return an instance of book if file data is successfully parsed, null
	 *         otherwise
	 */
	public abstract Book parseFromTxt(String fileData);

	/**
	 * This method parse Json file data and form book object
	 * 
	 * @param fileData
	 *            file data
	 * @return an instance of book if file data is successfully parsed, null
	 *         otherwise
	 */
	public abstract Book parseFromJson(String fileData);

	/**
	 * This method write the book information into txt format
	 * 
	 * @param book
	 *            an instance of book
	 */
	public abstract void WriteToTxt(Book book);

	/**
	 * This method write the book information into JSON format
	 * 
	 * @param book
	 *            an instance of book
	 */
	public abstract void WriteToJson(Book book);

}
