package in.spring4buddies.application.beans;

public class InnerRefBean {

	private String name;
	private String address;

	public InnerRefBean() {
		System.out.println("(constructor) InnerRefBean()");
	}

	public void inner() {
		System.out.println("inner()");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return name + " " + address;
	}
}
