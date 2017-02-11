package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Flight;
import in.spring4buddies.application.model.Hotel;
import in.spring4buddies.application.model.Passenger;
import in.spring4buddies.application.model.TravelTrip;

import org.springframework.stereotype.Service;

@Service
public interface TravelService {

	TravelTrip getTravelTripByPassengerId(int passengerId);

	TravelTrip bookFlightAndHotel(Hotel hotel, Flight flight, Passenger passenger) throws Exception;

}