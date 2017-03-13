package in.spring4buddies.application.service;

import org.springframework.stereotype.Service;

import in.spring4buddies.application.model.Trade;

@Service("tradeService")
public class TradeServiceImpl implements TradeService {

	@Override
	public Trade getTradeByType(String tradeType) {
		System.out.println("TradeService : getTradeByType() : invoked");
		return new Trade();
	}

	@Override
	public void addTrade(Trade trade) {
		System.out.println("TradeService : addTrade() : invoked");
	}

	@Override
	public Trade updateTrade(Trade trade, String tradeType) {
		System.out.println("TradeService : updateTrade() : invoked");
		return trade;
	}

	@Override
	public void deleteTrade(String tradeType) {
		System.out.println("TradeService : deleteTrade() : invoked");
	}
}
