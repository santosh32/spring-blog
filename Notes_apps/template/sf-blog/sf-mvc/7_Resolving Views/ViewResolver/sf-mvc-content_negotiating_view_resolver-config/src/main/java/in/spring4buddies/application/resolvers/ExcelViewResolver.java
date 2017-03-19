package in.spring4buddies.application.resolvers;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class ExcelViewResolver implements ViewResolver {

	@Override
	public View resolveViewName(String viewname, Locale locale) throws Exception {
		ExcelView excelView = new ExcelView();
		return excelView;
	}
}