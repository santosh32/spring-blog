package in.spring4buddies.application.callback;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class EmployeeWithInferface implements InitializingBean, DisposableBean {

	private String empId;
	private String name;

	public EmployeeWithInferface() {
		System.out.println("(cons) EmployeeWithInferface()");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy method - EmployeeWithInferface:destroy()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init method - EmployeeWithInferface:afterPropertiesSet() ");
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
