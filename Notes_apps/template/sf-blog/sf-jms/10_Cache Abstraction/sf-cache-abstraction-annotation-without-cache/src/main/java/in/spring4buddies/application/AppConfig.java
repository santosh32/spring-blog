package in.spring4buddies.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@EnableCaching
@Configuration
@ComponentScan(basePackages = "in.spring4buddies.application")
public class AppConfig {

	// Suitable for basic use cases, no persistence capabilities or eviction  contracts.
//	@Bean
//	public CacheManager cacheManager() {
//		// configure and return an implementation of Spring's CacheManager SPI
//		SimpleCacheManager cacheManager = new SimpleCacheManager();
//		cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("products")));
//		return cacheManager;
//	}

	// EhCache based CacheManager, most commonly used in Enterprise applications.
//	@Bean
//	public CacheManager cacheManager() {
//		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
//	}
//
//	@Bean
//	public EhCacheManagerFactoryBean ehCacheCacheManager() {
//		EhCacheManagerFactoryBean factory = new EhCacheManagerFactoryBean();
//		factory.setConfigLocation(new ClassPathResource("ehcache.xml"));
//		factory.setShared(true);
//		return factory;
//	}

}