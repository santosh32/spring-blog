package in.spring4buddies.application.service;

import in.spring4buddies.application.dao.HotelDao;
import in.spring4buddies.application.model.Hotel;

import java.util.Date;
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
	public List<Hotel> getHotelFor(Date from, Date to) {
		return hotelDao.getHotelNamesFor(from, to);
	}

	@Transactional(rollbackFor = Exception.class, noRollbackFor = Exception.class)
	@Override
	public void bookHotel(Hotel hotel) {
		hotelDao.bookHotel(hotel);
	}
}