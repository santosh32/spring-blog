package in.spring4buddies.application.model;

import java.util.Date;

public class TravelTrip {

	private int passengerId;
	private String name;
	private int flightId;
	private String flightName;
	private int hotelId;
	private String hotelName;
	private Date bookedFrom;
	private Date bookedTo;

	public TravelTrip() {

	}

	public TravelTrip(int passengerId, String name, int flightId, String flightName, int hotelId, String hotelName, Date bookedFrom, Date bookedTo) {
		super();
		this.passengerId = passengerId;
		this.name = name;
		this.flightId = flightId;
		this.flightName = flightName;
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Date getBookedFrom() {
		return bookedFrom;
	}

	public void setBookedFrom(Date bookedFrom) {
		this.bookedFrom = bookedFrom;
	}

	public Date getBookedTo() {
		return bookedTo;
	}

	public void setBookedTo(Date bookedTo) {
		this.bookedTo = bookedTo;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	@Override
	public String toString() {
		return "TravelTrip [passengerId=" + passengerId + ", name=" + name + ", flightId=" + flightId + ", flightName=" + flightName + ", hotelId="
				+ hotelId + ", hotelName=" + hotelName + ", bookedFrom=" + bookedFrom + ", bookedTo=" + bookedTo + "]";
	}

}