package in.spring4buddies.application.jibx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jibx.JibxMarshaller;

import in.spring4buddies.application.jibx.helper.JibxHelper;

@Configuration
public class JibxConfig {

	@Bean
	public JibxHelper castorHelper(JibxMarshaller jibxMarshaller) {
		JibxHelper jibxHelper = new JibxHelper();
		jibxHelper.setMarshaller(jibxMarshaller);
		jibxHelper.setUnmarshaller(jibxMarshaller);
		return jibxHelper;
	}

	@Bean
	public JibxMarshaller getJibxMarshaller() {
		JibxMarshaller jibxMarshaller = new JibxMarshaller();
		jibxMarshaller.setTargetPackage("in.spring4buddies.application.jaxb");
		return jibxMarshaller;
	}
}
