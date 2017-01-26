package in.spring4buddies.application;

import in.spring4buddies.application.dao.EmployeeDao;
import in.spring4buddies.application.model.Employee;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application { 

	public static void main(String[] args) throws Exception {
		  String confFile = "applicationContext.xml";
	        ConfigurableApplicationContext context =
	                                    new ClassPathXmlApplicationContext(confFile);
	        EmployeeDao empDao = (EmployeeDao) context.getBean("employeeDAO");
	        Employee emp = empDao.findEmployeeById(1);
	        System.out.println(emp.getName()+" | "+emp.getSalary()+" | "+emp.getDept());
	}
}
