package name.brucephillips.springjpaexample.service;

import static org.junit.Assert.*;

import java.util.List;

import name.brucephillips.springjpaexample.model.Person;
import name.brucephillips.springjpaexample.service.PersonService;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


@ContextConfiguration(locations={"classpath:applicationContextTest.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class PersonServiceTest {
	
	private static final Logger logger = Logger.getLogger(PersonServiceTest.class.getName() );
	
	@Autowired
	PersonService personService;

	@Test
	public void testFindByEmplid() {
		
		Person person = personService.findByEmplid( new Long("1") );
		
		assertNotNull("Person object is null but should not be.", person);
		
		logger.info("Person state is " + person);
		
		
	}
	
	@Test
	public void testFindByEmplidDoesNotExist() {
		
		Person person = personService.findByEmplid( new Long("100") );
		
		assertNull("Person object is NOT null but should be.", person);
		
	}
	
	@Test
	public void testFindAllEmployees() {
		
		List<Person> employees = personService.findAllEmployees() ;
		
		assertEquals("The number of employees found is not 3 but should be.", 3, employees.size() );
		
	}
	
	@Test
	public void testSaveEmployee() {
		
		Person person = new Person();
		person.setFirst_name("George");
		person.setLast_name("Hosler");
		
		personService.save(person);
		
		List<Person> employees = personService.findAllEmployees() ;
		
		assertEquals("The number of employees found is not 4 but should be.", 4, employees.size() );
		
		logger.info("Person state is " + person);

	}
	
	@Test
	public void testUdate() {
		
	    Person person1 = new Person();
		person1.setEmplid(new Long("1"));
		person1.setFirst_name("Brian");
		person1.setLast_name("Phillips");
		
		personService.update(person1);
		
		logger.info("Person with emplid of 1 first name was changed to Brian");

		
		Person person = personService.findByEmplid( new Long("1") );
		
		assertEquals( "First name of update person is not Brian but it should be.", "Brian", person.getFirst_name() );

		
	}
	
	@Test
	public void testDelete() {
		
		Person person = personService.findByEmplid( new Long("3") );
		
		personService.delete(person);
				
		logger.info("Person with emplid of was deleted.");
		
		List<Person> employees = personService.findAllEmployees() ;
		
		assertEquals("The number of employees found is not 2 but should be.", 2, employees.size() );
	
		
	}

}
