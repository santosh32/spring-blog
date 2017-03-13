package in.spring4buddies.application.service;

import in.spring4buddies.application.model.Broker;

public interface BrokerService {

	Broker getBrokerByName(String name);

	void addBroker(Broker broker);

	Broker updateBroker(Broker broker, String name);

	void deleteBroker(String name);

}
