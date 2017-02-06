package in.spring4buddies.application;

import in.spring4buddies.application.model.Staff;

import java.io.FileReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class CSVRearder<T> {

	@SuppressWarnings("unchecked")
	public static <T> List<Staff> getStaffData(Class<T> clazz, String[] columns) throws Exception {

		ColumnPositionMappingStrategy<T> strategy = new ColumnPositionMappingStrategy<T>();
		strategy.setType(clazz);

		strategy.setColumnMapping(columns);

		CsvToBean<T> csvToBean = new CsvToBean<T>();

		String csvFilename = "D:/poc/blogWS/code/spring-blog/Notes_apps/template/sf-blog/sf-dao/14_JDBC Batch Operations/sf-dao-batch-operations-annotation/src/main/resources/staff.csv";
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));

		List<Staff> staffs = (List<Staff>) csvToBean.parse(strategy, csvReader);

		for (Staff staff : staffs) {
			System.out.println(staff.getStaffId() + " | " + staff.getlLame() + " | " + staff.getfName() + " | " + staff.getCity() + " | "
					+ staff.getState() + " | " + staff.gethPhone());
		}
		System.out.println("Done");
		return staffs;
	}

}
