package in.spring4buddies.application.topic;

import in.spring4buddies.application.listener.GenericMessageListener;
import in.spring4buddies.application.utils.ActiveMQUtils;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

public class MessageSubscriber {

	public static void receiver() throws JMSException {

		Connection connection = ActiveMQUtils.connection();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Topic destination = session.createTopic("test.message.topic");

		TopicSubscriber topicSubscriber = session.createDurableSubscriber(destination,"sub-0");

		topicSubscriber.setMessageListener(new GenericMessageListener());

		connection.start();
	}
}