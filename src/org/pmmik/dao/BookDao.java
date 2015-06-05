package org.pmmik.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.pmmik.pojo.Book;

public class BookDao extends AbstractDao<Book, Integer> {

	public BookDao(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Book> listAllBooks() {
		return super.listAll(Book.TABLE_NAME);
	}
	
	public List<Book> searchByAuthor(String name){
		String sqlCommand = String.format("select b from %s b where b.%s='*%s*'", Book.TABLE_NAME, Book.AUTHOR, name); //$NON-NLS-1$
		Query q = this.getEntityManager().createQuery(sqlCommand);
		
		try{
			List<Book> result = new ArrayList<>();
			for (Object item : q.getResultList()) {
				result.add((Book) item);
			}
			return result;
		}catch(Exception e){
			return null;
		}
	}
	
	public List<Book> searchByTitle(String title){
		String sqlCommand=String.format("select b from %s b where b.%s='*%s*'",Book.TABLE_NAME,Book.TITLE,title); //$NON-NLS-1$
		Query q=this.getEntityManager().createQuery(sqlCommand);
		
		try {
			List<Book> result = new ArrayList<>();
			for (Object item : q.getResultList()) {
				result.add((Book) item);
			}
			return result;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Book> searchByAuthorAndTitle(String text) {
		String[] words = text.split(" "); //$NON-NLS-1$
		String sqlCommand;
		Query q;
		List<Book> qResult = new ArrayList<>();
		List<Book> result = new ArrayList<>();
		
		for (String word : words) {
			sqlCommand = String.format("select b from %s b where b.%s='*%s*' or b.%s='*%s*'", Book.TABLE_NAME, Book.AUTHOR, word, Book.TITLE, word); //$NON-NLS-1$
			q = this.getEntityManager().createQuery(sqlCommand);
			
			qResult.clear();
			for (Object item : q.getResultList()) {
				qResult.add((Book) item);
			}
			
			if (result.isEmpty()) {
				for (Book book : qResult) {
					result.add(book);
				}
			}
			else {
				for (Book book : qResult) {
					if (!result.contains(book)) {
						result.remove(book);
					}
				}
			}
		}
		
		return result;
	}
	
}
