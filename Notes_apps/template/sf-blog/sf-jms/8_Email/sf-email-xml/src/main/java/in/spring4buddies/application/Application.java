package in.spring4buddies.application;

import in.spring4buddies.application.mail.MailData;
import in.spring4buddies.application.mail.MailUtil;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		MailUtil mailUtil = context.getBean(MailUtil.class);

		MailData mailData = new MailData();
		mailData.setFrom("do@gmail.com");
		mailData.setTo("do1@gmail.com");
		mailData.setSubject("Test Subject");
		mailData.setContent("Text Content");
		
		mailUtil.sendMail(mailData);

		((AbstractApplicationContext) context).close();
	}
}
