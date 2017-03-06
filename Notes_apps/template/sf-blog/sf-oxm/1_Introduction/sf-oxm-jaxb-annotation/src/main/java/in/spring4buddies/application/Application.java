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

		Address address = new Address("TS", "HYD", "Madhapur", "510103");
		Student student = new Student(1, "suresh", "suresh.b@gmail.com", address);

		Address address1 = new Address("TS", "HYD", "Hitech city", "510102");
		Student student1 = new Student(1, "mahesh", "suresh.k@gmail.com", address1);

		Students students = new Students();
		students.addStudent(student);
		students.addStudent(student1);
		jaxbHelper.marshal(students, "student-out.xml");

		System.out.println(jaxbHelper.unmarshal("student.xml"));

		context.close();
	}
}
