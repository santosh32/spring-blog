package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Flight;

import java.util.ArrayList;
import java.util.Date;

public interface FlightService {

	ArrayList<Flight> getFlightsFor(Date from, Date to);

	void bookFlight(Flight flight);
}