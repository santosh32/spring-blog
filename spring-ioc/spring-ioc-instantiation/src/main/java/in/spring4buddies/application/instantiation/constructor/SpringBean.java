package in.spring4buddies.application.instantiation.constructor;

import org.springframework.stereotype.Component;

@Component
public class SpringBean {

	public SpringBean() {
		System.out.println(" (cons) Constructor Instantiation : SpringBean() ");
	}

	public void print() {
		System.out.println("This is Bar : print()");
	}
}
