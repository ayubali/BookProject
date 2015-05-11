package com.book.perser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.ParseException;

import com.book.enity.Author;
import com.book.enity.Book;
import com.book.util.BookUtil;

/**
 * This class provides the support of parsing the JSON file data
 * 
 * @author ayub
 *
 */
public class JsonParser implements Parser<Book> {

	/*
	 * This method parse JSON file data and build an book instance
	 * 
	 * @param fileData file data
	 * 
	 * @return an instance of book if json file data is successfully parsed,
	 * null otherwise
	 */
	@Override
	public Book parse(String fileData) {
		Book book = new Book();
		try {

			ContainerFactory containerFactory = new ContainerFactory() {
				public List creatArrayContainer() {
					return new LinkedList();
				}

				public Map createObjectContainer() {
					return new LinkedHashMap();
				}
			};
			Map json = (Map) BookUtil.getParser().parse(fileData,
					containerFactory);
			Iterator iter = json.entrySet().iterator();

			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				Map jsonObject = (Map) entry.getValue();

				book.setName(((String) jsonObject.get("name")).trim());

				List<Author> authors = new ArrayList<Author>();
				Object obj = jsonObject.get("authors");
				if (obj instanceof List) {
					List list = (List) obj;
					for (Object object : list) {
						authors.add(new Author(object.toString().trim()));
					}
				} else {
					if (obj != null) {
						authors.add(new Author(obj.toString().trim()));
					}
				}

				book.setAuthors(authors);
				book.setPublished­Date(((String) jsonObject
						.get("published-date")).trim());

			}

		} catch (ParseException e) {
			System.err.println("ERROR in parsing JSON data");
		}
		return book;
	}
}
