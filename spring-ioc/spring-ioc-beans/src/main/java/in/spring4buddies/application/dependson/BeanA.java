package in.spring4buddies.application.dependson;

public class BeanA {

	private BeanB beanB;

	public BeanA() {
		System.out.println("Initializing BeanA");
	}

	public BeanB getBeanB() {
		return beanB;
	}

	public void setBeanB(BeanB beanB) {
		this.beanB = beanB;
	}
}
