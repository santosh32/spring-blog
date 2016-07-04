package in.spring4buddies.application.clone;

public class TestDeepCloning {

	public static void main(String[] args) throws CloneNotSupportedException {
		DeepDepartment dept = new DeepDepartment(1, "Human Resource");
		DeepEmployee original = new DeepEmployee(1, "Admin", dept);

		// Lets create a clone of original object
		DeepEmployee cloned = (DeepEmployee) original.clone();

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
		
		System.out.println("original.getDepartment() != cloned.getDepartment() ->" + (original.getDepartment() != cloned.getDepartment()));
		
		System.out.println("original - "+original);
		System.out.println("cloned - "+cloned);
		
		cloned.getDepartment().setName("Finance");
		cloned.setEmployeeName("IT");
		
		System.out.println("original - "+original);
		System.out.println("cloned - "+cloned);
		
	}
}