package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Flight;
import in.spring4buddies.application.model.Hotel;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelServiceImpl implements TravelService {

	@Autowired
	private HotelService hotelService;
	@Autowired
	private FlightService flightService;

	public Map<String, List<?>> getFlightsAndHotels(Date from, Date to) {
		List<Flight> flights = flightService.getFlightsFor(from, to);
		List<Hotel> hotels = hotelService.getHotelsFor(from, to);

		Map<String, List<?>> map = new HashMap<String, List<?>>();
		map.put(Flight.class.getSimpleName(), flights);
		map.put(Hotel.class.getSimpleName(), hotels);
		return map;
	}

	@Override
	public void bookFlightAndHotel(Date from, Date to) {
	}
}