This deploys to tomcat on port 8081.
TO RUN:

1. ./mvnw clean install
1. ./mvnw spring-boot:run

Be sure to add ?zeroDateTimeBehavior=convertToNull to the end of your db url in
application.properties

[http://localhost:8081/](http://localhost:8081/)
