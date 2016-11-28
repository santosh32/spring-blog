package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Override
	@Cacheable("products")
	public Product getByName(String name) {
		slowLookupOperation();
		logger.info("in getByName()");
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

	@CacheEvict(value = "products", allEntries = true)
//	@Caching (evict = { @CacheEvict(value= "products", allEntries=true) })
	public void refreshAllProducts() {
		// This method will remove all 'products' from cache, say as a result of
		// flush API call.
		logger.info("in refreshAllProducts()");
	}
}