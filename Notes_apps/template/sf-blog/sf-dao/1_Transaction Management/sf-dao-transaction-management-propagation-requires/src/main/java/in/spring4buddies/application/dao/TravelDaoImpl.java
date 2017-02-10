package in.spring4buddies.application.dao;

import in.spring4buddies.application.dao.helper.TravelTripRowMapper;
import in.spring4buddies.application.model.TravelTrip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TravelDaoImpl implements TravelDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public TravelTrip getTravelTripByPassengerId(int passengerId) {

		String sql = "select p.name p_name, h.name h_name, f.name f_name, fp.booked_from, fp.booked_to "
				+ "from Flight f, Hotel h, Passenger p, Flight_Passenger fp, Hotel_Passenger hp where p.passenger_Id = fp.passenger_Id "
				+ "and p.passenger_Id = hp.passenger_Id and f.flight_Id = fp.flight_Id and h.hotel_Id = hp.hotel_Id and p.passenger_Id = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] { passengerId }, new TravelTripRowMapper());
	}
}