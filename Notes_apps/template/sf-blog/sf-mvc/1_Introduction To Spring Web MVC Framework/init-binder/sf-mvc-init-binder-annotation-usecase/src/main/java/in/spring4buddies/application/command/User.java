package in.spring4buddies.application.command;

import java.util.Currency;
import java.util.Date;

public class User {

	private String name;
	private Date dateOfBirth;
	private Currency salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Currency getSalary() {
		return salary;
	}

	public void setSalary(Currency salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", dateOfBirth=" + dateOfBirth + ", salary=" + salary + "]";
	}

}