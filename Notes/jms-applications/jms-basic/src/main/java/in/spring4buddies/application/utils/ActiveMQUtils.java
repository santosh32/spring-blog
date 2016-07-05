package in.spring4buddies.application.utils;

import javax.jms.Connection;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQUtils {

	private final static ActiveMQConnectionFactory ACTIVE_MQ_CONNECTION_FACTORY = new ActiveMQConnectionFactory(
			"tcp://localhost:61616");

	public static Connection connection() throws JMSException {
		return ACTIVE_MQ_CONNECTION_FACTORY.createConnection();
	}
}