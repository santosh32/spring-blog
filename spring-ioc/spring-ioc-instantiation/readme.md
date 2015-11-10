#Instantiating beans
- A bean definition essentially is a recipe for creating one or more objects. The container looks at the recipe for a named bean when asked, and uses the configuration metadata encapsulated by that bean definition to create (or acquire) an actual object.
- Typically, to specify the bean class to be constructed in the case where the container itself directly creates the bean by calling its constructor reflectively, somewhat equivalent to Java code using the **new** operator.
- To specify the actual class containing the **static** factory method that will be invoked to create the object, in the less common case where the container invokes a **static** factory method on a class to create the bean. The object type returned from the invocation of the **static** factory method may be the same class or another class entirely.

**Inner class names**. If you want to configure a bean definition for a **static** nested class, you have to use the binary name of the nested class. For example, if you have a class called *Foo* in the *com.example* package, and this *Foo* class has a static nested class called *Bar*, the value of the 'class' attribute on a bean definition would be… *com.example.Foo$Bar* Notice the use of the **$** character in the name to separate the nested class name from the outer class name.

**Instantiation with a constructor** 
- When you create a bean by the constructor approach, all normal classes are usable by and compatible with Spring. That is, the class being developed does not need to implement any specific interfaces or to be coded in a specific fashion. Simply specifying the bean class should suffice. However, depending on what type of IoC you use for that specific bean, you may need a default (empty) constructor.
- The Spring IoC container can manage virtually any class you want it to manage; it is not limited to managing true JavaBeans. Most Spring users prefer actual JavaBeans with only a default (no-argument) constructor and appropriate setters and getters modeled after the properties in the container. You can also have more exotic non-bean-style classes in your container. If, for example, you need to use a legacy connection pool that absolutely does not adhere to the JavaBean specification, Spring can manage it as well.

With XML-based configuration metadata you can specify your bean class as follows:
````xml
<bean id="exampleBean" class="examples.ExampleBean"/>
<bean name="anotherExample" class="examples.ExampleBeanTwo"/>
````
**Instantiation with a static factory method**
- When defining a bean that you create with a static factory method, you use the class attribute to specify the class containing the static factory
method and an attribute named *factory-method* to specify the name of the factory method itself. You should be able to call this method (with optional
arguments as described later) and return a live object, which subsequently is treated as if it had been created through a constructor. One use for such a
bean definition is to call static factories in legacy code.
The following bean definition specifies that the bean will be created by calling a *factory-method*. The definition does not specify the type (class) of the
returned object, only the class containing the factory method. In this example, the createInstance() method must be a static method.
````xml
<bean id="clientService" class="examples.ClientService" factory-method="createInstance"/>
````
````java
public class ClientService {
	private static ClientService clientService = new ClientService();
	private ClientService() {}
	public static ClientService createInstance() {
	return clientService;
	}
}
````
**Instantiation using an instance factory method**
- Similar to instantiation through a static factory method, instantiation with an instance factory method invokes a non-static method of an existing bean from
the container to create a new bean. To use this mechanism, leave the class attribute empty, and in the *factory-bean* attribute, specify the name of a bean in the current (or parent/ancestor) container that contains the instance method that is to be invoked to create the object. Set the name of the factory method itself with the *factory-method* attribute.
````xml
	<!-- the factory bean, which contains a method called createInstance() -->
	<bean id="serviceLocator" class="examples.DefaultServiceLocator">
	<!-- inject any dependencies required by this locator bean -->
	</bean>
	<!-- the bean to be created via the factory bean -->
	<bean id="clientService" factory-bean="serviceLocator" factory-method="createClientServiceInstance"/>
````

````java
public class DefaultServiceLocator {
	private static ClientService clientService = new ClientServiceImpl();
	private DefaultServiceLocator() {}
	public ClientService createClientServiceInstance() {
	return clientService;
	}
}
````
````xml
<bean id="serviceLocator" class="examples.DefaultServiceLocator">
<!-- inject any dependencies required by this locator bean -->
</bean>
<bean id="clientService"factory-bean="serviceLocator" factory-method="createClientServiceInstance"/>
<bean id="accountService" factory-bean="serviceLocator" factory-method="createAccountServiceInstance"/>
````
````java
public class DefaultServiceLocator {
	private static ClientService clientService = new ClientServiceImpl();
	private static AccountService accountService = new AccountServiceImpl();
	private DefaultServiceLocator() {}
	public ClientService createClientServiceInstance() {
		return clientService;
	}
	public AccountService createAccountServiceInstance() {
		return accountService;
	}
}
````

