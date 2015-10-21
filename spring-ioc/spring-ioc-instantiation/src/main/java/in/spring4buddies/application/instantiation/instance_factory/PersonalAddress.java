package in.spring4buddies.application.instantiation.instance_factory;

public class PersonalAddress implements Address {
	
	public PersonalAddress(){
		System.out.println(" (cons) PersonalAddress()");
	}

	public void getAddress(String line1, String line2, String city,
			String state, String country) {
		System.out.println("Personal Address : getAddress()");
	}
}
