package org.pmmik.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.pmmik.dao.BookDao;
import org.pmmik.dao.Globals;
import org.pmmik.pojo.Book;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

@SuppressWarnings("restriction")
public class XMLCreator {

	private List<Book> bookList = new ArrayList<>();
	private Document dom;
	private static EntityManagerFactory factory;
	private EntityManager em;	
	private BookDao bookDao;
	

	private void loadData() {
		
		factory = Persistence.createEntityManagerFactory(Globals.PERSISTENCE_UNIT_NAME);
		this.em = factory.createEntityManager();
		this.bookDao = new BookDao(this.em);
		
		bookList=bookDao.listAllBooks();
	}

	private void createDocument() {

		// get an instance of factory
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			// get an instance of builder
			DocumentBuilder db = dbFactory.newDocumentBuilder();

			// create an instance of DOM
			this.dom = db.newDocument();

		} catch (ParserConfigurationException pce) {
			// dump it
			System.exit(1);
		}
	}

	/**
	 * The real workhorse which creates the XML structure
	 */
	private void createDOMTree() {

		// create the root element

		Element rootElement = this.dom.createElement("Books"); //$NON-NLS-1$
		this.dom.appendChild(rootElement);

		Element bElement;
		for (Book b : this.bookList) {
			bElement = createEmpElement(b);
			rootElement.appendChild(bElement);
		}
	}

	private Element createEmpElement(Book b) {

		Element bElement = this.dom.createElement("Book"); //$NON-NLS-1$

		// create author element and author text node and attach it to
		// bookElement
		Element nameElement = this.dom.createElement("Author"); //$NON-NLS-1$
		Text nameText = this.dom.createTextNode(b.getAuthor());
		nameElement.appendChild(nameText);
		bElement.appendChild(nameElement);

		// create title element and title text node and attach it to bookElement
		Element tElement = this.dom.createElement("Title"); //$NON-NLS-1$
		Text addText = this.dom.createTextNode(b.getTitle());
		tElement.appendChild(addText);
		bElement.appendChild(tElement);
		
		Element isbnElement = this.dom.createElement("ISBN"); //$NON-NLS-1$
		Text isbnText = this.dom.createTextNode(b.getIsbn());
		isbnElement.appendChild(isbnText);
		bElement.appendChild(isbnElement);
		
		Element amountElement = this.dom.createElement("Amount"); //$NON-NLS-1$
		Text amountText = this.dom.createTextNode(Integer.toString(b.getAmount()));
		amountElement.appendChild(amountText);
		bElement.appendChild(amountElement);

		return bElement;
	}

	@SuppressWarnings({ "resource" })
	private void printToFile(){

		try
		{
			//print
			OutputFormat format = new OutputFormat(this.dom);
			format.setIndenting(true);

			//to generate output to console use this serializer
			//XMLSerializer serializer = new XMLSerializer(System.out, format);


			//to generate a file output use fileoutputstream instead of system.out
			XMLSerializer serializer = new XMLSerializer(
			new FileOutputStream(new File("C:\\book_database.xml")), format); //$NON-NLS-1$

			serializer.serialize(this.dom);

		} catch(IOException ie) {
		    ie.printStackTrace();
		}
	}
	
	public void start(){
		loadData();
		createDocument();
		createDOMTree();
		printToFile();
	}
	
}
