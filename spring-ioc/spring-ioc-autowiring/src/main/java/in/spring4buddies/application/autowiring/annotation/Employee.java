package in.spring4buddies.application.autowiring.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {

	private String empId;
	private String name;
	@Autowired
	private Address address;

	public Employee() {
	}

//	@Autowired
	public Employee(Address address) {
		this.address = address;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

//	@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", address="
				+ address + "]";
	}

}
