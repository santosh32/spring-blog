package in.spring4buddies.application.jaxb;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "students")
public class Students {

	private List<Student> students;

	public Students() {
		students = new ArrayList<Student>();
	}

	public List<Student> getStudents() {
		return students;
	}

	@XmlElement(name = "student")
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	@Override
	public String toString() {
		return "Students [students=" + students + "]";
	}

}
