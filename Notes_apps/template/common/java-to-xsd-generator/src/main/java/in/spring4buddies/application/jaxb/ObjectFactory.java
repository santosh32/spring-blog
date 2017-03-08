
package in.spring4buddies.application.jaxb;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

	public ObjectFactory() {
	}

	public Flight createFlight() {
		return new Flight();
	}

	public Airport createAirport() {
		return new Airport();
	}
}
