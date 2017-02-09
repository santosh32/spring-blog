package in.spring4buddies.application.model;

import java.util.Date;

public class Hotel {

	private int hotelId;
	private String name;
	private String type;
	private Date bookedFrom;
	private Date bookedTo;

	public Hotel() {

	}

	public Hotel(int hotelId, String name, String type, Date bookedFrom, Date bookedTo) {
		super();
		this.hotelId = hotelId;
		this.name = name;
		this.type = type;
		this.bookedFrom = bookedFrom;
		this.bookedTo = bookedTo;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
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
		return "Hotel [hotelId=" + hotelId + ", name=" + name + ", type=" + type + ", bookedFrom=" + bookedFrom + ", bookedTo=" + bookedTo + "]";
	}

}