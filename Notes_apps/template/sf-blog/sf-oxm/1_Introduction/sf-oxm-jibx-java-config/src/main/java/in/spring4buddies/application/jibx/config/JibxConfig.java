package in.spring4buddies.application.jibx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.castor.CastorMarshaller;

import in.spring4buddies.application.jibx.helper.JibxHelper;

@Configuration
public class JibxConfig {

	@Bean
	public JibxHelper castorHelper(CastorMarshaller castorMarshaller) {
		JibxHelper castorHelper = new JibxHelper();
		castorHelper.setMarshaller(castorMarshaller);
		castorHelper.setUnmarshaller(castorMarshaller);
		return castorHelper;
	}

	@Bean
	public CastorMarshaller getCastorMarshaller() {
		CastorMarshaller castorMarshaller = new CastorMarshaller();
		Resource resource = new ClassPathResource("mapping.xml");
		castorMarshaller.setMappingLocation(resource);
		return castorMarshaller;
	}
}
