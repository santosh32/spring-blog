package in.spring4buddies.application.jaxb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.castor.CastorMarshaller;

import in.spring4buddies.application.jaxb.helper.CastorHelper;

@Configuration
public class CastorConfig {

	@Bean
	public CastorHelper JaxbHelper(CastorMarshaller castorMarshaller) {
		CastorHelper castorHelper = new CastorHelper();
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
