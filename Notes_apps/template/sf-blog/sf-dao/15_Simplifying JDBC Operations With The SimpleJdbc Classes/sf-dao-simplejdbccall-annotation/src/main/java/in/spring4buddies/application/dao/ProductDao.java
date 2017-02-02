package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Product;

import java.util.List;

public interface ProductDao {

	List<Product> getAllProducts();

	Product getProductById(int prod_id);

	void insertProduct(int prod_id, String name, String brand, int price);
}