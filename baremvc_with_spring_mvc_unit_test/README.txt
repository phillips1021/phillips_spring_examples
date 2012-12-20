This project is an example of how to do integration testing 
of a Spring MVC project by using the new MockMvc class
provided in Spring 3.2.

This project is initially based on the Simple-Spring-Web-Application
project provided by J. Verstry on GitHub at 
https://github.com/JVerstry/Web-Related-Examples.

I added to this project JUnit tests that demonstrate how to 
test the Spring MVC controller class HomeController.java.

The new code is in src/test/resources and src/test/java.

To run the tests use mvn -e clean test

To run the web application in Tomcat use mvn -e clean tomcat:run.  

Once Tomcat has started up you can use these URLs:

   http://localhost:9090/ 
   http://localhost:9090/compare?input1=Bruce&input2=Andrew
   

References:

Spring MVC Test Framework,
Spring Documentation for Release 3.2, 
http://static.springsource.org/spring/docs/3.2.x/spring-framework-reference/html/testing.html#spring-mvc-test-framework

JavaDoc for Class MockMvc, 
http://static.springsource.org/spring/docs/3.2.x/javadoc-api/org/springframework/test/web/servlet/MockMvc.html

JavaDoc for Interface ResultActions,
http://static.springsource.org/spring/docs/3.2.x/javadoc-api/org/springframework/test/web/servlet/ResultActions.html

JavaDoc for Class MockMvcRequestBuilders,
http://static.springsource.org/spring/docs/3.2.x/javadoc-api/org/springframework/test/web/servlet/request/MockMvcRequestBuilders.html

JavaDoc for Class MockHttpServletResponse,
http://static.springsource.org/spring/docs/3.2.x/javadoc-api/org/springframework/mock/web/MockHttpServletResponse.html
