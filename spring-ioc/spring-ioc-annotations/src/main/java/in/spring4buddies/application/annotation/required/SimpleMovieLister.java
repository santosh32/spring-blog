package in.spring4buddies.application.annotation.required;

import org.springframework.beans.factory.annotation.Required;

public class SimpleMovieLister {

	private MovieFinder movieFinderRequired;

	@Required
	public String getMovieByUps(String ups) {
		return movieFinderRequired.getMovieByUps(ups);
	}

	public void setMovieFinderRequired(MovieFinder movieFinderRequired) {
		this.movieFinderRequired = movieFinderRequired;
	}
}
