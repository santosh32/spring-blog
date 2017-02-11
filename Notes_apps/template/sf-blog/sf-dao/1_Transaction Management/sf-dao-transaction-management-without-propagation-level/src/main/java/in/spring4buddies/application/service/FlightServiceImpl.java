package in.spring4buddies.application.service;

import in.spring4buddies.application.dao.FlightDao;
import in.spring4buddies.application.exception.FlightNotAvailbleException;
import in.spring4buddies.application.model.Flight;
import in.spring4buddies.application.model.Passenger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightDao flightDao;

	@Override
	public List<Flight> getAllFlights() {
		return flightDao.getAllFlights();
	}

	@Override
	public void bookFlightWithPassenger(Flight flight, Passenger passenger) throws FlightNotAvailbleException {
		flightDao.bookFlightWithPassenger(flight, passenger);
		throw new FlightNotAvailbleException("Flights Not Available For Specified details");
	}
}