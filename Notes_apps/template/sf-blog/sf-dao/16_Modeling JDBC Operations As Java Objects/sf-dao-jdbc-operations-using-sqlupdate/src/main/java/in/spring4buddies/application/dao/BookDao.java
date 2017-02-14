package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Book;

public interface BookDao {

	Book getBookById(int bookId);

}