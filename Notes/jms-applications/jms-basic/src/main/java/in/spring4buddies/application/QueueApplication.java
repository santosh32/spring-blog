package in.spring4buddies.application;

import in.spring4buddies.application.queue.MessageReceiver;
import in.spring4buddies.application.queue.MessageReceiver1;
import in.spring4buddies.application.queue.MessageReceiver2;
import in.spring4buddies.application.queue.MessageSender;

import javax.jms.JMSException;

public class QueueApplication {

	public static void main(String... arg) throws JMSException {
		MessageReceiver.receiver();
		MessageReceiver1.receiver();
		MessageReceiver2.receiver();
		for (int i = 0; i < 10; i++) {
			MessageSender.send();
		}
	}
}
