package in.spring4buddies.application.mail;

import java.io.File;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamSource;
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
		mimeMessageHelper.setFrom(mailContent.getFrom());
		mimeMessageHelper.setTo(mailContent.getTo());
		mimeMessageHelper.setSubject(mailContent.getSubject());
		mimeMessageHelper.setText(mailContent.getContent());

		InputStream inputStream = MimeMessageHelperCreator.class.getClassLoader().getResourceAsStream("Smile.jpg");
		FileSystemResource inLineFileResource = new FileSystemResource(new File("Smile.jpeg"));
//		InputStreamSource imageSource = new ByteArrayResource(IOUtils.toByteArray(getClass().getResourceAsStream("/images/logo.png")));
		mimeMessageHelper.addInline("inLine123",inLineFileResource);

//		FileSystemResource attachmentFileResource = new FileSystemResource(new File("Smile.jpeg"));
//		mimeMessageHelper.addAttachment("attachment123.jpg", attachmentFileResource);

//		javaMailSender.send(mimeMessage);

		System.out.println("Mail Sent Successfully (MimeMessageHelper) ...!");
	}
}