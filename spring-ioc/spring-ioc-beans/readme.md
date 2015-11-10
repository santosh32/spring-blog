#Bean overview
- A Spring IoC container manages one or more beans. These beans are created with the configuration metadata that you supply to the container, for example, in the form of XML **<bean/>** definitions.
Within the container itself, these bean definitions are represented as **BeanDefinition** objects, which contain (among other information) the following metadata:
- A package-qualified class name: typically the actual implementation class of the bean being defined.
- Bean behavioral configuration elements, which state how the bean should behave in the container (scope, lifecycle callbacks, and so forth).
- References to other beans that are needed for the bean to do its work; these references are also called collaborators or dependencies.
- Other configuration settings to set in the newly created object, for example, the number of connections to use in a bean that manages a connection pool, or the size limit of the pool.
- class, name, scope, constructor, properties, autowiring mode, lazy-initialization, initialization method and destruction method.

#Naming beans
- Every bean has one or more identifiers. These identifiers must be unique within the container that hosts the bean. A bean usually has only one identifier, but if it requires more than one, the extra ones can be considered aliases.
- In XML-based configuration metadata, you use the *id* and/or *name* attributes to specify the bean identifier(s). The *id* attribute allows you to specify exactly one id. Conventionally these names are alphanumeric ('myBean', 'fooService', etc.), but may contain special characters as well. If you want to introduce other aliases to the bean, you can also specify them in the name attribute, separated by a comma ( ,), semicolon ( ;), or white space. As a historical note, in versions prior to Spring 3.1, the *id* attribute was defined as an *xsd:ID* type, which constrained possible characters. As of 3.1, it is defined as an *xsd:string* type. Note that bean id uniqueness is still enforced by the container, though no longer by XML parsers.
- You are not required to supply a name or id for a bean. If no name or id is supplied explicitly, the container generates a unique name for that bean.

#Aliasing a bean outside the bean definition
- In a bean definition itself, you can supply more than one name for the bean, by using a combination of up to one name specified by the id attribute, and any number of other names in the name attribute. These names can be equivalent aliases to the same bean, and are useful for some situations, such as allowing each component in an application to refer to a common dependency by using a bean name that is specific to that component itself.
- Specifying all aliases where the bean is actually defined is not always adequate, however. It is sometimes desirable to introduce an alias for a bean that is defined elsewhere. This is commonly the case in large systems where configuration is split amongst each subsystem, each subsystem having its own set of object definitions. In XML-based configuration metadata, you can use the <alias/> element to accomplish this.

````xml
<alias name="fromName" alias="toName"/>
````



