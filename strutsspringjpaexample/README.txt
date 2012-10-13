springjpaoracleexample project

Introduction

This project is an example of how to use Struts 2, Spring 3, JPA 2 
(with Hibernate 3.5 as the JPA provider) and Maven to configure a
web application.  

To run the tests and application you will need Maven installed on your computer.

To create the JavaDoc run mvn javadoc:javadoc.  To view the JavaDoc refresh the 
target folder and navigate to target/sit/apidocs and open index.html in a web browers.

Project Configuration


The application uses the configuration described in section 13.5 of the Spring 3.0 documentation
(http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/orm.html#orm-jpa)
to setup Spring integration with JPA.  This example application is also based upon the example
applications provided by Wes Wannemacher during our Struts 2 training.

The Spring configuration file creates an LocalContainerEntityManagerFactoryBean object 
and provides it with the data source, location of the persistence.xml file, and the 
name of the persistence unit to use.

The JPA persistence.xml file is found in src/test/resources/META-INF for testing and for the 
deployed webapp the persistence.xml file is in src/main/webapp/META-INF.  

The Spring configuration file for the tests--applicationContextTest.xml--is found in 
src/test/resources.  The Spring configuration file for the deployed webapp is found 
in src/main/resources.

The persistence.xml file defines the persistence unit including what classes are to be
JPA entities, what is the JPA provider (Hibernate), and the properties for the JPA 
provider.

The model classes use JPA 2 annotations to identify how a model class is related to a 
database table.

The data access classes use Spring's @Repository annotation to mark the class as one 
Spring should automatically create an instance of in the Inversion of Control container.
In the Spring configuration file are these nodes which are used with @Repository:

 <!-- scans the classpath for annotated components (including @Repository and @Service) that will be 
    auto-registered as Spring beans  -->          
    <context:component-scan base-package="edu.ku.it.si.springjpaexample" />

    <!-- This will ensure that hibernate or jpa exceptions are automatically translated into
         Spring's generic DataAccessException hierarchy for those classes annotated with Repository
         For example see PersonDaoJpa-->
    <bean class="org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor"/>
    
The data access classes also use the JPA @PersistenceContext annotation to mark which 
method Spring should use to inject the EntityManager object into the data access class.  
The data access classes then use the EntityManager object to create queries that will
run against the database and return model objects.    

Note that the data access classes do not extend any other class and are not tied to Hibernate. 
The model and data access classes only use JPA 2 annotations.  No Hibernate configuration 
files are needed.  The Hibernate properties are set in the persistence.xml file.

The service classes use Spring's @Service annotation to mark the class as one Spring should
automatically create an instance of in the Inversion of Control container.  Using the Struts 2 
Spring plugin (see the pom.xml) will cause Spring to inject the services classes into the 
Struts 2 Action Support classes.

In the service classes any data access classes needed are annotated with Spring's @Autowired annotation.
  
Run The Application In MyEclipse

If you have checked out the project from Subversion into MyEclipse, you should be able to right
click on the project name and select Run As - MyEclipse Server Application.  The application will 
be built and deployed to MyEclipse's built-in Tomcat server.  MyEclipse's web browser should
open and load the index.jsp page.

Enter 1, 2, or 3 in the employee ID text box.

Run The Application In Eclipse
  
 If you have checked out the project from Subversion into Eclipse, you should be able to right click
 on the project name and select Run As - Run On Server.  The application will be built and
 deployed to the server you select (e.g Tomcat 6) and then the index.jsp page of the 
 application will be loaded into Eclipse's built-in web brower.
 
 Enter 1, 2, or 3 in the employee ID text box.
 
Running The Application Using Maven
 
After checking out the project from subversion open a terminal window.  Navigate to the 
project's root folder - root folder is named strutsspringjpaexample (the pom.xml file 
should be in this folder).

To run the tests use mvn -e clean test.

To run the application on the Jetty Servlet container use mvn -e jetty:run

Once you see [INFO] Started Jetty Server in the console output, open a web browser and navigate to:

     http://localhost:8080/strutsspringjpaexample/index.jsp
     
Enter 1, 2, or 3 in the employee ID text box.

To stop the Jetty Servlet container type control-c in the terminal.

References:

http://www.apress.com/book/view/9781430226321; Spring Persistence with Hibernate;
Paul Tepper Fisher and Brian D. Murphy; Apress Publishing; 2010

http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/orm.html#orm-jpa; 
Section 13.5 JPA, Spring Framework Reference Documentation 3.0

https://documents.ku.edu/xythoswfs/webview/_xy-946125_2, Struts 2 (Includes Information On JPA) 
Presentations By Wes Wannemacher, Nov. 2010

https://codeprd.vm.ku.edu/svn/training/wantii, Struts 2 With JPA Examples 
Provided By Wes Wannemacher, Nov 2010

http://www.theserverside.com/tutorial/Hibernate-35-Without-Hibernate-Ridding-Your-Code-of-the-Hiberante-API-Calls,
Hibernate 3.5 Without Hibernate: Migrating to the Java Persistence API, By Andrew Tee & Cameron McKenzie,
TheServerSide.com

http://docs.jboss.org/hibernate/entitymanager/3.6/reference/en/html/, Hibernate EntityManager, Introducting
JPA Persistence, September 30, 2010

http://download.oracle.com/javaee/6/api/index.html?javax/persistence/package-summary.html, 
JEE 6 JPA 2 API





