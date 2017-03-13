package in.spring4buddies.application;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.spring4buddies.application.model.Trade;
import in.spring4buddies.application.service.TradeServiceImpl;

public class Application {

	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		TradeServiceImpl tradeService = (TradeServiceImpl) context.getBean("tradeService");

		Trade trade = new Trade("Pharma-SELL", "ÜSD", "EURO");
		tradeService.addTrade(trade);

		System.out.println(tradeService.getTradeByType("Pharma-SELL"));

		context.close();
	}
}
