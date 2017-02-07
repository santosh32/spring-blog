package in.spring4buddies.application.seeddata;

public class Employee {
	private int empId;
	private String hireDate;
	private String salary;
	private String dept;
	private String jobcode;
	private String sex;
	private String birthDate;
	private String lastName;
	private String firstName;
	private String middleName;
	private String phone;

	public Employee() {

	}

	public Employee(int empId, String hireDate, String salary, String dept, String jobcode, String sex, String birthDate, String lastName,
			String firstName, String middleName, String phone) {
		super();
		this.empId = empId;
		this.hireDate = hireDate;
		this.salary = salary;
		this.dept = dept;
		this.jobcode = jobcode;
		this.sex = sex;
		this.birthDate = birthDate;
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.phone = phone;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getJobcode() {
		return jobcode;
	}

	public void setJobcode(String jobcode) {
		this.jobcode = jobcode;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", hireDate=" + hireDate + ", salary=" + salary + ", dept=" + dept + ", jobcode=" + jobcode + ", sex="
				+ sex + ", birthDate=" + birthDate + ", lastName=" + lastName + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", phone=" + phone + "]";
	}
}