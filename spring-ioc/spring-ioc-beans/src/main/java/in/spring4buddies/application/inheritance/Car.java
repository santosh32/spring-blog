package in.spring4buddies.application.inheritance;

public class Car extends Vehicle {
	private int CC;
	private int gears;

	public int getCC() {
		return CC;
	}

	public void setCC(int cC) {
		CC = cC;
	}

	public int getGears() {
		return gears;
	}

	public void setGears(int gears) {
		this.gears = gears;
	}

}
