package in.spring4buddies.application.service;

import in.spring4buddies.application.dao.FlightDao;
import in.spring4buddies.application.exception.FlightNotAvailbleException;
import in.spring4buddies.application.model.Flight;
import in.spring4buddies.application.model.Passenger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightDao flightDao;

	@Transactional(readOnly = true)
	@Override
	public List<Flight> getAllFlights() {
		return flightDao.getAllFlights();
	}

	@Transactional(rollbackFor = FlightNotAvailbleException.class, noRollbackFor = FlightNotAvailbleException.class)
	@Override
	public void bookFlightWithPassenger(Flight flight, Passenger passenger) throws FlightNotAvailbleException {
		flightDao.bookFlightWithPassenger(flight, passenger);
		throw new FlightNotAvailbleException("Flights Not Available For Specified details");
	}
}