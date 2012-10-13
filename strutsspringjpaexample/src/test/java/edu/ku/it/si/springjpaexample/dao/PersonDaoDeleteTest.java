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
import edu.ku.it.si.springjpaexample.model.Person;

@ContextConfiguration(locations={"classpath:applicationContextTest.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class PersonDaoDeleteTest {
	
	@Autowired
	PersonDao personDao;
	
	private static final Logger logger = Logger.getLogger( PersonDaoTest.class.getName() );

	
	
	
	@Test
	public void testDelete() {
		
		Person person = personDao.findbyEmplid( new Long("3") );
		
		personDao.delete(person);
				
		logger.info("Person with emplid of was deleted.");
		
		List<Person> employees = personDao.findAllEmployees() ;
		
		assertEquals("The number of employees found is not 2 but should be.", 2, employees.size() );
	
		
	}
	
	

}
