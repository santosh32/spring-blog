package in.spring4buddies.application.mail;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class MimeMailMessageCreator implements MailMessageCreator {

	private JavaMailSender javaMailSender;

	public void setMailSender(final JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void sendMail(final MailContent mailContent) throws Exception {

		MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {

				mimeMessage.setFrom(new InternetAddress(mailContent.getFrom()));
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(mailContent.getTo()));
				mimeMessage.setSubject(mailContent.getSubject());
				mimeMessage.setText("Dear " + mailContent.getTo() + ", thank you for placing order.");
			}
		};

		javaMailSender.send(mimeMessagePreparator);

		System.out.println("Mail Sent Successfully (MimeMessagePreparator) ...!");
	}
}