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

		System.out.println("input data: " + fileData);

		Service service = ServiceProvider.getServiceProvider();
		Book book = service.doParse(fileData);
		System.out.println("book: " + book);
		
		System.out.println("targetFormat: "+BookSetting.targetFormat);
		service.doWrite(book);

	}

}
