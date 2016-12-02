package in.spring4buddies.application.mail;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SimpleMailMessageCreator implements MailMessageCreator {

	private MailSender mailSender;

	public void setMailSender(final MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendMail(final MailContent mailContent) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(mailContent.getFrom());
		message.setTo(mailContent.getTo());
		message.setSubject(mailContent.getSubject());
		message.setText(mailContent.getContent());

		mailSender.send(message);

		System.out.println("Mail Sent Successfully (SimpleMailMessage) ...!");
	}
}