package com.book.exception;

/**
 * This class is a sub type of Exception class to provide an mandatory
 * attribute(ISBN) support of parsing data
 * 
 * @author ayub
 *
 */
public class ISBNNotFoundException extends Exception {
	public ISBNNotFoundException(String msg) {
		super(msg);
	}
}
