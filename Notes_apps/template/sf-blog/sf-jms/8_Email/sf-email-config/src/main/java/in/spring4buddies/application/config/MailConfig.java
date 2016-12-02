package in.spring4buddies.application.config;

import in.spring4buddies.application.mail.MimeMailMessageCreator;
import in.spring4buddies.application.mail.MimeMessageHelperCreator;
import in.spring4buddies.application.mail.SimpleMailMessageCreator;

import java.util.Properties;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

@SuppressWarnings("deprecation")
@Configurable
// @ComponentScan(basePackages = { "in.spring4buddies.application.*" })
@PropertySource("classpath:mail.properties")
public class MailConfig {

	@Autowired
	private Environment env;

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
	public JavaMailSenderImpl javaMailSender() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost(env.getProperty("mail.smtp.host"));
		javaMailSender.setPort(NumberUtils.toInt(env.getProperty("mail.smtp.port")));

		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.transport.protocol", env.getProperty("mail.transport.protocol"));
		javaMailProperties.put("mail.smtp.auth", env.getProperty("mail.smtp.auth"));
		javaMailProperties.put("mail.smtp.starttls.enable", env.getProperty("mail.smtp.starttls.enable"));
		javaMailProperties.put("mail.debug", env.getProperty("mail.debug"));
		javaMailSender.setJavaMailProperties(javaMailProperties);

		return javaMailSender;
	}

}
