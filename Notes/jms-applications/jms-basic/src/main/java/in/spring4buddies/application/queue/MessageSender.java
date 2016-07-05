package in.spring4buddies.application.queue;

import in.spring4buddies.application.utils.ActiveMQUtils;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class MessageSender {

	public static void send() throws JMSException {

		Connection connection = ActiveMQUtils.connection();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//		Session session = connection.createSession(false, Session.DUPS_OK_ACKNOWLEDGE);

		Destination destination = session.createQueue("test.message.queue");

		MessageProducer messageProducer = session.createProducer(destination);
//		messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
		messageProducer.setPriority(1);

//		MapMessage mapMessage = session.createMapMessage();
//
//		mapMessage.setString("Name", "Tim");
//		mapMessage.setString("Role", "Developer");
//		mapMessage.setDouble("Salary", 850000);
//		messageProducer.send(mapMessage);
		
		TextMessage textMessage = session.createTextMessage("Test");
		messageProducer.send(textMessage);

		if (connection != null) {
			connection.close();
		}
	}
}