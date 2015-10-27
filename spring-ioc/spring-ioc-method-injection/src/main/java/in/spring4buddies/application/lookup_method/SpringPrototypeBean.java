package in.spring4buddies.application.lookup_method;

public class SpringPrototypeBean {

	public SpringPrototypeBean() {
		System.out.println("(constructor) SpringPrototypeBean() ");
	}

	public String prototype() {
		return "SpringPrototypeBean : prototype() ";
	}
}
