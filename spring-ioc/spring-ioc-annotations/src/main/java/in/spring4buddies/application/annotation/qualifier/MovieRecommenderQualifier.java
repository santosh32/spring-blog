package in.spring4buddies.application.annotation.qualifier;

import in.spring4buddies.application.annotation.autowired.MovieCatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MovieRecommenderQualifier {

	@Autowired
//	@Qualifier("firstMovieCatalog")
	private MovieCatalog firstMovieCatalog;

	@Autowired
	private MovieCatalog secondMovieCatalog;

	public String getFirstMovieCatalog() {
		return firstMovieCatalog.getQualifierName("FirstMovieCatalog");
	}

	public String getSecondMovieCatalog() {
		return secondMovieCatalog.getQualifierName("SecondMovieCatalog");
	}
}
