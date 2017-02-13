package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MovieDaoImpl_NamedParameterJdbcTemplate implements MovieDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private final String SQL_INSERT_MOVIE = "insert into movie (MOVIE_ID, title, director) values(MOVIE_SEQ.NEXTVAL, :title, :director)";

	@Override
	public long addMovie(final Movie movie) {
		MapSqlParameterSource parameters = new MapSqlParameterSource()
			.addValue("title", movie.getTitle())
			.addValue("director", movie.getDirector());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		namedParameterJdbcTemplate.update(SQL_INSERT_MOVIE, parameters, keyHolder, new String[] { "MOVIE_ID" });

		long insertedId = keyHolder.getKey().longValue();
		return insertedId;
	}

}