package edu.ku.it.si.springjpaexample.service;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ku.it.si.springjpaexample.model.Person;
import edu.ku.it.si.springjpaexample.service.PersonService;

@ContextConfiguration(locations={"classpath:applicationContextTest.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceTest {
	
	private static final Logger logger = Logger.getLogger(PersonServiceTest.class.getName() );
	
	@Autowired
	PersonService personService;

	@Test
	public void testFindbyEmplid() {
		
		Person person = personService.findbyEmplid( new Long("1") );
		
		assertNotNull("Person object is null but should not be.", person);
		
		logger.info("Person state is " + person);
		
		
	}

}
