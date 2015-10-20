package in.spring4buddies.application.beans.config;

import in.spring4buddies.application.beans.xml.SpringFooBean;
import in.spring4buddies.application.beans.xml.SpringHelloWorldBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringLauncherByAnnotationConfigApplicationContext {

	public static void main(String args[]) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringAppConfig.class);

		SpringHelloWorldBean springHelloWorldApp = (SpringHelloWorldBean) applicationContext
				.getBean(SpringHelloWorldBean.class);
		springHelloWorldApp.print();

		SpringFooBean springFooBean = (SpringFooBean) applicationContext
				.getBean(SpringFooBean.class);
		springFooBean.foo();

		applicationContext.close();

	}
}
