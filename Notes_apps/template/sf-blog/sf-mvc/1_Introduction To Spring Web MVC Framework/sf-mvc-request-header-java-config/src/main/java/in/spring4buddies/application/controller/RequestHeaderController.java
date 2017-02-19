package in.spring4buddies.application.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestHeaderController {

	@RequestMapping(value = "/singleHeader")
	public String singleRequestHeader(@RequestHeader(value = "Accept-Encoding", defaultValue = "en-US") String encoding) {

		System.out.println("**************************");
		System.out.println("Single Request Header Test");
		System.out.println("Accept-Encoding :: " + encoding);
		System.out.println("**************************");

		return "success";
	}

	@RequestMapping(value = "/multipleHeader")
	public String multipleRequestHeader(@RequestHeader("Accept-Encoding") String encoding, 
			@RequestHeader("Accept-Language") String language) {

		System.out.println("**************************");
		System.out.println("Multiple Request Header Test");
		System.out.println("Accept-Encoding :: " + encoding);
		System.out.println("Accept-Language :: " + language);
		System.out.println("**************************");

		return "success";
	}

	@RequestMapping(value = "/mapHeader")
	public String mapRequestHeader(@RequestHeader Map<String, String> mapHeaders) {

		System.out.println("**************************");
		System.out.println("Map Request Header Test");
		for (Map.Entry<String, String> entry : mapHeaders.entrySet()) {
			System.out.println(entry.getKey() + "  : " + entry.getValue());
		}
		System.out.println("**************************");

		return "success";
	}
}