package org.pmmik.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = Book.TABLE_NAME)
@Table(name = Book.TABLE_NAME, schema = PersistentObject.SCHEMA)
public class Book extends PersistentObject {
	
	public final static String TABLE_NAME = "books"; //$NON-NLS-1$
	public final static String AUTHOR="book_author"; //$NON-NLS-1$
	public final static String TITLE="book_title"; //$NON-NLS-1$
	public final static String ISBN="book_isbn"; //$NON-NLS-1$
	public final static String LOANABLE="book_loanable"; //$NON-NLS-1$
	public final static String AMOUNT="book_amount"; //$NON-NLS-1$
	
	@Column(name=AUTHOR, nullable=false)
	private String author;
	@Column(name=TITLE, nullable=false)
	private String title;
	@Column(name=ISBN, nullable=false, unique=true)
	private String isbn;
	@Column(name=LOANABLE, nullable=false)
	private boolean loanable;
	@Column(name=AMOUNT, nullable=false)
	private int amount;
	
    public Book() {
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
		return "Book [author=" + this.author + ", title=" + this.title + ", isbn=" + this.isbn //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ ", loanable=" + this.loanable + ", amount=" + this.amount + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean isLoanable() {
		return this.loanable;
	}

	public void setLoanable(boolean loanable) {
		this.loanable = loanable;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + amount;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + (loanable ? 1231 : 1237);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (amount != other.amount)
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (loanable != other.loanable)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
}
