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
		String sqlCommand = String.format("select b from %s b where b.%s like :author", Book.TABLE_NAME, "author"); //$NON-NLS-1$ //$NON-NLS-2$
		Query q = this.getEntityManager().createQuery(sqlCommand);
		q.setParameter("author","%"+name+"%"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		
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
		String sqlCommand=String.format("select b from %s b where b.%s like :title",Book.TABLE_NAME,"title"); //$NON-NLS-1$ //$NON-NLS-2$
		Query q=this.getEntityManager().createQuery(sqlCommand);
		q.setParameter("title", "%"+title+"%"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		
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
			sqlCommand = String.format("select b from %s b where b.%s like :p1 or b.%s like :p2", Book.TABLE_NAME, "author", "title"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

			q = this.getEntityManager().createQuery(sqlCommand);
			q.setParameter("p1", "%"+word+"%"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			q.setParameter("p2", "%"+word+"%"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			
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
