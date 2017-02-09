package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Flight;

import java.util.Date;
import java.util.List;

public interface FlightService {

	List<Flight> getFlightsFor(Date from, Date to);

	void bookFlight(Flight flight);
}