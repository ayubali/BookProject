package com.book.starter;

import com.book.enity.Book;
import com.book.enity.FileFormat;
import com.book.services.Service;
import com.book.services.ServiceProvider;
import com.book.util.BookSetting;
import com.book.util.BookUtil;

public class Starter {

	public static void main(String[] args) {

		if (args.length < 1 || args[0].length() < 1) {
			System.err.println("please enter file name in command line");
			return;
		}

		BookSetting.loadProjectSetting("config/book-info-converter.properties");
		String fileData = BookUtil.readInputFile(args[0].trim());
		if (fileData != null && BookSetting.targetFormat != FileFormat.NOVALUE) {
			BookSetting.inputFormat = BookUtil.detectFileFormat(fileData);
			if (BookSetting.inputFormat == FileFormat.TXT) {
				System.err.println("Input format " + BookSetting.inputFormat
						+ " is not supported.");
				return;
			}
			if (BookSetting.targetFormat == FileFormat.TXT) {
				System.err.println("Target format " + BookSetting.targetFormat
						+ " is not supported.");
				return;
			}
			Service service = ServiceProvider.getServiceProvider();
			Book book = service.doParse(fileData);
			if (book != null) {

				System.out.println("Reading input ...\n++++");
				System.out.print(fileData);
				System.out.println("----");
				System.out.println("Guessing text format ... ");
				System.out.println("Book data is in " + BookSetting.inputFormat
						+ " format");
				System.out.println("Converting to " + BookSetting.targetFormat
						+ " format");
				System.out.println("Here is the output... \n++++");
				service.doWrite(book);
				System.out.println("----");
			}
		}

	}

}
