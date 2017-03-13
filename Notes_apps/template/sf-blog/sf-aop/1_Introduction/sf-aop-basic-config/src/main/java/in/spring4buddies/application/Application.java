package in.spring4buddies.application;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.spring4buddies.application.model.Trade;
import in.spring4buddies.application.service.TradeService;

public class Application {

	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		TradeService tradeService = (TradeService) context.getBean("tradeService");

		String tradeType = "Pharma-SELL";

		System.out.println("---------------addTrade-------------------");
		Trade trade = new Trade(tradeType, "ÜSD", "EURO");
		tradeService.addTrade(trade);

		System.out.println("-----------------getTradeByType-----------------");
		System.out.println("==> " + tradeService.getTradeByType(tradeType));

		System.out.println("---------------updateTrade-------------------");
		tradeType = "Pharma-BUY";
		tradeService.updateTrade(trade, tradeType);

		System.out.println("---------------getTradeByType-------------------");
		System.out.println("==> " + tradeService.getTradeByType(tradeType));

		System.out.println("---------------deleteTrade-------------------");
		try {
			tradeService.deleteTrade(tradeType);
		} catch (Exception e) {
			System.out.println("<==> After throwing Exception handled here <==> ");
		}

		System.out.println("------------------getTradeByType----------------");
		System.out.println("==> " + tradeService.getTradeByType(tradeType));
		System.out.println("----------------------------------");
		context.close();
	}
}
