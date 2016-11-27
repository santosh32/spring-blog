package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Product;

public interface ProductService {

	Product getByName(String name);
}