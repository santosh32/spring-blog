package in.spring4buddies.application;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.spring4buddies.application.jpa.NodeRefRepository;

public class Application {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		NodeRefRepository nodeRefRepository = context.getBean(NodeRefRepository.class);

		context.close();
	}
}
