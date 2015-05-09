package com.book.provider;

import com.book.enity.Book;

public interface Service {

	public Book parseFromTxt(String fileName);

	public Book parseFromJson(String fileName);

	public Book WriteToTxt(String fileName);

	public Book WriteToJson(String fileName);

}
