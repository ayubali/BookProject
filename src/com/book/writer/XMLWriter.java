package com.book.writer;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.book.enity.Author;
import com.book.enity.Book;

/**
 * This class provides the support of writing book info to XML
 * 
 * @author ayub
 *
 */
public class XMLWriter implements Writer<Book> {

	/*
	 * This method write book information into XML format
	 * 
	 * @param book an instance of Book
	 */
	@Override
	public void write(Book book) {
		DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder icBuilder;
		try {
			icBuilder = icFactory.newDocumentBuilder();
			Document doc = icBuilder.newDocument();
			Element mainRootElement = doc.createElementNS(
					"http://example.com/programming/test/book", "book");
			doc.appendChild(mainRootElement);
			mainRootElement.appendChild(addBook(doc, book));

			// output DOM XML to console
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult console = new StreamResult(System.out);
			transformer.transform(source, console);
		} catch (Exception e) {
			System.err.println("ERROR in writing book information to XML");
		}
	}

	private Node addBook(Document doc, Book book) {
		Element bookNode = doc.createElement("book");
		bookNode.appendChild(CreateBookElements(doc, "isbn", book.getIsbn()));
		bookNode.appendChild(CreateBookElements(doc, "name", book.getName()));
		Element authorsNode = doc.createElement("authors");
		List<Author> authorList = book.getAuthors();
		for (Author author : authorList) {
			authorsNode.appendChild(CreateBookElements(doc, "author",
					author.getName()));
		}
		bookNode.appendChild(authorsNode);
		bookNode.appendChild(CreateBookElements(doc, "published-date",
				book.getPublished­Date()));
		return bookNode;
	}

	// utility method to create text node
	private Node CreateBookElements(Document doc, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}

}
