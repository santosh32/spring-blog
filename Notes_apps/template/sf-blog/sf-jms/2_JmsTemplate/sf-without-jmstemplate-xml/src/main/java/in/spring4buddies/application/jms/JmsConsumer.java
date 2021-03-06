package in.spring4buddies.application.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer extends JmsHelper {

	public void consumer() throws Exception {

		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(getBrokerUrl());
		Connection connection = connectionFactory.createConnection();
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		try {
			Queue queue = session.createQueue(getCustomerQueue());

			// Consumer
			MessageConsumer consumer = session.createConsumer(queue);

			TextMessage textMsg = (TextMessage) consumer.receive();

			System.out.println(textMsg);
			System.out.println("Received: " + textMsg.getText());
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