package in.spring4buddies.application.rest.model;

import java.util.ArrayList;
import java.util.Collection;

public class BookCase extends ArrayList<Book> {

	public BookCase() {
	}

	public BookCase(Collection<? extends Book> c) {
		super(c);
	}
}