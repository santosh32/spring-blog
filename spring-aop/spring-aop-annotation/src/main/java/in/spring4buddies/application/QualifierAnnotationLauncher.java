package in.spring4buddies.application;

import in.spring4buddies.application.annotation.qualifier.MovieRecommenderQualifier;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QualifierAnnotationLauncher {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"beans.xml");

		MovieRecommenderQualifier recommenderQualifier = applicationContext
				.getBean(MovieRecommenderQualifier.class);
		System.out.println(recommenderQualifier.getFirstMovieCatalog());
		System.out.println(recommenderQualifier.getSecondMovieCatalog());

		applicationContext.close();
	}
}
