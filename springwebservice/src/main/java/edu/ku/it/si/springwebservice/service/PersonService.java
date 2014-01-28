
package edu.ku.it.si.springwebservice.service;

import edu.ku.it.si.springwebservice.model.Person;

/**
 * Specifies methods a PersonService class must implement
 * to provide information on a Person or group of Persons
 * @author bphillips
 *
 */
public interface PersonService {
	
	/**
	 * Get the person with the provided userName.
	 * @param userName
	 * @return Person object
	 */
	Person getPerson(String userName) ;

    public Person createPerson(String firstName, String lastName, String userName);

}
