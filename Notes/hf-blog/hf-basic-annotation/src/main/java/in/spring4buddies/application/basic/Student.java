package in.spring4buddies.application.basic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public final class Student {

	@Id
	@Column(name = "sid")
	@SequenceGenerator(name = "seq", sequenceName = "student_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private long id;

	@Column(name = "age")
	private int age;

	@Column(name = "name")
	private String name;

	@Column(name = "CREATED_DATE")
	private Date created_date = new Date();

	public Student() {
	}

	public Student(int id, int age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}

	public Student(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
