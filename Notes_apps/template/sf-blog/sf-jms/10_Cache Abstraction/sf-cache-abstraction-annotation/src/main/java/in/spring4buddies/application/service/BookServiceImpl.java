package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl implements BookService {

	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

	@Override
	@Cacheable("getBookByIsbn")
	public Book getBookByIsbn(String isbn, String name) {
		slowLookupOperation();
		logger.info("in getBookByIsbn({},{})", isbn, name);
		return new Book(isbn, name);
	}

	public void slowLookupOperation() {
		try {
			long time = 5000L;
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

	@CacheEvict(value = "getBookByIsbn", allEntries = true)
	// @Caching (evict = { @CacheEvict(value= "books", allEntries=true) })
	public void refreshAllBooks() {
		// This method will remove all 'products' from cache, say as a result of
		// flush API call.
		logger.info("in refreshAllBooks()");
	}

}