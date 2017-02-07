package in.spring4buddies.application;

import java.io.InputStreamReader;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

public class CSVRearder<T> {

	public static <T> List<T> getDataByCSV(Class<T> clazz, String filename, String[] columns) throws Exception {

		ColumnPositionMappingStrategy<T> strategy = new ColumnPositionMappingStrategy<T>();
		strategy.setType(clazz);
		strategy.setColumnMapping(columns);

		CSVReader csvReader = new CSVReader(new InputStreamReader(CSVRearder.class.getClassLoader().getResourceAsStream(filename)));

		return new CsvToBean<T>().parse(strategy, csvReader);
	}

	public static <T> List<T> getDataByCSV(Class<T> clazz, String[] columns) throws Exception {
		return getDataByCSV(clazz, clazz.getName() + ".csv", columns);
	}
}
