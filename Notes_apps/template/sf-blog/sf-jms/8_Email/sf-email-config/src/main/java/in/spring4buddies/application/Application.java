package in.spring4buddies.application;

import in.spring4buddies.application.config.MailConfig;
import in.spring4buddies.application.mail.MailContent;
import in.spring4buddies.application.mail.MimeMailMessageCreator;
import in.spring4buddies.application.mail.MimeMessageHelperCreator;
import in.spring4buddies.application.mail.SimpleMailMessageCreator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new AnnotationConfigApplicationContext(MailConfig.class);

		SimpleMailMessageCreator simpleMailMessageCreator = context.getBean(SimpleMailMessageCreator.class);
		MimeMailMessageCreator mimeMailMessageCreator = context.getBean(MimeMailMessageCreator.class);
		MimeMessageHelperCreator mimeMessageHelperCreator = context.getBean(MimeMessageHelperCreator.class);

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

		((AbstractApplicationContext) context).close();
	}
}
