package edu.ku.it.si.springjpaexample.dao;

import java.util.List;

import edu.ku.it.si.springjpaexample.model.Gender;
import edu.ku.it.si.springjpaexample.model.Person;

/**
 * Specifies behaviors a PersonDao must implement to 
 * support interaction between the Person class
 * and a data repository.
 * @author bphillips
 *
 */
public interface PersonDao extends GenericDao<Person> {
	

	
	/**
	 * Get all Person objects.
	 * @return collection of Person objects
	 */
	List<Person> findAllEmployees();
	
	
	
	/**
	 * Get all Person objects with the 
	 * Gender provided.
	 * @param gender
	 * @return collection of Person objects
	 */
	List<Person> findByGender(Gender gender) ;
	
	
}
