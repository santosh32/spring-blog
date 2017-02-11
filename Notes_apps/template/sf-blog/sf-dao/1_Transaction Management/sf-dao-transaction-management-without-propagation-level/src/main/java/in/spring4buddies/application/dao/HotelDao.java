package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Hotel;
import in.spring4buddies.application.model.Passenger;

import java.util.List;

public interface HotelDao {
	
	List<Hotel> getAllHotels();

	void bookHotelWithPassenger(Hotel hotel, Passenger passenger);
}