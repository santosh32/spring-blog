package in.spring4buddies.application.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "airport")
public class Airport {

	@XmlElement(required = true)
	protected String code;

	@XmlElement(required = true)
	protected String name;

	@XmlElement(required = true)
	protected String city;

	public Airport() {

	}

	public Airport(String code, String name, String city) {
		super();
		this.code = code;
		this.name = name;
		this.city = city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Airport [code=" + code + ", name=" + name + ", city=" + city + "]";
	}
}
