package in.spring4buddies.application.clone;

public class ShallowEmployee implements Cloneable {

	private int empoyeeId;
	private String employeeName;
	private ShallowDepartment department;

	public ShallowEmployee(int id, String name, ShallowDepartment dept) {
		this.empoyeeId = id;
		this.employeeName = name;
		this.department = dept;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public int getEmpoyeeId() {
		return empoyeeId;
	}

	public void setEmpoyeeId(int empoyeeId) {
		this.empoyeeId = empoyeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public ShallowDepartment getDepartment() {
		return department;
	}

	public void setDepartment(ShallowDepartment department) {
		this.department = department;
	}
}