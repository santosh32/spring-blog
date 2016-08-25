package in.spring4buddies.application.rest.controller;

import in.spring4buddies.application.rest.model.Book;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/book")
public class BookController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Book getBookById(@PathVariable String id) {

		for (Book book : books) {
			if (id.equals(book.getId())) {
				return book;
			}
		}
		return null;
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ResponseBody
	public List<Book> updateBook(@RequestBody Book book) {

		for (Book bk : books) {
			if (book.getId().equals(bk.getId())) {
				books.remove(bk);
				books.add(book);
				return books;
			}
		}

		return books;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public List<Book> insertBook(@RequestBody Book book) {
		books.add(book);
		return books;
	}

	@RequestMapping(method = RequestMethod.DELETE, consumes = "application/json")
	@ResponseBody
	public List<Book> deleteBook(@RequestBody Book book) {

		for (Book bk : books) {
			if (book.getId().equals(bk.getId())) {
				books.remove(bk);
				return books;
			}
		}

		return books;
	}

	private static CopyOnWriteArrayList<Book> books = new CopyOnWriteArrayList<Book>();

	static {
		
		Book book = new Book();
		book.setId("1000");
		book.setIsbn("isbn-1000");
		book.setTitle("Spring Framework");
		books.add(book);
		
		Book book2 = new Book();
		book2.setId("2000");
		book2.setIsbn("isbn-2000");
		book2.setTitle("Spring MVC");
		books.add(book2);

		Book book3 = new Book();
		book3.setId("3000");
		book3.setIsbn("isbn-3000");
		book3.setTitle("Spring ORM");
		books.add(book3);

		Book book4 = new Book();
		book4.setId("4000");
		book4.setIsbn("isbn-4000");
		book4.setTitle("Spring JDBC");
		books.add(book4);

		Book book5 = new Book();
		book5.setId("5000");
		book5.setIsbn("isbn-5000");
		book5.setTitle("Spring JMS");
		books.add(book5);

		Book book6 = new Book();
		book6.setId("6000");
		book6.setIsbn("isbn-6000");
		book6.setTitle("Spring Rest");
		books.add(book6);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Book> getAllBooks() {
		return books;
	}
}