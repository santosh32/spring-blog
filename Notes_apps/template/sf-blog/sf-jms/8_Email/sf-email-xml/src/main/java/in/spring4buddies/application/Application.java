package in.spring4buddies.application;

import in.spring4buddies.application.mail.MailContent;
import in.spring4buddies.application.mail.SimpleMailMessageCreator;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		SimpleMailMessageCreator mailUtil = context.getBean(SimpleMailMessageCreator.class);

		MailContent mailData = new MailContent();
		mailData.setFrom("do@gmail.com");
		mailData.setTo("do1@gmail.com");
		mailData.setSubject("Test Subject");
		mailData.setContent("Text Content");
		
		mailUtil.sendMail(mailData);

		((AbstractApplicationContext) context).close();
	}
}
