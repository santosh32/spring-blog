package in.spring4buddies.application.jms;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;

public class JmsConsumer {

	private JmsTemplate jmsTemplate;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void consumer() {

		Message message = (Message) jmsTemplate.receive();

		System.out.println("Received: " + message.getPayload());
	}
}