package in.spring4buddies.application.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RequestHeaderController {

	@RequestMapping(value = "/singleHeader")
	public String singleRequestHeader(@RequestHeader(value = "Accept-Encoding", defaultValue = "en-US") String encoding, Model model) {
		model.addAttribute("message", "Accept-Encoding : " + encoding);
		return "displayRequestHeader";
	}

	@RequestMapping(value = "/multipleHeader")
	public String multipleRequestHeader(@RequestHeader("Accept-Encoding") String encoding, @RequestHeader("Accept-Language") String language,
			Model model) {
		model.addAttribute("message", "Accept-Encoding : " + encoding + "<br> Accept-Language : " + language);
		return "displayRequestHeader";
	}

	@RequestMapping(value = "/mapHeader")
	public String mapRequestHeader(@RequestHeader Map<String, String> mapHeaders, Model model) {

		StringBuffer buffer = new StringBuffer();
		for (Map.Entry<String, String> entry : mapHeaders.entrySet()) {
			buffer.append((entry.getKey() + "  : " + entry.getValue() + "<br>"));
		}
		model.addAttribute("message", buffer.toString());

		return "displayRequestHeader";
	}

	@RequestMapping("httpHeaders")
	public String handleRequestWithAllHeaders2(@RequestHeader HttpHeaders httpHeaders, Model model) {
		model.addAttribute("message", httpHeaders);
		return "displayRequestHeader";
	}

	@RequestMapping(headers = { "User-Agent", "Accept-Language" })
	public String handleRequestByTwoHeaders(@RequestHeader("User-Agent") String userAgent, @RequestHeader("Accept-Language") String acceptLanguage,
			Model map) {
		String message = "User-Agent and Accept headers : " + userAgent + ", " + acceptLanguage;
		map.addAttribute("message", message);
		return "displayRequestHeader";
	}

	@RequestMapping(value = "{empId}")
	public String handleRequestById(@PathVariable("empId") String tradeId, @RequestHeader("If-Modified-Since") Date date, Model model) {
		String message = "empId and If-Modified-Since header : " + tradeId + ", " + date;
		model.addAttribute("message", message);
		return "displayRequestHeader";
	}
}