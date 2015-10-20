package in.spring4buddies.application.beans.xml;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringLauncherByXmlBeanFactory {

	public static void main(String args[]) {

		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);

		SpringHelloWorldBean springHelloWorldApp = (SpringHelloWorldBean) beanFactory
				.getBean("springHelloWorldBean");

		springHelloWorldApp.print();
	}
}
