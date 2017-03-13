package in.spring4buddies.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.spring4buddies.application.dao.TradeDaoImpl;
import in.spring4buddies.application.model.Trade;

@Service("tradeService")
public class TradeServiceImpl implements TradeService {

	@Autowired
	private TradeDaoImpl tradeDao;

	public void setTradeDao(TradeDaoImpl tradeDao) {
		this.tradeDao = tradeDao;
	}

	@Override
	public Trade getTradeByType(String tradeType) {
		System.out.println("TradeService : getTradeByType() : invoked");
		return tradeDao.getTradeByType(tradeType);
	}

	@Override
	public void addTrade(Trade trade) {
		System.out.println("TradeService : addTrade() : invoked");
		tradeDao.addTrade(trade);
	}

	@Override
	public Trade updateTrade(Trade trade, String tradeType) {
		System.out.println("TradeService : updateTrade() : invoked");
		return tradeDao.updateTrade(trade, tradeType);
	}

	@Override
	public void deleteTrade(String tradeType) {
		System.out.println("TradeService : deleteTrade() : invoked");
		tradeDao.deleteTrade(tradeType);
	}
}
