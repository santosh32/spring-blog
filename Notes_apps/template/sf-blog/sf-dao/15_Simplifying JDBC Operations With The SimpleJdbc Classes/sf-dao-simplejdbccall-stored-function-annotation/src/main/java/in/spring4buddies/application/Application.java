package in.spring4buddies.application;

import in.spring4buddies.application.dao.ProductDao;
import in.spring4buddies.application.dao.ProductDaoImpl;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String args[]) {

		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		ProductDao productDao = (ProductDaoImpl) context.getBean("productDao");

		int prod_id = RandomUtils.nextInt(10, 100);

		Double price = productDao.getPriceById(prod_id);
		System.out.println(price);

		context.close();
	}
}
