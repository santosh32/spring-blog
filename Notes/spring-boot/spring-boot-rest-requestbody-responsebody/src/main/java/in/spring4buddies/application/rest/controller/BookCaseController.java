package in.spring4buddies.application.rest.controller;

import in.spring4buddies.application.rest.model.BookCase;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/bookcase")
public class BookCaseController {

	private BookCase bookCase;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public BookCase getBookCase() {
		return this.bookCase;
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void setBookCase(@RequestBody BookCase bookCase) {
		this.bookCase = bookCase;
	}
}