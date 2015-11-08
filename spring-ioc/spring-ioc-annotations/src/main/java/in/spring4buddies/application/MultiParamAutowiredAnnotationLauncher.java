package in.spring4buddies.application;

import in.spring4buddies.application.annotation.autowired.MovieRecommender;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MultiParamAutowiredAnnotationLauncher {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"beans.xml");

		MovieRecommender movieRecommender = applicationContext
				.getBean(MovieRecommender.class);
		System.out.println(movieRecommender.getMovieCatalog());
		System.out.println(movieRecommender.getCustomerPreference());

		applicationContext.close();
	}
}
