package in.spring4buddies.application.beans;

public class SpringFooBean {

	public SpringFooBean() {
		System.out.println("(constructor) SpringFooBean()");
	}

	public void foo() {
		System.out.println("foo()");
	}

	@Override
	public String toString() {
		return "SpringFooBean-ref";
	}
}
