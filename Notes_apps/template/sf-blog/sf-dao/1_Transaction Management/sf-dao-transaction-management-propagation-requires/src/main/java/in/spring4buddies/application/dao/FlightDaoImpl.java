package in.spring4buddies.application.dao;

import in.spring4buddies.application.dao.helper.FlightRowMapper;
import in.spring4buddies.application.model.Flight;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FlightDaoImpl implements FlightDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Flight> getFlightsFor(Date from, Date to) {
//		String sql = "SELECT * FROM Flight WHERE BOOKED_FROM = ? AND BOOKED_TO TO = ?";
		String sql = "SELECT * FROM Flight";
//		return jdbcTemplate.query(sql, new Object[] { from, to }, new FlightRowMapper());
		return jdbcTemplate.query(sql, new FlightRowMapper());
	}

	@Override
	public void bookFlight(Flight flight) {
		String sql = "INSERT INTO Flight (flight_id, name, type, booked_from, booked_to) VALUES (?, ?, ?, ?);";
		jdbcTemplate.update(sql,
				new Object[] { flight.getFlightId(), flight.getName(), flight.getType(), flight.getBookedFrom(), flight.getBookedTo() });
	}
}