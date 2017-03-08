package in.spring4buddies.application;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.spring4buddies.application.jaxb.Airport;
import in.spring4buddies.application.jaxb.Flight;
import in.spring4buddies.application.jibx.config.JibxConfig;
import in.spring4buddies.application.jibx.helper.JibxHelper;

public class Application {

	public static void main(String[] args) throws Exception {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JibxConfig.class);

		JibxHelper jibxHelper = context.getBean(JibxHelper.class);

		Airport from = new Airport("MUM", "Etihad Airways", "Mumbai");
		Airport to = new Airport("NY", "Etihad Airways", "New York");

		Flight flight = new Flight("NY600", null, null, from, to);

		XMLGregorianCalendar xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
		flight.setArrivalTime(xmlCalendar);
		flight.setDepartureTime(xmlCalendar);

		jibxHelper.marshal(flight, "flight-out.xml");

//		System.out.println(jibxHelper.unmarshal("flight.xml"));

		context.close();
	}
}
