package in.spring4buddies.application;

import in.spring4buddies.application.dao.helper.DateUtil;
import in.spring4buddies.application.service.TravelService;

import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {
		String confFile = "beans-hsql.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		TravelService travelService = context.getBean(TravelService.class);

		Date date = new Date();
		Date plus5days = DateUtil.addDays(date, 5);

		System.out.println(travelService.getTravelTripByPassengerId(1));

		context.close();
	}
}
