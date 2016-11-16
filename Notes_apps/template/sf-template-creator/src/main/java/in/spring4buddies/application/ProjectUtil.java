package in.spring4buddies.application;

import java.text.MessageFormat;

public class ProjectUtil {

	public static String replace(String template, String... parameters) {

		return new MessageFormat(template).format(parameters);
	}
}
