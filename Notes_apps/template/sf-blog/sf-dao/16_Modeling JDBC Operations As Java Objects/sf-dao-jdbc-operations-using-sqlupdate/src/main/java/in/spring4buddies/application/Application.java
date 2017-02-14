package in.spring4buddies.application;

import in.spring4buddies.application.dao.BookDao;
import in.spring4buddies.application.dao.BookDaoImpl;
import in.spring4buddies.application.model.Book;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String args[]) {

		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		BookDao bookDao = (BookDaoImpl) context.getBean("bookDao");

		int bookId = RandomUtils.nextInt(10, 100);
		Book book = new Book();
		bookDao.update(book);

		context.close();
	}
}
