package in.spring4buddies.application.rest.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> httpMessageConverters) {
		
//		httpMessageConverters.add(createXmlHttpMessageConverter());
		httpMessageConverters.add(new MappingJackson2HttpMessageConverter());

		super.configureMessageConverters(httpMessageConverters);
	}

//	private HttpMessageConverter<Object> createXmlHttpMessageConverter() {
//		MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();
//
//		XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
//		xmlConverter.setMarshaller(xstreamMarshaller);
//		xmlConverter.setUnmarshaller(xstreamMarshaller);
//
//		return xmlConverter;
//	}
}