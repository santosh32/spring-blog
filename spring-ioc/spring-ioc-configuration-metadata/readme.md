#The IoC container
- IoC is also known as **dependency injection (DI)**. It is a process whereby objects define their dependencies, that is, the other objects they work with, only through constructor arguments, arguments to a factory method, or properties that are set on the object instance after it is constructed or returned from a factory method. The container then injects those dependencies when it creates the bean. This process is fundamentally the inverse, hence the name Inversion of Control (IoC) or dependency injection.
- The *org.springframework.beans* and *org.springframework.context* packages are the basis for Spring Framework’s IoC container. The **BeanFactory** interface provides an advanced configuration mechanism capable of managing any type of object. **ApplicationContext** is a sub interface of **BeanFactory**. It adds easier integration with Spring’s AOP features; message resource handling (for use in internationalization), event publication; and application-layer specific contexts such as the **WebApplicationContext** for use in web applications.
- In short, the **BeanFactory** provides the configuration framework and basic functionality, and the **ApplicationContext** adds more enterprise specific functionality. The ApplicationContext is a complete superset of the BeanFactory.
- *In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC container are called beans. A bean is an object*
*that is instantiated, assembled, and otherwise managed by a Spring IoC container. Otherwise, a bean is simply one of many objects in your application.*
*Beans, and the dependencies among them, are reflected in the configuration metadata used by a container*.

**Container overview**
- The interface *org.springframework.context.ApplicationContext* represents the Spring IoC container and is responsible for instantiating, configuring, and assembling the aforementioned beans. The container gets its instructions on what objects to instantiate, configure, and assemble by reading configuration metadata. The configuration metadata is represented in XML, Java annotations, or Java code. It allows you to express the objects that compose your application and the rich interdependencies between such objects.
- Several implementations of the ApplicationContext interface are supplied out-of-the-box with Spring. In standalone applications it is common to create an instance of **ClassPathXmlApplicationContext** or **FileSystemXmlApplicationContext**. While XML has been the traditional format for defining configuration metadata you can instruct the container to use Java annotations or code as the metadata format by providing a small amount of XML configuration to declaratively enable support for these additional metadata formats.

#**<< Diagram goes here >>** 

**Configuration metadata**
- The Spring IoC container consumes a form of configuration metadata; this configuration metadata represents how you as an application developer tell the Spring container to instantiate, configure, and assemble the objects in your application.

Configuration metadata is traditionally supplied in a simple and intuitive XML format, we can also do it in other forms.

- XML configuration.
- Annotation-based configuration: Spring 2.5 introduced support for annotation-based configuration metadata.
  (Ex : @Autowired, @Required, @Service, @Repository).
- Java-based configuration: Starting with Spring 3.0, many features provided by the Spring JavaConfig project became part of the core Spring Framework.
  (Ex : @Configuration, @Bean, @Import and @DependsOn annotations).

````xml

<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans.xsd">

		<bean id="..." class="...">
			<!-- collaborators and configuration for this bean go here -->
		</bean>
		<bean id="..." class="...">
			<!-- collaborators and configuration for this bean go here -->
		</bean>
		<!-- more bean definitions go here -->
	</beans>
````

**Instantiating a container**
- Instantiating a Spring IoC container is straightforward. The location path or paths supplied to an ApplicationContext constructor are actually resource strings that allow the container to load configuration metadata from a variety of external resources such as the local file system, from the Java CLASSPATH, and so on.

````java

1. ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"services.xml", "daos.xml"});


2. ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext-annotation.xml");
				

3. AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringAppConfig.class);
	
			
4. Resource resource = new ClassPathResource("applicationContext.xml");
   BeanFactory beanFactory = new XmlBeanFactory(resource);


5. FileSystemXmlApplicationContext applicationContext = new FileSystemXmlApplicationContext(
				".././src/main/resources/applicationContext.xml");
````

**Composing XML-based configuration metadata**
- It can be useful to have bean definitions span multiple XML files. Often each individual XML configuration file represents a logical layer or module in your
architecture. You can use the application context constructor to load bean definitions from all these XML fragments. This constructor takes multiple Resource
locations, as was shown in the previous section. Alternatively, use one or more occurrences of the **<import/>** element to load bean definitions from another file or files.

````xml

<beans>
	<import resource="services.xml" />
	<import resource="resources/messageSource.xml" />
	<import resource="/resources/themeSource.xml" />
	<bean id="bean1" class="..." />
	<bean id="bean2" class="..." />
</beans>
````

**Using the container**
The ApplicationContext is the interface for an advanced factory capable of maintaining a registry of different beans and their dependencies. Using 
the method **T getBean(String name, Class<T> requiredType)** you can retrieve instances of your beans.The **ApplicationContext** enables you to read bean definitions and access them as follows:

````java
// create and configure beans
ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"services.xml", "daos.xml"});
// retrieve configured instance
1. PetStoreService service = context.getBean("petStore", PetStoreService.class);
2. PetStoreService service = context.getBean("petStore");
3. PetStoreService service = context.getBean(PetStoreService.class);

````

**Quick points**
````java
- ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
- ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
- AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAppConfig.class);
````
````xml
- <context:annotation-config />
- <context:component-scan base-package="" />
- <dependency>
	<groupId>cglib</groupId>
	<artifactId>cglib</artifactId>
	<version>3.0</version>
  </dependency>
  ````
  ````java
 - @Configuration, @Bean etc..
 - @Autowire, @component, @service, @Request
 ````





