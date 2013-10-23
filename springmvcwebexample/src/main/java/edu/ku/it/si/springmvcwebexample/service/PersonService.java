
package edu.ku.it.si.springmvcwebexample.service;

import java.util.List;

import edu.ku.it.si.springmvcwebexample.model.Person;

/**
 * Describes methods a PersonService type must
 * implement to provide services related
 * to a Person.
 * @author bphillips
 *
 */
public interface PersonService {
	
	/**
	 * Get a collection of Person objects.
	 * @return collection of Person objects
	 */
	List<Person> getPeople() ;
	
	
	/**
	 * Get collection of Person objects
	 * where last name matches provided
	 * value.
	 * @param lastName
	 * @return collection of Person objects
	 */
	List<Person>getPeople(String lastName);

}
