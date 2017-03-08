package in.spring4buddies.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.spring4buddies.application.jaxb.Airport;
import in.spring4buddies.application.jaxb.Flight;
import in.spring4buddies.application.jibx.config.JibxConfig;
import in.spring4buddies.application.jibx.helper.JibxHelper;

public class Application {

	public static void main(String[] args) throws Exception {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JibxConfig.class);

		JibxHelper castorHelper = context.getBean(JibxHelper.class);

		Airport from = new Airport();
		Flight flight = new Flight();
		flight.setFrom(from);

		castorHelper.marshal(flight, "flight-out.xml");

		System.out.println(castorHelper.unmarshal("flight.xml"));

		context.close();
	}
}
