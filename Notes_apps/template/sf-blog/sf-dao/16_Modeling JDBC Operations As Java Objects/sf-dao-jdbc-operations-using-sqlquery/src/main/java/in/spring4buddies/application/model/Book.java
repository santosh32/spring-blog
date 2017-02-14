package in.spring4buddies.application.model;

import java.util.Date;

public class Book {

	private int bookId;
	private String isbn;
	private String title;
	private String author;
	private int edition;
	private Date publishingDate;
	private String publisher;
	private String cityPublished;
	private double prince;

	public Book() {

	}

	public Book(int bookId, String isbn, String title, String author, int edition, Date publishingDate, String publisher, String cityPublished,
			double prince) {
		super();
		this.bookId = bookId;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.edition = edition;
		this.publishingDate = publishingDate;
		this.publisher = publisher;
		this.cityPublished = cityPublished;
		this.prince = prince;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public Date getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCityPublished() {
		return cityPublished;
	}

	public void setCityPublished(String cityPublished) {
		this.cityPublished = cityPublished;
	}

	public double getPrince() {
		return prince;
	}

	public void setPrince(double prince) {
		this.prince = prince;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", edition=" + edition + ", publishingDate="
				+ publishingDate + ", publisher=" + publisher + ", cityPublished=" + cityPublished + ", prince=" + prince + "]";
	}

}