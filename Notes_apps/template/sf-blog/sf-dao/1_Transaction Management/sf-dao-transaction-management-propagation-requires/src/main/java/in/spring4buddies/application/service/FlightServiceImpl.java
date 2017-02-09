package in.spring4buddies.application.service;

import in.spring4buddies.application.dao.FlightDao;
import in.spring4buddies.application.model.Flight;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightDao flightDao;

	@Override
	public List<Flight> getFlightsFor(Date from, Date to) {
		return flightDao.getFlightsFor(from, to);
	}

	@Override
	public void bookFlight(Flight flight) {
		flightDao.bookFlight(flight);
	}
}