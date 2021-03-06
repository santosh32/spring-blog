package in.spring4buddies.application.command;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class User {

	@NotEmpty(message = "UserName is empty")
	private String name;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@NotNull(message = "DateOfBirth is empty")
	private Date dateOfBirth;

	@NumberFormat(style = Style.CURRENCY, pattern = "###,##,##,###.##")
	@NotNull(message = "Salary is empty")
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