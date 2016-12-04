package in.spring4buddies.application.config;

import in.spring4buddies.application.properties.ApplicationProperties;
import in.spring4buddies.application.properties.DatabaseProperties;
import in.spring4buddies.application.properties.MailProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan
@PropertySources({ @PropertySource("classpath:application.properties"), @PropertySource("classpath:database.properties") })
public class EnvironmentConfig {

	@Autowired
	private Environment env;
	
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
		applicationProperties.setGoogleUrl(env.getProperty("application.google.url"));
		applicationProperties.setYahooUrl(env.getProperty("application.yahoo.url"));
		return applicationProperties;
	}

	@Bean
	public DatabaseProperties databaseProperties() {
		DatabaseProperties databaseProperties = new DatabaseProperties();
		databaseProperties.setUrl(env.getProperty("datasource.url"));
		databaseProperties.setUser(env.getProperty("datasource.username"));
		databaseProperties.setPasscode(env.getProperty("datasource.password"));
		databaseProperties.setDrivername(env.getProperty("datasource.driver-class-name"));
		return databaseProperties;
	}
	
	@Bean
	public MailProperties mailProperties() {
		MailProperties mailProperties = new MailProperties();
		mailProperties.setHost(env.getProperty("mail.smtp.host"));
		mailProperties.setPort(env.getProperty("mail.smtp.port"));
		mailProperties.setUsername(env.getProperty("mail.smtp.username"));
		mailProperties.setPassword(env.getProperty("mail.smtp.password"));
		return mailProperties;
	}
}
