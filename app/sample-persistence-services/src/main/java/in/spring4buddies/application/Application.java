package in.spring4buddies.application;

import in.spring4buddies.application.domain.ConfigAttribute;
import in.spring4buddies.application.repository.ConfigAttributeRepository;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(Application.class);

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	ConfigAttributeRepository attributeRepository;

	@Override
	public void run(String... args) throws Exception {
		Iterable<ConfigAttribute> configAttributeIterable = attributeRepository
				.findAll();
		Iterator<ConfigAttribute> iterator = configAttributeIterable.iterator();
		while (iterator.hasNext()) {
			ConfigAttribute configAttribute = iterator.next();
			LOGGER.info(configAttribute.getName() + ", "
					+ configAttribute.getDescription());
		}
	}
}
