package in.spring4buddies.application.jpa;

import in.spring4buddies.application.jpa.domain.Address;
import in.spring4buddies.application.jpa.domain.Employee;

import com.google.gson.Gson;

public class Test {

	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setName("santosh");
		employee.setSalary(10000);
		
		Address address = new Address();
		address.setAddressLine1("Gayathri Classic");
		address.setCity("HYD");
		address.setZipcode("508218");
		employee.setAddress(address);
		
		Gson gson = new Gson();
		String json = gson.toJson(employee);
		System.out.println(json);

	}

}
