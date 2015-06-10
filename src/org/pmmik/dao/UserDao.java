package org.pmmik.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.pmmik.pojo.User;

public class UserDao extends AbstractDao<User, Integer> {

	public UserDao(EntityManager entityManager) {
		super(entityManager);
	}
	
	public boolean login(String username, String password) {
		String sqlCommand = String.format("select u from %s u where u.%s='%s' and u.%s='%s'",  //$NON-NLS-1$
				User.TABLE_NAME, "username", username, "password", password); //$NON-NLS-1$ //$NON-NLS-2$
		Query q = this.getEntityManager().createQuery(sqlCommand);
		
		User user = (User) q.getSingleResult();
		
		return user != null;
	}
}
