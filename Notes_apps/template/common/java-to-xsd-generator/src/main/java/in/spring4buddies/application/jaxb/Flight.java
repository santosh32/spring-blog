
package in.spring4buddies.application.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "number", "departureTime", "arrivalTime", "from", "to" })
@XmlRootElement(name = "flight")
public class Flight {

	@XmlElement(required = true)
	protected String number;
	@XmlElement(required = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar departureTime;
	@XmlElement(required = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar arrivalTime;
	@XmlElement(required = true)
	protected Airport from;
	@XmlElement(required = true)
	protected Airport to;

	public String getNumber() {
		return number;
	}

	public void setNumber(String value) {
		this.number = value;
	}

	public XMLGregorianCalendar getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(XMLGregorianCalendar value) {
		this.departureTime = value;
	}

	public XMLGregorianCalendar getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(XMLGregorianCalendar value) {
		this.arrivalTime = value;
	}

	public Airport getFrom() {
		return from;
	}

	public void setFrom(Airport value) {
		this.from = value;
	}

	public Airport getTo() {
		return to;
	}

	public void setTo(Airport value) {
		this.to = value;
	}
}
