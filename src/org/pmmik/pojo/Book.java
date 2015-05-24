package org.pmmik.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = Book.TABLE_NAME)
@Table(name = Book.TABLE_NAME, schema = PersistentObject.SCHEMA)
public class Book extends PersistentObject {
	
	public final static String TABLE_NAME = "books"; //$NON-NLS-1$
	public final static String C_AUTHOR="book_author";
	public final static String C_TITLE="book_title";
	public final static String C_ISBN="book_isbn";
	public final static String C_LOANABLE="book_loanable";
	public final static String C_AMOUNT="book_amount";
	
	@Column(name=C_AUTHOR, nullable=false)
	private String author;
	@Column(name=C_TITLE, nullable=false)
	private String title;
	@Column(name=C_ISBN, nullable=false, unique=true)
	private String isbn;
	@Column(name=C_LOANABLE, nullable=false)
	private boolean loanable;
	@Column(name=C_AMOUNT, nullable=false)
	private int amount;
	
    public Book(){
    
    }

	public Book(String author, String title, String isbn, boolean loanable,
			int amount) {
		super();
		this.author = author;
		this.title = title;
		this.isbn = isbn;
		this.loanable = loanable;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", isbn=" + isbn
				+ ", loanable=" + loanable + ", amount=" + amount + "]";
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean isLoanable() {
		return loanable;
	}

	public void setLoanable(boolean loanable) {
		this.loanable = loanable;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public static String getTableName() {
		return TABLE_NAME;
	}

	public static String getcAuthor() {
		return C_AUTHOR;
	}

	public static String getcTitle() {
		return C_TITLE;
	}

	public static String getcIsbn() {
		return C_ISBN;
	}

	public static String getcLoanable() {
		return C_LOANABLE;
	}

	public static String getcAmount() {
		return C_AMOUNT;
	}
    
    

}
