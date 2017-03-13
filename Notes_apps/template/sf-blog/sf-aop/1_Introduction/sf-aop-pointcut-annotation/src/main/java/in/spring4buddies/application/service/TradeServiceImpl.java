package in.spring4buddies.application.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import in.spring4buddies.application.model.Trade;

@Service("tradeService")
public class TradeServiceImpl {

	private static Map<String, Trade> tradeMap = new ConcurrentHashMap<>();

	public Trade getTradeByType(String tradeType) {
		System.out.println("TradeService : getTradeByType() : invoked");
		return tradeMap.get(tradeType);
	}

	public void addTrade(Trade trade) {
		System.out.println("TradeService : addTrade() : invoked");
		tradeMap.put(trade.getTradeType(), trade);
	}

	public Trade updateTrade(Trade trade, String tradeType) {
		System.out.println("TradeService : updateTrade() : invoked");
		// TODO consider this as update
		tradeMap.put(tradeType, trade);
		return trade;
	}

	public void deleteTrade(String tradeType) {
		System.out.println("TradeService : deleteTrade() : invoked");
		tradeMap.remove(tradeType);
	}
}
