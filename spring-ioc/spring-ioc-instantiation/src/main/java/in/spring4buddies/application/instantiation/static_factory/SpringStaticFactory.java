package in.spring4buddies.application.instantiation.static_factory;

public class SpringStaticFactory {

	private static SpringStaticFactory springStaticFactory = new SpringStaticFactory();

	private SpringStaticFactory() {
		System.out.println(" (cons) This would not execute, but its executing - SpringStaticFactory()");
	}

	// Static factory method
	public static SpringStaticFactory springStaticFactory() {
		return springStaticFactory;
	}

	public void print() {
		System.out.println("Inside print()");
	}

}
