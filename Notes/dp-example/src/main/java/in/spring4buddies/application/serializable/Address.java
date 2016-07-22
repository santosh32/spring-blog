package in.spring4buddies.application.serializable;

import java.io.Serializable;

public class Address implements Serializable {

	private static final long serialVersionUID = 2L;
	String line1;
	String line2;
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	@Override
	public String toString() {
		return "Address [line1=" + line1 + ", line2=" + line2 + "]";
	}
	
	
}
