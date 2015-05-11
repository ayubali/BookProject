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
 * This class parse the json file data
 * 
 * @author ayub
 *
 */
public class JsonParser implements Parser<Book> {

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

				book.setName((String) jsonObject.get("name"));

				List list = (List) jsonObject.get("authors");
				List<Author> authors = new ArrayList<Author>();
				for (Object object : list) {
					authors.add(new Author(object.toString()));
				}

				book.setAuthors(authors);
				book.setPublished­Date((String) jsonObject
						.get("published­date"));

			}

		} catch (ParseException e) {
			System.err.println("ERROR in parsing JSON data");
		}
		return book;
	}

}
