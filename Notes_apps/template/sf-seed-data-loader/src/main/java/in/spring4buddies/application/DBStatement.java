package in.spring4buddies.application;

import in.spring4buddies.application.csv.CSVRearder;
import in.spring4buddies.application.seeddata.Employee;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DBStatement<T> {

	public static <T> List<String> insert(List<T> data) throws Exception {

		List<String> queries = new ArrayList<>();
		for (T t : data) {
			Class<?> clazz = t.getClass();
			Field[] fields = clazz.getDeclaredFields();
			StringBuffer columns = new StringBuffer();
			StringBuffer values = new StringBuffer();
			StringBuffer query = new StringBuffer("insert into " + clazz.getSimpleName());
			int i = 0;
			for (Field field : fields) {
				field.setAccessible(true);
				String name = field.getName();
				if (i != 0) {
					columns.append(",");
					values.append(",");
				}
				columns.append(name);
				values.append("'" + field.get(t) + "'");
				i++;

			}
			query.append(" (").append(columns).append(" ) values ( ").append(values).append(" )");
			queries.add(query.toString());
		}
		return queries;
	}
}
