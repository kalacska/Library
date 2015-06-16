package org.pmmik.comparator;

import java.util.Comparator;

import org.pmmik.pojo.Book;

public class ComparatorClass implements Comparator<Book> {

	@Override
	public int compare(Book b1, Book b2) {
		// TODO Auto-generated method stub
		return b1.getAuthor().compareTo(b2.getAuthor());
	}

}
