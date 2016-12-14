package in.spring4buddies.application;

import in.spring4buddies.application.jms.JmsConsumer;
import in.spring4buddies.application.jms.JmsProducer;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {

		GenericXmlApplicationContext applicationContext = new GenericXmlApplicationContext("classpath:beans.xml");

		JmsProducer jmsProducer = applicationContext.getBean(JmsProducer.class);
		JmsConsumer jmsConsumer = applicationContext.getBean(JmsConsumer.class);

		jmsProducer.produce();

		jmsConsumer.consumer();

		applicationContext.close();

	}
}
