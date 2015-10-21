package in.spring4buddies.application.c_namespace;

public class SpringFooBean {

	private SpringBarBean springBarBean;
	private SpringBazBean springBazBean;

	public SpringFooBean() {
		System.out.println("(constructor) SpringFooBean()");
	}

	public SpringFooBean(SpringBarBean springBarBean,
			SpringBazBean springBazBean) {
		System.out.println("(constructor) SpringFooBean(springBarBean,springBazBean)");
		this.springBarBean = springBarBean;
		this.springBazBean = springBazBean;
	}

	@Override
	public String toString() {
		return "SpringFooBean_c \n " + springBarBean.toString() + ""
				+ springBazBean.toString();
	}
}
