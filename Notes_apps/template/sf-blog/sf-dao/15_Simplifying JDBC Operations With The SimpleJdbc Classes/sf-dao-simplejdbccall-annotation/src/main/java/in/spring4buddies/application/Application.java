package in.spring4buddies.application;

import in.spring4buddies.application.dao.ProductJdbcCall;
import in.spring4buddies.application.model.Product;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String args[]) {
		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);
		ProductJdbcCall productJdbcCall = (ProductJdbcCall) context.getBean("productJdbcCall");
		productJdbcCall.callProcedure(104, "Product A", "Brand A", 230);
		productJdbcCall.callProcedure(105, "Product B", "Brand B", 130);
		List<Product> products = productJdbcCall.getAllProducts();
		System.out.println(products);

		context.close();
	}
}
