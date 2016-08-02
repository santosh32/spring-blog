package in.spring4buddies.application.ioc.contatiner_overview;

import in.spring4buddies.application.Constant;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@SuppressWarnings({ "deprecation", "resource" })
public class ContainerOverviewMain {

	public static void main(String[] args) {
		
		Resource resource = new FileSystemResource(Constant.APPLICATION_CONTEXT_XML);
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		HelloWorld helloWorld = (HelloWorld) beanFactory.getBean("helloWorld");
		System.out.println("BeanFactory : FileSystemResource == "+ helloWorld.getMessage());
		
		ClassPathResource classPathResource = new ClassPathResource("ContainerOverviewBeans.xml");
		BeanFactory beanFactory1 = new XmlBeanFactory(classPathResource);
		HelloWorld helloWorld1 = (HelloWorld) beanFactory1.getBean("helloWorld");
		System.out.println("BeanFactory : ClassPathResource == "+ helloWorld1.getMessage());
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[] {"ContainerOverviewBeans.xml"});
		BeanFactory beanFactory2 = applicationContext;
		HelloWorld helloWorld2 = (HelloWorld) beanFactory2.getBean("helloWorld");
		System.out.println("ApplicationContext : ClassPathXmlApplicationContext == "+ helloWorld2.getMessage());
		
		ApplicationContext applicationContext1 = new FileSystemXmlApplicationContext(Constant.APPLICATION_CONTEXT_XML);
		HelloWorld helloWorld3 = (HelloWorld) applicationContext1.getBean("helloWorld");
		System.out.println("ApplicationContext : FileSystemXmlApplicationContext == "+ helloWorld3.getMessage());
		
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AnnotationConfig.class);
		HelloWorld helloWorld4 = annotationConfigApplicationContext.getBean(HelloWorld.class);
		System.out.println("AnnotationConfigApplicationContext  == "+ helloWorld4.getMessage());
		annotationConfigApplicationContext.close();
		
		
	}
}
