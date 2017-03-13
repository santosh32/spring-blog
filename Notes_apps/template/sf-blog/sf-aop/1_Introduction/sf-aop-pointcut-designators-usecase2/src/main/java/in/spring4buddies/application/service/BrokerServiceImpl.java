package in.spring4buddies.application.service;

import org.springframework.stereotype.Service;

import in.spring4buddies.application.model.Broker;

@Service("brokerService")
public class BrokerServiceImpl implements BrokerService {

	@Override
	public Broker getBrokerByName(String name) {
		System.out.println("BrokerService : getBrokerByName() : invoked");
		return new Broker();
	}

	@Override
	public void addBroker(Broker broker) {
		System.out.println("BrokerService : addBroker() : invoked");
	}

	@Override
	public Broker updateBroker(Broker broker, String name) {
		System.out.println("BrokerService : updateBroker() : invoked");
		return broker;
	}

	@Override
	public void deleteBroker(String name) {
		System.out.println("BrokerService : deleteBroker() : invoked");
	}
}
