package in.spring4buddies.application.service;

import in.spring4buddies.application.dao.FlightDao;
import in.spring4buddies.application.model.Flight;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightDao flightDao;

	@Transactional(readOnly = true)
	@Override
	public List<Flight> getFlightsFor(Date from, Date to) {
		return flightDao.getFlightsFor(from, to);
	}

	@Transactional(rollbackFor = Exception.class, noRollbackFor = Exception.class)
	@Override
	public void bookFlight(Flight flight) {
		flightDao.bookFlight(flight);
	}
}