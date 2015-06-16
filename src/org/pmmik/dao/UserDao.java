package org.pmmik.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.pmmik.pojo.User;

public class UserDao extends AbstractDao<User, Integer> {

	public UserDao(EntityManager entityManager) {
		super(entityManager);
	}

	public boolean login(String username, String password) {
		String sqlCommand = String.format(
				"select u from %s u where u.%s=:uname and u.%s=:pw", //$NON-NLS-1$
				User.TABLE_NAME, "username", "password"); //$NON-NLS-1$ //$NON-NLS-2$
		Query q = this.getEntityManager().createQuery(sqlCommand);
		q.setParameter("uname", username); //$NON-NLS-1$
		q.setParameter("pw", password); //$NON-NLS-1$
		List<User> users = q.getResultList();

		return !users.isEmpty();
	}
}
