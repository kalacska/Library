package org.pmmik.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class AbstractDao<T, PK extends Serializable> implements Dao<T, PK> {

	private EntityManager entityManager;
	protected Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(EntityManager entityManager) {
		this.entityManager = entityManager;
		ParameterizedType genericsSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericsSuperClass.getActualTypeArguments()[0];		
	}

	@Override
	public T create(T t) {
		try {
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(t);
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			this.entityManager.getTransaction().rollback();
		}
		return t;
	}

	@Override
	public T read(PK id) {
		return this.entityManager.find(this.entityClass, id);	
	}

	/*
	 * Merge creates a new instance of your entity, 
	 * copies the state from the supplied entity, and makes the new copy managed.
	 *  
	 * Ld.: http://spitballer.blogspot.hu/2010/04/jpa-persisting-vs-merging-entites.html
	 */
	@Override
	public T update(T t) {
		try {
			this.entityManager.getTransaction().begin();
			T result = this.entityManager.merge(t);
			this.entityManager.getTransaction().commit();
			return result;
		} catch (Exception e) {
			this.entityManager.getTransaction().rollback();
			return t;
		}		
	}

	@Override
	public void delete(T t) {
		try {
			this.entityManager.getTransaction().begin();
			T mgd = this.entityManager.merge(t);
			this.entityManager.remove(mgd);		
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			this.entityManager.getTransaction().rollback();
		}
	}

	public List<T> listAll(String tableName) {		
		
		Query query = this.entityManager.createQuery("Select t from " + tableName + " t"); //$NON-NLS-1$ //$NON-NLS-2$
		@SuppressWarnings("unchecked")
		List<T> dataList = query.getResultList();
	
		return dataList;		
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return this.entityManager;
	}	
	
}
