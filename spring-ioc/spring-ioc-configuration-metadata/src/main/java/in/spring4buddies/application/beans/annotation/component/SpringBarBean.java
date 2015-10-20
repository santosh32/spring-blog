package in.spring4buddies.application.beans.annotation.component;

import org.springframework.stereotype.Component;

@Component
public class SpringBarBean {

	public void bar() {
		System.out.println("This is Bar Bean");
	}
}
