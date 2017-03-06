package in.spring4buddies.application.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "address")
public class Address {

	private String state;
	private String city;
	private String area;
	private String zip;

	public Address() {

	}

	public Address(String state, String city, String area, String zip) {
		super();
		this.state = state;
		this.city = city;
		this.area = area;
		this.zip = zip;
	}

	public String getState() {
		return state;
	}

	@XmlElement
	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	@XmlElement
	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	@XmlElement
	public void setArea(String area) {
		this.area = area;
	}

	public String getZip() {
		return zip;
	}

	@XmlElement
	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", area=" + area + ", zip=" + zip + "]";
	}

}
