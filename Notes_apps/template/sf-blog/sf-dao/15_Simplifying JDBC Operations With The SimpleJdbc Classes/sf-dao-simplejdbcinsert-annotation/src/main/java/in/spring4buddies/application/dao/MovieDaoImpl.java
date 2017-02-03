package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Movie;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class MovieDaoImpl implements MovieDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SimpleJdbcInsert simpleJdbcInsert;

	@Override
	public long addMovie(final Movie movie) {

		simpleJdbcInsert.withTableName("movie").usingGeneratedKeyColumns("id");
		
		Map<String, Object> parameters = new HashMap<String, Object>(2);
		parameters.put("title", movie.getTitle());
		parameters.put("director", movie.getDirector());
		
		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
		return insertedId.longValue();
	}
}