This project demonstrates using the Spring RestTemplate class to call
a REST web service and process the response.

For more information on Spring RestTemplate see:
 http://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/remoting.html#rest-client-access

This application calls the REST web service created by the 
springwebservice project.  The .war file created by that project
must be deployed to Tomcat running on your local computer.

To build and run the application follow these steps:
1. In a terminal window navigate to the project’s root folder (the location where the project’s pom.xml resides). 
2. Enter this command to create the jar file:  
   a. mvn -e clean -DskipTests=true assembly:assembly 
3. cd to the target folder
4. Run this command to execute the program:
   a. java -cp SpringWebServiceClient-jar-with-dependencies.jar edu.ku.it.si.springwebserviceclient.app.App 
   
   In the terminal window you will see many log messages (logging is set to the debug level).
   The last log message you see should be: Person returned is Person [lastName=Phillips, firstName=Bruce]