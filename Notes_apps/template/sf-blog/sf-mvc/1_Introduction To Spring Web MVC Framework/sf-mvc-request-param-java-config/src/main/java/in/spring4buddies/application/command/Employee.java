package in.spring4buddies.application.command;

public class Employee {
	private long empId;
	private String name;
	private String address;
	private String city;
	private String state;
	private String country;

	public Employee() {
	}

	public Employee(long empId, String name, String address, String city, String state, String country) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", address=" + address + ", city=" + city + ", state=" + state + ", country="
				+ country + "]";
	}
}
