package in.spring4buddies.application;

import in.spring4buddies.application.properties.ApplicationFields;
import in.spring4buddies.application.properties.DatabaseFields;
import in.spring4buddies.application.properties.MailFields;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		ApplicationFields applicationProperties = context.getBean(ApplicationFields.class);
		DatabaseFields databaeProperties = context.getBean(DatabaseFields.class);
		MailFields mailProperties = context.getBean(MailFields.class);
		
		System.out.println(applicationProperties);
		System.out.println(databaeProperties);
		System.out.println(mailProperties);

		((AbstractApplicationContext) context).close();

	}
}
