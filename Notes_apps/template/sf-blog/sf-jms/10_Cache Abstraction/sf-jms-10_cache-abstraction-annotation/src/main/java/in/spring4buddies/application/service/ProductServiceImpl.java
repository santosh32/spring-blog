package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Product;

import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Override
	public Product getByName(String name) {
		slowLookupOperation();
		return new Product(name, 100);
	}

	public void slowLookupOperation() {
		try {
			long time = 5000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}
}