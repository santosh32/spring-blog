package in.spring4buddies.application.rest.model;

public class Book {

	private String id;

	private String isbn;

	private String title;

	public Book() {
	}

	public Book(String isbn, String title) {
		this.isbn = isbn;
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	@Override
//	public String toString() {
//		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + "]";
//	}

}