package in.spring4buddies.application.problem_area;

public class SpringSingletonBean {

	private SpringPrototypeBean springPrototypeBean;

	public SpringSingletonBean() {
		System.out.println("(constructor) SpringSingletonBean()");
	}

	public SpringSingletonBean(SpringPrototypeBean springPrototypeBean) {
		System.out
				.println("(constructor) SpringSingletonBean(springPrototypeBean)");
		this.springPrototypeBean = springPrototypeBean;
	}

	public SpringPrototypeBean getSpringPrototypeBean() {
		return springPrototypeBean;
	}

	public void setSpringPrototypeBean(SpringPrototypeBean springPrototypeBean) {
		this.springPrototypeBean = springPrototypeBean;
	}

	public String call() {
		return springPrototypeBean.prototype();
	}
}
