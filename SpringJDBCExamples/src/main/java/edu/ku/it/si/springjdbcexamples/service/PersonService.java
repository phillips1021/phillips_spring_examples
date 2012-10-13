package edu.ku.it.si.springjdbcexamples.service;

import java.util.List;
import java.util.Map;

import edu.ku.it.si.springjdbcexamples.model.Person;

/**
 * Specifies behaviors for providing services
 * related to a Person.
 * @author brucephillips
 *
 */
public interface PersonService {
	
	public List<String> getLastNames();
	
	public int getNumberOfPeople();

	public String getFirstName(String lastName);

	public Person getPerson(String lastName);

	public void addPerson(String string, String string2);

	public void updatePerson(Person person);

	public void deletePerson(Person person);

	public void doDBCleanUp();

	public int countPeopleWithFirstName(String firstName);

	/**
	 * Using the provided personSkeleton
	 * get Person objects from the data repository
	 * that have the same first and last name
	 * @param personSkeleton has value for first and last name
	 * @return Person object with all information
	 */
	public List<Person> getPerson(Person personSkeleton);

	/**
	 * Using the provided personId value
	 * find the Person object in the repository
	 * with that personID value
	 * @param personId value
	 * @return Person object that has the person ID value
	 */
	public Person getPerson(int personId);

	
	public List<Map<String,Object>> getPeopleList();

	/**
	 * Using the provided Person object
	 * add that Person to the data repository
	 * @param newPerson Person to add
	 */
	public void addPerson(Person newPerson);

	public List<Person> getAllPersons();

}
