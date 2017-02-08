package in.spring4buddies.application.csv;

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

		CSVReader csvReader = new CSVReader(new InputStreamReader(CSVRearder.class.getClassLoader()
				.getResourceAsStream("csv/" + filename.toLowerCase())));

		return new CsvToBean<T>().parse(strategy, csvReader);
	}

	public static <T> List<T> getDataByCSV(Class<T> clazz, String[] columns) throws Exception {
		return getDataByCSV(clazz, clazz.getSimpleName() + ".csv", columns);
	}

	public static <T> List<T> getDataByCSV(Class<T> clazz) throws Exception {
		return getDataByCSV(clazz, CSVHeader.load(clazz));
	}
}
