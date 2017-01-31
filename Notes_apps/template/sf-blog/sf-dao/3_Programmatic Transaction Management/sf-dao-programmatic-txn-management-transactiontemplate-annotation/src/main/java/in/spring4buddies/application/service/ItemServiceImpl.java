package in.spring4buddies.application.service;

import in.spring4buddies.application.dao.ItemDao;
import in.spring4buddies.application.model.Item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class ItemServiceImpl implements ItemService {
	@Autowired
	ItemDao itemDao;

	@Override
	public List<Item> getItems() {
		return itemDao.getItems();
	}

	@Override
	public void addItem(Item item) {
		itemDao.addItem(item);
	}

	@Override
	public void updateItem(Item item) {
		itemDao.updateItem(item);
	}

	@Override
	public void deleteItem(Item item) throws Exception {
		itemDao.deleteItem(item);
	}
}