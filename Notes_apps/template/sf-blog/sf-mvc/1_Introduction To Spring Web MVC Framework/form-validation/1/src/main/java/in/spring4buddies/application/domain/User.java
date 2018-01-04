package in.spring4buddies.application.domain;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {

	@NotEmpty
	@Size
	private String name;

	@NotEmpty
	@Size
	private String password;

	@NotEmpty
	private String gender;

	@NotEmpty
	private String country;

	@NotEmpty
	@Size
	private String aboutYou;

	@NotEmpty
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