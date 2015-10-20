package in.spring4buddies.application.beans.xml;

public class SpringFooBean {

	private SpringBarBean springBarBean;

	public void foo() {
		System.out.println("This is Foo Bean");
		springBarBean.bar();
	}

	public void setSpringBarBean(SpringBarBean springBarBean) {
		this.springBarBean = springBarBean;
	}
}
