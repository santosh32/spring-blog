package in.spring4buddies.application.mail;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MimeMessageHelperCreator implements MailMessageCreator {

	private JavaMailSender javaMailSender;

	public void setMailSender(final JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void sendMail(final MailContent mailContent) throws Exception {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		mimeMessageHelper.setTo(mailContent.getTo());
		mimeMessageHelper.setText(mailContent.getContent());

		javaMailSender.send(mimeMessage);

		System.out.println("Mail Sent Successfully (MimeMessageHelper) ...!");
	}
}