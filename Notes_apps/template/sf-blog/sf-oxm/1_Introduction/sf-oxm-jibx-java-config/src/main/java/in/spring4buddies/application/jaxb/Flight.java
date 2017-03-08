package in.spring4buddies.application.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement(name = "flight")
public class Flight {

	@XmlElement(required = true)
	protected String number;

	@XmlElement(required = true)
	protected XMLGregorianCalendar departureTime;

	@XmlElement(required = true)
	protected XMLGregorianCalendar arrivalTime;

	@XmlElement(required = true)
	protected Airport from;

	@XmlElement(required = true)
	protected Airport to;

	public Flight() {

	}

	public Flight(String number, XMLGregorianCalendar departureTime, XMLGregorianCalendar arrivalTime, Airport from, Airport to) {
		super();
		this.number = number;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.from = from;
		this.to = to;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public XMLGregorianCalendar getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(XMLGregorianCalendar departureTime) {
		this.departureTime = departureTime;
	}

	public XMLGregorianCalendar getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(XMLGregorianCalendar arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Airport getFrom() {
		return from;
	}

	public void setFrom(Airport from) {
		this.from = from;
	}

	public Airport getTo() {
		return to;
	}

	public void setTo(Airport to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "Flight [number=" + number + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", from=" + from + ", to=" + to
				+ "]";
	}

}