package in.spring4buddies.application.service;

import in.spring4buddies.application.dao.HotelDao;
import in.spring4buddies.application.exception.HotelNotAvailbleException;
import in.spring4buddies.application.model.Hotel;
import in.spring4buddies.application.model.Passenger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelDao hotelDao;

	@Override
	public List<Hotel> getAllHotels() {
		return hotelDao.getAllHotels();
	}

	@Override
	public void bookHotelWithPassenger(Hotel hotel, Passenger passenger) throws HotelNotAvailbleException {
		hotelDao.bookHotelWithPassenger(hotel, passenger);
		throw new HotelNotAvailbleException("Hotels Not Available For Specified details");
	}
}