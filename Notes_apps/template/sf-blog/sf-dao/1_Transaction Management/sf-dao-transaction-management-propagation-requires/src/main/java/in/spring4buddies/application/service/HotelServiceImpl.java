package in.spring4buddies.application.service;

import in.spring4buddies.application.dao.HotelDao;
import in.spring4buddies.application.exception.HotelNotAvailbleException;
import in.spring4buddies.application.model.Hotel;
import in.spring4buddies.application.model.Passenger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelDao hotelDao;

	@Transactional(readOnly = true)
	@Override
	public List<Hotel> getAllHotels() {
		return hotelDao.getAllHotels();
	}

	@Transactional(rollbackFor = HotelNotAvailbleException.class, noRollbackFor = HotelNotAvailbleException.class)
	@Override
	public void bookHotelWithPassenger(Hotel hotel, Passenger passenger) throws HotelNotAvailbleException {
		hotelDao.bookHotelWithPassenger(hotel, passenger);
		throw new HotelNotAvailbleException("Hotels Not Availble For Specified details");
	}
}