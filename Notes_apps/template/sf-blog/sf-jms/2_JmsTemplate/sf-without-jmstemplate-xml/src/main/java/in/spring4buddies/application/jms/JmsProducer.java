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
public class JmsProducer {

	public void produce(int count) throws Exception {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = connectionFactory.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		try {
			// Producer
			Queue queue = session.createQueue("CUSTOMER_QUEUE");

			MessageProducer producer = session.createProducer(queue);

			String payload = "SomeTask : " + count;
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