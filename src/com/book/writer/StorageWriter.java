package com.book.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.book.enity.Author;
import com.book.enity.Book;
import com.book.util.BookSetting;

public class StorageWriter implements Writer<Book> {

	@Override
	public void write(Book book) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(BookSetting.storageFile);
			bw = new BufferedWriter(fw);
			bw.write("name:" + book.getName());
			bw.newLine();
			bw.write("isbn:" + book.getIsbn());
			bw.newLine();
			String bookAuthors = "";
			List<Author> authors = book.getAuthors();
			for (Author author : authors) {
				bookAuthors += author.getName() + " ,";
			}
			bw.write("authors:" + book.getPublished­Date());
			bw.newLine();
			bw.write("published-date:" + book.getPublished­Date());
			bw.newLine();

		} catch (IOException e) {
			System.err.println("ERROR in writting data to file.");
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				System.err.println("ERROR in closing file.");
			}
		}
	}
}
