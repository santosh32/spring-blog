package in.spring4buddies.application.c_namespace;

import java.beans.ConstructorProperties;

public class SpringBazBean {

	private String name;
	private String role;
	private Integer age;
	private Double salary;

	public SpringBazBean() {
		System.out.println("(constructor) SpringBazBean() ");
	}
	
//	@ConstructorProperties({ "name", "age", "salary", "role" })
	public SpringBazBean(String name, Integer age, Double salary, String role) {
		System.out.println("(constructor) SpringBazBean(name, age, salary, role ) ");
		this.name = name;
		this.role = role;
		this.age = age;
		this.salary = salary;
	}

//	@ConstructorProperties({ "name", "role", "age", "salary" })
	public SpringBazBean(String name, String role, Integer age, Double salary) {
		System.out.println("(constructor) SpringBazBean(name, role, age, salary) ");
		this.name = name;
		this.role = role;
		this.age = age;
		this.salary = salary;
	}
	public SpringBazBean(String name, String role) {
		System.out.println("(constructor) SpringBazBean(name, role) ");
		this.name = name;
		this.role = role;
		this.age = age;
	}
	

	@Override
	public String toString() {
		return "name - " + name + " , role - " + role + " , age - " + age
				+ " , salary - " + salary;
	}
}
