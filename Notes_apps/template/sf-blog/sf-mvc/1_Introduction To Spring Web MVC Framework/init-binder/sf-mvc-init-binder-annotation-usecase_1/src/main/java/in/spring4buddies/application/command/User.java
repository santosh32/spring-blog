package in.spring4buddies.application.command;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class User {

	private String name;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dateOfBirth;

	@NumberFormat(pattern = "#,###,###,###.##")
	private BigDecimal salary;

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

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", dateOfBirth=" + dateOfBirth + ", salary=" + salary + "]";
	}
}