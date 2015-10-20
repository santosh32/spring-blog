package in.spring4buddies.application.constructor_injection;

public class SpringBarBean {

	private String name;
	private String role;
	private Integer age;
	private Double salary;

	public SpringBarBean() {
		System.out.println("(constructor) SpringBarBean() ");
	}

	public SpringBarBean(String name, String role, Integer age, Double salary) {
		System.out.println("(constructor) SpringBarBean(name, role, age, salary) ");
		this.name = name;
		this.role = role;
		this.age = age;
		this.salary = salary;
	}

	public SpringBarBean(String name, Integer age, Double salary, String role) {
		System.out.println("(constructor) SpringBarBean(name, age, salary, role ) ");
		this.name = name;
		this.role = role;
		this.age = age;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "name - " + name + " , role - " + role + " , age - " + age
				+ " , salary - " + salary;
	}
}
