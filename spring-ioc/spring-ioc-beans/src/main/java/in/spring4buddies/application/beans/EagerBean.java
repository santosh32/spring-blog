package in.spring4buddies.application.beans;

public class EagerBean {

	public EagerBean() {
		System.out.println("(constructor) EagerBean()");
	}

	public void eager() {
		System.out.println("Eager()");
	}
}
