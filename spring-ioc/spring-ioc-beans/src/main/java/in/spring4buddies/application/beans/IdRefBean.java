package in.spring4buddies.application.beans;

public class IdRefBean {

	private String name;
	private String address;

	public IdRefBean() {
		System.out.println("(constructor) IdRefBean()");
	}

	public void idref() {
		System.out.println("idref()");
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
