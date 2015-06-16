package org.pmmik.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {

	private EntityManagerFactory emFactory;
	private EntityManager em;
	private UserDao dao;
	
	@Before
	public void setUp() throws Exception {
		this.emFactory = Persistence.createEntityManagerFactory(Globals.PERSISTENCE_UNIT_NAME);
		this.em = this.emFactory.createEntityManager();
		this.dao = new UserDao(this.em);
	}

	@Test
	public void testLogin() {
		assertTrue(this.dao.login("admin", "admin")); //$NON-NLS-1$ //$NON-NLS-2$
		assertFalse(this.dao.login("admin", "123")); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
