package in.spring4buddies.application.clone;

public class TestShallowCloning {

	public static void main(String[] args) throws CloneNotSupportedException {
		ShallowDepartment dept = new ShallowDepartment(1, "Human Resource");
		ShallowEmployee original = new ShallowEmployee(1, "Admin", dept);

		// Lets create a clone of original object
		ShallowEmployee cloned = (ShallowEmployee) original.clone();

		// Let verify using employee id, if cloning actually workded
		System.out.println("cloned.getEmpoyeeId() = " + cloned.getEmpoyeeId());

		// Verify JDK's rules
		// Must be true and objects must have different memory addresses
		System.out.println("original != cloned ->" + (original != cloned));

		// As we are returning same class; so it should be true
		System.out.println("(original.getClass() == cloned.getClass()) ->"
				+ (original.getClass() == cloned.getClass()));

		// Default equals method checks for refernces so it should be false. If
		// we want to make it true,
		// we need to override equals method in Employee class.
		System.out.println("original.equals(cloned) ->"
				+ original.equals(cloned));
		
		cloned.getDepartment().setName("Finance");
		
		System.out.println("original.getDepartment().getName() ->"+original.getDepartment().getName());
	}
}