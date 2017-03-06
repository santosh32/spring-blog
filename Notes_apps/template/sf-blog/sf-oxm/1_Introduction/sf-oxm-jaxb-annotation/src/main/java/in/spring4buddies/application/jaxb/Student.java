package in.spring4buddies.application.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
public class Student {

	private int sid;
	private String name;
	private String email;
	private Address address;

	public Student() {

	}

	public Student(int sid, String name, String email, Address address) {
		super();
		this.sid = sid;
		this.name = name;
		this.email = email;
		this.address = address;
	}

	public int getSid() {
		return sid;
	}

	@XmlElement
	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	@XmlElement
	public void setAddress(Address address) {
		this.address = address;
	}
}
