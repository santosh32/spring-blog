package in.spring4buddies.application.model;

import java.util.Date;

public class HotelPassenger {

	private int hotelId;
	private int passengerId;
	private Date bookedFrom;
	private Date bookedTo;

	public HotelPassenger() {

	}

	public HotelPassenger(int hotelId, int passengerId, Date bookedFrom, Date bookedTo) {
		super();
		this.hotelId = hotelId;
		this.passengerId = passengerId;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
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
		return "HotelPassenger [hotelId=" + hotelId + ", passengerId=" + passengerId + ", bookedFrom=" + bookedFrom + ", bookedTo=" + bookedTo + "]";
	}

}