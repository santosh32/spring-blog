package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Book;
import in.spring4buddies.application.sqlquery.BookSqlUpdate;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

	private BookSqlUpdate bookSqlUpdate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.bookSqlUpdate = new BookSqlUpdate(dataSource);
	}

	@Override
	public void update(Book book) {
		bookSqlUpdate.execute(book);
	}
}