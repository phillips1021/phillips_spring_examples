package edu.ku.it.si.springjpaexample.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import edu.ku.it.si.springjpaexample.dao.PersonDao;
import edu.ku.it.si.springjpaexample.model.Gender;
import edu.ku.it.si.springjpaexample.model.Person;

@ContextConfiguration(locations={"classpath:applicationContextTest.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class PersonDaoTest {
	
	@Autowired
	PersonDao personDao;
	
	private static final Logger logger = Logger.getLogger( PersonDaoTest.class.getName() );

	@Test
	public void testFindbyEmplid() {
		
		Person person = personDao.find( new Long("1") );
		
		assertNotNull("Person object is null but should not be.", person);
		
		logger.info("Person state is " + person);
		
		
	}
	
	@Test
	public void testFindAllEmployees() {
		
		List<Person> employees = personDao.findAllEmployees() ;
		
		assertEquals("The number of employees found is not 3 but should be.", 3, employees.size() );
		
	}
	
	@Test
	public void testSaveEmployee() {
		
		Person person = new Person();
		person.setFirstName("George");
		person.setLastName("Hosler");
		person.setGender( Gender.MALE );
		
		personDao.create(person);
		
		List<Person> employees = personDao.findAllEmployees() ;
		
		assertEquals("The number of employees found is not 4 but should be.", 4, employees.size() );
		
		logger.info("Person state is " + person);

		
		
	}
	
	@Test
	public void testGetEmployeesByGender() {
		
		List<Person> maleEmployees = personDao.findByGender(Gender.MALE);
		
		assertNotNull("The collection of maleEmployees is null but should not be: ", maleEmployees);
		
		logger.info("Collection of male employees is " + maleEmployees);
		
		
	}
	
	
	

}
