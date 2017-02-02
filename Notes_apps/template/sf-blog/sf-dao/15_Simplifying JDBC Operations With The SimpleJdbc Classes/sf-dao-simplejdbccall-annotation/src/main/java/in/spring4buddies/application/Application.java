package in.spring4buddies.application;

import in.spring4buddies.application.dao.ProductDao;
import in.spring4buddies.application.dao.ProductDaoImpl;
import in.spring4buddies.application.model.Product;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String args[]) {
		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		ProductDao productDao = (ProductDaoImpl) context.getBean("productDao");

//		List<Product> products = productDao.getAllProducts();
//		System.out.println("list of products - " + products);

		int prod_id = RandomUtils.nextInt(10, 100);
		Product product = new Product(prod_id, "VCD", 4500, "CD");

		productDao.insertProduct(product);

		product = productDao.getProductById(prod_id);
		System.out.println(product);

		context.close();
	}
}
