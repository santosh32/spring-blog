package in.spring4buddies.application.instantiation.instance_factory;

public class SpringInstanceFactory {

	private static SpringInstanceFactory springInstanceFactory = new SpringInstanceFactory();

	private SpringInstanceFactory() {
		System.out.println("This would not execute, but its executing - (cons)SpringInstanceFactory()");
	}

	// Static factory method
	public static SpringInstanceFactory springInstanceFactory() {
		return springInstanceFactory;
	}

}
