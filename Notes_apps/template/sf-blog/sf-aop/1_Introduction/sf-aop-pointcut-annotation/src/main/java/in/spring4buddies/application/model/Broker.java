package in.spring4buddies.application.model;

public class Broker {

	private String name;
	private String addres;

	public Broker() {

	}

	public Broker(String name, String addres) {
		super();
		this.name = name;
		this.addres = addres;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	@Override
	public String toString() {
		return "Broker [name=" + name + ", addres=" + addres + "]";
	}
}
