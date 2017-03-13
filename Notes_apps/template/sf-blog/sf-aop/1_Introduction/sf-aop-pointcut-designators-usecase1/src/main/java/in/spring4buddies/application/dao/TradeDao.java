package in.spring4buddies.application.dao;

import in.spring4buddies.application.model.Trade;

public interface TradeDao {

	Trade getTradeByType(String tradeType);

	void addTrade(Trade trade);

	Trade updateTrade(Trade trade, String tradeType);

	void deleteTrade(String tradeType);

}
