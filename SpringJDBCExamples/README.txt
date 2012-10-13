Project Information
This project is an example of using Spring 3.1 JDBC to
query a data repository.  The project also demonstrates
how to use the Spring 3.0 embedded database feature.

Run the Application
To run the application use mvn clean package exec:java.  
This will cause the main class--SpringJDBCExamplesApp--
to be executed.

As the application runs, the results of the database
queries are sent to the console.

Additional Information
More information about Spring JDBC and how to setup
an embedded database is available at:


http://www.brucephillips.name/blog/index.cfm/2009/11/3/Using-Spring-30-To-Create-An-Embedded-InMemory-Database-In-Your-Java-Application
http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/jdbc.html
http://static.springsource.org/spring/docs/3.1.x/javadoc-api/org/springframework/jdbc/core/simple/SimpleJdbcDaoSupport.html
http://static.springsource.org/spring/docs/3.1.x/javadoc-api/org/springframework/jdbc/core/support/JdbcDaoSupport.html

To update your Spring JDBC code to use Spring 3.1:

1.  Change references to SimpleJdbcDaoSupport to JdbcDaoSupport
2.  Change reference to method getSimpleJdbcTemplate() to getJdbcTemplate()
3.  If your code uses NamedParameterJdbcTemplate then instead of extending JdbcDaoSupport extend NamedParameterJdbcDaoSupport


