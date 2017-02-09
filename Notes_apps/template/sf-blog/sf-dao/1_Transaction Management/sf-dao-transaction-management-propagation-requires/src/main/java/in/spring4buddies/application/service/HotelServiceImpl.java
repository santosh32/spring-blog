package in.spring4buddies.application.service;

import in.spring4buddies.application.dao.HotelDao;
import in.spring4buddies.application.model.Hotel;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelDao hotelDao;

	@Override
	public List<Hotel> getHotelNamesFor(Date from, Date to) {
		return hotelDao.getHotelNamesFor(from, to);
	}

	@Override
	public void bookHotel(Hotel hotel) {
		hotelDao.bookHotel(hotel);
	}
}