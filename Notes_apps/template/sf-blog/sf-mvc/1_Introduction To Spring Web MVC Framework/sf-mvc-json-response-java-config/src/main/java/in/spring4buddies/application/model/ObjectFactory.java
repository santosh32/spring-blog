package in.spring4buddies.application.model;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

	public ObjectFactory() {
	}

	public Employees createEmployees() {
		return new Employees();
	}

	public Employees.Employee createEmployeesEmployee() {
		return new Employees.Employee();
	}
}
