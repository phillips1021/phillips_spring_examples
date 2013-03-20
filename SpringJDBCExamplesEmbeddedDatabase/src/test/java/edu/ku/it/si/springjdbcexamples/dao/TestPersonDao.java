package edu.ku.it.si.springjdbcexamples.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.ku.it.si.springjdbcexamples.dao.PersonDao;
import edu.ku.it.si.springjdbcexamples.model.Person;



@ContextConfiguration //if no location is specified will look for TestPersonDao-context.xml in this package
@RunWith(SpringJUnit4ClassRunner.class)
public class TestPersonDao {

	@Autowired
	PersonDao personDao ;
	
	private static final Logger logger = Logger.getLogger(TestPersonDao.class.getName() );
	
	@Test
	public void testGetLastNames() {
		
		List<String> lastNames = personDao.getLastNames() ;
		
		assertTrue("Collection of last names is not greater than 0 but should be.", lastNames.size() > 0) ;
		
	}
	
	
	@Test
	public void testGetPersonUsingLastName() {
		
		Person person  = personDao.getPerson("Phillips");
		
		assertEquals("Person first name is not Bruce but should be.", "Bruce", person.getPersonFirstName() );
		
		
	}

	@Test
	public void testGetNumberOfPeople() {
		
		int numberOfPeople = personDao.getNumberOfPeople();
		
		logger.info("Number of people found in table is " + numberOfPeople);
		
		assertEquals("Number of people in table is not 1", 1, numberOfPeople);
		
	}
	
	@Test
	public void testGetFirstName() {
		
		String firstName = personDao.getFirstName("Phillips");
		
		logger.info("First name of Phillips is " + firstName);
		
		assertEquals("First name not Bruce", "Bruce", firstName);
		
	}
	
	@Test
	public void testAddPerson() {
		
		String firstName = "Kit";
		String lastName = "Cole";
		
		personDao.addPerson(firstName, lastName);
		
        int numberOfPeople = personDao.getNumberOfPeople();
		
		logger.info("Number of people found in table is " + numberOfPeople);
		
		assertEquals("Number of people in table is not 2", 2, numberOfPeople);
		
	}
	
	
	@Test
	public void testGetAllPersons() {
		
		List<Person> people = personDao.getAllPersons();
		
		logger.info("The number of people in the table is " + people.size() );
		
		assertEquals("Number of people in table is not 2", 2, people.size() );
		
		
	}
	
	@Test
	public void testUpdatePerson() {
		
		Person person = new Person();
		person.setPersonFirstName("Bruce");
		person.setPersonLastName("Smith");
		person.setPersonID(1);
		
		personDao.updatePerson(person);
		
		Person personChanged = personDao.getPerson(1);
		
		logger.info("Person's last name was updated to " + personChanged.getPersonLastName() );
		
		assertEquals("Person's last name was not updated to Smith, but should have been.", "Smith", personChanged.getPersonLastName() );
		
	}
	
	
	@Test
	public void testDeletePerson() {
		
		int startCount = personDao.getNumberOfPeople() ;
		
		Person person = new Person();
		person.setPersonFirstName("Jane");
		person.setPersonLastName("Doe");
		
		
		personDao.addPerson(person);
		
		List<Person> personList = personDao.getPerson(person);
		
		personDao.deletePerson(personList.get(0) );
		
		int endCount = personDao.getNumberOfPeople() ;
		
		assertEquals("After adding a new person and deleting that person the number of people is not the same number as before.", startCount, endCount);
		
		
		
		
	}
	
	
	@Test
	public void testGetPeopleList() {
		
		
		List<Map<String,Object>> peopleMapList = personDao.getPeopleList() ;
		
		
		assertTrue("Collection of Map objects is not greater than 0 but should be.", peopleMapList.size() > 0) ;
		
	}
	
	
	
	

}
