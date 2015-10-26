package in.spring4buddies.application.dependson;

public class BeanB {

	private String name;

	public BeanB() {
		System.out.println("BeanB is initialized.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
