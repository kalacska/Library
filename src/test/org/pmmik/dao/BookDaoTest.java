package test.org.pmmik.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.pmmik.dao.BookDao;
import org.pmmik.pojo.Book;

public class BookDaoTest {
	
	private static final String PESISTENCE_UNIT_NAME = Book.TABLE_NAME; //$NON-NLS-1$
	private EntityManagerFactory emFactory;
	private EntityManager em;
	private BookDao bookDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.emFactory = Persistence.createEntityManagerFactory(PESISTENCE_UNIT_NAME);
		this.em = this.emFactory.createEntityManager();
		bookDao = new BookDao(em);
		
		Book book1 = new Book();
		book1.setAuthor("Sir Arthur Conan Doyle");
		book1.setTitle("The Adventures of Sherlock Holmes");
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
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSearchByAuthor() {
		Query q = this.em.createQuery("select b from " + Book.TABLE_NAME + " b where b.id=0"); //$NON-NLS-1$
		List<Book> expected = q.getResultList();
		
		assertEquals(expected, bookDao.searchByAuthor("Doyle"));
	}

	@Ignore
	@Test
	public void testSearchByTitle() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSearchByAuthorAndTitle() {
		fail("Not yet implemented");
	}

}
