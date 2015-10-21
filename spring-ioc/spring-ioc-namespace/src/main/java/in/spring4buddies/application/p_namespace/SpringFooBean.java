package in.spring4buddies.application.p_namespace;

public class SpringFooBean {

	private SpringBarBean springBarBean;
	private SpringBazBean springBazBean;

	public SpringFooBean() {
		System.out.println("(constructor) SpringFooBean()");
	}

	public void setSpringBarBean(SpringBarBean springBarBean) {
		this.springBarBean = springBarBean;
	}

	public SpringBarBean getSpringBarBean() {
		return springBarBean;
	}

	public SpringBazBean getSpringBazBean() {
		return springBazBean;
	}

	public void setSpringBazBean(SpringBazBean springBazBean) {
		this.springBazBean = springBazBean;
	}

	@Override
	public String toString() {
		return springBarBean.toString() + "\n" + springBazBean.toString();
	}
}
