package in.spring4buddies.application;

import in.spring4buddies.application.jaxb.Address;
import in.spring4buddies.application.jaxb.Student;
import in.spring4buddies.application.jaxb.Students;
import in.spring4buddies.application.jaxb.helper.JaxbHelper;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {

		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		JaxbHelper jaxbHelper = (JaxbHelper) context.getBean("jaxbHelper");

		Address address = new Address("TS", "HYD", "Hitechcity", "510102");
		Student student = new Student(1, "suresh", "suresh.b@gmail.com", address);

		Students students = new Students();
		students.addStudent(student);
		jaxbHelper.marshal(student, "student.xml");

		context.close();
	}
}
