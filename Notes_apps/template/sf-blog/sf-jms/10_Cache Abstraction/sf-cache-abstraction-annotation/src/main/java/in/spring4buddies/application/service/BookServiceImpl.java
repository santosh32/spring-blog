package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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

	@Override
	@Cacheable(cacheNames = "getBookByCacheKeyIsbn", key = "#isbn")
	public Book getBookByCacheKeyIsbn(String isbn, String name) {
		slowLookupOperation();
		logger.info("in getBookByCacheKeyIsbn({},{})", isbn, name);
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

	@Override
	// @CacheEvict(value = "getBookByIsbn", allEntries = true)
	@Caching(evict = { @CacheEvict(value = "getBookByIsbn", allEntries = true),
			@CacheEvict(cacheNames = "getBookByCacheKeyIsbn", key = "#isbn", allEntries = true) })
	public void refreshAllBooks() {
		// This method will remove all 'books' from cache, say as a result of
		// flush API call.
		logger.info("in refreshAllBooks()");
	}

	@Override
	@CachePut(cacheNames = "getBookByCacheKeyIsbn", key = "#isbn")
	public Book updateBook(String isbn, String name) {
		logger.info("in updateBook({},{})", isbn, name);
		return new Book(isbn, name);
	}

}