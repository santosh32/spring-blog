# Dependencies
A typical enterprise application does not consist of a single object (or bean in the Spring parlance). Even the simplest application has a few objects that work together to present what the end-user sees as a coherent application

# Dependency injection
Dependency injection (DI) is a process whereby objects define their dependencies, that is, the other objects they work with, only through constructor arguments, arguments to a factory method, or properties that are set on the object instance after it is constructed or returned from a factory method. The container then injects those dependencies when it creates the bean. This process is fundamentally the inverse, hence the name Inversion of Control (IoC), of the bean itself controlling the instantiation or location of its dependencies on its own by using direct construction of classes, or the Service Locator pattern.

DI exists in two major variants, Constructor-based dependency injection and Setter-based dependency injection.

# Constructor-based dependency injection
Constructor-based DI is accomplished by the container invoking a constructor with a number of arguments, each representing a dependency. Calling a static factory method with specific arguments to construct the bean is nearly equivalent, and this discussion treats arguments to a constructor and to a static factory method similarly.

````java
public class SpringFooBean {

	private SpringBarBean springBarBean;

	public SpringFooBean() {
		System.out.println("(constructor) SpringFooBean()");
	}

	public SpringFooBean(SpringBarBean springBarBean) {
		System.out.println("(constructor) SpringFooBean(springBarBean)");
		this.springBarBean = springBarBean;
	}

```

````java
public class SpringBarBean {

	private String name;
	private String role;
	private Integer age;
	private Double salary;

	public SpringBarBean() {
		System.out.println("(constructor) SpringBarBean() ");
	}
	
//	@ConstructorProperties({ "name", "age", "salary", "role" })
	public SpringBarBean(String name, Integer age, Double salary, String role) {
		System.out.println("(constructor) SpringBarBean(name, age, salary, role ) ");
		this.name = name;
		this.role = role;
		this.age = age;
		this.salary = salary;
	}

//	@ConstructorProperties({ "name", "role", "age", "salary" })
	public SpringBarBean(String name, String role, Integer age, Double salary) {
		System.out.println("(constructor) SpringBarBean(name, role, age, salary) ");
		this.name = name;
		this.role = role;
		this.age = age;
		this.salary = salary;
	}
	public SpringBarBean(String name, String role, Integer age) {
		System.out.println("(constructor) SpringBarBean(name, role, age) ");
		this.name = name;
		this.role = role;
		this.age = age;
	}
	
````

````xml
	<bean id="springBarBean2" class="in.spring4buddies.application.constructor_injection.SpringBarBean">
		<constructor-arg name="name" value="name:bar" />
		<constructor-arg name="role" value="se"/>
		<constructor-arg name="age" value="35" />
		<constructor-arg name="salary" value="25.25" />
	</bean>
	
	<bean id="springBarBean2" class="in.spring4buddies.application.constructor_injection.SpringBarBean">
		<constructor-arg name="name" value="name:bar" />
		<constructor-arg name="role" value="se"/>
		<constructor-arg name="age" value="35" />
		<constructor-arg name="salary" value="25.25" />
	</bean>
	
	<bean id="springBarBean2" class="in.spring4buddies.application.constructor_injection.SpringBarBean">
		<constructor-arg index=="0" value="name:bar" />
		<constructor-arg index=="1" value="se"/>
		<constructor-arg index=="2" value="35" />
		<constructor-arg index=="3" value="25.25" />
	</bean>
	
	<bean id="springBarBean1" class="in.spring4buddies.application.constructor_injection.SpringBarBean">
		<constructor-arg type="java.lang.Integer" value="35"/>
		<constructor-arg type="java.lang.String" value="name:bar" />
		<constructor-arg type="java.lang.Double" value="25.25" />
		<constructor-arg type="java.lang.String" value="role:se" />
	</bean>
	
	<bean id="springFooBean3"
		class="in.spring4buddies.application.constructor_injection.SpringFooBean">
		<constructor-arg ref="springBarBean3" />
	</bean>
````

# Setter-based dependency injection
Setter-based DI is accomplished by the container calling setter methods on your beans after invoking a no-argument constructor or no-argument static factory method to instantiate your bean.
````java
public class SpringFooBean {

	private SpringBarBean springBarBean;

	public SpringFooBean() {
		System.out.println("(constructor) SpringFooBean()");
	}

	public void setSpringBarBean(SpringBarBean springBarBean) {
		this.springBarBean = springBarBean;
	}

	public SpringBarBean getSpringBarBean() {
		return springBarBean;
	}
}
````
````java
public class SpringBarBean {

	private String name;
	private String role;
	private Integer age;
	private Double salary;

	public SpringBarBean() {
		System.out.println("(constructor) SpringBarBean() ");
	}

	//setters and getters
}
````
````xml
	<bean id="springFooBeani" class="in.spring4buddies.application.setter_injection.SpringFooBean">
		<property name="springBarBean" ref="springBarBeani" />
	</bean>

	<bean id="springBarBeani" class="in.spring4buddies.application.setter_injection.SpringBarBean">
		<property name="name" value="name:bar" />
		<property name="role" value="se" />
		<property name="age" value="35" />
		<property name="salary" value="25.25" />
	</bean>
````


