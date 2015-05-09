package com.book.provider;

import com.book.enity.Book;

public class ServiceProvider implements Service {

	private static ServiceProvider provider = new ServiceProvider();

	private ServiceProvider() {
	}

	public static ServiceProvider getServiceProvider() {
		return provider;
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
