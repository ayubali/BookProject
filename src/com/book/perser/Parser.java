package com.book.perser;

/**
 * @author ayub
 *
 * @param <T>
 */
public interface Parser<T> {

	/**
	 * parse file data to type T
	 * 
	 * @param fileData
	 * @return T
	 */
	public T parse(String fileData);

}
