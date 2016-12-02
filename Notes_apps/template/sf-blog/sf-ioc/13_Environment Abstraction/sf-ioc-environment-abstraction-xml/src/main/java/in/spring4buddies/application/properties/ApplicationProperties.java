package in.spring4buddies.application.properties;

public class ApplicationProperties {

	private String yahooUrl;
	private String googleUrl;

	public String getYahooUrl() {
		return yahooUrl;
	}

	public void setYahooUrl(String yahooUrl) {
		this.yahooUrl = yahooUrl;
	}

	public String getGoogleUrl() {
		return googleUrl;
	}

	public void setGoogleUrl(String googleUrl) {
		this.googleUrl = googleUrl;
	}

	@Override
	public String toString() {
		return "ApplicationProperties [yahooUrl=" + yahooUrl + ", googleUrl=" + googleUrl + "]";
	}

}
