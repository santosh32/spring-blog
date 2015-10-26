package in.spring4buddies.application.callback.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Employee {

	private String empId;
	private String name;

	public Employee() {
		System.out.println("(cons) Employee()");
	}

	@PostConstruct
	public void init() {
		System.out.println("Bean initializing - Employee:@PostConstruct ");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Bean destroying - Employee:@PreDestroy");
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
