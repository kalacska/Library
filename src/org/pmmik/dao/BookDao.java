package org.pmmik.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.pmmik.pojo.Book;

public class BookDao extends AbstractDao<Book, Integer> {

	public BookDao(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	public List<Book> listAllBooks() {
		return super.listAll(Book.TABLE_NAME);
	}
	
	public List<Book> searchByAuthor(String name){
		String sqlCommand = String.format("select b from %s b where b.%s = '*%s*'",Book.TABLE_NAME, Book.C_AUTHOR, name); //$NON-NLS-1$
		Query q = this.getEntityManager().createQuery(sqlCommand);
		
		try{
			return (List<Book>) q.getResultList();
		}catch(Exception e){
			return null;
		}
	}
	
	public List<Book> serchByTitle(String title){
		String sqlCommand=String.format("select b from %s b where b.%s='*%s*'",Book.TABLE_NAME,Book.C_TITLE,title);
		Query q=this.getEntityManager().createQuery(sqlCommand);
		
		try {
			return (List<Book>) q.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
}
