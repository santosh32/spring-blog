package in.spring4buddies.application;

import in.spring4buddies.application.service.FlightService;
import in.spring4buddies.application.service.HotelService;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {
		String confFile = "beans-hsql.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		HotelService hotelService = context.getBean(HotelService.class);

		FlightService flightService = context.getBean(FlightService.class);

		System.out.println(hotelService);
		System.out.println(flightService);

		context.close();
	}
}
