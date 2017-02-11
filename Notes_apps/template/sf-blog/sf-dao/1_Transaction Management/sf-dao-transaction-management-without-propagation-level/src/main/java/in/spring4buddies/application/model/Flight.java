package in.spring4buddies.application.model;

public class Flight {

	private int flightId;
	private String name;
	private String type;

	public Flight() {

	}

	public Flight(int flightId, String name, String type) {
		super();
		this.flightId = flightId;
		this.name = name;
		this.type = type;
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

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", name=" + name + ", type=" + type + "]";
	}

}