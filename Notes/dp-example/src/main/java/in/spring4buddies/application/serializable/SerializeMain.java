package in.spring4buddies.application.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeMain {
	
	public static void main(String[] args) {
		
		Employee emp = new Employee();
		emp.setEmployeeId(101);
		emp.setEmployeeName("SAntosh");
		emp.setDepartment("CSIT");
		emp.setName("parent name");
		
		Address address = new Address();
		address.setLine1("line1");
		address.setLine2("line2");
		
		emp.setAddress(address);
		
		try {
			FileOutputStream fileOut = new FileOutputStream("c:/employee/employee.ser");
			ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
			outStream.writeObject(emp);
			outStream.close();
			fileOut.close();
			System.out.println("Serialized Employee...");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}
