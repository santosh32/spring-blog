package in.spring4buddies.application.structural.facade;

import java.util.Date;

public class Client {
	public static void main(String[] args) {
		TravelFacade facade = new TravelFacade();
		facade.getFlightsAndHotels(new Date(), new Date());
	}
}