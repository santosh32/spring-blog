package in.spring4buddies.application.dao;

import in.spring4buddies.application.dao.helper.HotelRowMapper;
import in.spring4buddies.application.dao.helper.TravelTripRowMapper;
import in.spring4buddies.application.model.Hotel;
import in.spring4buddies.application.model.Passenger;
import in.spring4buddies.application.model.TravelTrip;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HotelDaoImpl implements HotelDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Hotel> getAllHotels() {
		String sql = "SELECT * FROM HOTEL";
		return jdbcTemplate.query(sql, new HotelRowMapper());
	}

	@Override
	public void bookHotelWithPassenger(Hotel hotel, Passenger passenger) {
		String sql = "INSERT INTO HOTEL_PASSENGER (hotel_id, passenger_Id, booked_from, booked_to) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { hotel.getHotelId(), passenger.getPassengerId(), passenger.getBookedFrom(), passenger.getBookedTo() });
	}
	
	public TravelTrip getTravelTripByPassengerId(int passengerId) {
		System.out.println("Travel Trip details are...");

		String sql = "select p.name p_name, h.name h_name, f.name f_name, fp.booked_from, fp.booked_to "
				+ "from Flight f, Hotel h, Passenger p, Flight_Passenger fp, Hotel_Passenger hp where p.passenger_Id = fp.passenger_Id "
				+ "and p.passenger_Id = hp.passenger_Id and f.flight_Id = fp.flight_Id and h.hotel_Id = hp.hotel_Id and p.passenger_Id = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] { passengerId }, new TravelTripRowMapper());
	}
}