package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Flight;
import in.spring4buddies.application.model.Hotel;

import java.util.Date;
import java.util.List;

public class TravelServiceImpl {

	private HotelService hotelService;
	private FlightService flightService;

	public void getFlightsAndHotels(Date from, Date to) {
		List<Flight> flights = flightService.getFlightsFor(from, to);
		List<Hotel> hotels = hotelService.getHotelNamesFor(from, to);
	}
}