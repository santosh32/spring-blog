package in.spring4buddies.application.listener;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class GenericMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		if (message instanceof MapMessage) {
			System.out.println("message - " + message);
		} else if (message instanceof TextMessage) {
			System.out.println("message - " + message);
		} else {
			System.out.println("Invalid Message Received");
		}
	}
}