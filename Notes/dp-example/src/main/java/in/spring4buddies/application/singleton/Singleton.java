package in.spring4buddies.application.singleton;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private static Singleton singleton = null;

	// private static volatile Singleton singleton=null;
	
	private Singleton() {
		if (singleton != null) {
			throw new InstantiationError(
					"Its Singleton Class use getInstance method for object creation");
		}
	}

	public static Singleton getInstance() {
		return Holder.singleton;

	}

	/**
	 * good way for getting the instance. No need to worry about
	 * BillPughSingleton
	 */
	private static class Holder {
		private static final Singleton singleton = new Singleton();
	}

	/**
	 * Use this code for preventing Singleton breakage in multi threading
	 * scenario and comment above getInstance method As this is the efficient
	 * way If we put synchronized at method level level then will impact
	 * performance and will executed every time when getInstance is called But
	 * if once the instance is created then there is no need for synchronized.
	 */

//	public static Singleton getInstance() {
//		if (singleton == null) {
//			synchronized (Singleton.class) {
//				if (singleton == null) {
//					singleton = new Singleton();
//				}
//			}
//		}
//		return singleton;
//	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		/***
		 * We can place below check OR we can remove the exception thrown check
		 * and return singleton instead of super.clone() Use any one way
		 */
		if (singleton != null) {
			throw new InstantiationError(
					"Its Singleton Class use getInstance method for object creation");
		}
		return super.clone();
	}

	/***
	 * 
	 * To Prevent breaking of singleton pattern by using serilization/
	 * de-serilization
	 */
	private Object readResolve() {
		System.out.println("Read Resolve executed");
		return singleton;
	}

	/** This is my implementation to stop it but Its not working. */
	public Object newInstance() throws InstantiationException {
		throw new InstantiationError("Creating of this object is not allowed.");
	}
}