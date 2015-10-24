package in.spring4buddies.application.setter_injection;

public class SpringFooBean {

	private SpringBarBean springBarBean;

	public SpringFooBean() {
		System.out.println("(constructor) SpringFooBean()");
	}

	public void setSpringBarBean(SpringBarBean springBarBean) {
		this.springBarBean = springBarBean;
	}

	public SpringBarBean getSpringBarBean() {
		return springBarBean;
	}

	@Override
	public String toString() {
		return springBarBean.toString();
	}
}
