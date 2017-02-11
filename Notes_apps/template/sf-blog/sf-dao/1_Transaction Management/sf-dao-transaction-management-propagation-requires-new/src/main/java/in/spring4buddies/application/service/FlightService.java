package in.spring4buddies.application.service;

import in.spring4buddies.application.exception.FlightNotAvailbleException;
import in.spring4buddies.application.model.Flight;
import in.spring4buddies.application.model.Passenger;

import java.util.List;

public interface FlightService {

	List<Flight> getAllFlights();

	void bookFlightWithPassenger(Flight flight, Passenger passenger) throws FlightNotAvailbleException;
}