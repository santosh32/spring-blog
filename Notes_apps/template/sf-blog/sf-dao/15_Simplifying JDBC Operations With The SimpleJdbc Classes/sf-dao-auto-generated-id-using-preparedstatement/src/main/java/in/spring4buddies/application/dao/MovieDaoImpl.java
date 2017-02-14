package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MovieDaoImpl implements MovieDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_MOVIE = "insert into movie (MOVIE_ID, title, director) values (MOVIE_SEQ.NEXTVAL, :title, :director)";

	@Override
	public long addMovie(final Movie movie) {

		KeyHolder keyHolder = new GeneratedKeyHolder();

		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
				final PreparedStatement ps = connection.prepareStatement(SQL_INSERT_MOVIE, new String[] { "MOVIE_ID" });
				ps.setString(1, movie.getTitle());
				ps.setString(2, movie.getDirector());
				return ps;
			}

		};

		jdbcTemplate.update(psc, keyHolder);

		long insertedId = keyHolder.getKey().longValue();
		return insertedId;
	}

}