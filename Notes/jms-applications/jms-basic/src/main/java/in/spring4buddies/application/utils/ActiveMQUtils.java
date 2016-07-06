package in.spring4buddies.application.utils;

import in.spring4buddies.application.listener.GenericMessageListener;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQUtils {

	private final static ActiveMQConnectionFactory ACTIVE_MQ_CONNECTION_FACTORY = new ActiveMQConnectionFactory(
			"tcp://localhost:61616");

	public static Connection connection() throws JMSException {
		return ACTIVE_MQ_CONNECTION_FACTORY.createConnection();
	}

	public static MessageConsumer createConsumer(String queue) throws JMSException {

		Connection connection = ACTIVE_MQ_CONNECTION_FACTORY.createConnection();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createQueue(queue);

		MessageConsumer consumer = session.createConsumer(destination);

		consumer.setMessageListener(new GenericMessageListener());

		connection.start();

		return consumer;
	}
	
	public static MessageConsumer createSynchronouConsumer(String queue) throws JMSException {

		Connection connection = ACTIVE_MQ_CONNECTION_FACTORY.createConnection();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createQueue(queue);

		MessageConsumer consumer = session.createConsumer(destination);

		connection.start();

		return consumer;
	}

	public void createProducer(String queue) {

	}
}