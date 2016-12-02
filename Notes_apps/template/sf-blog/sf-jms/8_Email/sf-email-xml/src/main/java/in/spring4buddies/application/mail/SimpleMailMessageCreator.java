package in.spring4buddies.application.mail;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SimpleMailMessageCreator implements MailMessageCreator {

	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendMail(MailContent mailData) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(mailData.getFrom());
		message.setTo(mailData.getTo());
		message.setSubject(mailData.getSubject());
		message.setText(mailData.getContent());

		mailSender.send(message);

		System.out.println("Mail Sent Successfully (SimpleMailMessage) ...!");
	}
}