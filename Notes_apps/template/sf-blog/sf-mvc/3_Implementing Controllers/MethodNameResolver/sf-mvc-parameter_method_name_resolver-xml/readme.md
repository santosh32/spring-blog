mvn clean install
mvn tomcat7:run

http://localhost:8080/sf-mvc-parameter_method_name_resolver-xml/employee/add.htm

http://localhost:8080/sf-mvc-parameter_method_name_resolver-xml/customer/*.htm?action=add
http://localhost:8080/sf-mvc-parameter_method_name_resolver-xml/customer/*.htm?action=delete
http://localhost:8080/sf-mvc-parameter_method_name_resolver-xml/customer/*.htm?action=update
http://localhost:8080/sf-mvc-parameter_method_name_resolver-xml/customer/*.htm?action=list
