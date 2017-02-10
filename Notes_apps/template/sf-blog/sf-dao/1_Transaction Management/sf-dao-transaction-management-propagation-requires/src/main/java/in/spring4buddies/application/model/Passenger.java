package in.spring4buddies.application.model;

public class Passenger {

	private int passengerId;
	private String name;
	private int flightId;
	private int hotelId;

	public Passenger() {

	}

	public Passenger(int passengerId, String name, int flightId, int hotelId) {
		super();
		this.passengerId = passengerId;
		this.name = name;
		this.flightId = flightId;
		this.hotelId = hotelId;
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
		return "Passenger [passengerId=" + passengerId + ", name=" + name + ", flightId=" + flightId + ", hotelId=" + hotelId + "]";
	}

}