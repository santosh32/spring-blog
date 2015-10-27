package in.spring4buddies.application;

import in.spring4buddies.application.problem_area.SpringSingletonBean;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProblemAreaLauncher {

	public static void main(String args[]) {

		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext_problem_area.xml");

		System.out.println("********* Observe output from Here ******");
		SpringSingletonBean springSingletonBean = applicationContext
				.getBean(SpringSingletonBean.class);

		for (int i = 0; i < 3; i++) {
			System.out.println("springSingletonBean - "
					+ springSingletonBean.call());
		}
		applicationContext.close();
	}
}
