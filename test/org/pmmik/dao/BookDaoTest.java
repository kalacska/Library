package org.pmmik.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
		book1.setAuthor("Sir Arthur Conan Doyle"); //$NON-NLS-1$
		book1.setTitle("The Adventures of Sherlock Holmes"); //$NON-NLS-1$
		this.books.add(book1);
		
		Book book2 = new Book();
		book2.setAuthor("Sir Arthur Conan Doyle"); //$NON-NLS-1$
		book2.setTitle("The Lost World"); //$NON-NLS-1$
		this.books.add(book2);
	}

	@After
	public void tearDown() throws Exception {
		this.em = this.emFactory.createEntityManager();
		this.em.getTransaction().begin();
		
		Query q = this.em.createQuery("delete from " + Book.TABLE_NAME); //$NON-NLS-1$
		q.executeUpdate();
		this.em.getTransaction().commit();
		this.em.close();
	}

	@Ignore
	@Test
	public void testListAllBooks() {
		fail("Not yet implemented"); //$NON-NLS-1$
	}

	@Ignore
	@Test
	public void testSearchByAuthor() {
		Query q = this.em.createQuery("select b from " + Book.TABLE_NAME + " b where b.id=2"); //$NON-NLS-1$ //$NON-NLS-2$
		List<Book> expected = q.getResultList();
		
		assertEquals(expected, this.bookDao.searchByAuthor("Martin")); //$NON-NLS-1$
	}

	@Ignore
	@Test
	public void testSearchByTitle() {
		fail("Not yet implemented"); //$NON-NLS-1$
	}

	@Ignore
	@Test
	public void testSearchByAuthorAndTitle() {
		fail("Not yet implemented"); //$NON-NLS-1$
	}

}
