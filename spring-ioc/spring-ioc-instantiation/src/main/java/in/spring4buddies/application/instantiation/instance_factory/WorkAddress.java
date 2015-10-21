package in.spring4buddies.application.instantiation.instance_factory;

public class WorkAddress implements Address {
	
	public WorkAddress(){
		System.out.println(" (cons) WorkAddress()");
	}

	public void getAddress(String line1, String line2, String city,
			String state, String country) {
		System.out.println("Work Address : getAddress()");
	}
}
