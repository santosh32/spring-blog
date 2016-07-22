package in.spring4buddies.application.serializable;

import java.io.Serializable;

public class Parent implements Serializable {

	private static final long serialVersionUID = 3L;
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Parent [name=" + name + "]";
	}

}
