package in.spring4buddies.application.beans.xml;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringLauncherByFileSystemXmlApplicationContext {

	public static void main(String args[]) {

		FileSystemXmlApplicationContext applicationContext = new FileSystemXmlApplicationContext(
				"D:/poc/blogWS/code/spring-ioc/Spring - IoC Containers/spring-ioc-xml/src/main/resources/applicationContext.xml");

		SpringHelloWorldBean springHelloWorldApp = (SpringHelloWorldBean) applicationContext
				.getBean("springHelloWorldBean");

		springHelloWorldApp.print();
		
		applicationContext.close();
	}
}
