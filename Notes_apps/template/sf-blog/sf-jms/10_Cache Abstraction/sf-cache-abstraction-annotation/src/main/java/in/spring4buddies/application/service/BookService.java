package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Book;

public interface BookService {

	Book getBookByIsbn(String isbn, String name);

	Book getBookByCacheKeyIsbn(String isbn, String name);

	Book getBookByIsbnAndBasedOnCondition(String isbn, String name);

	void refreshAllBooks();

	Book updateBook(String isbn, String name);
}