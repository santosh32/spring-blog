package in.spring4buddies.application.annotation.autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class MovieRecommender {

	private MovieCatalog movieCatalog;
	private CustomerPreferenceDao customerPreferenceDao;

	@Autowired
	public void prepare(MovieCatalog movieCatalog,
			CustomerPreferenceDao customerPreferenceDao) {
		this.movieCatalog = movieCatalog;
		this.customerPreferenceDao = customerPreferenceDao;
	}

	public String getMovieCatalog() {
		return movieCatalog.getMovieCatalog();
	}

	public String getCustomerPreference() {
		return customerPreferenceDao.getCustomerPreference();
	}
}
