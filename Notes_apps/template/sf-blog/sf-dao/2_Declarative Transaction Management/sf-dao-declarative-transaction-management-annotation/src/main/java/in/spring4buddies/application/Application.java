package in.spring4buddies.application;

import in.spring4buddies.application.model.Item;
import in.spring4buddies.application.service.ItemService;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {
		String confFile = "beans-hsql.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		ItemService itemService = context.getBean(ItemService.class);

		System.out.println(" *****  Insert new item ******");
		int itemId = RandomUtils.nextInt(1, 100);
		Item item = new Item();
		item.setItemId(itemId);
		item.setItemName("T-shirts");
		item.setItemDesc("Mens T-shirts");
		item.setItemPrice(1000);
		itemService.addItem(item);

		System.out.println(" *****  Select items ******");
		List<Item> items = itemService.getItems();
		for (Item item1 : items) {
			System.out.println(item1.getItemId() + " | " + item1.getItemName() + " | " + item1.getItemDesc() + " | " + item1.getItemPrice());
		}

		item.setItemPrice(2000);
		itemService.updateItem(item);

		System.out.println(" *****  Select items  ******");
		items = itemService.getItems();
		for (Item item1 : items) {
			System.out.println(item1.getItemId() + " | " + item1.getItemName() + " | " + item1.getItemDesc() + " | " + item1.getItemPrice());
		}

		try {
			itemService.deleteItem(item);
		} catch (Exception e) {
			System.out.println("Error Occred while deletion");
		}

		System.out.println(" *****  Select items  ******");
		items = itemService.getItems();
		for (Item item1 : items) {
			System.out.println(item1.getItemId() + " | " + item1.getItemName() + " | " + item1.getItemDesc() + " | " + item1.getItemPrice());
		}

		context.close();
	}
}
