mvn clean install
mvn tomcat7:run

http://localhost:8080/sf-mvc-path-variable-java-config/employee/Greg/HitechCity/Hyd/TS/India

http://localhost:8080/sf-mvc-path-variable-java-config/PathVariable/Greg/HitechCity/Hyd/TS/India
http://localhost:8080/sf-mvc-path-variable-java-config/PathVariable/Greg/HitechCity

#Ambiguous error
http://localhost:8080/sf-mvc-path-variable-java-config/PathVariable/Greg
http://localhost:8080/sf-mvc-path-variable-java-config/PathVariable/123

http://localhost:8080/sf-mvc-path-variable-java-config/PathVariable/Greg
http://localhost:8080/sf-mvc-path-variable-java-config/PathVariable/123