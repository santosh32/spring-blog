package in.spring4buddies.application;

import in.spring4buddies.application.dao.helper.DateUtil;
import in.spring4buddies.application.model.Flight;
import in.spring4buddies.application.model.Hotel;
import in.spring4buddies.application.model.Passenger;
import in.spring4buddies.application.service.TravelService;

import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {
		String confFile = "beans-hsql.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		TravelService travelService = context.getBean(TravelService.class);

		travelService.bookFlightAndHotel(getHotel(), getFlight(), getPassenger());
		System.out.println(travelService.getTravelTripByPassengerId(1));

		context.close();
	}

	private static Passenger getPassenger() {
		Date date = new Date();
		Date plus5days = DateUtil.addDays(date, 5);
		return new Passenger(1, "James", date, plus5days);
	}

	private static Flight getFlight() {
		return new Flight(1, null, null);
	}

	private static Hotel getHotel() {
		return new Hotel(1, null, null);
	}
}
