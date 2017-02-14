package in.spring4buddies.application.sqlquery;

import in.spring4buddies.application.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

public class BookMappingSqlQuery extends MappingSqlQuery<Book> {

	public BookMappingSqlQuery(DataSource ds) {
		super(ds, "select * from book where book_id = ?");
		super.declareParameter(new SqlParameter("book_id", Types.INTEGER));
		compile();
	}

	@Override
	protected Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();
		book.setBookId(rs.getInt("BOOK_ID"));
		book.setIsbn(rs.getString("ISBN"));
		book.setTitle(rs.getString("TITLE"));
		book.setAuthor(rs.getString("AUTHOR"));
		book.setEdition(rs.getInt("EDITION"));
		book.setPublishingDate(rs.getDate("PUBLISHING_DATE"));
		book.setPublisher(rs.getString("PUBLISHER"));
		book.setCityPublished(rs.getString("CITY_PUBLISHED"));
		book.setPrince(rs.getDouble("PRICE"));
		return book;
	}
}