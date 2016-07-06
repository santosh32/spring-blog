package in.spring4buddies.application.queue.synchronous;

import in.spring4buddies.application.utils.ActiveMQUtils;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.TextMessage;

public class MessageReceiver {

	public static void main(String[] args) throws JMSException {

		MessageConsumer consumer = ActiveMQUtils.createSynchronouConsumer("test.message.queue");

		TextMessage message = (TextMessage) consumer.receive();
		
		System.out.println("message received is = " + message.getText());
	}
}