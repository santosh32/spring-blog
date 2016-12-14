package in.spring4buddies.application.config;

import in.spring4buddies.application.jms.JmsConsumer;
import in.spring4buddies.application.jms.JmsProducer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@PropertySource("activemq.properties")
@ComponentScan(basePackages = "in.spring4buddies.application.*")
public class AppConfig {
	
	@Autowired
	private Environment environment;

	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL(environment.getProperty("broker.url"));
		return activeMQConnectionFactory;
	}

	@Bean
	public ActiveMQQueue activeMQQueue() {
		ActiveMQQueue activeMQQueue = new ActiveMQQueue(environment.getProperty("cutomer.queue"));
		return activeMQQueue;
	}

	@Bean
	public JmsTemplate jmsTemplate(ActiveMQConnectionFactory activeMQConnectionFactory, ActiveMQQueue activeMQQueue) {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(activeMQConnectionFactory);
		jmsTemplate.setDefaultDestination(activeMQQueue);
		return jmsTemplate;
	}

	@Bean
	public JmsProducer jmsProducer(JmsTemplate jmsTemplate) {
		JmsProducer jmsProducer = new JmsProducer();
		jmsProducer.setJmsTemplate(jmsTemplate);
		return jmsProducer;
	}

	@Bean
	public JmsConsumer jmsConsumer(JmsTemplate jmsTemplate) {
		JmsConsumer jmsConsumer = new JmsConsumer();
		jmsConsumer.setJmsTemplate(jmsTemplate);
		return jmsConsumer;
	}
}
