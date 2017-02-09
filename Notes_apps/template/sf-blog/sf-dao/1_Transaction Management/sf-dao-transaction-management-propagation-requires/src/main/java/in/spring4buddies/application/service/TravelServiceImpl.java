package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Flight;
import in.spring4buddies.application.model.Hotel;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelServiceImpl {

	@Autowired
	private HotelService hotelService;
	@Autowired
	private FlightService flightService;

	public void getFlightsAndHotels(Date from, Date to) {
		List<Flight> flights = flightService.getFlightsFor(from, to);
		List<Hotel> hotels = hotelService.getHotelFor(from, to);
	}
}