package in.spring4buddies.application.queue.asynchronous;

import in.spring4buddies.application.listener.GenericMessageListener;
import in.spring4buddies.application.utils.ActiveMQUtils;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

public class MessageReceiver {

	public static void main(String[] args) throws JMSException {

		Connection connection = ActiveMQUtils.connection();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination destination = session.createQueue("test.message.queue");

		MessageConsumer consumer = session.createConsumer(destination);

		consumer.setMessageListener(new GenericMessageListener());

		connection.start();
	}
}