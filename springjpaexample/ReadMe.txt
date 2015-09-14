The springjpaexample project is an example of how to use
Spring to configure a web application without using any
XML configuration including web.xml and also how to 
use Spring JPA.

The project also shows how to create a unit test for the
Spring MVC Web controller.

Use Maven to build the war file:

   mvn -e clean package

Then copy the springjpaexample.war to your Servlet container.

In a web browser go to:
   http://localhost:8080/springjpaexample (your port may 
be different)
