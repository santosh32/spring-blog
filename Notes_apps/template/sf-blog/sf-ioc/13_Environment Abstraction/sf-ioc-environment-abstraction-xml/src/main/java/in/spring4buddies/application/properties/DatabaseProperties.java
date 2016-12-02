package in.spring4buddies.application.properties;

public class DatabaseProperties {

	private String url;
	private String user;
	private String passcode;
	private String drivername;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPasscode() {
		return passcode;
	}

	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	@Override
	public String toString() {
		return "DatabaeProperties [url=" + url + ", user=" + user + ", passcode=" + passcode + ", drivername=" + drivername + "]";
	}
}
