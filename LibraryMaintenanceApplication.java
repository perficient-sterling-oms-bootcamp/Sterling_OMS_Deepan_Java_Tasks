package com.bhaiti.server.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class LibraryMaintenanceApplication extends BookDetails {

	private static final String libraryDirectoryPath = "C://Study materials//Library Details//libraryDetails.xml";
	
	static ArrayList<BookDetails> listOfBooks = new ArrayList<BookDetails>();

	public static void main(String[] args) {
		// Collects the actual input (number of books)
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Number of books to be added: ");
		try {
			int numberOfBooks = (Integer.parseInt(bufferedReader.readLine()));
			collectBookInformation(bufferedReader, numberOfBooks);
			xmlConverter();
		} catch (NullPointerException nullPointerException) {
			System.out.println("Please enter a value.");
		} catch (NumberFormatException numberFormatException) {
			System.out.println("Book Price can only be in decimal/integer digits.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Collects book information
	public static void collectBookInformation(BufferedReader bufferedReader, int numberOfBooks) throws IOException {
		for (int i = 0; i < numberOfBooks; i++) {
			BookDetails bookDetails = new BookDetails();
			System.out.println("Book Name: ");
			bookDetails.setBookName(bufferedReader.readLine());
			if (bookDetails.getBookName() == null || bookDetails.getBookName().isEmpty()) {
				System.out.println("Please enter a book name.");
			} else {
				System.out.println("Book Price: ");
				bookDetails.setBookPrice(Float.parseFloat(bufferedReader.readLine()));
				System.out.println("Book Author: ");
				bookDetails.setBookAuthor(bufferedReader.readLine());
				if (bookDetails.getBookAuthor() == null || bookDetails.getBookAuthor().isEmpty()) {
					System.out.println("Please enter the author's name of the book.");
				}
			}
			listOfBooks.add(i, bookDetails);
		}
	}

	// Creates XML file based on given input
	public static void xmlConverter() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// Root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("BookList");
			doc.appendChild(rootElement);

			for (int i = 0; i < listOfBooks.size(); i++) {
				// Book element
				Element book = doc.createElement("Book");
				rootElement.appendChild(book);

				// Book Name elements
				Element bookName = doc.createElement("Name");
				bookName.appendChild(doc.createTextNode(String.valueOf(listOfBooks.get(i).getBookName())));
				book.appendChild(bookName);

				// Book Price elements
				Element bookPrice = doc.createElement("Price");
				bookPrice.appendChild(doc.createTextNode(String.valueOf(listOfBooks.get(i).getBookPrice())));
				book.appendChild(bookPrice);

				// Book Author elements
				Element bookAuthor = doc.createElement("Author");
				bookAuthor.appendChild(doc.createTextNode(String.valueOf(listOfBooks.get(i).getBookAuthor())));
				book.appendChild(bookAuthor);
			}

			// Write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(libraryDirectoryPath));

			// Output to console for testing
			StreamResult consoleResult = new StreamResult(System.out);

			// XML formatter
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			// XML output in console
			transformer.transform(source, consoleResult);

			// XML output generated in file
			transformer.transform(source, result);

			System.out.println("File saved!");

		} catch (ParserConfigurationException parserConfigurationException) {
			parserConfigurationException.printStackTrace();
		} catch (TransformerException transformerException) {
			transformerException.printStackTrace();
		}

	}

}