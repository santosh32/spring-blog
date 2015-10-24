package in.spring4buddies.application.callback;

public class Employee {

	private String empId;
	private String name;

	public Employee() {
		System.out.println("(cons) Employee()");
	}

	public void init() {
		System.out.println("Bean initializing - Employee:init() ");
	}

	public void destroy() {
		System.out.println("Bean destroying - Employee:destroy()");
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

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + "]";
	}

}
