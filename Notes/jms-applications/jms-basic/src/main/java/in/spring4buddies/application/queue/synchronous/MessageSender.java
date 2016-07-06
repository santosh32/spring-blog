package in.spring4buddies.application.queue.synchronous;

import in.spring4buddies.application.utils.ActiveMQUtils;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class MessageSender {

	public static void main(String[] args) throws JMSException,
			InterruptedException {

		Connection connection = null;
		int i = 0;
		while (i < 5) {
			connection = ActiveMQUtils.connection();

			Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			// Session session = connection.createSession(false,
			// Session.DUPS_OK_ACKNOWLEDGE);

			Destination destination = session.createQueue("test.message.queue");

			MessageProducer messageProducer = session.createProducer(destination);
			// messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			// messageProducer.setPriority(1);

			// MapMessage mapMessage = session.createMapMessage();
			//
			// mapMessage.setString("Name", "Tim");
			// mapMessage.setString("Role", "Developer");
			// mapMessage.setDouble("Salary", 850000);
			// messageProducer.send(mapMessage);

			Thread.sleep(5000);
			
			TextMessage textMessage = session.createTextMessage("Test-" + i);
			messageProducer.send(textMessage);

			System.out.println("Message Sent is :" + textMessage.getText());
			i++;

			if (connection != null) {
				connection.close();
			}
		}

	}
}