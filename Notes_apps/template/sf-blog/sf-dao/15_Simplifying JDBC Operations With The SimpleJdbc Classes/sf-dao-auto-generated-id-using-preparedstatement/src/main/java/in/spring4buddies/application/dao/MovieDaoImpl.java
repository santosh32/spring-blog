package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MovieDaoImpl implements MovieDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_MOVIE = "insert into movie(title, director) values(?, ?)";

	@Override
	public long addMovie(final Movie movie) {
		final PreparedStatementCreator psc = new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(final Connection connection) throws SQLException {
				final PreparedStatement ps = connection.prepareStatement(SQL_INSERT_MOVIE, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, movie.getTitle());
				ps.setString(2, movie.getDirector());
				return ps;
			}

		};
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(psc, keyHolder);
		long insertedId = keyHolder.getKey().longValue();
		return insertedId;
	}

}