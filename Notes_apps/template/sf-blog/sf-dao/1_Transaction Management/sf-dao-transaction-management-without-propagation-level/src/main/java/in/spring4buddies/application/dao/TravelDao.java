package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Passenger;
import in.spring4buddies.application.model.TravelTrip;

public interface TravelDao {

	TravelTrip getTravelTripByPassengerId(int passengerId);

	void insertPassenger(Passenger passenger);
}