package in.spring4buddies.application.service;

import in.spring4buddies.application.dao.TravelDao;
import in.spring4buddies.application.model.Flight;
import in.spring4buddies.application.model.Hotel;
import in.spring4buddies.application.model.Passenger;
import in.spring4buddies.application.model.TravelTrip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TravelServiceImpl implements TravelService {

	@Autowired
	private HotelService hotelService;

	@Autowired
	private FlightService flightService;

	@Autowired
	TravelDao travelDao;

	@Override
	public TravelTrip getTravelTripByPassengerId(int passengerId) {
		return travelDao.getTravelTripByPassengerId(passengerId);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public TravelTrip bookFlightAndHotel(Hotel hotel, Flight flight, Passenger passenger) throws Exception {
		travelDao.insertPassenger(passenger);
		try {
			flightService.bookFlightWithPassenger(flight, passenger);
			hotelService.bookHotelWithPassenger(hotel, passenger);
			System.out.println("Booked Flight and Hotel Successfully");
			return getTravelTripByPassengerId(passenger.getPassengerId());
		} catch (Exception e) {
			System.out.println("==> " + e.getMessage());
		}
		return null;
	}
}