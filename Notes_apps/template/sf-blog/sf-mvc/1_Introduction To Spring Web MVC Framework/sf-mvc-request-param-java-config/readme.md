mvn clean install
mvn tomcat7:run

http://localhost:8080/sf-mvc-request-param-java-config/employee?name=Greg&address=HitechCity&city=Hyd&state=TS&country=IN

http://localhost:8080/sf-mvc-request-param-java-config/RequestParam?name=Greg&address=HitechCity&city=Hyd&state=TS&country=IN
http://localhost:8080/sf-mvc-request-param-java-config/RequestParam/map?name=Greg&address=HitechCity&city=Hyd&state=TS&country=IN
http://localhost:8080/sf-mvc-request-param-java-config/RequestParam/dateformat?dateOfBirth=1980-10-31&hireDate=2017-03-03