package in.spring4buddies.application.clone;

public class DeepEmployee implements Cloneable {

	private int empoyeeId;
	private String employeeName;
	private DeepDepartment department;

	public DeepEmployee(int id, String name, DeepDepartment dept) {
		this.empoyeeId = id;
		this.employeeName = name;
		this.department = dept;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		DeepEmployee cloned = (DeepEmployee) super.clone();
		cloned.setDepartment((DeepDepartment) cloned.getDepartment().clone());
		return cloned;
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

	public DeepDepartment getDepartment() {
		return department;
	}

	public void setDepartment(DeepDepartment department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "DeepEmployee [empoyeeId=" + empoyeeId + ", employeeName="
				+ employeeName + ", department=" + department + "]";
	}

}