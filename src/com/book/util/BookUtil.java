package com.book.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.book.enity.FileFormat;

/**
 * This class represents the utility for book conversion
 * 
 * @author ayub
 *
 */
public class BookUtil {

	private static JSONParser parser = new JSONParser();

	private BookUtil() {
	}

	/**
	 * This Method return JSONParser singleton object
	 * 
	 * @return JSONParser object
	 */
	public static JSONParser getJSONParser() {
		return parser;
	}

	/**
	 * This Method takes a fileName and return BufferedReader object
	 * 
	 * @param fileName
	 *            fileName is the Name of file
	 * @return a BufferedReader object
	 */
	public static BufferedReader getBufferedReader(String fileName)
			throws FileNotFoundException, IOException {
		BufferedReader reader = null;
		URL url = getURL(fileName);
		if (url != null) {
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
		} else {
			File file = new File(fileName);
			FileReader fileReader = new FileReader(file);
			reader = new BufferedReader(fileReader);
		}
		return reader;

	}

	/**
	 * This method takes file content as String and determine file format
	 * 
	 * @param fileData
	 *            file content
	 * @return format of file
	 */
	public static FileFormat detectFileFormat(String fileData) {
		FileFormat format = FileFormat.NOVALUE;
		if (isJson(fileData)) {
			format = FileFormat.JSON;
		} else if (isTxt(fileData)) {
			format = format.TXT;
		}
		return format;
	}

	/**
	 * This method determine whether file data is in JSON format or not
	 * 
	 * @param fileData
	 *            file content
	 * @return true if file data is in JSON format, false otherwise
	 */
	private static boolean isJson(String fileData) {
		try {
			parser.parse(fileData);
			return true;
		} catch (ParseException ex) {
			return false;
		}
	}

	/**
	 * This method determine whether file data is in TXT format or not
	 * 
	 * @param fileData
	 *            file content
	 * @return true if file data is in TXT format, false otherwise
	 */
	private static boolean isTxt(String fileData) {
		String[] lines = fileData.split("\n");
		if (lines[0].contains("name")) {
			return true;
		}
		return false;
	}

	/**
	 * This methods reads data from file and return the file data as string
	 * 
	 * @param fileName
	 *            The name of file
	 * @return content of the file as String, null otherwise
	 */
	public static String readInputFile(String fileName) {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = null;
		String line = null;
		try {
			reader = getBufferedReader(fileName);
			while (true) {
				line = reader.readLine();
				if (line == null) {
					break;
				}
				line = line.trim();
				if (!line.isEmpty()) {
					sb.append(line);
					sb.append("\n");
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println(fileName + " is not found");
			return null;
		} catch (UnknownHostException ex) {
			System.err.println(fileName + " is not valid web url");
			return null;
		} catch (IOException e) {
			System.err.println("Could not read the " + fileName);
			return null;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					System.err.println("ERROR in closing " + fileName);
				}
			}
		}
		return sb.toString();
	}

	/**
	 * Reads the parameter from the ResourceBundle. If it is null, use the
	 * default. If its equal to the word "null" return null instead. Watch for
	 * null pointers with non object stuff.
	 *
	 * @param prb
	 *            The list of properties
	 * @param key
	 *            The property key
	 * @param deflt
	 *            The default value
	 * @return The parameter value in string
	 */
	public static String readParameter(ResourceBundle prb, String key,
			String deflt) {
		String tmp = prb.getString(key);
		return ((tmp != null) && (tmp.trim().length() != 0) ? (tmp.trim()
				.equals("null") ? null : tmp.trim()) : deflt);
	}

	/**
	 * This method takes a url and return URL object
	 * 
	 * @param fileName
	 *            the Name of url
	 * @return a valid URL object if fileName is valid web url, null otherwise
	 */
	private static URL getURL(String fileName) {
		URL url = null;
		try {
			url = new URL(fileName);
		} catch (MalformedURLException e) {
			return null;
		}
		return url;
	}
}
