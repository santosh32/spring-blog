package in.spring4buddies.application.service;

import in.spring4buddies.application.dao.FlightDao;
import in.spring4buddies.application.model.Flight;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightDao flightDao;

	@Override
	public ArrayList<Flight> getFlightsFor(Date from, Date to) {
		return flightDao.getFlightsFor(from, to);
	}

	@Override
	public void bookFlight(Flight flight) {
		flightDao.bookFlight(flight);
	}
}