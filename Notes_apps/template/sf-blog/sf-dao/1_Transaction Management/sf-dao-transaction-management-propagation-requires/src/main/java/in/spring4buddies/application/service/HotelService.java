package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Hotel;

import java.util.Date;
import java.util.List;

public interface HotelService {

	List<Hotel> getHotelsFor(Date from, Date to);

	void bookHotel(Hotel hotel);
}