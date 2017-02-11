package in.spring4buddies.application;

import in.spring4buddies.application.dao.helper.DateUtil;
import in.spring4buddies.application.model.Flight;
import in.spring4buddies.application.model.Hotel;
import in.spring4buddies.application.model.Passenger;
import in.spring4buddies.application.service.TravelService;

import java.util.Date;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {
		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		TravelService travelService = context.getBean(TravelService.class);

		int passengerID = RandomUtils.nextInt(1000, 1500);
		try {
			System.out.println(travelService.bookFlightAndHotel(getHotel(), getFlight(), getPassenger(passengerID)));
		} catch (Exception e) {
			System.out.println("Error: Passenger Booking Failed - " + e.getMessage());
		}

		context.close();
	}

	private static Passenger getPassenger(int passengerID) {
		Date date = new Date();
		Date plus5days = DateUtil.addDays(date, 5);
		return new Passenger(passengerID, "James Bond", date, plus5days);
	}

	private static Flight getFlight() {
		return new Flight(RandomUtils.nextInt(100, 110), null, null);
	}

	private static Hotel getHotel() {
		return new Hotel(RandomUtils.nextInt(200, 210), null, null);
	}
}
