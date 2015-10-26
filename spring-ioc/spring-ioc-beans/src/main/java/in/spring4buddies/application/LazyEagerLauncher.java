package in.spring4buddies.application;

import in.spring4buddies.application.beans.EagerBean;
import in.spring4buddies.application.beans.LazyBean;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LazyEagerLauncher {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		// uncomment and comment observe the output
//		LazyBean lazyBean = applicationContext.getBean("lazyBean", LazyBean.class);
		EagerBean eagerBean = applicationContext.getBean("eagerBean", EagerBean.class);

		applicationContext.close();
	}
}
