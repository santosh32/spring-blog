package in.spring4buddies.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(name = "properties", value = { "classpath:application.properties"
		, "classpath:${sub.placehodler.property}.properties" })
//@PropertySources({
//    @PropertySource("classpath:application.properties"),
//    @PropertySource("classpath:${sub.placehodler.property}.properties"),
//})
public class ApplicationByPlaceholderByProperty {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		try {
			ctx.register(ApplicationByPlaceholderByProperty.class);
			ctx.refresh();
			Environment env = ctx.getEnvironment();
			System.out.println("sub.placehodler.property = " + env.getProperty("sub.placehodler.property"));
			System.out.println("some.placeholder.property = " + env.getProperty("some.placeholder.property"));
		} finally {
			ctx.close();
		}
	}

}
