package com.book.writer;

/**
 * @author ayub
 *
 * @param <T>
 */
public interface Writer<T> {

	/**
	 * write object type of T
	 * 
	 * @param obj
	 *            The type T
	 */
	public void write(T obj);
}
