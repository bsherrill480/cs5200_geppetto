This deploys to tomcat on port 8081.
TO RUN:

1. ./mvnw clean install
1. ./mvnw spring-boot:run

To run also need to add a src/main/resources/application.properties file. For example
```
debug=true
spring.mvc.view.prefix = /WEB-INF/jsp/
spring.mvc.view.suffix = .jsp
server.port = 8081

#DataSource settings: set here configurations for the database connection
spring.datasource.url = jdbc:mysql://localhost:3306/Geppetto?zeroDateTimeBehavior=convertToNull
spring.datasource.username = root
spring.datasource.password = password
spring.datasource.driverClassName = com.mysql.jdbc.Driver
```

Be sure to add ?zeroDateTimeBehavior=convertToNull to the end of your db url in
application.properties

[http://localhost:8081/](http://localhost:8081/)
