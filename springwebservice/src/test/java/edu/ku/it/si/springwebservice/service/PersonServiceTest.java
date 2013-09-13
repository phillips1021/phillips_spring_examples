package edu.ku.it.si.springwebservice.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.ku.it.si.springwebservice.model.Person;


@ContextConfiguration(locations = { "classpath:applicationContext_Test.xml" }) 
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceTest {
	
	@Autowired
	private PersonService personService;


	@Test
	public void testGetPerson() {
		
		String userName = "bphillips";
		
		Person person = personService.getPerson(userName);
		
		assertEquals("Person last name does not equal Phillips but should.", "Phillips", person.getLastName());
		
		
	}

}
