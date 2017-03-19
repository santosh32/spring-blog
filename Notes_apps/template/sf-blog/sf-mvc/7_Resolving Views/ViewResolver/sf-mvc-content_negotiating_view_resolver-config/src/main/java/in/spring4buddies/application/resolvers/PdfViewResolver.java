package in.spring4buddies.application.resolvers;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import in.spring4buddies.application.view.PdfView;

public class PdfViewResolver implements ViewResolver {

	@Override
	public View resolveViewName(String viewName, Locale locale) throws Exception {
		return new PdfView();
	}
}