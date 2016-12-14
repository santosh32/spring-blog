package in.spring4buddies.application;

import in.spring4buddies.application.config.AppConfig;
import in.spring4buddies.application.jms.JmsConsumer;
import in.spring4buddies.application.jms.JmsProducer;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		JmsProducer jmsProducer = applicationContext.getBean(JmsProducer.class);
		JmsConsumer jmsConsumer = applicationContext.getBean(JmsConsumer.class);

		jmsProducer.produce();

		jmsConsumer.consumer();

		applicationContext.close();
	}
}
