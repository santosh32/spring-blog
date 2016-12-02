package in.spring4buddies.application.mail;

import java.io.StringWriter;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class VelocityBasedMailMessageCreator implements MailMessageCreator {

	private JavaMailSender javaMailSender;

	private VelocityEngine velocityEngine;

	public void setMailSender(final JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	@Override
	public void sendMail(final MailContent mailContent) throws Exception {

		MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {

				mimeMessage.setFrom(new InternetAddress(mailContent.getFrom()));
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(mailContent.getTo()));
				mimeMessage.setSubject(mailContent.getSubject());

				Template template = velocityEngine.getTemplate("./template/email.vm");

				VelocityContext velocityContext = new VelocityContext();
				velocityContext.put("firstname", mailContent.getFirstName());
				velocityContext.put("lastname", mailContent.getLastName());

				StringWriter stringWriter = new StringWriter();

				template.merge(velocityContext, stringWriter);

				mimeMessage.setText(stringWriter.toString());
			}
		};

		javaMailSender.send(mimeMessagePreparator);

		System.out.println("Mail Sent Successfully (MimeMessagePreparator) ...!");
	}
}