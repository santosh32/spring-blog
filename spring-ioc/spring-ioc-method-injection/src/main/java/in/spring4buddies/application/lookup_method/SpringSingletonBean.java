package in.spring4buddies.application.lookup_method;

public abstract class SpringSingletonBean {

	protected abstract SpringPrototypeBean createSpringPrototypeBean();

	public SpringSingletonBean() {
		System.out.println("(constructor) SpringSingletonBean()");
	}

//	public SpringSingletonBean(SpringPrototypeBean springPrototypeBean) {
//		System.out.println("(constructor) SpringSingletonBean(springPrototypeBean)");
//		this.springPrototypeBean = springPrototypeBean;
//	}

	public String call() {
		return createSpringPrototypeBean().prototype();
	}
}
