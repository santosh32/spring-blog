package delete.later;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Interval;

public class DateHelper {

	static SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) throws Exception {

		String dateInString1 = "2016-10-16 06:47:28";
		Date date1 = dateFormat.parse(dateInString1);

		String dateInString2 = "2016-10-16 07:47:28";
		Date date2 = dateFormat.parse(dateInString2);

		String dateInString3 = "2016-10-16 06:47:27";
		Date date3 = dateFormat.parse(dateInString3);

		System.out.println(date1);
		System.out.println(date2);
		System.out.println(date3);
		System.out.println("");

		System.out.println(dateFormat.format(date1));
		System.out.println(dateFormat.format(date2));
		System.out.println(dateFormat.format(date3));
		System.out.println("");

		System.out.println(dateFormat.format(date3) + " is between\n"
				+ dateFormat.format(date1) + " And " + dateFormat.format(date2)
				+ " - " + isWithInRange(date3, date1, date2));

	}

	private static boolean isWithInRange(Date createdDate, Date startDate,
			Date endDate) {
		return (createdDate.equals(startDate) || createdDate.after(startDate))
				&& (createdDate.equals(endDate) || createdDate.before(endDate));
	}

}
