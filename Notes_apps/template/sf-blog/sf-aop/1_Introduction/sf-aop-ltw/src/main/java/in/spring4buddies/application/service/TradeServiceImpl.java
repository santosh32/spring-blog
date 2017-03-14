package in.spring4buddies.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import in.spring4buddies.application.model.Trade;

@Service("tradeService")
public class TradeServiceImpl implements TradeService {

	private static Logger logger = LoggerFactory.getLogger(TradeServiceImpl.class);

	@Override
	public Trade getTradeByType(String tradeType) {
		logger.info("TradeService : getTradeByType() : invoked");
		return new Trade("Chemical", "ÜSD", "EURO");
	}

	@Override
	public void addTrade(Trade trade) {
		logger.info("TradeService : addTrade() : invoked");
	}

	@Override
	public Trade updateTrade(Trade trade, String tradeType) {
		logger.info("TradeService : updateTrade() : invoked");
		return trade;
	}

	@Override
	public void deleteTrade(String tradeType) {
		logger.info("TradeService : deleteTrade() : invoked");
	}
}
