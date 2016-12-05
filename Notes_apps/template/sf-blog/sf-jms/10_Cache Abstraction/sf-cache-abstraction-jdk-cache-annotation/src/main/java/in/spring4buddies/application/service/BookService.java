package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Book;

public interface BookService {

	Book getBookByIsbn(String isbn, String name);

	void refreshAllBooks();

}