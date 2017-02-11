package in.spring4buddies.application.model;

public class Hotel {

	private int hotelId;
	private String name;
	private String type;

	public Hotel() {

	}

	public Hotel(int hotelId, String name, String type) {
		super();
		this.hotelId = hotelId;
		this.name = name;
		this.type = type;
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

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", name=" + name + ", type=" + type + "]";
	}

}