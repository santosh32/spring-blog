package in.spring4buddies.application;

import in.spring4buddies.application.model.Item;
import in.spring4buddies.application.service.ItemService;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {
		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		ItemService itemService = (ItemService) context.getBean("itemService");

		System.out.println(" *****  Insert new item ******");
		int itemId = RandomUtils.nextInt(1, 100);
		Item item = new Item();
		item.setItemId(itemId);
		item.setItemName("T-shirts");
		item.setItemDesc("Mens T-shirts");
		item.setItemPrice(1000);
		itemService.addItem(item);

		System.out.println(" *****  Select item by id ******");
		List<Item> items = itemService.getItems();
		for (Item item1 : items) {
			System.out.println(item1.getItemId() + " | " + item1.getItemName() + " | " + item1.getItemDesc() + " | " + item1.getItemPrice());
		}

		context.close();
	}
}
