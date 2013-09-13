package edu.ku.it.si.springwebservice.service;



import edu.ku.it.si.springwebservice.model.Person;

/**
 * Provides hard-coded Person data.
 * @author bphillips
 *
 */

public class PersonServiceDummyData implements PersonService {
	

	/* (non-Javadoc)
	 * @see edu.ku.it.si.springwebservice.service.PersonService#getPerson(java.lang.String)
	 */
	@Override
	public Person getPerson(String userName) {
		
		Person person = new Person();
		person.setFirstName("Bruce");
		person.setLastName("Phillips");
		
		return person;
		
		
	}

}
