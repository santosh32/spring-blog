package in.spring4buddies.application.model;

import java.io.Serializable;

public class Book implements Serializable {
	private static final long serialVersionUID = -4456140130010381102L;
	private String isbn;
	private String name;

	public Book(String isbn, String name) {
		this.isbn = isbn;
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + "]";
	}

}