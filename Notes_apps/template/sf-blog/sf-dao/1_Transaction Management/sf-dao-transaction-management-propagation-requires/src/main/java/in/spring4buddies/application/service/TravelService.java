package in.spring4buddies.application.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface TravelService {

	Map<String, List<?>> getFlightsAndHotels(Date from, Date to);

	void bookFlightAndHotel(Date from, Date to);
	
}