package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Hotel;

import java.util.ArrayList;
import java.util.Date;

public interface HotelService {
	ArrayList<Hotel> getHotelNamesFor(Date from, Date to);

	void bookHotel(Hotel hotel);
}