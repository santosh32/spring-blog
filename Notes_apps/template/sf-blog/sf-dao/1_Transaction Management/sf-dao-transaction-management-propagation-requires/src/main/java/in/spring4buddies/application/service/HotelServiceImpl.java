package in.spring4buddies.application.service;

import in.spring4buddies.application.dao.HotelDao;
import in.spring4buddies.application.model.Hotel;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelDao hotelDao;

	@Override
	public ArrayList<Hotel> getHotelNamesFor(Date from, Date to) {
		return hotelDao.getHotelNamesFor(from, to);
	}

	@Override
	public void bookHotel(Hotel hotel) {
		hotelDao.bookHotel(hotel);
	}
}