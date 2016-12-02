package in.spring4buddies.application.properties;

public class MailProperties {

	private String host;
	private String port;
	private String username;
	private String password;

	private String protocol;
	private String auth;
	private String starttls;
	private String debug;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getStarttls() {
		return starttls;
	}

	public void setStarttls(String starttls) {
		this.starttls = starttls;
	}

	public String getDebug() {
		return debug;
	}

	public void setDebug(String debug) {
		this.debug = debug;
	}

	@Override
	public String toString() {
		return "MailProperties [host=" + host + ", port=" + port + ", username=" + username + ", password=" + password + ", protocol=" + protocol
				+ ", auth=" + auth + ", starttls=" + starttls + ", debug=" + debug + "]";
	}

}
