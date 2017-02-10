package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Flight;
import in.spring4buddies.application.model.Passenger;

import java.util.List;

public interface FlightDao {

	List<Flight> getAllFlights();

	void bookFlight(Flight flight, Passenger passenger);
}