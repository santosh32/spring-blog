package in.spring4buddies.application;

import in.spring4buddies.application.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleApplication {

	private static final Logger logger = LoggerFactory.getLogger(SimpleApplication.class);

	public static void main(String[] args) {

		GenericXmlApplicationContext context = new GenericXmlApplicationContext("beans.xml");

		BookService service = context.getBean(BookService.class);

		logger.info("Book ->" + service.getBookByIsbn("isbn-100", "Spring Framework"));
		logger.info("Book ->" + service.getBookByIsbn("isbn-200", "Spring Boot"));
		logger.info("Book ->" + service.getBookByIsbn("isbn-300", "Spring MVC"));

		logger.info("Book ->" + service.getBookByIsbn("isbn-100", "Spring Framework"));
		logger.info("Book ->" + service.getBookByIsbn("isbn-200", "Spring Boot"));
		logger.info("Book ->" + service.getBookByIsbn("isbn-100", "Spring Framework"));
		logger.info("Book ->" + service.getBookByIsbn("isbn-300", "Spring MVC"));

		logger.info("Refreshing all Books");
		service.refreshAllBooks();

		logger.info("Book [after refresh]->" + service.getBookByIsbn("isbn-100", "Spring Framework"));
		logger.info("Book [after refresh]->" + service.getBookByIsbn("isbn-200", "Spring Boot"));
		logger.info("Book [after refresh]->" + service.getBookByIsbn("isbn-300", "Spring MVC"));

		logger.info("Book [after refresh]->" + service.getBookByIsbn("isbn-100", "Spring Framework"));
		logger.info("Book [after refresh]->" + service.getBookByIsbn("isbn-200", "Spring Boot"));
		logger.info("Book [after refresh]->" + service.getBookByIsbn("isbn-100", "Spring Framework"));
		logger.info("Book [after refresh]->" + service.getBookByIsbn("isbn-300", "Spring MVC"));

		context.close();
	}
}