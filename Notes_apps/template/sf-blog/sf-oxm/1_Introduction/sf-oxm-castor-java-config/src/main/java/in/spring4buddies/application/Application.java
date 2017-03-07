package in.spring4buddies.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.spring4buddies.application.castor.config.CastorConfig;
import in.spring4buddies.application.castor.helper.CastorHelper;
import in.spring4buddies.application.jaxb.Address;
import in.spring4buddies.application.jaxb.Student;
import in.spring4buddies.application.jaxb.Students;

public class Application {

	public static void main(String[] args) throws Exception {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CastorConfig.class);

//		CastorHelper castorHelper = context.getBean(CastorHelper.class);
//
//		Address address = new Address("TS", "HYD", "Madhapur", "510103");
//		Student student = new Student(1, "suresh", "suresh.b@gmail.com", address);
//
//		Address address1 = new Address("TS", "HYD", "Hitech city", "510102");
//		Student student1 = new Student(1, "mahesh", "suresh.k@gmail.com", address1);
//
//		Students students = new Students();
//		students.addStudent(student);
//		students.addStudent(student1);
//		castorHelper.marshal(students, "student-out.xml");
//
//		System.out.println(castorHelper.unmarshal("student.xml"));

		context.close();
	}
}
