package in.spring4buddies.application.rest;

import in.spring4buddies.application.rest.model.Book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestClientApplication {
	
	private static String URI = "http://localhost:8080/book";

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(
				RestClientApplication.class, args);
		
		RestTemplate restTemplate = new RestTemplate();
		Book book = restTemplate.getForObject(URI, Book.class, "1000");
	}

}
