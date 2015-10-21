package in.spring4buddies.application.instantiation.instance_factory;

public class SpringInstanceFactory {

	private static SpringInstanceFactory springInstanceFactory = new SpringInstanceFactory();

	private SpringInstanceFactory() {
		System.out.println(" (cons) This would not execute, but its executing : SpringInstanceFactory()");
	}

	// Static factory method
	public static SpringInstanceFactory springInstanceFactory() {
		return springInstanceFactory;
	}

	// Instance factory methods
	public Address createPersonalInstance() {
		return new PersonalAddress();
	}

	public Address createWorkInstance() {
		return new WorkAddress();
	}
}
