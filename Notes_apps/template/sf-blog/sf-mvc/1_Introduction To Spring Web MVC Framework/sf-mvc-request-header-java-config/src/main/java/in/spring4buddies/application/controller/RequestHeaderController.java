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
	public String singleRequestHeader(@RequestHeader(value = "Accept-Encoding", defaultValue = "en-US") String encoding) {

		System.out.println("**************************");
		System.out.println("Single Request Header Test");
		System.out.println("Accept-Encoding :: " + encoding);
		System.out.println("**************************");

		return "success";
	}

	@RequestMapping(value = "/multipleHeader")
	public String multipleRequestHeader(@RequestHeader("Accept-Encoding") String encoding, @RequestHeader("Accept-Language") String language) {

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

	@RequestMapping(headers = "User-Agent")
	public String handleAllTradesRequests(@RequestHeader("User-Agent") String userAgent, Model model) {
		model.addAttribute("message", "all trades requests, User-Agent header  : " + userAgent);
		return "displayRequestHeader";
	}

	@RequestMapping(headers = "From")
	public String handleRequestByFromHeader(@RequestHeader String From, Model model) {
		model.addAttribute("message", "trade request by From header  : " + From);
		return "displayRequestHeader";
	}

	@RequestMapping
	public String handleRequestWithAllHeaders(@RequestHeader Map<String, String> header, Model model) {
		String message = "Trade request with all headers : " + header;
		model.addAttribute("message", message);
		return "displayRequestHeader";
	}

	@RequestMapping("tradeCurrencies")
	public String handleRequestWithAllHeaders2(@RequestHeader HttpHeaders httpHeaders, Model model) {
		String message = "Trade request with all headers : " + httpHeaders;
		model.addAttribute("message", message);
		return "displayRequestHeader";
	}

	@RequestMapping(headers = { "User-Agent", "Accept-Language" })
	public String handleRequestByTwoHeaders(@RequestHeader("User-Agent") String userAgent, @RequestHeader("Accept-Language") String acceptLanguage,
			Model map) {
		String message = "Trade request by User-Agent and Accept headers : " + userAgent + ", " + acceptLanguage;
		map.addAttribute("message", message);
		return "displayRequestHeader";
	}

	@RequestMapping(value = "{tradeId}")
	public String handleRequestById(@PathVariable("tradeId") String tradeId, @RequestHeader("If-Modified-Since") Date date, Model model) {
		String message = "Trade request by trade id and If-Modified-Since header : " + tradeId + ", " + date;
		model.addAttribute("message", message);
		return "displayRequestHeader";
	}

	@RequestMapping(value = "exchangeRates")
	public String handleExchangeRatesRequest(@RequestHeader(value = "Accept", required = false) String acceptHeader, Model model) {

		String message = "exchange rates request.  Accept header: " + acceptHeader;
		model.addAttribute("message", message);
		return "displayRequestHeader";
	}
}