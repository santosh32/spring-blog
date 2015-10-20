package in.spring4buddies.application.instantiation.static_factory;

public class SpringStaticFactory {

//	private static SpringInstanceFactory springInstanceFactory = new SpringInstanceFactory();

	private SpringStaticFactory(){
		System.out.println(" (cons) This would not execute, but its executing : SpringStaticFactory()");
	}
	
	// Static factory method
//	public static SpringInstanceFactory springInstanceFactory() {
//		return springInstanceFactory;
//	}

	// Instance factory methods
	public Address createPersonalInstance() {
		return new PersonalAddress();
	}

	public Address createWorkInstance() {
		return new WorkAddress();
	}
}
