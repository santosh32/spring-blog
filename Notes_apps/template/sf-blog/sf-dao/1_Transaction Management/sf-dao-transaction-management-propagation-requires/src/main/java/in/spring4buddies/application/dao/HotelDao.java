package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Hotel;

import java.util.ArrayList;
import java.util.Date;

public interface HotelDao {
	ArrayList<Hotel> getHotelNamesFor(Date from, Date to);

	void bookHotel(Hotel hotel);
}