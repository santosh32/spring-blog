package in.spring4buddies.application;

import in.spring4buddies.application.dao.ProductDao;
import in.spring4buddies.application.dao.ProductDaoImpl;
import in.spring4buddies.application.model.Product;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String args[]) {
		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		ProductDao productDao = (ProductDaoImpl) context.getBean("productDao");

		List<Product> products = productDao.getAllProducts();
		System.out.println("list of products - " + products);

		Product product = productDao.getProductById(100);
		System.out.println(product);

		context.close();
	}
}
