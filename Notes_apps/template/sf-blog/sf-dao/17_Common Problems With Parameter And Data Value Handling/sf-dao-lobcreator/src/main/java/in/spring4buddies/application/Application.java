package in.spring4buddies.application;

import in.spring4buddies.application.dao.PhotoDao;
import in.spring4buddies.application.model.Photo;

import java.io.File;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String args[]) throws Exception {

		String confFile = "beans.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		PhotoDao photoDao = (PhotoDao) context.getBean("photoDao");

		Photo photo = new Photo();
		photo.setPhotoId(RandomUtils.nextLong(1, 100));
		photo.setClobImage(new File(
				"D:/poc/spring-blog/Notes_apps/template/sf-blog/sf-dao/17_Common Problems With Parameter And Data Value Handling/sf-dao-lobcreator/src/main/resources/images/clobImage.jpg"));
		photo.setBlogImage(new File(
				"D:/poc/spring-blog/Notes_apps/template/sf-blog/sf-dao/17_Common Problems With Parameter And Data Value Handling/sf-dao-lobcreator/src/main/resources/images/blobImage.jpg"));
		photoDao.addPhoto(photo);

		context.close();
	}
}
