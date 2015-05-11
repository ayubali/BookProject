package com.book.provider;

import com.book.enity.Book;

public class ServiceProviderImpl extends ServiceProvider {

	private static ServiceProviderImpl provider = new ServiceProviderImpl();

	private ServiceProviderImpl() {
	}

	public static ServiceProviderImpl getServiceProvider() {
		return provider;
	}

	@Override
	public Book parseFromTxt(String fileData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book parseFromJson(String fileData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void WriteToTxt(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void WriteToJson(Book book) {
		// TODO Auto-generated method stub
		
	}

	
}
