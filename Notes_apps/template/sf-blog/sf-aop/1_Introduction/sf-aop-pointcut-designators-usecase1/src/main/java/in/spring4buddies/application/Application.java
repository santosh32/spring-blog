package in.spring4buddies.application;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.spring4buddies.application.model.Trade;
import in.spring4buddies.application.service.TradeService;

public class Application {

	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		TradeService tradeService = (TradeService) context.getBean("tradeService");

		System.out.println("*******************************************");

		Trade trade = new Trade("Pharma-SELL", "ÜSD", "EURO");
		tradeService.addTrade(trade);

		System.out.println(tradeService.getTradeByType("Pharma-SELL"));

		System.out.println("*******************************************");
		context.close();
	}
}
