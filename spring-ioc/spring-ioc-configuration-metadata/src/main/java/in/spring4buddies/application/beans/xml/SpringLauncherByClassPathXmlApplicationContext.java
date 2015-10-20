package in.spring4buddies.application.beans.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLauncherByClassPathXmlApplicationContext {

	public static void main(String args[]) {
		
		String configFile = "applicationContext.xml";
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				configFile);
		
//		ApplicationContext applicationContext = 
//		    	new ClassPathXmlApplicationContext(new String[] {"Spring-ModuleA.xml",
//		              "Spring-ModuleB.xml","Spring-Modulec.xml"});
		

		// No bean named 'springHelloWorld' is defined
//		SpringHelloWorldApp springHelloWorld = (SpringHelloWorldApp) applicationContext
//				.getBean("springHelloWorld");
//		springHelloWorld.print();

		SpringHelloWorldBean springHelloWorldApp = (SpringHelloWorldBean) applicationContext
				.getBean("springHelloWorldBean");
		springHelloWorldApp.print();
		
		SpringFooBean springFooBean = (SpringFooBean) applicationContext
				.getBean("springFooBean");
		springFooBean.foo();
		
		applicationContext.close();
	}
}
