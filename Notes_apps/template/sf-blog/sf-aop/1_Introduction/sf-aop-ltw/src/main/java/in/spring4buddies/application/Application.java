package in.spring4buddies.application;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.spring4buddies.application.model.Trade;
import in.spring4buddies.application.service.TradeService;

public class Application {

	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");

		TradeService tradeService = (TradeService) context.getBean("tradeService");

		Trade trade = new Trade("Chemical", "ÜSD", "EURO");
		System.out.println("======================");
		tradeService.addTrade(trade);
		System.out.println("======================");

		// System.out.println("==> " + tradeService.getTradeByType("Chemical"));

		context.close();
	}
}
