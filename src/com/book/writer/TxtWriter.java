package com.book.writer;

import java.util.List;

import com.book.enity.Author;
import com.book.enity.Book;

/**
 * This class provides the support of writing book info to TXT
 * 
 * @author ayub
 *
 */
public class TxtWriter implements Writer<Book> {
	/*
	 * This method write book information into TXT format
	 * 
	 * @param book an instance of Book
	 */
	@Override
	public void write(Book book) {
		System.out.println("Name: " + book.getName().toUpperCase());
		String bookAuthors = "";

		List<Author> authors = book.getAuthors();
		for (Author author : authors) {
			bookAuthors += author.getName() + " ,";
		}

		System.out.println("Author: "
				+ bookAuthors.substring(0, bookAuthors.length() - 1));
		System.out.println("Published Date: " + book.getPublished­Date());
		System.out.println("ISBN: " + book.getIsbn());

	}

}
