package in.spring4buddies.application.serializable;

import java.io.Serializable;

public class Singleton implements Serializable {

	private static final long serialVersionUID = 3119105548371608200L;
	private static final Singleton singleton = new Singleton();

	private Singleton() {
		if (Singleton.singleton != null) {
			throw new InstantiationError(
					"Creating of this object is not allowed.");
		}
	}

	public static Singleton getInstance() {
		return singleton;
	}

	/***
	 * We can place below check OR we can remove the exception thrown check and
	 * return singleton instead of super.clone() Use any one way
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException(
				"Cloning of this class is not allowed");
	}

	/**
	 * To Prevent breaking of singleton pattern by using serilization/de
	 * serilization
	 */
	protected Object readResolve() {
		return singleton;
	}

	/** This is my implementation to stop it but Its not working. */
	public Object newInstance() throws InstantiationException {
		throw new InstantiationError("Creating of this object is not allowed.");
	}
}