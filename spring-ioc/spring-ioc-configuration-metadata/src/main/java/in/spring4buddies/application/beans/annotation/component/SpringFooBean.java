package in.spring4buddies.application.beans.annotation.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
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
