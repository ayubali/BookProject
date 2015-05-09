package com.book.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class BookUtil {

	// private static Parser parser = new Parser();
	private BookUtil() {
	}
	
	
	/* public Parser getParser()
	  {
	  		 return parser;	 	
	  }	
	*/
	
	private BufferedReader getBufferedReader(String fileName) {

		BufferedReader reader = null;
		FileReader fileReader = null;
		File file = null;
		try {
			file = new File(fileName);
			fileReader = new FileReader(file);
			reader = new BufferedReader(fileReader);
		} catch (FileNotFoundException e) {
			System.err.println(fileName + " is not found.");
		}

		return reader;
	}

}
