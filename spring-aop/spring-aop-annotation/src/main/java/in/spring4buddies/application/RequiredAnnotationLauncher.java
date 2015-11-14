package in.spring4buddies.application;

import in.spring4buddies.application.annotation.required.SimpleMovieLister;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RequiredAnnotationLauncher {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"beans.xml");

		SimpleMovieLister simpleMovieLister = applicationContext
				.getBean(SimpleMovieLister.class);
		System.out.println(simpleMovieLister.getMovieByUps("UPS1234974890"));

		applicationContext.close();
	}
}
