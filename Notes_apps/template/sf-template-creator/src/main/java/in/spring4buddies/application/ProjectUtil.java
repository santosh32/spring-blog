package in.spring4buddies.application;

import java.text.MessageFormat;

public class ProjectUtil {

	public static String replace(String template, String... parameters) {

		return new MessageFormat(template).format(parameters);
	}

	public static String replace(String template, boolean isLowerCase, String... parameters) {
		String str = replace(template, parameters);
		if (isLowerCase) {
			str = str.replace(" ", "-").toLowerCase();
		}
		return str;
	}
}
