package in.spring4buddies.application.beans;

public class SpringRefBean {

	public SpringRefBean() {
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
