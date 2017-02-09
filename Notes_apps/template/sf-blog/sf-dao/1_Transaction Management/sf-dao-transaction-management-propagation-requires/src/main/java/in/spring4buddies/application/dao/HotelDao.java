package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Hotel;

import java.util.Date;
import java.util.List;

public interface HotelDao {
	
	List<Hotel> getHotelNamesFor(Date from, Date to);

	void bookHotel(Hotel hotel);
}