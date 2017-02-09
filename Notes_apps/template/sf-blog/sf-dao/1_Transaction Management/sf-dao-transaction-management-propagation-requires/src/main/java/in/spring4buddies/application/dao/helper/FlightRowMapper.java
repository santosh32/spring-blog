package in.spring4buddies.application.dao.helper;

import in.spring4buddies.application.model.Flight;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FlightRowMapper implements RowMapper<Flight> {

	public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Flight flight = new Flight();
		flight.setFlightId(rs.getInt("flight_id"));
		flight.setName(rs.getString("name"));
		flight.setType(rs.getString("type"));
		flight.setBookedFrom(rs.getDate("booked_from"));
		flight.setBookedTo(rs.getDate("booked_to"));
		return flight;
	}
}