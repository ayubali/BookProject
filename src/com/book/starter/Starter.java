package com.book.starter;

import com.book.enity.Book;
import com.book.services.Service;
import com.book.services.ServiceProvider;
import com.book.util.BookSetting;
import com.book.util.BookUtil;

public class Starter {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("please enter file name in command line");
			return;
		}

		BookSetting.loadProjectSetting("config/book-info-converter.properties");
		String fileData = BookUtil.readInputFile(args[0].trim());
		BookSetting.inputFormat = BookUtil.DetectFileFormat(fileData);

		System.out.println("Reading input ...\n++++");
		System.out.print(fileData);
		System.out.println("----");

		System.out.println("Guessing text format ... ");
		System.out.println("Book data is in " + BookSetting.inputFormat
				+ " format");
		System.out.println("Converting to " + BookSetting.targetFormat
				+ " format");

		Service service = ServiceProvider.getServiceProvider();
		Book book = service.doParse(fileData);
		System.out.println("Here is the output... \n++++");
		service.doWrite(book);

	}

}
