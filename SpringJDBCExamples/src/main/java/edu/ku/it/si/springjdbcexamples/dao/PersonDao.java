package edu.ku.it.si.springjdbcexamples.dao;

import java.util.List;
import java.util.Map;

import edu.ku.it.si.springjdbcexamples.model.Person;

/**
 * Specifies behaviors for getting Person information
 * out of the data repository.
 * @author brucephillips
 *
 */
public interface PersonDao {
	
	/**
	 * Get last names of every person.
	 * @return Collection of last names
	 */
	public List<String> getLastNames();

	/**
	 * Get count of Person records in repository. 
	 * (see: http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/jdbc.html,
	 * section 13.2.1.1. Querying (SELECT) )
	 * @return number of Person records in repository
	 */
	public int getNumberOfPeople();

    /**
     * Get the Person's first name using the 
     * provided last name.
	 * (see: http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/jdbc.html,
	 * section 13.2..1.1 Querying (SELECT) )
     * @param lastName
     * @return first name
     */
	public String getFirstName(String lastName);
	

	/**
	 * Get Person with the provided last name.
	 * (see: http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/jdbc.html,
	 * section 13.2.3. Querying (SELECT) )
	 * @param lastName
	 * @return Person object with matching last name
	 */
	public Person getPerson(String lastName);



	/**
	 * Create a Person in the data repository 
	 * that has the provided first and last names.
	 * (see: http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/jdbc.html)
	 * @param firstName
	 * @param lastName
	 */
	public void addPerson(String firstName, String lastName);

	/**
	 * Use the provided Person object's state to 
	 * update the Person object in the data repository
	 * that has the same person ID value as the provided
	 * person object.
	 * (see: http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/jdbc.html)
	 * @param person Person object with state used to update data repository
	 */
	public void updatePerson(Person person);

	/**
	 * Use the provided Person object's person ID 
	 * value to find a matching Person in the data 
	 * repository and then delete that Person from
	 * the data repository.
	 * (see: http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/jdbc.html)
	 * @param person
	 */
	public void deletePerson(Person person);

	/**
	 * Remove any records from tblPerson that
	 * have a personID > 4 so that the table
	 * starts off in a consistent state 
	 * if this program has been run before
	 * 
	 */
	public void doDBCleanUp();

	/**
	 * Count the number of Person's in the data repository
	 * that have the provided first name.
	 * (see: http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/jdbc.html)
	 * section 13.2.2. NamedParameterJdbcTemplate)
	 * @param firstName
	 * @return
	 */
	public int countPeopleWithFirstName(String firstName);

	/**
	 * Using the first and last name of the provided
	 * Person object find all Person objects that
	 * have that first and last name.
	 * (see: http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/jdbc.html,
	 * section 13.2.2. NamedParameterJdbcTemplate)
	 * @param personSkeleton Person with first and last name to match
	 * @return
	 */
	public List<Person> getPerson(Person personSkeleton);

	/**
	 * Using the provided person ID value find
	 * the Person object in the data repository that
	 * has that person id value.
	 * (see: http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/jdbc.html)
	 * @param personId
	 * @return Person that has matching person ID value
	 */
	public Person getPerson(int personId);

	/**
	 * Get all Person objects from data repository
	 * as a List of Map objects.
	 * (see: http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/jdbc.html)
	 * @return List of Map objects where each Map object represents a Person
	 */
	public List<Map<String,Object>> getPeopleList();

	/**
	 * Using the provided Person object
	 * add it to the data repository.
	 * (see: http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/jdbc.html,
	 * section 13.5.1. Inserting data using SimpleJdbcInsert)
	 * @param newPerson
	 */
	public void addPerson(Person newPerson);

	/**
	 * Get all Person objects out of the data
	 * repository using the Spring JDBC's
	 * SimpleJdbcTemplate's query method
	 * and Java 5's covariant return type
	 * so that no cast is needed.
	 * @return collection of Person objects
	 */
	public List<Person> getAllPersons();

}
