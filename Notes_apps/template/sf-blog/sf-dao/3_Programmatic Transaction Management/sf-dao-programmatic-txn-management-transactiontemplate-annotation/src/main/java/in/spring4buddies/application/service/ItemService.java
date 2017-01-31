package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Item;

import java.util.List;

public interface ItemService {

	List<Item> getItems();

	void addItem(Item item);

	void updateItem(Item item);

	void deleteItem(Item item) throws Exception;
}
