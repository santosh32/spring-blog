# Configuration metadata

the Spring IoC container consumes a form of configuration metadata; this configuration metadata represents how you as an application developer tell the Spring container to instantiate, configure, and assemble the objects in your application.

Configuration metadata is traditionally supplied in a simple and intuitive XML format, which is what most of this chapter uses to convey key concepts and features of the Spring IoC container.

For information about using other forms of metadata with the Spring container, see:
Annotation-based configuration: Spring 2.5 introduced support for annotation-based configuration metadata.
Java-based configuration: Starting with Spring 3.0, many features provided by the Spring JavaConfig project became part of the core Spring Framework. Thus you can define beans external to your application classes by using Java rather than XML files. To use these new features, see the
@Configuration, @Bean, @Import and @DependsOn annotations.

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

# Instantiating a container
Instantiating a Spring IoC container is straightforward. The location path or paths supplied to an ApplicationContext constructor are actually resource strings that allow the container to load configuration metadata from a variety of external resources such as the local file system, from the Java CLASSPATH, and so on.

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

# Composing XML-based configuration metadata

````xml

<beans>
	<import resource="services.xml" />
	<import resource="resources/messageSource.xml" />
	<import resource="/resources/themeSource.xml" />
	<bean id="bean1" class="..." />
	<bean id="bean2" class="..." />
</beans>
````




