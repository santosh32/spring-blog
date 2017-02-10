package in.spring4buddies.application.model;

import java.util.Date;

public class FlightPassenger {

	private int flightId;
	private int passengerId;
	private Date bookedFrom;
	private Date bookedTo;

	public FlightPassenger() {

	}

	public FlightPassenger(int flightId, int passengerId, Date bookedFrom, Date bookedTo) {
		super();
		this.flightId = flightId;
		this.passengerId = passengerId;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
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
		return "FlightPassenger [flightId=" + flightId + ", passengerId=" + passengerId + ", bookedFrom=" + bookedFrom + ", bookedTo=" + bookedTo
				+ "]";
	}

}