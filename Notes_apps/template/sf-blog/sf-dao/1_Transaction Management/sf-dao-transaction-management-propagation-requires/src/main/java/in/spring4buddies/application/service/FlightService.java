package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Flight;
import in.spring4buddies.application.model.Passenger;

import java.util.List;

public interface FlightService {

	List<Flight> getAllFlights();

	void bookFlight(Flight flight, Passenger passenger);
}