package in.spring4buddies.application.beans.config;

import in.spring4buddies.application.beans.xml.SpringBarBean;
import in.spring4buddies.application.beans.xml.SpringFooBean;
import in.spring4buddies.application.beans.xml.SpringHelloWorldBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringAppConfig {

	@Bean
	public SpringBarBean springBarBean() {
		return new SpringBarBean();
	}

//	@Bean
//	public SpringFooBean springFooBean() {
//		SpringFooBean springFooBean = new SpringFooBean();
//		springFooBean.setSpringBarBean(springBarBean());
//		return springFooBean;
//	}
	
	@Bean
	public SpringFooBean springFooBean(SpringBarBean springBarBean) {
		SpringFooBean springFooBean = new SpringFooBean();
		springFooBean.setSpringBarBean(springBarBean);
		return springFooBean;
	}

	@Bean
	public SpringHelloWorldBean springHelloWorldBean() {
		return new SpringHelloWorldBean();
	}
}
