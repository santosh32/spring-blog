package in.spring4buddies.application.ioc.contatiner_overview;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan(value = "in.spring4buddies.application.ioc.contatiner_overview")
public class AnnotationConfig {

	@Bean
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}
}
