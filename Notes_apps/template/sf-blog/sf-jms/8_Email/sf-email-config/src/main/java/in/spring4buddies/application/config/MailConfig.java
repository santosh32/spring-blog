package in.spring4buddies.application.config;

import in.spring4buddies.application.mail.MimeMailMessageCreator;
import in.spring4buddies.application.mail.MimeMessageHelperCreator;
import in.spring4buddies.application.mail.SimpleMailMessageCreator;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

@SuppressWarnings("deprecation")
@Configurable
public class MailConfig {

	@Bean
	public MimeMailMessageCreator mimeMailMessageCreator() {
		return new MimeMailMessageCreator();
	}

	@Bean
	public SimpleMailMessageCreator simpleMailMessageCreator() {
		return new SimpleMailMessageCreator();
	}

	@Bean
	public MimeMessageHelperCreator mimeMessageHelperCreator() {
		return new MimeMessageHelperCreator();
	}

	@Bean
	public VelocityEngineFactoryBean velocityEngineFactoryBean() {
		VelocityEngineFactoryBean velocityEngineFactoryBean = new VelocityEngineFactoryBean();

		Properties velocityProperties = new Properties();
		velocityProperties.put("resource.loader", "class");
		velocityProperties.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		velocityEngineFactoryBean.setVelocityProperties(velocityProperties);
		return velocityEngineFactoryBean;
	}

	@Bean
	public JavaMailSenderImpl javaMailSenderImpl() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost(null);
		javaMailSender.setPort(0);

		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.transport.protocol", null);
		javaMailProperties.put("mail.smtp.auth", null);
		javaMailProperties.put("mail.smtp.auth", null);
		javaMailProperties.put("mail.debug", null);
		javaMailSender.setJavaMailProperties(javaMailProperties);

		return javaMailSender;
	}
}
