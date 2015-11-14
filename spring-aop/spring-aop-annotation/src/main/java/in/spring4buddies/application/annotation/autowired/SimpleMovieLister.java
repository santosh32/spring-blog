package in.spring4buddies.application.annotation.autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class SimpleMovieLister {

	private MovieFinder movieFinder;

	@Autowired
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
