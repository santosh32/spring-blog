package in.spring4buddies.application;

import in.spring4buddies.application.dao.PhotoDao;
import in.spring4buddies.application.model.Photo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String args[]) throws Exception {

		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		PhotoDao photoDao = (PhotoDao) context.getBean("photoDao");

		Photo photo = photoDao.getById(1);
		System.out.println(photo);

		context.close();
	}
}
