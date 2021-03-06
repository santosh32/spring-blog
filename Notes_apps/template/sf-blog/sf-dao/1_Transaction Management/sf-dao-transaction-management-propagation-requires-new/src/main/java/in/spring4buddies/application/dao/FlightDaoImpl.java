package in.spring4buddies.application.dao;

import in.spring4buddies.application.dao.helper.FlightRowMapper;
import in.spring4buddies.application.model.Flight;
import in.spring4buddies.application.model.Passenger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FlightDaoImpl implements FlightDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Flight> getAllFlights() {
		String sql = "SELECT * FROM Flight";
		return jdbcTemplate.query(sql, new FlightRowMapper());
	}

	@Override
	public void bookFlightWithPassenger(Flight flight, Passenger passenger) {
		String sql = "INSERT INTO FLIGHT_PASSENGER (flight_id, passenger_Id, booked_from, booked_to) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql,
				new Object[] { flight.getFlightId(), passenger.getPassengerId(), passenger.getBookedFrom(), passenger.getBookedTo() });
	}
}