1. Container overview
	- Configuration metadata
	- Instantiating a container
	- Composing XML-based configuration metadata
	- Using the container
2. Bean overview
	- Naming beans
	- Aliasing a bean outside the bean definition
	- Instantiating beans
	- Instantiation with a constructor
	- Instantiation with a static factory method
	- Instantiation using an instance factory method
3. Dependencies
	- Dependency Injection
	- Constructor-based dependency injection
	- Setter-based dependency injection
	- Dependency resolution process
	- Examples of dependency injection
	- Dependencies and configuration in detail
	- Straight values (primitives, Strings, and so on)
	- References to other beans (collaborators)
	- Inner beans
	- Collections
	- Null and empty string values
	- XML shortcut with the p-namespace
	- XML shortcut with the c-namespace
	- Compound property names
	- Using depends-on
	- Lazy-initialized beans
	- Autowiring collaborators
	- Limitations and disadvantages of autowiring
	- Excluding a bean from autowiring
	- Method injection
	- Lookup method injection
	- Arbitrary method replacement
4. Bean scopes
	- The singleton scope
	- The prototype scope
	- Singleton beans with prototype-bean dependencies
	- Request, session, application, and WebSocket scopes
	- Initial web configuration
	- Request scope
	- Session scope
	- Application scope
	- Scoped beans as dependencies
	- Custom scopes
	- Creating a custom scope
	- Using a custom scope
5. callbacks
	- Lifecycle callbacks
	- Initialization callbacks
	- Destruction callbacks
	- Default initialization and destroy methods
	- Combining lifecycle mechanisms
	- Startup and shutdown callbacks
	- Shutting down the Spring IoC container gracefully in non-web applications
	- ApplicationContextAware and BeanNameAware
	- Other Aware interfaces
6. inheritance
7. Container Extension Points
	- Customizing beans using a BeanPostProcessor
	- Example: Hello World, BeanPostProcessor-style
	- Example: The RequiredAnnotationBeanPostProcessor
	- Customizing configuration metadata with a BeanFactoryPostProcessor
	- Example: the Class name substitution PropertyPlaceholderConfigurer
	- Example: the PropertyOverrideConfigurer
	- Customizing instantiation logic with a FactoryBean
8. Annotation-based container configuration
	- @Required
	- @Autowired
	- Fine-tuning annotation-based autowiring with @Primary
	- Fine-tuning annotation-based autowiring with qualifiers
	- Using generics as autowiring qualifiers
	- CustomAutowireConfigurer
	- @Resource
	- @PostConstruct and @PreDestroy
9. Classpath scanning and managed components
	- @Component and further stereotype annotations
	- Meta-annotations
	- Automatically detecting classes and registering bean definitions
	- Using filters to customize scanning
	- Defining bean metadata within components
	- Naming autodetected components
	- Providing a scope for autodetected components
	- Providing qualifier metadata with annotations
10. JSR 330 Standard Annotations
	- Dependency Injection with @Inject and @Named
	- @Named: a standard equivalent to the @Component annotation
	- Limitations of JSR-330 standard annotations
11. Java-based container configuration
	- Basic concepts: @Bean and @Configuration
	- Instantiating the Spring container using AnnotationConfigApplicationContext
	- Simple construction
	- Building the container programmatically using register(Class<?>…​)
	- Enabling component scanning with scan(String…​)
	- Support for web applications with AnnotationConfigWebApplicationContext
	- Using the @Bean annotation
	- Declaring a bean
	- Bean dependencies
	- Receiving lifecycle callbacks
	- Specifying bean scope
	- Customizing bean naming
	- Bean aliasing
	- Bean description
	- Using the @Configuration annotation
	- Injecting inter-bean dependencies
	- Lookup method injection
	- Further information about how Java-based configuration works internally
	- Composing Java-based configurations
	- Using the @Import annotation
	- Conditionally include @Configuration classes or @Bean methods
	- Combining Java and XML configuration
12. Environment abstraction
	- Bean definition profiles
	- @Profile
	- XML bean definition profiles
	- Activating a profile
	- Default profile
	- PropertySource abstraction
	- @PropertySource
	- Placeholder resolution in statements
13. LoadTimeWeaver
14. ApplicationContext
15. BeanFactory
16. Resources 
			- UrlResource, ClassPathResource, FileSystemResource, ServletContextResource, 				InputStreamResource, ByteArrayResource
			- ResourceLoader, ResourceLoaderAware interface
			- 
17. Validation, Data Binding, and Type Conversion
18. 
19.
20.