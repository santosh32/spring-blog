package in.spring4buddies.application.inheritance;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
@AttributeOverrides({
		@AttributeOverride(name = "firstname", column = @Column(name = "FIRSTNAME")),
		@AttributeOverride(name = "lastname", column = @Column(name = "LASTNAME")) })
public class Customer extends Person {

	@Column(name = "joining_date")
	private Date joiningDate;

	@Column(name = "department_name")
	private String departmentName;

	//setter & getters
	
	public Customer() {
	}

	public Customer(String firstname, String lastname, String departmentName,
			Date joiningDate) {

		super(firstname, lastname);

		this.departmentName = departmentName;
		this.joiningDate = joiningDate;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}