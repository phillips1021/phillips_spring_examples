strutsspringdataexample project

Introduction

This project is an example of how to use Struts 2, Spring 3, Spring Data JPA, JPA 2 
(with Hibernate 3.5 as the JPA provider), Spring Data REST and Maven to configure a
web application.  

To run the tests and application you will need Maven installed on your computer.

To create the JavaDoc run mvn javadoc:javadoc.  To view the JavaDoc refresh the 
target folder and navigate to target/site/apidocs and open index.html in a web browser.

Project Configuration
The application uses the configuration described in section 13.5 of the Spring 3.0 documentation
(http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/orm.html#orm-jpa)
to setup Spring integration with JPA.  

The application also uses the Spring Data JPA library to have Spring automatically 
create a PersonRepository bean to manage interaction between Person objects and the 
data repository.  The PersonRepository bean Spring creates is based 
on the PersonRepository interface in the repository package.
See - http://www.springsource.org/spring-data for more information about Spring Data JPA.

The JPA persistence.xml file is found in src/test/resources/META-INF for testing and for the 
deployed webapp the persistence.xml file is in src/main/webapp/META-INF.  

The Spring configuration file for the tests--applicationContextTest.xml--is found in 
src/test/resources.  The Spring configuration file for the web application is found 
in src/main/resources.

The Spring configuration file creates a LocalContainerEntityManagerFactoryBean object 
and provides it with the data source, location of the persistence.xml file, and the 
name of the persistence unit to use.

The persistence.xml file defines the persistence unit including what classes are to be
JPA entities, what is the JPA provider (Hibernate), and the properties for the JPA 
provider.

The model classes use JPA 2 annotations to identify how a model class is related to a 
database table.

The service class uses Spring's @Service annotation to mark the class as one Spring should
automatically create an instance of in the Inversion of Control container.  Using the Struts 2 
Spring plugin (see the pom.xml) will cause Spring to inject the services classes into the 
Struts 2 Action Support classes.

The service class also uses the JPA @PersistenceContext annotation to mark which 
instance field Spring should use to inject the EntityManager object.  
The PersonRepository bean that Spring creates will use that EntityManager object.   

In the service class the PersonRepository that is needed is annotated with Spring's @Autowired annotation.

The application also uses the Spring Data REST library to create RESTful endpoints that
allow interaction with the data repository using REST urls.  See the references
below for more information about Spring Data REST.
  
Testing, Building, and Running The Application Using Maven
 
After downloading the zipped project archive, unzip it.  Navigate to the 
project's root folder - root folder is named strutsspringdataexample (the pom.xml file 
should be in this folder).

To run the tests use mvn -e clean test.

To run the application on the Jetty Servlet container use mvn -e jetty:run

Once you see [INFO] Started Jetty Server in the console output, open a web browser and navigate to:

     http://localhost:8080/strutsspringdataexample/index.jsp
     
Enter 1, 2, or 3 in the employee ID text box.

To access the RESTful end points exposed by the projects use of Spring
Data REST use curl commands such as:

curl -v http://localhost:8080/strutsspringdataexample/rest/person/3  (where the number is the emplid of the person you want to find)

or to add a person:

curl -v -d '{"first_name" : "Steve", "last_name" : "Smith"}' -H "Content-Type: application/json" http://localhost:8080/strutsspringdataexample/rest/person

To stop the Jetty Servlet container type control-c in the terminal.

References:

http://www.springsource.org/spring-data, Spring Data

http://static.springsource.org/spring-data/data-jpa/docs/1.0.0.M2/reference/html,
Spring Data JPA - Reference Documentation

http://static.springsource.org/spring-data/data-jpa/docs/1.0.0.M2/api/,
Spring Data JPA API

http://blog.springsource.com/2011/02/10/getting-started-with-spring-data-jpa/,
Getting Started with Spring Data JPA, February 10, 2011

http://www.apress.com/book/view/9781430226321; Spring Persistence with Hibernate;
Paul Tepper Fisher and Brian D. Murphy; Apress Publishing; 2010

http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/orm.html#orm-jpa; 
Section 13.5 JPA, Spring Framework Reference Documentation 3.0

http://www.theserverside.com/tutorial/Hibernate-35-Without-Hibernate-Ridding-Your-Code-of-the-Hiberante-API-Calls,
Hibernate 3.5 Without Hibernate: Migrating to the Java Persistence API, By Andrew Tee & Cameron McKenzie,
TheServerSide.com

http://docs.jboss.org/hibernate/entitymanager/3.6/reference/en/html/, Hibernate EntityManager, Introducing
JPA Persistence, September 30, 2010

http://download.oracle.com/javaee/6/api/index.html?javax/persistence/package-summary.html, 
JEE 6 JPA 2 API

http://www.springsource.org/spring-data/rest, Spring Data REST

http://xebee.xebia.in/2012/09/23/giving-rest-to-your-jpa-repositories, Vijay
Rawat's blog article on Spring Data REST

http://www.brucephillips.name/blog/index.cfm/2011/3/25/Using-Spring-Data-JPA-To-Reduced-Data-Access-Coding, 
Bruce Phillips blog article on Spring Data JPA

http://www.brucephillips.name/blog/index.cfm/2012/9/25/Using-Spring-Data-REST-To-Easily-Create-RESTful-Endpoints-For-Data-Stored-In-A-Database, 
Bruce Phillips blog article on Spring Data REST





