package in.spring4buddies.application.model;

public class Staff {

	private int staff_Id;
	private String last_name;
	private String first_Name;
	private String city;
	private String state;
	private String home_phone;

	public Staff() {

	}

	public Staff(int staff_Id, String last_name, String first_Name, String city, String state, String home_phone) {
		super();
		this.staff_Id = staff_Id;
		this.last_name = last_name;
		this.first_Name = first_Name;
		this.city = city;
		this.state = state;
		this.home_phone = home_phone;
	}

	public int getStaff_Id() {
		return staff_Id;
	}

	public void setStaff_Id(int staff_Id) {
		this.staff_Id = staff_Id;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHome_phone() {
		return home_phone;
	}

	public void setHome_phone(String home_phone) {
		this.home_phone = home_phone;
	}

	@Override
	public String toString() {
		return "Staff [staff_Id=" + staff_Id + ", last_name=" + last_name + ", first_Name=" + first_Name + ", city=" + city + ", state=" + state
				+ ", home_phone=" + home_phone + "]";
	}

}