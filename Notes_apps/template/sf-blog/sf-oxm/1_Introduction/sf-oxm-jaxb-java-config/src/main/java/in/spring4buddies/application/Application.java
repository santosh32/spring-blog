package in.spring4buddies.application;

import in.spring4buddies.application.jaxb.Address;
import in.spring4buddies.application.jaxb.Student;
import in.spring4buddies.application.jaxb.Students;
import in.spring4buddies.application.jaxb.config.JaxbConfig;
import in.spring4buddies.application.jaxb.helper.JaxbHelper;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JaxbConfig.class);

		JaxbHelper jaxbHelper = context.getBean(JaxbHelper.class);

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
