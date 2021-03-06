package in.spring4buddies.application.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = { "in.spring4buddies.application.domain" })
@EnableJpaRepositories(basePackages = { "in.spring4buddies.application.repository" })
@EnableTransactionManagement
public class DBConfig {

	@Bean
	public DataSource dataSource() {
		// no need shutdown, EmbeddedDatabaseFactoryBean will take care of this
		EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase embeddedDatabase = embeddedDatabaseBuilder
				.setType(EmbeddedDatabaseType.H2)
				// .H2 or .DERBY
				.addScript("classpath:db/sql/create-db_DDL.sql")
				.addScript("classpath:db/sql/config_attribute_DML.sql").build();
		return embeddedDatabase;
	}

}
