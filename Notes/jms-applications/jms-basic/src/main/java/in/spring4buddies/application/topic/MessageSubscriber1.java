package in.spring4buddies.application.topic;

import in.spring4buddies.application.listener.GenericMessageListener;
import in.spring4buddies.application.utils.ActiveMQUtils;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;

public class MessageSubscriber1 {

	public static void receiver() throws JMSException {

		Connection connection = ActiveMQUtils.connection();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Topic destination = session.createTopic("test.message.topic");

		MessageConsumer consumer = session.createDurableSubscriber(destination,"sub-1");

		consumer.setMessageListener(new GenericMessageListener());

		connection.start();
	}
}