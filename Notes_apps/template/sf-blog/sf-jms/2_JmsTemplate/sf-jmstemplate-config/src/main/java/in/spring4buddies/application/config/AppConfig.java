package in.spring4buddies.application.config;

import in.spring4buddies.application.jms.JmsConsumer;
import in.spring4buddies.application.jms.JmsProducer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("activemq.properties")
@ComponentScan(basePackages = "in.spring4buddies.application.*")
public class AppConfig {

	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		return activeMQConnectionFactory;
	}

	@Bean
	public ActiveMQQueue activeMQQueue() {
		ActiveMQQueue activeMQQueue = new ActiveMQQueue();
		return activeMQQueue;
	}

	@Bean
	public JmsProducer jmsProducer() {
		JmsProducer jmsProducer = new JmsProducer();
		return jmsProducer;
	}

	@Bean
	public JmsConsumer jmsConsumer() {
		JmsConsumer jmsConsumer = new JmsConsumer();
		return jmsConsumer;
	}
}
