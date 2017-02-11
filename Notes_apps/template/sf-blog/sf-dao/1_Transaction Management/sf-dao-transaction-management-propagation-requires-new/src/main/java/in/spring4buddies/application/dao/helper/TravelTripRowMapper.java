package in.spring4buddies.application.dao.helper;

import in.spring4buddies.application.model.TravelTrip;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TravelTripRowMapper implements RowMapper<TravelTrip> {

	public TravelTrip mapRow(ResultSet rs, int rowNum) throws SQLException {
		TravelTrip travelTrip = new TravelTrip();
		travelTrip.setPassengerId(rs.getInt("passenger_id"));
		travelTrip.setName(rs.getString("p_name"));
		travelTrip.setHotelId(rs.getInt("hotel_id"));
		travelTrip.setHotelName(rs.getString("h_name"));
		travelTrip.setFlightId(rs.getInt("flight_id"));
		travelTrip.setFlightName(rs.getString("f_name"));
		travelTrip.setBookedFrom(rs.getDate("booked_from"));
		travelTrip.setBookedTo(rs.getDate("booked_to"));
		return travelTrip;
	}
}