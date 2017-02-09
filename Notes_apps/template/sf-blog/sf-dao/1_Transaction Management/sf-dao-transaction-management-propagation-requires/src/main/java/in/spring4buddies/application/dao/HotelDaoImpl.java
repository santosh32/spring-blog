package in.spring4buddies.application.dao;

import in.spring4buddies.application.dao.helper.HotelRowMapper;
import in.spring4buddies.application.model.Hotel;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HotelDaoImpl implements HotelDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Hotel> getHotelNamesFor(Date from, Date to) {
		String sql = "SELECT * FROM HOTEL WHERE FROM=? AND TO= ?;";
		return jdbcTemplate.query(sql, new Object[] { from, to }, new HotelRowMapper());
	}

	@Override
	public void bookHotel(Hotel hotel) {
		String sql = "INSERT INTO HOTEL (hotel_id, name, type, booked_from, booked_to) VALUES (?, ?, ?, ?);";
		jdbcTemplate.update(sql, new Object[] { hotel.getHotelId(), hotel.getName(), hotel.getType(), hotel.getBookedFrom(), hotel.getBookedTo() });
	}
}