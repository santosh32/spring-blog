package in.spring4buddies.application;

import in.spring4buddies.application.dao.helper.DateUtil;
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
		Date plus5days = DateUtil.addDays(date, 5);

		System.out.println(flightService.getFlightsFor(date, plus5days));
		System.out.println(hotelService.getHotelsFor(date, plus5days));

		context.close();
	}
}
