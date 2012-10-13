/**
 * 
 */
package edu.ku.it.si.springjpaexample.service;

import java.util.List;

import edu.ku.it.si.springjpaexample.model.Person;

/**
 * Defines behaviors a PersonService must implement to 
 * support interaction between a Controller and PersonDao
 * @author bphillips
 *
 */
public interface PersonService {
	
	
	/**
	 * Get Person with the associated emplid.
	 * @param emplid - Employee ID
	 * @return Person object
	 */
	public Person findbyEmplid(Long emplid);
	
	
	/**
	 * Get all Person objects.
	 * @return collection of Person objects
	 */
	public List<Person> findAllEmployees();
	
		
	/**
	 * Update the data repository with the 
	 * state of the provided Person object.
	 * @param person Person object
	 */
	public void update(Person person);
	
	
	/**
	 * Remove the associated Person
	 * record from the data repository.
	 * @param person
	 */
	public void delete(Person person);
	
	
	/**
	 * Save the state of the provided
	 * Person object into the data
	 * repository.
	 * @param person
	 */
	public void save(Person person); 

}
