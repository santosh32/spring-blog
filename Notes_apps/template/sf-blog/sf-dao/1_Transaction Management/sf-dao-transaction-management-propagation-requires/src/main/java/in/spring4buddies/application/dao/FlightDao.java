package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Flight;

import java.util.ArrayList;
import java.util.Date;

public interface FlightDao {

	ArrayList<Flight> getFlightsFor(Date from, Date to);

	void bookFlight(Flight flight);
}