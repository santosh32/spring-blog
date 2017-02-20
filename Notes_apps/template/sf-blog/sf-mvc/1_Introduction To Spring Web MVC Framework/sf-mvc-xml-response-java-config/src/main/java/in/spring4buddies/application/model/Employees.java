package in.spring4buddies.application.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "employee" })
@XmlRootElement(name = "employees")
public class Employees {

	protected List<Employees.Employee> employee;

	public List<Employees.Employee> getEmployees() {
		if (employee == null) {
			employee = new ArrayList<Employees.Employee>();
		}
		return this.employee;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "age", "firstName", "id", "lastName", "salary" })
	@XmlRootElement(name = "employee")
	public static class Employee {

		protected int age;
		@XmlElement(required = true)
		protected String firstName;
		protected int id;
		@XmlElement(required = true)
		protected String lastName;
		protected float salary;

		public int getAge() {
			return age;
		}

		public void setAge(int value) {
			this.age = value;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String value) {
			this.firstName = value;
		}

		public int getId() {
			return id;
		}

		public void setId(int value) {
			this.id = value;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String value) {
			this.lastName = value;
		}

		public float getSalary() {
			return salary;
		}

		public void setSalary(float value) {
			this.salary = value;
		}

	}

}
