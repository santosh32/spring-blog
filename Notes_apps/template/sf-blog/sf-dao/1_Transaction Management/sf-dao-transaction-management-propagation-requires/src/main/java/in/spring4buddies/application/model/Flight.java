package in.spring4buddies.application.model;

import java.util.Date;

public class Flight {

	private int flightId;
	private String name;
	private String type;
	private Date bookedFrom;
	private Date bookedTo;

	public Flight() {

	}

	public Flight(int flightId, String name, String type, Date bookedFrom, Date bookedTo) {
		super();
		this.flightId = flightId;
		this.name = name;
		this.type = type;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", name=" + name + ", type=" + type + ", bookedFrom=" + bookedFrom + ", bookedTo=" + bookedTo + "]";
	}

}