package com.book.provider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.book.enity.Book;

public class ServiceProvider implements Service {

	private static ServiceProvider provider = new ServiceProvider();

	private ServiceProvider() {
	}

	public static ServiceProvider getServiceProvider() {
		return provider;
	}

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

	
	
	@Override
	public Book parseFromTxt(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book parseFromJson(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book WriteToTxt(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book WriteToJson(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
