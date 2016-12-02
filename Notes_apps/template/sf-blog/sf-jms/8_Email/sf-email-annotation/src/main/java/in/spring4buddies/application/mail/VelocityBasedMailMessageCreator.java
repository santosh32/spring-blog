package in.spring4buddies.application.mail;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

@SuppressWarnings("deprecation")
public class VelocityBasedMailMessageCreator implements MailMessageCreator {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
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

				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

				mimeMessageHelper.setFrom(new InternetAddress(mailContent.getFrom()));
				mimeMessageHelper.setTo(new InternetAddress(mailContent.getTo()));
				mimeMessageHelper.setSubject(mailContent.getSubject());

				Map<String, Object> model = new HashMap<>();
				model.put("firstname", mailContent.getFirstName());
				model.put("lastname", mailContent.getLastName());

				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "template/email.vm", "UTF-8", model);

				mimeMessageHelper.setText(text, true);
			}
		};

		javaMailSender.send(mimeMessagePreparator);

		System.out.println("Mail Sent Successfully (MimeMessagePreparator) ...!");
	}
}