package in.spring4buddies.application.beans;

public class LazyBean {

	public LazyBean() {
		System.out.println("(constructor) LazyBean()");
	}

	public void lazy() {
		System.out.println("lazy()");
	}
}
