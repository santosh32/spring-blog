package in.spring4buddies.application.constructor_injection;

public class SpringFooBean {

	private SpringBarBean springBarBean;

	public SpringFooBean() {
		System.out.println("(constructor) SpringFooBean()");
	}

	public SpringFooBean(SpringBarBean springBarBean) {
		System.out.println("(constructor) SpringFooBean(springBarBean)");
		this.springBarBean = springBarBean;
	}

	@Override
	public String toString() {
		return springBarBean.toString();
	}
}
