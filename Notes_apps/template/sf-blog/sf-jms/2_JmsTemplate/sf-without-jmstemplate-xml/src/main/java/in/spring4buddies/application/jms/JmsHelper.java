package in.spring4buddies.application.jms;

import org.springframework.beans.factory.annotation.Value;

public class JmsHelper {
	
	@Value("${broker.url}")
	private String brokerUrl;
	
	@Value("${cutomer.queue}")
	private String customerQueue;
	
	public String getBrokerUrl() {
		return brokerUrl;
	}
	public void setBrokerUrl(String brokerUrl) {
		this.brokerUrl = brokerUrl;
	}
	public String getCustomerQueue() {
		return customerQueue;
	}
	public void setCustomerQueue(String customerQueue) {
		this.customerQueue = customerQueue;
	}
	
	

}
