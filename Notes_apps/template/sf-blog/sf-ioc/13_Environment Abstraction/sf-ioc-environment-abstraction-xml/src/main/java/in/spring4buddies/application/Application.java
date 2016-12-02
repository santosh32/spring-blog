package in.spring4buddies.application;

import in.spring4buddies.application.properties.ApplicationProperties;
import in.spring4buddies.application.properties.DatabaseProperties;
import in.spring4buddies.application.properties.MailProperties;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
//		ApplicationProperties applicationProperties = context.getBean(ApplicationProperties.class);
		DatabaseProperties databaeProperties = context.getBean(DatabaseProperties.class);
		MailProperties mailProperties = context.getBean(MailProperties.class);
		
//		System.out.println(applicationProperties);
		System.out.println(databaeProperties);
		System.out.println(mailProperties);

		((AbstractApplicationContext) context).close();

	}
}
