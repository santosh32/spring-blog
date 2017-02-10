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

@Transactional(propagation = Propagation.REQUIRED)
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

	@Override
	public TravelTrip bookFlightAndHotel(Hotel hotel, Flight flight, Passenger passenger) {
		hotelService.bookHotel(hotel, passenger);
		flightService.bookFlight(flight, passenger);
		System.out.println("Booked Flight and Hotel Successfully");
		return getTravelTripByPassengerId(passenger.getPassengerId());
	}
}