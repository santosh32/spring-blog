package in.spring4buddies.application.dao.helper;

import in.spring4buddies.application.model.Hotel;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class HotelRowMapper implements RowMapper<Hotel> {

	public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
		Hotel hotel = new Hotel();
		hotel.setHotelId(rs.getInt("hotel_id"));
		hotel.setName(rs.getString("name"));
		hotel.setType(rs.getString("type"));
		hotel.setBookedFrom(rs.getDate("bookedFrom"));
		hotel.setBookedTo(rs.getDate("bookedTo"));
		return hotel;
	}
}