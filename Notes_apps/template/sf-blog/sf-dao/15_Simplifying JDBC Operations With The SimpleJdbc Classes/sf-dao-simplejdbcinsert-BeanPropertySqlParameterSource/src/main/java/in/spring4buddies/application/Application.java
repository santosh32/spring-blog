package in.spring4buddies.application;

import in.spring4buddies.application.dao.MovieDao;
import in.spring4buddies.application.model.Movie;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String args[]) {
		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		MovieDao movieDao = (MovieDao) context.getBean("movieDao");

		Movie movie = new Movie();
		movie.setTitle(" Captain America: Civil War");
		movie.setDirector("Anthony Russo, Joe Russo");
		movie.setGenre("Action & Adventure, Science Fiction & Fantasy");
		movie.setRaiting("4.1");
		movie.setBoxOffice("$408,080,554.00");
		System.out.println("Movie ID ==> "+movieDao.addMovie(movie));
		
		context.close();
	}
}
