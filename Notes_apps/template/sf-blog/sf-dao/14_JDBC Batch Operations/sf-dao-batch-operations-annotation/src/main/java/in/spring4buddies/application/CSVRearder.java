package in.spring4buddies.application;

import in.spring4buddies.application.model.Staff;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

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

	public static void main(String[] args) throws Exception {
		getStaffData(null, null);
	}

	public static <T> void getStaffData(Class<T> clazz, String[] columns1) throws Exception {

		ColumnPositionMappingStrategy<Staff> strategy = new ColumnPositionMappingStrategy<Staff>();
		strategy.setType(Staff.class);

		String[] columns = new String[] { "staffId", "lLame", "fName", "city", "state", "hPhone" };
		strategy.setColumnMapping(columns);

		CsvToBean<Staff> csvToBean = new CsvToBean<Staff>();

		String csvFilename = "D:/poc/blogWS/code/spring-blog/Notes_apps/template/sf-blog/sf-dao/14_JDBC Batch Operations/sf-dao-batch-operations-annotation/src/main/resources/staff.csv";
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));

		List<Staff> list = csvToBean.parse(strategy, csvReader);

		for (Object object : list) {
			Staff staff = (Staff) object;
			System.out.println(staff.getStaffId() + " | " + staff.getlLame() + " | " + staff.getfName() + " | " + staff.getCity() + " | "
					+ staff.getState() + " | " + staff.gethPhone());
		}
		System.out.println("Done");
	}

}
