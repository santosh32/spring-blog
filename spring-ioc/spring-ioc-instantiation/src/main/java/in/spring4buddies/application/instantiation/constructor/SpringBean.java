package in.spring4buddies.application.instantiation.constructor;

import org.springframework.stereotype.Component;

@Component
public class SpringBean {

	public SpringBean() {
		System.out.println("Constructor Instantiation :  (cons) SpringBean() ");
	}

	public void print() {
		System.out.println("This is Bar : print()");
	}
}
