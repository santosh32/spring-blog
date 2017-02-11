package in.spring4buddies.application.dao;

import in.spring4buddies.application.dao.helper.TravelTripRowMapper;
import in.spring4buddies.application.model.Passenger;
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

		String sql = "SELECT p.NAME p_name, "+
						  "h.NAME h_name, "+
						  "f.NAME f_name, "+
						  "fp.booked_from, "+
						  "fp.booked_to, "+
						  "p.passenger_id, "+
						  "f.flight_id, "+
						  "h.hotel_id "+
						"FROM flight f, "+
						  "hotel h, "+
						  "passenger p, "+
						  "flight_passenger fp, "+
						  "hotel_passenger hp "+
						"WHERE p.passenger_id = fp.passenger_id "+
						"AND p.passenger_id   = hp.passenger_id "+
						"AND f.flight_id      = fp.flight_id "+
						"AND h.hotel_id       = hp.hotel_id "+
						"AND p.passenger_id   = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] { passengerId }, new TravelTripRowMapper());
	}

	@Override
	public void insertPassenger(Passenger passenger) {
		String sql = "INSERT INTO PASSENGER (passenger_Id, name) VALUES (?, ?)";
		jdbcTemplate.update(sql,
				new Object[] { passenger.getPassengerId(), passenger.getName()});		
	}
}