package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Movie;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class MovieDaoImpl implements MovieDao {

	@Autowired
	private SimpleJdbcInsert simpleJdbcInsert;

	@Override
	public long addMovie(final Movie movie) {

		simpleJdbcInsert.withSchemaName("srlp").withTableName("movie");

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("movie_id", movie.getId());
		parameters.put("title", movie.getTitle());
		parameters.put("director", movie.getDirector());
		parameters.put("genre", movie.getGenre());
		parameters.put("raiting", movie.getRaiting());
		parameters.put("box_office", movie.getBoxOffice());

		Number insertedId = simpleJdbcInsert.execute(parameters);

		return insertedId.longValue();
	}
}