package in.spring4buddies.application;

import in.spring4buddies.application.topic.MessagePublisher;
import in.spring4buddies.application.topic.MessageSubscriber;
import in.spring4buddies.application.topic.MessageSubscriber1;
import in.spring4buddies.application.topic.MessageSubscriber2;

import javax.jms.JMSException;

public class TopicApplication {

	public static void main(String... arg) throws JMSException {
		MessageSubscriber.receiver();
		MessageSubscriber1.receiver();
		MessageSubscriber2.receiver();
		for (int i = 0; i < 3; i++) {
			MessagePublisher.send();
		}
	}
}
