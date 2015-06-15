package org.pmmik.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.validation.constraints.AssertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.pmmik.dao.BookDao;
import org.pmmik.dao.Globals;
import org.pmmik.pojo.Book;

public class BookDaoTest {
	
	private EntityManagerFactory emFactory;
	private EntityManager em;
	private BookDao bookDao;
	private List<Book> books = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
		this.emFactory = Persistence.createEntityManagerFactory(Globals.PERSISTENCE_UNIT_NAME);
		this.em = this.emFactory.createEntityManager();
		this.bookDao = new BookDao(this.em);
		
		Book book1 = new Book();
		book1.setAuthor("Patrick Naughton"); //$NON-NLS-1$
		book1.setTitle("The Java Handbook"); //$NON-NLS-1$
		book1.setAmount(3);
		book1.setIsbn("0-07-882199-1");
		book1.setLoanable(true);
		this.books.add(book1);
		
		Book book2 = new Book();
		book2.setAuthor("Robert C. Martin"); //$NON-NLS-1$
		book2.setTitle("Clean Code"); //$NON-NLS-1$
		book2.setAmount(2);
		book2.setIsbn("978-0132350884");
		book2.setLoanable(true);
		this.books.add(book2);
	}

	@Test
	public void testListAllBooks() {
		int i=0;
		while (i<bookDao.listAllBooks().size()) {
			assertEquals(bookDao.listAllBooks().get(i).getAmount(), books.get(i).getAmount());
			assertEquals(bookDao.listAllBooks().get(i).getAuthor(), books.get(i).getAuthor());
			assertEquals(bookDao.listAllBooks().get(i).getIsbn(), books.get(i).getIsbn());
			assertEquals(bookDao.listAllBooks().get(i).getTitle(), books.get(i).getTitle());
			i+=1;
		}
	}

	@Test
	public void testSearchByAuthor() {
		assertEquals(books.get(0).getAuthor(), bookDao.searchByAuthor("Patrick").get(0).getAuthor());
	}

	@Test
	public void testSearchByTitle() {
		assertEquals(books.get(1).getTitle(), bookDao.searchByTitle("Clean").get(0).getTitle());
	}

	@Test
	public void testSearchByAuthorAndTitle() {
		assertEquals(books.get(0).getAuthor(), bookDao.searchByAuthorAndTitle("Java").get(0).getAuthor());
	}
	
	@Test
	public void testSelectById(){
		assertEquals(books.get(0).getAuthor(), bookDao.selectById("0-07-882199-1").getAuthor());
	}

}
