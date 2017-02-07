package in.spring4buddies.application.seeddata;

public class Customer {

	private int customerId;
	private String contact;
	private String address;
	private String city;
	private String firstOrder;
	private String state;
	private String zipCode;
	private String country;
	private String phone;
	private String name;

	public Customer() {

	}

	public Customer(int customerId, String contact, String address, String city, String firstOrder, String state, String zipCode, String country,
			String phone, String name) {
		super();
		this.customerId = customerId;
		this.contact = contact;
		this.address = address;
		this.city = city;
		this.firstOrder = firstOrder;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.phone = phone;
		this.name = name;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFirstOrder() {
		return firstOrder;
	}

	public void setFirstOrder(String firstOrder) {
		this.firstOrder = firstOrder;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", contact=" + contact + ", address=" + address + ", city=" + city + ", firstOrder="
				+ firstOrder + ", state=" + state + ", zipCode=" + zipCode + ", country=" + country + ", phone=" + phone + ", name=" + name + "]";
	}

}