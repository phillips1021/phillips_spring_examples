package edu.ku.it.si.springjdbcexamples.dao;

import java.util.List;


import edu.ku.it.si.springjdbcexamples.model.Person;

/**
 * Specifies behaviors for getting Person information
 * out of the data repository.
 * @author brucephillips
 *
 */
public interface PersonDao {
	

	/**
	 * Remove any records from tblPerson that
	 * have a personID > 0 so that the table
	 * starts off in a consistent state 
	 * if this program has been run before
	 * 
	 */
	public void doDBCleanUp();

	
	/**
	 * Using the first and last name of the provided
	 * Person object find all Person objects that
	 * have that first and last name.
	 * (see: http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/jdbc.html#jdbc-NamedParameterJdbcTemplate)
	 * @param personSkeleton Person with first and last name to match
	 * @return collection of Person objects that match the personSkeleton
	 */
	public List<Person> getPerson(Person personSkeleton);
	

	/**
	 * Using the provided Person object
	 * add it to the data repository.
	 * (see: http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/jdbc.html#jdbc-simple-jdbc-insert-1)
	 * @param newPerson Person object to add to data repository
	 */
	public void addPerson(Person newPerson);

	/**
	 * Get all Person objects out of the data
	 * repository using the Spring JDBC's
	 * SimpleJdbcTemplate's query method
	 * and Java 5's covariant return type
	 * so that no cast is needed.
	 * (see: http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/jdbc.html#jdbc-SimpleJdbcTemplate)
	 * @return Collection of Person objects representing all records in the 
	 * data repository
	 */
	public List<Person> getAllPersons();
	
	/**
	 * Insert each Person object stored in the provided
	 * collection into the data repository
	 * using Spring's JDBC's SimpleJdbcInsert class's
	 * executeBatch method that takes a SqlParameterSource
	 * that is a MapSqlParameterSource.
	 * (see: http://static.springsource.org/spring/docs/3.0.x/javadoc-api/org/springframework/jdbc/core/simple/SimpleJdbcInsert.html#executeBatch(org.springframework.jdbc.core.namedparam.SqlParameterSource[])
	 * @param people Collection of Person objects
	 * @return number of records inserted into the data repository.
	 */
	public int saveAllPersonsMap(List<Person> people);
	
	
	/**
	 * Insert each Person object stored in the provided
	 * collection into the data repository
	 * using Spring's JDBC's SimpleJdbcInsert class's
	 * executeBatch method that takes a SqlParameterSource
	 * that is a BeanPropertySqlParameterSource.
	 * (see: http://static.springsource.org/spring/docs/3.0.x/javadoc-api/org/springframework/jdbc/core/simple/SimpleJdbcInsert.html#executeBatch(org.springframework.jdbc.core.namedparam.SqlParameterSource[])
	 * @param people Collection of Person objects
	 * @return number of records inserted into the data repository.
	 */
	public int saveAllPersonsBean(List<Person> people);

}
