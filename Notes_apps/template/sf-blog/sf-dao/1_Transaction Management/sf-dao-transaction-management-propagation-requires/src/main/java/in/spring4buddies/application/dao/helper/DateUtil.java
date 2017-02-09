package in.spring4buddies.application.dao.helper;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

public class DateUtil {

	public static String convertToString(Date date) {
		return DateFormatUtils.format(date, "yyyy-MM-dd");
	}

}