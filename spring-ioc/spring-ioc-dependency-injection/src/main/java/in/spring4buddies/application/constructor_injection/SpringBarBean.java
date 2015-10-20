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
	}

	@Override
	public String toString() {
		return "name - " + name + " , role - " + role + " , age" + age
				+ " ,salary" + salary;
	}
}
