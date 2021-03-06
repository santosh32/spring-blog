package in.spring4buddies.application.beans.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class SpringFooBean {

	@Autowired
	private SpringBarBean springBarBean;

	public void foo() {
		System.out.println("This is Foo Bean");
		springBarBean.bar();
	}

	public void setSpringBarBean(SpringBarBean springBarBean) {
		this.springBarBean = springBarBean;
	}
}
