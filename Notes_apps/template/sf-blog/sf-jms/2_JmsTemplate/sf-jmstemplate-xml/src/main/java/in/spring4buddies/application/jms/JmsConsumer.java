package in.spring4buddies.application.jms;

import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;

public class JmsConsumer {

	private JmsTemplate jmsTemplate;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void consumer() throws Exception {

		TextMessage message = (TextMessage) jmsTemplate.receive();

		System.out.println("Received: " + message.getText());
	}
}