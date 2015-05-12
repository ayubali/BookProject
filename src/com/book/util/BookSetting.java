package com.book.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import java.util.PropertyResourceBundle;

import com.book.enity.FileFormat;

/**
 * This class represents project setting information
 * 
 * @author ayub
 *
 */
public class BookSetting {

	public static FileFormat inputFormat = FileFormat.NOVALUE;
	public static FileFormat targetFormat = FileFormat.NOVALUE;
	public static String storageFile = null;
	public static boolean isStorageEnabled = false;

	/**
	 * This method load project property file and initialize project setting
	 * 
	 * @param fileName
	 *            The name of the property file
	 */
	public static void loadProjectSetting(String fileName) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(fileName);
			PropertyResourceBundle prb = new PropertyResourceBundle(input);
			if (BookUtil.readParameter(prb, "targetFormat", "")
					.equalsIgnoreCase("json")) {
				targetFormat = FileFormat.JSON;
			} else if (BookUtil.readParameter(prb, "targetFormat", "")
					.equalsIgnoreCase("txt")) {
				targetFormat = FileFormat.TXT;
			}

			storageFile = BookUtil.readParameter(prb, "targetFormat", "");
			isStorageEnabled = Boolean.parseBoolean(BookUtil.readParameter(prb,
					"targetFormat", ""));

		} catch (FileNotFoundException notFoundException) {
			System.err.println(fileName + " is not found");
		} catch (IOException e) {
			System.err.println(fileName + " could not load properties file");
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					System.err.println("ERROR in closing " + fileName);
				}
			}
		}

	}
}
