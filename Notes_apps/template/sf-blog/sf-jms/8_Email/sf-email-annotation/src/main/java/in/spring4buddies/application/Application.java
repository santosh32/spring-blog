package in.spring4buddies.application;

import in.spring4buddies.application.mail.MailContent;
import in.spring4buddies.application.mail.MimeMailMessageCreator;
import in.spring4buddies.application.mail.MimeMessageHelperCreator;
import in.spring4buddies.application.mail.SimpleMailMessageCreator;
import in.spring4buddies.application.mail.VelocityBasedMailMessageCreator;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		SimpleMailMessageCreator simpleMailMessageCreator = context.getBean(SimpleMailMessageCreator.class);
		MimeMailMessageCreator mimeMailMessageCreator = context.getBean(MimeMailMessageCreator.class);
		MimeMessageHelperCreator mimeMessageHelperCreator = context.getBean(MimeMessageHelperCreator.class);
		VelocityBasedMailMessageCreator velocityBasedMailMessageCreator = context.getBean(VelocityBasedMailMessageCreator.class);

		MailContent mailContent = new MailContent();
		mailContent.setFrom("do-not-reply@gmail.com");
		mailContent.setTo("test-user@gmail.com");

		mailContent.setSubject("Test Subject - Using SimpleMailMessage");
		mailContent.setContent("Text Content - Using SimpleMailMessage");
		simpleMailMessageCreator.sendMail(mailContent);

		mailContent.setSubject("Test Subject - Using MimeMessagePreparator");
		mailContent.setContent("Text Content - Using MimeMessagePreparator");
		mimeMailMessageCreator.sendMail(mailContent);

		mailContent.setSubject("Test Subject - Using MimeMessageHelper");
		mailContent.setContent("Text Content - Using MimeMessageHelper and which includes the inLine and attachement jpgs");
		mimeMessageHelperCreator.sendMail(mailContent);

		mailContent.setSubject("Test Subject - Using VelocityTemplates");
		mailContent.setContent(null);
		mailContent.setFirstName("Rahul");
		mailContent.setLastName("Dravid");
		velocityBasedMailMessageCreator.sendMail(mailContent);

		((AbstractApplicationContext) context).close();
	}
}
