package in.spring4buddies.application.p_namespace;

public class SpringBazBean {

	private String name;
	private String role;

	public SpringBazBean() {
		System.out.println("(constructor) SpringBazBean() ");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "name - " + name + " , role - " + role;
	}
}
