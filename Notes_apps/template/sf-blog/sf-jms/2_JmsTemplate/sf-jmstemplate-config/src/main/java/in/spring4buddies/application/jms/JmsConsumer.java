package in.spring4buddies.application.jms;

import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsConsumer {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void consumer() throws Exception {

		TextMessage message = (TextMessage) jmsTemplate.receive();

		System.out.println("Received: " + message.getText());
	}
}