package in.spring4buddies.application;

import in.spring4buddies.application.dao.EmployeeDao;
import in.spring4buddies.application.model.Employee;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExploreCurdApi {

	public static void main(String[] args) throws Exception {
		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		EmployeeDao empDao = (EmployeeDao) context.getBean("employeeDao");

		System.out.println(" *****  Insert new employee ******");
		Employee newEmployee = new Employee();
		newEmployee.setEmpId(1);
		newEmployee.setDept("DB");
		newEmployee.setName("Garav");
		newEmployee.setSalary(1000);
		empDao.insertEmployee(newEmployee);

		System.out.println(" *****  Select employee by id ******");
		Employee employee = empDao.findEmployeeById(1);
		System.out.println(employee.getName() + " | " + employee.getSalary() + " | " + employee.getDept());

		System.out.println(" *****  Update employee ******");
		Employee updateEmployee = new Employee();
		updateEmployee.setEmpId(1);
		updateEmployee.setSalary(2000);
		empDao.updateEmployee(updateEmployee);

		System.out.println(" *****  Select employee by id ******");
		employee = empDao.findEmployeeById(1);
		System.out.println(employee.getName() + " | " + employee.getSalary() + " | " + employee.getDept());

		System.out.println(" *****  Delete employee ******");
		empDao.removeEmployee(1);

		System.out.println(" *****  Select employee by id ******");
		try {
			employee = empDao.findEmployeeById(1);
			System.out.println(employee.getName() + " | " + employee.getSalary() + " | " + employee.getDept());
		} catch (Exception e) {
			System.out.println("No Records found ? ");
		}

		context.close();
	}
}
