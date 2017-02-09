package in.spring4buddies.application;

import in.spring4buddies.application.service.FlightService;

import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {
		String confFile = "beans-hsql.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

//		HotelService hotelService = context.getBean(HotelService.class);

		FlightService flightService = context.getBean(FlightService.class);

//		System.out.println(hotelService);
		Date date = new Date();
		
		System.out.println(flightService.getFlightsFor(date,date));

		context.close();
	}
}
