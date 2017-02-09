package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Flight;
import in.spring4buddies.application.model.Hotel;

import java.util.ArrayList;
import java.util.Date;

public class TravelServiceImpl {

	private HotelService hotelService;
	private FlightService flightService;

	public void getFlightsAndHotels(Date from, Date to) {
		ArrayList<Flight> flights = flightService.getFlightsFor(from, to);
		ArrayList<Hotel> hotels = hotelService.getHotelNamesFor(from, to);
	}
}