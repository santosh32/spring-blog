package in.spring4buddies.application.sqlquery;

import in.spring4buddies.application.model.Book;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

public class BookSqlUpdate extends SqlUpdate {

	public BookSqlUpdate(DataSource ds) {
		setDataSource(ds);
		setSql("INSERT INTO BOOK (BOOK_ID, ISBN, TITLE, AUTHOR, PUBLISHER, CITY_PUBLISHED, PUBLISHING_DATE, EDITION, PRICE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?");
		declareParameter(new SqlParameter("BOOK_ID", Types.NUMERIC));
		declareParameter(new SqlParameter("EDITION", Types.NUMERIC));
		declareParameter(new SqlParameter("PRICE", Types.NUMERIC));
		declareParameter(new SqlParameter("ISBN", Types.VARCHAR));
		declareParameter(new SqlParameter("TITLE", Types.VARCHAR));
		declareParameter(new SqlParameter("AUTHOR", Types.VARCHAR));
		declareParameter(new SqlParameter("PUBLISHING_DATE", Types.DATE));
		declareParameter(new SqlParameter("PUBLISHER", Types.VARCHAR));
		declareParameter(new SqlParameter("CITY_PUBLISHED", Types.VARCHAR));
		compile();
	}

	public int execute(Book book) {
		return update(book.getBookId(), book.getIsbn(), book.getTitle(), book.getAuthor(), book.getEdition(), book.getPublishingDate(),
				book.getPublisher(), book.getCityPublished(), book.getPrince());
	}
}