package in.spring4buddies.application.mail;

import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MimeMessageHelperCreator implements MailMessageCreator {
	
	@Autowired
	private JavaMailSender javaMailSender;

	public void setMailSender(final JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public void sendMail(final MailContent mailContent) throws Exception {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();

		// MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

		// use the true flag to indicate you need a multipart message
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

		mimeMessageHelper.setFrom(mailContent.getFrom());
		mimeMessageHelper.setTo(mailContent.getTo());
		mimeMessageHelper.setSubject(mailContent.getSubject());
		mimeMessageHelper.setText(mailContent.getContent());

		InputStream inputStream = MimeMessageHelperCreator.class.getClassLoader().getResourceAsStream("images/cute-smile.jpg");
		InputStreamSource inputStreamSource = new ByteArrayResource(IOUtils.toByteArray(inputStream));

		mimeMessageHelper.addInline("inLine123", inputStreamSource, "image/png");

		InputStream inputStream1 = MimeMessageHelperCreator.class.getClassLoader().getResourceAsStream("images/smile.jpg");
		InputStreamSource inputStreamSource1 = new ByteArrayResource(IOUtils.toByteArray(inputStream1));

		mimeMessageHelper.addAttachment("attachment123.jpg", inputStreamSource1);

		javaMailSender.send(mimeMessage);

		System.out.println("Mail Sent Successfully (MimeMessageHelper) ...!");
	}
}