package in.spring4buddies.application;

import in.spring4buddies.application.service.FlightService;
import in.spring4buddies.application.service.HotelService;

import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {
		String confFile = "beans-hsql.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		HotelService hotelService = context.getBean(HotelService.class);

		FlightService flightService = context.getBean(FlightService.class);

		Date date = new Date();

		System.out.println(flightService.getFlightsFor(date, date));
		System.out.println(hotelService.getHotelsFor(date, date));

		context.close();
	}
}
