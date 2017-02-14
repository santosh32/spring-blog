package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Book;
import in.spring4buddies.application.sqlquery.BookMappingSqlQuery;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

	private BookMappingSqlQuery bookMappingSqlQuery;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.bookMappingSqlQuery = new BookMappingSqlQuery(dataSource);
	}

	@Override
	public Book getBookById(int bookId) {
		return bookMappingSqlQuery.findObject(bookId);
	}
}