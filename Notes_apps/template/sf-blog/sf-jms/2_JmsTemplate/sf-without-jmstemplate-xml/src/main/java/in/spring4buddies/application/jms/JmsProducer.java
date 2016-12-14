package in.spring4buddies.application.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Component;

@Component
public class JmsProducer extends JmsHelper {

	public void produce() throws Exception {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(getBrokerUrl());
		Connection connection = connectionFactory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		try {
			// Producer
			Queue queue = session.createQueue(getCustomerQueue());

			MessageProducer producer = session.createProducer(queue);

			String payload = "SomeTask  ";
			Message msg = session.createTextMessage(payload);

			System.out.println("Sending text '" + payload + "'");

			producer.send(msg);
		} finally {
			if (session != null) {
				session.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}
}