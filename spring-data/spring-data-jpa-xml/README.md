- You may get build errors when you do mvn clean install, make sure that oracle dependency in place.

		<dependency>
			<groupId>com.oracle</groupId>
			<artifactId>ojdbc6</artifactId>
			<version>11.2.0.2.0</version>
		</dependency>


- verify pom.xml and replace spring and oracle dependency versions.
     
     		<spring.version>4.0.0.RELEASE</spring.version>
		<hibernate-entitymanager.version>4.2.8.Final</hibernate-entitymanager.version>

- verify spring-config.xml for JPA related stuff.

		<bean id="entityManagerFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
			<property name="dataSource" ref="dataSource" />
			<property name="jpaVendorAdapter" ref="jpaVendorAdapter" />
			<!-- spring based scanning for entity classes -->
			<property name="packagesToScan" value="in.spring4buddies.application.jpa" />
		</bean>

		<bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager" />

		<bean id="employeeService" class="in.spring4buddies.application.service.EmployeeService">
			<constructor-arg name="employeeRepository" ref="employeeRepository" />
		</bean>

- Make sure that Entity class and Repositories are in same package.
  		
		in.spring4buddies.application.jpa
		
- Once mvn clean install is success then you can run Application.java from IDE, then application will insert the Employee data into the database.

		Application.java
