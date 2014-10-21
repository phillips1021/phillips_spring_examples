package edu.ku.it.si.springjpaexample.dao;

import static org.junit.Assert.*;


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
public class PersonDaoUpdateTest {
	
	@Autowired
	PersonDao personDao;
	
	private static final Logger logger = Logger.getLogger( PersonDaoTest.class.getName() );


	
	
	@Test
	public void testUdate() {
		
	    Person person1 = new Person();
		person1.setEmplid(new Long("1"));
		person1.setFirstName("Brian");
		person1.setLastName("Phillips");
		
		personDao.update(person1);
		
		logger.info("Person with emplid of 1 first name was changed to Brian");

		
		Person person = personDao.find( new Long("1") );
		
		assertEquals( "First name of update person is not Brian but it should be.", "Brian", person.getFirstName() );

		
	}
	
	

}
