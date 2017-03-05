mvn clean install
mvn tomcat7:run

http://localhost:8080/sf-mvc-request-header-java-config/singleHeader
Accept-Encoding application/x-www-form-urlencoded

http://localhost:8080/sf-mvc-request-header-java-config/multipleHeader
Accept-Encoding  application/x-www-form-urlencoded
Accept-Language  en-US,en;q=0.8

http://localhost:8080/sf-mvc-request-header-java-config/mapHeader
host  localhost:8080
connection  keep-alive
cache-control  no-cache
user-agent  Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36
postman-token  dd134df6-d9e1-6204-914c-5601f9dac8d0
accept  */*
accept-encoding  application/x-www-form-urlencoded
accept-language  en-US,en;q=0.8
cookie  JSESSIONID=ADE75B92F4748AB4738C72944CCBD2F7

http://localhost:8080/sf-mvc-request-header-java-config/httpHeaders
{host=[localhost:8080], connection=[keep-alive], cache-control=[no-cache], user-agent=[Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36], postman-token=[69ef3abc-488f-f2e6-a0f6-c3b5627fc276], accept=[*/*], accept-encoding=[gzip, deflate, sdch, br], accept-language=[en-US,en;q=0.8], cookie=[JSESSIONID=ADE75B92F4748AB4738C72944CCBD2F7]}

http://localhost:8080/sf-mvc-request-header-java-config

