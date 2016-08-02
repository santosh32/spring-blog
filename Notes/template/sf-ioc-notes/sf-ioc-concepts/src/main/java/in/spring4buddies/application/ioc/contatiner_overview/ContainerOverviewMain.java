package in.spring4buddies.application.ioc.contatiner_overview;

import in.spring4buddies.application.Constant;

import java.io.FileInputStream;
import java.io.InputStream;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class ContainerOverviewMain {

	public static void main(String[] args) {
		
//		Resource resource = new FileSystemResource(Constant.APPLICATION_CONTEXT_XML);
//		BeanFactory factory = new XmlBeanFactory(resource);
//		HelloWorld helloWorld = (HelloWorld) factory.getBean("helloWorld");
//		System.out.println(helloWorld.getMessage());
		
		Resource resource = new FileSystemResource(Constant.APPLICATION_CONTEXT_XML);
		BeanFactory factory = new XmlBeanFactory(resource);
		
//		ClassPathResource resource = new ClassPathResource("ContainerOverviewBeans.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
		
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"ContainerOverviewBeans.xml"});
		BeanFactory factory = context;
		
		HelloWorld helloWorld = (HelloWorld) factory.getBean("helloWorld");
		System.out.println(helloWorld.getMessage());

	}
}
