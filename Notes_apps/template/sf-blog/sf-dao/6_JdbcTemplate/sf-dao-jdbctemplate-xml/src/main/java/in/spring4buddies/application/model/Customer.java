package in.spring4buddies.application.model;

public class Customer {

	private int cust_Id;
	private String name;
	private int salary;
	private String dept;

	public int getCust_Id() {
		return cust_Id;
	}

	public Customer(int cust_Id, String name, int salary, String dept) {
		super();
		this.cust_Id = cust_Id;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}

	public void setCust_Id(int cust_Id) {
		this.cust_Id = cust_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
}
