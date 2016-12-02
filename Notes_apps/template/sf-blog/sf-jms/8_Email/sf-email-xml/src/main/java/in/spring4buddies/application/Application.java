package in.spring4buddies.application;

import in.spring4buddies.application.mail.MailContent;
import in.spring4buddies.application.mail.SimpleMailMessageCreator;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		SimpleMailMessageCreator simpleMailMessageCreator = context.getBean(SimpleMailMessageCreator.class);

		MailContent mailContent = new MailContent();
		mailContent.setFrom("do-not-reply@gmail.com");
		mailContent.setTo("test-user@gmail.com");
		mailContent.setSubject("Test Subject");
		mailContent.setContent("Text Content");
		
		simpleMailMessageCreator.sendMail(mailContent);

		((AbstractApplicationContext) context).close();
	}
}
