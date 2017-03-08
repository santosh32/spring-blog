package in.spring4buddies.application.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "airport", propOrder = { "code", "name", "city" })
public class Airport {

	@XmlElement(required = true)
	protected String code;
	@XmlElement(required = true)
	protected String name;
	@XmlElement(required = true)
	protected String city;

	public String getCode() {
		return code;
	}

	public void setCode(String value) {
		this.code = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String value) {
		this.city = value;
	}
}
