package in.spring4buddies.application.dao;

import org.springframework.stereotype.Repository;

import in.spring4buddies.application.model.Trade;

@Repository("tradeDao")
public class TradeDaoImpl {

	public Trade getTradeByType(String tradeType) {
		System.out.println("TradeDao : getTradeByType() : called");
		return new Trade("Pharma-SELL", "ÜSD", "EURO");
	}

	public void addTrade(Trade trade) {
		System.out.println("TradeDao : addTrade() : called");
	}

	public Trade updateTrade(Trade trade, String tradeType) {
		System.out.println("TradeDao : updateTrade() : called");
		return trade;
	}

	public void deleteTrade(String tradeType) {
		System.out.println("TradeDao : deleteTrade() : called");
	}
}
