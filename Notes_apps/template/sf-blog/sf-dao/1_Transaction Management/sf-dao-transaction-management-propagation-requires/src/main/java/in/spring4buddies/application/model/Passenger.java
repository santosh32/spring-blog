package in.spring4buddies.application.model;

public class Passenger {

	private int passengerId;
	private String name;
	private String flightId;
	private String hotelId;

	public Passenger() {

	}

	public Passenger(int passengerId, String name, String flightId, String hotelId) {
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

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", name=" + name + ", flightId=" + flightId + ", hotelId=" + hotelId + "]";
	}

}