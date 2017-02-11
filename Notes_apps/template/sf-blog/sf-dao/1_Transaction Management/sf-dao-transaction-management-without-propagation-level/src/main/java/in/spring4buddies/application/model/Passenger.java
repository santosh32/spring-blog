package in.spring4buddies.application.model;

import java.util.Date;

public class Passenger {

	private int passengerId;
	private String name;
	private Date bookedFrom;
	private Date bookedTo;

	public Passenger() {

	}

	public Passenger(int passengerId, String name, Date bookedFrom, Date bookedTo) {
		super();
		this.passengerId = passengerId;
		this.name = name;
		this.bookedFrom = bookedFrom;
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
		return "Passenger [passengerId=" + passengerId + ", name=" + name + ", bookedFrom=" + bookedFrom + ", bookedTo=" + bookedTo + "]";
	}

}