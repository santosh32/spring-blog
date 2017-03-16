mvn clean install
mvn tomcat7:run

http://localhost:8080/sf-mvc-bean_name_url_handler_mapping-config/employee/Greg/HitechCity/Hyd/TS/India

http://localhost:8080/sf-mvc-bean_name_url_handler_mapping-config/PathVariable/Greg/HitechCity/Hyd/TS/India
http://localhost:8080/sf-mvc-bean_name_url_handler_mapping-config/PathVariable/Greg/HitechCity

#Ambiguous error
http://localhost:8080/sf-mvc-bean_name_url_handler_mapping-config/PathVariable/Greg
http://localhost:8080/sf-mvc-bean_name_url_handler_mapping-config/PathVariable/123

http://localhost:8080/sf-mvc-bean_name_url_handler_mapping-config/PathVariable/Greg
http://localhost:8080/sf-mvc-bean_name_url_handler_mapping-config/PathVariable/123