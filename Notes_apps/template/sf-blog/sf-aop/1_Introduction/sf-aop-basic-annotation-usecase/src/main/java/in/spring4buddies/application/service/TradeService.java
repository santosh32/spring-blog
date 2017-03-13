package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Trade;

public interface TradeService {

	Trade getTradeByType(String tradeType);

	void addTrade(Trade trade);

	Trade updateTrade(Trade trade, String tradeType);

	void deleteTrade(String tradeType) throws Exception;

}
