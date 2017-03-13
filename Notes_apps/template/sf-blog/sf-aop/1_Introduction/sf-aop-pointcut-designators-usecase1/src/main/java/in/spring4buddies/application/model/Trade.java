package in.spring4buddies.application.model;

public class Trade {

	private String tradeType;
	private String buyCurrency;
	private String sellCurrency;

	public Trade() {

	}

	public Trade(String tradeType, String buyCurrency, String sellCurrency) {
		super();
		this.tradeType = tradeType;
		this.buyCurrency = buyCurrency;
		this.sellCurrency = sellCurrency;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getBuyCurrency() {
		return buyCurrency;
	}

	public void setBuyCurrency(String buyCurrency) {
		this.buyCurrency = buyCurrency;
	}

	public String getSellCurrency() {
		return sellCurrency;
	}

	public void setSellCurrency(String sellCurrency) {
		this.sellCurrency = sellCurrency;
	}

	@Override
	public String toString() {
		return "Trade [tradeType=" + tradeType + ", buyCurrency=" + buyCurrency + ", sellCurrency=" + sellCurrency + "]";
	}
}
