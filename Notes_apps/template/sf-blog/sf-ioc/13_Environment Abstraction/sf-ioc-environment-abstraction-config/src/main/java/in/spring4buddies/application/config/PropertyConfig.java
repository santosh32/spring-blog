package in.spring4buddies.application.config;

import in.spring4buddies.application.properties.ApplicationProperties;
import in.spring4buddies.application.properties.DatabaseProperties;
import in.spring4buddies.application.properties.MailProperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan
@PropertySource(value = { "classpath:application.properties, classpath:database.properties, classpath:mail.properties" }, ignoreResourceNotFound = true)
public class PropertyConfig {

	@Value("${application.google.url}")
	private String googleUrl;
	@Value("${application.yahoo.url}")
	private String yahooUrl;

	@Value("${datasource.url}")
	private String url;
	@Value("${datasource.username}")
	private String user;
	@Value("${datasource.password}")
	private String passcode;
	@Value("${datasource.driver-class-name}")
	private String drivername;

	@Value("${mail.smtp.host}")
	private String host;
	@Value("${mail.smtp.port}")
	private String port;
	@Value("${mail.smtp.username}")
	private String username;
	@Value("${mail.smtp.password}")
	private String password;

//	@Bean
//	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
//		PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
//		ClassPathResource[] resources = new ClassPathResource[] { new ClassPathResource("application.properties"),
//				new ClassPathResource("database.properties"), new ClassPathResource("mail.properties") };
//		propertyPlaceholderConfigurer.setLocations(resources);
//		propertyPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
//		return propertyPlaceholderConfigurer;
//	}

//	@Bean
//	public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
//		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
//		ClassPathResource[] resources = new ClassPathResource[] { new ClassPathResource("application.properties"),
//				new ClassPathResource("database.properties"), new ClassPathResource("mail.properties") };
//		propertySourcesPlaceholderConfigurer.setLocations(resources);
//		propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
//		return propertySourcesPlaceholderConfigurer;
//	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
//		ClassPathResource[] resources = new ClassPathResource[] { new ClassPathResource("application.properties"),
//				new ClassPathResource("database.properties"), new ClassPathResource("mail.properties") };
//		propertySourcesPlaceholderConfigurer.setLocations(resources);
		propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
		return propertySourcesPlaceholderConfigurer;
	}

	@Bean
	public ApplicationProperties applicationProperties() {
		ApplicationProperties applicationProperties = new ApplicationProperties();
		applicationProperties.setGoogleUrl(googleUrl);
		applicationProperties.setYahooUrl(yahooUrl);
		return applicationProperties;
	}

	@Bean
	public DatabaseProperties databaseProperties() {
		DatabaseProperties databaseProperties = new DatabaseProperties();
		databaseProperties.setUrl(url);
		databaseProperties.setUser(user);
		databaseProperties.setPasscode(passcode);
		databaseProperties.setDrivername(drivername);
		return databaseProperties;
	}

	@Bean
	public MailProperties mailProperties() {
		MailProperties mailProperties = new MailProperties();
		mailProperties.setHost(host);
		mailProperties.setPort(port);
		mailProperties.setUsername(username);
		mailProperties.setPassword(password);
		return mailProperties;
	}
}
