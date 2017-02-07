package in.spring4buddies.application.seeddata;

public class Staff {

	private int staffId;
	private String lLame;
	private String fName;
	private String city;
	private String state;
	private String hPhone;

	public Staff(int staffId, String lLame, String fName, String city, String state, String hPhone) {
		super();
		this.staffId = staffId;
		this.lLame = lLame;
		this.fName = fName;
		this.city = city;
		this.state = state;
		this.hPhone = hPhone;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getlLame() {
		return lLame;
	}

	public void setlLame(String lLame) {
		this.lLame = lLame;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
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

	public String gethPhone() {
		return hPhone;
	}

	public void sethPhone(String hPhone) {
		this.hPhone = hPhone;
	}

	public Staff() {

	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", lLame=" + lLame + ", fName=" + fName + ", city=" + city + ", state=" + state + ", hPhone=" + hPhone
				+ "]";
	}

}