package in.spring4buddies.application.jaxb.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import in.spring4buddies.application.jaxb.helper.JaxbHelper;

@Configuration
public class JaxbConfig {

	@Bean
	public JaxbHelper JaxbHelper(Jaxb2Marshaller jaxb2Marshaller) {
		JaxbHelper jaxbHelper = new JaxbHelper();
		jaxbHelper.setMarshaller(jaxb2Marshaller);
		jaxbHelper.setUnmarshaller(jaxb2Marshaller);
		return jaxbHelper;
	}

	@Bean
	public Jaxb2Marshaller getJaxbMarshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setPackagesToScan("in.spring4buddies.application.jaxb");

		Map<String, Object> props = new HashMap<String, Object>();
		props.put(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

		jaxb2Marshaller.setMarshallerProperties(props);

		return jaxb2Marshaller;
	}
}
