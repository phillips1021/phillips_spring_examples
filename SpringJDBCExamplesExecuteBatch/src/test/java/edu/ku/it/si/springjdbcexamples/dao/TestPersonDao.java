package edu.ku.it.si.springjdbcexamples.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
	public void testSaveAllPersonsMap() {
		
		personDao.doDBCleanUp() ;
		
		List<Person> people = new ArrayList<Person>();
		
		Person person1 = new Person();
		person1.setPersonFirstName("Jackie");
		person1.setPersonLastName("Jones");
		people.add(person1);
		
		Person person2 = new Person();
		person2.setPersonFirstName("Jimmy");
		person2.setPersonLastName("Jones");
		people.add(person2);
		
		
		int peopleSaved = personDao.saveAllPersonsMap(people);
		
		assertEquals("Number of Person objects saved is not 2 but should be.", 2, peopleSaved);
		
        people = personDao.getAllPersons();
        
        logger.info("The number of people in the table is now " + people.size() );
		
		logger.info("The people in the table are " + people );

		
	}
	
	
	
	@Test
	public void testSaveAllPersonsBean() {
		
		personDao.doDBCleanUp() ;
		
		List<Person> people = new ArrayList<Person>();
		
		Person person1 = new Person();
		person1.setPersonFirstName("Jackie");
		person1.setPersonLastName("Jones");
		people.add(person1);
		
		Person person2 = new Person();
		person2.setPersonFirstName("Jimmy");
		person2.setPersonLastName("Jones");
		people.add(person2);
		
		
		int peopleSaved = personDao.saveAllPersonsBean(people);
		
		assertEquals("Number of Person objects saved is not 2 but should be.", 2, peopleSaved);
		
        people = personDao.getAllPersons();
        
        logger.info("The number of people in the table is now " + people.size() );
		
		logger.info("The people in the table are " + people );

		
	}
	
	
	
	

}
