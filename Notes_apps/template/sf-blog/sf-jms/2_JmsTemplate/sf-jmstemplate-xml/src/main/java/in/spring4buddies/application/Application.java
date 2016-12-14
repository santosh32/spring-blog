package in.spring4buddies.application;

import in.spring4buddies.application.jms.JmsConsumer;
import in.spring4buddies.application.jms.JmsProducer;

import java.net.URI;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {

		// optional and its not working, run from command prompt
		// BrokerService broker = BrokerFactory.createBroker(new
		// URI("broker:(tcp://localhost:61616)"));
		// broker.start();

		GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("classpath:beans.xml");

		JmsProducer jmsProducer = applicationContext.getBean(JmsProducer.class);
		JmsConsumer jmsConsumer = applicationContext.getBean(JmsConsumer.class);

		jmsProducer.produce();

		jmsConsumer.consumer();

		applicationContext.close();

	}
}
