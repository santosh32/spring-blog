package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class MovieDaoImpl implements MovieDao {

	@Autowired
	private SimpleJdbcInsert simpleJdbcInsert;

	@Override
	public long addMovie(final Movie movie) {

		simpleJdbcInsert.withSchemaName("srlp")
			.withTableName("movie")
			.usingGeneratedKeyColumns("movie_id");

		SqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("title", movie.getTitle())
			.addValue("director", movie.getDirector())
			.addValue("genre", movie.getGenre())
			.addValue("raiting", movie.getRaiting())
			.addValue("box_office", movie.getBoxOffice());

		Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);

		return insertedId.longValue();
	}
}