package in.spring4buddies.application.beans.annotation.component;

import org.springframework.stereotype.Component;

@Component
public class SpringHelloWorldBean {

	public void print() {
		System.out.println("Hello World From Spring");
	}
}
