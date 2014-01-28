This project is an example of how to use the Spring Web MVC framework to create a 
REST web service.  You can learn more about the Spring Web MVC framework at
http://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/

This simple example returns a JSON formatted Person object.

It allows provides a REST end point to create a Person object.

To run the unit/integration tests do mvn -e clean test

To create the .war file run the following Maven command:  mvn -e clean package
in the project's root folder.

Then copy from the target folder springwebservice.war to your Tomcat's webapps folder

To test that everything is working go to this URL in your web browser:
  http://localhost:8080/springwebservice/person/username/bphillips
  
For an example of using Spring to create a web service client application see 
project springwebserviceclient.