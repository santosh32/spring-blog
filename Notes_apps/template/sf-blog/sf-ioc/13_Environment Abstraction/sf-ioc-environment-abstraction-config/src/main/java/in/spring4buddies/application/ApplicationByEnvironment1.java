package in.spring4buddies.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(name = "application", value = "classpath:application.properties")
@PropertySource(name = "properties", value = { "classpath:application.properties", "classpath:database.properties" })
public class ApplicationByEnvironment1 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		try {
			ctx.register(ApplicationByEnvironment1.class);
			ctx.refresh();
			Environment env = ctx.getEnvironment();
			System.out.println("Google Url : " + env.getProperty("application.google.url"));
			System.out.println("DataBase Url : " + env.getProperty("datasource.url"));
		} finally {
			ctx.close();
		}
	}

}
