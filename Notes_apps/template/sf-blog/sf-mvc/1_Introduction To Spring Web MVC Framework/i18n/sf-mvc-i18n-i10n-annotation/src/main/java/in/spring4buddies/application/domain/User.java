package in.spring4buddies.application.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {

	@NotEmpty(message = "UserName cannot be empty")
	@Size(min = 1, max = 16, message = "Size should be between 1 to 16")
	private String name;

	@NotEmpty(message = "Password cannot be empty")
	@Size(min = 1, max = 16, message = "Size should be between 1 to 16")
	private String password;

	@NotEmpty(message = "Gender cannot be empty")
	private String gender;

	@NotEmpty(message = "Country cannot be empty")
	private String country;

	@NotEmpty(message = "AboutYou cannot be empty")
	@Size(min = 1, max = 50, message = "Size should be between 1 to 50")
	private String aboutYou;

	@NotEmpty(message = "Community cannot be empty")
	private String[] community;

	private Boolean feed;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAboutYou() {
		return aboutYou;
	}

	public void setAboutYou(String aboutYou) {
		this.aboutYou = aboutYou;
	}

	public String[] getCommunity() {
		return community;
	}

	public void setCommunity(String[] community) {
		this.community = community;
	}

	public Boolean getFeed() {
		return feed;
	}

	public void setFeed(Boolean feed) {
		this.feed = feed;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}