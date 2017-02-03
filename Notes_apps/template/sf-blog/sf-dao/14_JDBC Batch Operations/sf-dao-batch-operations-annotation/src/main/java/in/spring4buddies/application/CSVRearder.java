package in.spring4buddies.application;

import in.spring4buddies.application.model.Staff;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class CSVRearder {
	
	public static List<Staff> getStaffData() throws IOException {

		InputStream inputStream = CSVRearder.class.getClassLoader().getResourceAsStream("staff.csv");
		List<String> lines = IOUtils.readLines(inputStream);
		List<Staff> staffs = new ArrayList<Staff>();

		for (String line : lines) {
			String[] data = StringUtils.split(line, ",");
			Staff staff = new Staff();
			staff.setStaffId(NumberUtils.toInt(data[0]));
			staff.setlLame(data[1]);
			staff.setfName(data[2]);
			staff.setCity(data[3]);
			staff.setState(data[4]);
			staff.sethPhone(data[5]);
			staffs.add(staff);
			System.out.println(line);
		}
		return staffs;
	}
}
