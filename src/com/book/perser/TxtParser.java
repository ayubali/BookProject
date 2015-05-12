package com.book.perser;

import java.util.ArrayList;
import java.util.List;

import com.book.enity.Author;
import com.book.enity.Book;

/**
 * This class provides the support of parsing the txt file data
 * 
 * @author ayub
 *
 */
public class TxtParser implements Parser<Book> {

	/*
	 * This method parse TXT file data and build an book instance
	 * 
	 * @param fileData file data
	 * 
	 * @return an instance of book if TXT file data is successfully parsed, null
	 * otherwise
	 */
	@Override
	public Book parse(String fileData) {
		Book book = new Book();
		try {

			String[] lines = fileData.split("\n");
			for (String line : lines) {
				String[] data = line.split(":");
				if (data.length != 2) {
					continue;
				}
				if (data[0].equalsIgnoreCase("name")) {
					book.setName(data[1].trim());
				} else if (data[0].equalsIgnoreCase("published-date")) {
					book.setPublished­Date(data[1].trim());
				} else if (data[0].equalsIgnoreCase("authors")) {
					String[] authorsList = data[1].split(",");
					List<Author> authors = new ArrayList<Author>();
					for (int i = 0; i < authorsList.length; i++) {
						authors.add(new Author(authorsList[i].trim()));
					}
					book.setAuthors(authors);
				}

			}
		} catch (Exception ex) {
			System.err.println("ERROR in parsing txt data");
			return null;

		}

		return book;

	}

}
