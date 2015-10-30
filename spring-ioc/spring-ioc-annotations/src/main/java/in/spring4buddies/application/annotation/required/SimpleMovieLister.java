package in.spring4buddies.application.annotation.required;

import org.springframework.beans.factory.annotation.Required;

public class SimpleMovieLister {

	private MovieFinder movieFinder;

	@Required
	public void setMovieFinder(MovieFinder movieFinder) {
		this.movieFinder = movieFinder;
	}

	public String getMovieByUps(String ups) {
		return movieFinder.getMovieByUps(ups);
	}

	public MovieFinder getMovieFinder() {
		return movieFinder;
	}
}
