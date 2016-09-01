package in.spring4buddies.application.rest;

import in.spring4buddies.application.rest.model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

//@SpringBootApplication
public class RestClientApplication {

	private static String URI = "http://localhost:8080/book";

	public static void main(String[] args) throws Exception {

		RestTemplate restTemplate = new RestTemplate();
	    restTemplate.setMessageConverters(getMessageConverters());
	 
	    /****************** GET functionality **********************/
//		use_getForObject(restTemplate);
//		use_exchangeForGet(restTemplate);
//	    use_getForEntity(restTemplate);
	    
	    
	    /****************** POST functionality **********************/
//		use_postForObject(restTemplate);
//		use_exchangeForGet(restTemplate);
//	    use_getForEntity(restTemplate);
		
		
	    /****************** PUT functionality **********************/
//		use_put(restTemplate);
//		use_exchangeForGet(restTemplate);
//	    use_getForEntity(restTemplate);
		
	    /****************** DELETE functionality **********************/
		use_delete(restTemplate);
//		use_exchangeForGet(restTemplate);
//	    use_getForEntity(restTemplate);
	}

	private static void use_getForObject(RestTemplate restTemplate) throws JsonProcessingException {
		
		Book[] books = restTemplate.getForObject(URI, Book[].class);
		printObjectAsJson(books);;

		Book book = restTemplate.getForObject(URI + "/{id}", Book.class,"1000");
		printObjectAsJson(book);
		
		MultiValueMap<String,String> requestParamMap = new LinkedMultiValueMap<>();
		requestParamMap.add("isbn", "isbn-1000");
		
		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(URI+"/1000").queryParams(requestParamMap).build();
		System.out.println(uriComponents.toUri());
		
		Book bookByReuestParam = restTemplate.getForObject(uriComponents.toString(), Book.class);
		printObjectAsJson(bookByReuestParam);	
		}
	
	private static void use_getForEntity(RestTemplate restTemplate) throws JsonProcessingException {

		ResponseEntity<Book[]> response = restTemplate.getForEntity(URI, Book[].class);
		Book[] books = response.getBody();
		printObjectAsJson(books);

		MultiValueMap<String, String> requestParamMap = new LinkedMultiValueMap<>();
		requestParamMap.add("isbn", "isbn-1000");

		UriComponents uriComponents = UriComponentsBuilder
				.fromHttpUrl(URI + "/1000").queryParams(requestParamMap)
				.build();
		System.out.println(uriComponents.toUri());

		ResponseEntity<Book> response1 = restTemplate.getForEntity(uriComponents.toString(), Book.class);
		Book book = response1.getBody();
		printObjectAsJson(book);
	}

	private static void use_exchangeForGet(RestTemplate restTemplate) throws JsonProcessingException {
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<String> httpEntity = new HttpEntity<String>(headers);

		ResponseEntity<Book[]> response = restTemplate.exchange(URI, HttpMethod.GET, httpEntity, Book[].class);
		Book[] books = response.getBody();
		printObjectAsJson(books);
		
		ResponseEntity<Book> response1 = restTemplate.exchange(URI + "/1000", HttpMethod.GET, httpEntity, Book.class);
		Book book = response1.getBody();
		printObjectAsJson(book);
	}

	
	private static void use_postForObject(RestTemplate restTemplate) throws Exception {

		Book book = new Book();
		book.setId("1001");
		book.setIsbn("isbn-1001");
		book.setTitle("Hibernate Framework");

		Book[] books = restTemplate.postForObject(URI, book, Book[].class);
		
		printObjectAsJson(books);

	}
	
	private static void use_put(RestTemplate restTemplate) throws Exception {

		Book[] books = restTemplate.getForObject(URI, Book[].class);
		printObjectAsJson(books);

		Book book = new Book();
		book.setId("1000");
		book.setIsbn("isbn-1000");
		book.setTitle("Spring Framework Updated");

		restTemplate.put(URI, book);
		
		books = restTemplate.getForObject(URI, Book[].class);
		printObjectAsJson(books);

	}
	
	private static void use_delete(RestTemplate restTemplate) throws Exception {

		Book[] books = restTemplate.getForObject(URI, Book[].class);
		printObjectAsJson(books);

		restTemplate.delete(URI+"/2000");
		
		books = restTemplate.getForObject(URI, Book[].class);
		printObjectAsJson(books);

	}

	private static <T> void printObjectAsJson(T t) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(t);
		System.out.println(json);
	}
	
	private static List<HttpMessageConverter<?>> getMessageConverters() {
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();

		MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		jackson2HttpMessageConverter.setPrettyPrint(true);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		jackson2HttpMessageConverter.setObjectMapper(objectMapper);
		

		converters.add(jackson2HttpMessageConverter);
		return converters;
	}
}
